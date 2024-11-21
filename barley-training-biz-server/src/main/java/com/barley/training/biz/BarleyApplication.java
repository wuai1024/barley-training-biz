package com.barley.training.biz;

import com.barley.common.auth.annotation.EnableMyAuthConfig;
import com.barley.common.auth.annotation.EnableUserInjectionConfig;
import com.barley.common.datasource.annotation.EnableDynamicQueryConfig;
import com.barley.common.datasource.annotation.EnableMyBatisPlus;
import com.barley.common.redis.annotation.EnableRedisConfig;
import com.barley.common.webmvc.annotation.EnableGlobalException;
import com.barley.common.webmvc.annotation.EnableHttpNotNullConverter;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMyBatisPlus
@EnableHttpNotNullConverter
@EnableGlobalException
@EnableUserInjectionConfig
@EnableMyAuthConfig
@EnableRedisConfig
@MapperScan("com.barley.**.mapper*")
@SpringBootApplication
@EnableDynamicQueryConfig
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "智慧教室 API", version = "1.0", description = "智慧教室 API"))
public class BarleyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BarleyApplication.class, args);
    }
}
