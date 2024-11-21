package com.barley.training.biz.config;

import com.barley.common.datasource.factory.DataSourceFactory;
import com.zaxxer.hikari.HikariConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSourceConfig implements DataSourceFactory {
    private final DataSourceProperties properties;

    @Override
    public HikariConfig getHikariConfig(String sourceType) {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(properties.getDriverClassName());
        hikariConfig.setJdbcUrl(properties.getUrl());
        hikariConfig.setUsername(properties.getUsername());
        hikariConfig.setPassword(properties.getPassword());
        return hikariConfig;
    }
}
