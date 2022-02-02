package com.example.Department.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket swaggerConfigurations(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.paths(PathSelectors.ant("/department/**"))
                .apis(RequestHandlerSelectors.basePackage("com.example.Department") )
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Department API",
                "Api to perform operations on Department",
                "1.0",
                "Free to Use",
                new Contact("Sultan", "http://abc.com", "sb123@gmail.com"),
                "API Licence",
                "http://licenceUrl.com",
                Collections.emptyList()
        );
    }

}
