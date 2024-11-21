package com.barley.training.biz.config;

import com.barley.common.datasource.DynamicQueryTypeEnum;
import com.barley.common.datasource.FileConfig;
import com.barley.common.datasource.factory.FileConfigFactory;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class DynamicQueryFileConfig implements FileConfigFactory {
    private static final ConcurrentHashMap<String, FileConfig> CACHE = new ConcurrentHashMap<>();

    @Override
    public FileConfig get(DynamicQueryTypeEnum dynamicQueryType, String code) {
        final String type = dynamicQueryType.name().toLowerCase();
        final String codeType = code.toUpperCase().replaceAll("-", "_");
        return CACHE.computeIfAbsent(dynamicQueryType.name() + code, key -> {
            final Yaml yaml = new Yaml();
            try (InputStream inputStream = this.getClass().getResourceAsStream("/dynamic/" + type + "/" + codeType + ".yaml")) {
                if (Objects.isNull(inputStream)) {
                    return null;
                }
                return yaml.loadAs(inputStream, FileConfig.class);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }

}
