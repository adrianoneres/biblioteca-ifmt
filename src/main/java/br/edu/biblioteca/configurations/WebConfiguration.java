package br.edu.biblioteca.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
  @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders(
                        "Content-Type",
                        "X-Requested-With",
                        "Accept",
                        "Origin",
                        "jwt-token",
                        "Authorization",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers",
                        "Access-Control-Allow-Origin",
                        "Service-Worker-Allowed")
                .exposedHeaders(
                        "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Authorization")
                .allowedMethods(
                        "GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH", "HEAD", "TRACE", "CONNECT");
    }
}
