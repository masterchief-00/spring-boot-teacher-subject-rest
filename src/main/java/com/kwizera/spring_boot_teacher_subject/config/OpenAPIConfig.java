package com.kwizera.spring_boot_teacher_subject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Teacher - Subject API Documentation")
                        .description("API documentation for my Spring Boot app")
                        .version("1.0.0"));
    }
}
