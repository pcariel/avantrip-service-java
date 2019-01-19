package io.avantrip.conf;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("avantrip")
                .produces(Stream.of("application/json").collect(Collectors.toSet())).select()
                .apis(RequestHandlerSelectors.basePackage("io.avantrip.controller")).build().apiInfo(apiInfo())
                .protocols(Stream.of("http").collect(Collectors.toSet()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Avantrip Flight fraudulent", "description", "1.0.0", "termsOfServiceUrl",
                new Contact("Pablo Cariel", "url", "email"), "license", "licenseUrl", Collections.emptyList());
    }
}