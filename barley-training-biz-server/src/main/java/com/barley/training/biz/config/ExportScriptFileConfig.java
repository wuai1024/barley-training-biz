package com.barley.training.biz.config;

import com.barley.common.datasource.FileConfig;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ExportScriptFileConfig {
    private static final ConcurrentHashMap<String, FileConfig> CACHE = new ConcurrentHashMap<>();

    public FileConfig get(String code) {
        final String codeType = code.toUpperCase().replaceAll("-", "_");
        return CACHE.computeIfAbsent(code, key -> {
            final Yaml yaml = new Yaml();
            try (InputStream inputStream = this.getClass().getResourceAsStream("/dynamic/export/" + codeType + ".yaml")) {
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
