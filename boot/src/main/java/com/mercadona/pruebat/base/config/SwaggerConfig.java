package com.mercadona.pruebat.base.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI swaggerConfigMgaIos() {
        Info info = new Info().title("PruebaTe").description("Aplicación para aumentar mi sueldo anual")
            .version("v1.0.0");
        OpenAPI openAPI = new OpenAPI();
        addImplicitOAuth2WithoutScopes(openAPI);
        return openAPI.info(info);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/docs").setViewName("forward:/swagger-ui.html");
    }

    private void addImplicitOAuth2WithoutScopes(OpenAPI openAPI) {
        var securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.OAUTH2);
        securityScheme.setFlows(new OAuthFlows().implicit(new OAuthFlow().authorizationUrl("").scopes(new Scopes())));
        openAPI.components(
            new Components()
                .addSecuritySchemes("adfs", securityScheme)
        );
    }
}
