package com.unicesumar.govinizacao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*"); // Permitir todas as origens. Você pode restringir isso aos domínios específicos do seu aplicativo.
        config.addAllowedMethod("*"); // Permitir todos os métodos HTTP (GET, POST, PUT, etc).
        config.addAllowedHeader("*"); // Permitir todos os cabeçalhos HTTP.
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
