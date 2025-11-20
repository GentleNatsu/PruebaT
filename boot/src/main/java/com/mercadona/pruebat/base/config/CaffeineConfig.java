package com.mercadona.pruebat.base.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CaffeineConfig {

  @Bean
  public CacheManager cacheManager() {
    CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();

    caffeineCacheManager.registerCustomCache(
      "get-product-id",                            // Configuración específica de la caché get-example-id
      Caffeine.newBuilder()
        .expireAfterWrite(5, TimeUnit.MINUTES)     // Configuración del tiempo de expiración
        .recordStats()                             // Habilita la recopilación de estadísticas de caché
        .build()
    );

    caffeineCacheManager.registerCustomCache(
      "get-products",                              // Configuración específica de la caché get-products
      Caffeine.newBuilder()
        .expireAfterWrite(5, TimeUnit.MINUTES)     // Configuración del tiempo de expiración
        .recordStats()                             // Habilita la recopilación de estadísticas de caché
        .build()
    );

    return caffeineCacheManager;
  }

}
