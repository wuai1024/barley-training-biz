package com.barley.training.biz;

import com.barley.common.auth.annotation.EnableMyAuthConfig;
import com.barley.common.auth.annotation.EnableUserInjectionConfig;
import com.barley.common.datasource.annotation.EnableDynamicQueryConfig;
import com.barley.common.datasource.annotation.EnableMyBatisPlus;
import com.barley.common.redis.annotation.EnableRedisConfig;
import com.barley.common.webmvc.annotation.EnableGlobalException;
import com.barley.common.webmvc.annotation.EnableHttpNotNullConverter;
import com.barley.stub.file.annotation.EnableS3Client;
import com.barley.training.biz.channel.ItcApis;
import com.barley.training.biz.channel.config.ItcConfig;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableS3Client
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

    @Bean
    public ItcApis itcApis() {
        ItcConfig itcConfig = new ItcConfig();
        itcConfig.setBaseUrl("http://192.168.5.62");
        itcConfig.setCompany("BL");
        itcConfig.setDevice_name("TE-0600R");
        itcConfig.setClient_id("20882088");
        itcConfig.setSecret("nGk5R2wrnZqQ02bed29rjzax1QWRIu1O");
        return new ItcApis(itcConfig);
    }
}
