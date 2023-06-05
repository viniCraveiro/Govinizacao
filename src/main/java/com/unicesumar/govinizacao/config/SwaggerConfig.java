package com.unicesumar.govinizacao.config;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.servers.*;
import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import io.swagger.v3.oas.models.security.*;
import org.springframework.context.annotation.*;

@OpenAPIDefinition(servers = {
        @Server(url = "http://localhost:8080/", description = "Localhost Server"),
})
@Configuration
public class SwaggerConfig {

    private static final String SCHEME_NAME = "token";
    private static final String SCHEME = "basic";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(info())
                .components(new Components()
                        .addSecuritySchemes(SCHEME_NAME, createSecurityScheme()))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
    }

    private SecurityScheme createSecurityScheme() {
        return new SecurityScheme()
                .name(SCHEME_NAME)
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER)
                .scheme(SCHEME);
    }

    private Info info() {
        return new Info().title("API GOVINIZACAO")
                .description("Documentação da API do Govinizacao")
                .version("V0");
    }
}
