package com.mercadona.pruebat.base.mercaceptors;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MercaceptorsConfiguration implements WebMvcConfigurer {

    private final LocaleMercaceptor localeMercaceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeMercaceptor);
    }
}
