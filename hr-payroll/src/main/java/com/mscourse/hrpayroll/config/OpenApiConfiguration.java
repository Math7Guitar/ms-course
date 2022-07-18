package com.mscourse.hrpayroll.config;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@OpenAPIDefinition(info = 
@Info(title = "hr-payroll API", version = "v1", description = "Documentation of hr-payroll API"))
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(
                new io.swagger.v3.oas.models.info.Info()
                .title("hr-payroll API")
                .version("v1")
                .license( new License()
                                .name("apache 2.0")
                                .url("http://springdoc.org") )
            );
    }    
}
