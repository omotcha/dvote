package org.omotcha.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  // documentation type: SWAGGER_2
//                .groupName("None") // documentation group name: None
                .apiInfo(apiInfo()) // api info conf
                .select() // returns an ApiSelectorBuilder instance, used to document the api interface
                .apis(RequestHandlerSelectors.basePackage("org.omotcha.controller")) // where to scan
                .paths(PathSelectors.any())// select any path, no actual filtering
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("dvote API")
                .description("dvote API MGMT")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
