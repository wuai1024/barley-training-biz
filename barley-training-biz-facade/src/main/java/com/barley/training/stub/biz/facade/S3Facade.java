package com.barley.training.stub.biz.facade;

import com.barley.common.base.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "S3Facade", description = "S3 存储接口")
public interface S3Facade {

    String URL_PREFIX = "/s3";

    @Operation(summary = "获取下载链接")
    @GetMapping(value = "/getDownloadUrl")
    ResponseData<String> getDownloadUrl(@RequestParam @Parameter(description = "文件Key") String key,
                                        @RequestParam(required = false, defaultValue = "") @Parameter(description = "下载的文件名称") String fileName);

    @Operation(summary = "获取文件链接")
    @GetMapping(value = "/getUrl")
    ResponseData<String> getUrl(@RequestParam @Parameter(description = "文件Key") String key);

    @Operation(summary = "获取文件链接-集合")
    @PostMapping(value = "/getUrls")
    ResponseData<List<String>> getUrls(@RequestParam @Parameter(description = "类型") String type,
                                       @RequestBody List<String> keyList);

    @Operation(summary = "上传模板文件")
    @PostMapping(value = "/upload")
    ResponseData<String> upload(@RequestParam(value = "file") MultipartFile file,
                                @RequestParam(value = "type", required = false, defaultValue = "Media") String type,
                                @RequestParam(value = "isUrl", required = false, defaultValue = "false") boolean isUrl);
}
