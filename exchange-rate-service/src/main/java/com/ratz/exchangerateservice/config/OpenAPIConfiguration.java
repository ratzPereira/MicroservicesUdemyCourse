package com.ratz.exchangerateservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(info = @Info(title = "Exchange Service API", version = "v1", description = "Documentation of Exchange Service API"))
public class OpenAPIConfiguration {

  @Bean
  public OpenAPI customOpenAPI(){

    return new OpenAPI().components(new Components())
        .info(new io.swagger.v3.oas.models.info.Info()
            .title("Exchange Service API")
            .version("v1")
            .license(new License().name("Apache2.0").url("https://springdoc.org")));
  }

}
