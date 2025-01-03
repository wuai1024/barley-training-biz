package com.barley.training.biz.controller.admin;

import com.barley.common.base.response.ResponseData;
import com.barley.stub.file.S3TypeEnum;
import com.barley.stub.file.s3.S3Factory;
import com.barley.training.biz.constant.Constant;
import com.barley.training.stub.biz.facade.admin.S3Facade;
import com.media.pdf.PDFCommand;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Log4j2
@RestController
@RequestMapping(S3Facade.URL_PREFIX)
@RequiredArgsConstructor
public class S3Controller implements S3Facade {
    private final S3Factory s3Factory;

    @Override
    public ResponseData<String> getDownloadUrl(String key, String fileName) {
        return ResponseData.SUCCESS(s3Factory.getInstance(Constant.S3_FILE).getObjectDownloadUrl(fileName, key));
    }

    @Override
    public ResponseData<String> getUrl(String key) {
        return ResponseData.SUCCESS(s3Factory.getInstance(Constant.S3_FILE).getObjectUrl(key));
    }

    @Override
    public ResponseData<List<String>> getUrls(String type, List<String> keyList) {
        if (StringUtils.isBlank(type)) {
            return ResponseData.SUCCESS(s3Factory.getStyleInstance(Constant.S3_FILE, S3TypeEnum.ALI_YUN)
                    .defaultUrl(keyList));
        }
        if (StringUtils.equalsIgnoreCase(type, "THUMBNAIL")) {
            return ResponseData.SUCCESS(s3Factory.getStyleInstance(Constant.S3_FILE, S3TypeEnum.ALI_YUN)
                    .thumbnailUrl(keyList));
        }
        if (StringUtils.equalsIgnoreCase(type, "COVER")) {
            return ResponseData.SUCCESS(s3Factory.getStyleInstance(Constant.S3_FILE, S3TypeEnum.ALI_YUN)
                    .coverUrl(keyList));
        }
        if (StringUtils.equalsIgnoreCase(type, "COVER_MIN")) {
            return ResponseData.SUCCESS(s3Factory.getStyleInstance(Constant.S3_FILE, S3TypeEnum.ALI_YUN)
                    .coverMinUrl(keyList));
        }
        return ResponseData.SUCCESS(s3Factory.getStyleInstance(Constant.S3_FILE, S3TypeEnum.ALI_YUN)
                .defaultUrl(keyList));
    }

    @SneakyThrows
    @Override
    public ResponseData<String> upload(MultipartFile file, String type, boolean isUrl) {
        final String originalFilename = file.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename)) {
            return ResponseData.FAILURE("403", "");
        }
        final int index = originalFilename.lastIndexOf(".");
        if (index < 0) {
            return ResponseData.FAILURE("403", "");
        }

        //noinspection SwitchStatementWithTooFewBranches
        final String instanceId = switch (type.toUpperCase(Locale.ROOT)) {
            case "PUBLIC" -> Constant.S3_PUBLIC;
            default -> Constant.S3_FILE;
        };

        final String suffix = originalFilename.substring(index).toLowerCase(Locale.ROOT);
        final File cacheFile = Paths.get(Constant.PUT_CACHE, UUID.randomUUID() + suffix).toFile();
        try {
            // 保存上传文件
            file.transferTo(cacheFile);

            // 如果是PDF 解析文件
            //noinspection SwitchStatementWithTooFewBranches
            final String s3Path = switch (suffix) {
                case "pdf" -> pdf(instanceId, type, cacheFile);
                default -> file(instanceId, type, cacheFile);
            };

            // 如果需要URL 回显
            if (isUrl) {
                return ResponseData.SUCCESS(s3Factory.getStyleInstance(instanceId, S3TypeEnum.TENCENT)
                        .defaultUrl(s3Path));
            }
            return ResponseData.SUCCESS(s3Path);
        } finally {
            if (cacheFile.exists() && cacheFile.delete()) {
                log.info("[S3] 文件({}-{}), 上传完成自动回收", originalFilename, cacheFile.getAbsoluteFile());
            }
        }
    }

    private String pdf(String instanceId, String type, File cacheFile) throws IOException {
        final File coverFile = Paths.get(Constant.PUT_CACHE, UUID.randomUUID() + ".jpeg").toFile();
        try {
            // 获取封面
            PDFCommand.toCoverImage(cacheFile.getAbsolutePath(), coverFile.getAbsolutePath());
            // 上传PDF到S3
            try (FileInputStream inputStream = new FileInputStream(cacheFile)) {
                s3Factory.getInstance(instanceId)
                        .putObject("/" + Constant.TRAINING + "/" + type.toLowerCase(Locale.ROOT) + "/" + cacheFile.getName(), inputStream);
            }
            // 上传封面到S3
            final String s3Path;
            try (FileInputStream inputStream = new FileInputStream(coverFile)) {
                s3Path = s3Factory.getInstance(instanceId)
                        .putObject("/" + Constant.TRAINING + "/" + type.toLowerCase(Locale.ROOT) + "/" + cacheFile.getName() + "#COVER.jpeg", inputStream);
            }
            return s3Path;
        } finally {
            if (coverFile.exists() && coverFile.delete()) {
                log.info("[S3] 文件({}), 上传完成自动回收", coverFile.getAbsoluteFile());
            }
        }
    }

    private String file(String instanceId, String type, File cacheFile) throws IOException {
        final String s3Path;
        try (FileInputStream inputStream = new FileInputStream(cacheFile)) {
            s3Path = s3Factory.getInstance(instanceId)
                    .putObject("/" + Constant.TRAINING + "/" + type.toLowerCase(Locale.ROOT) + "/" + cacheFile.getName(), inputStream);
        }
        return s3Path;
    }
}
