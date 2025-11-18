package com.mercadona.pruebat.base.driving.controllers.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "ProvetaApi", description = "ProvetaApi")
@RequestMapping("/api/v1/proveta")
public interface ProvetaApi {

    @GetMapping
    String proveta();
}
