package com.mercadona.pruebat.base.driving.controllers.api;

import com.mercadona.pruebat.base.driving.controllers.models.LoginRequestDto;
import com.mercadona.pruebat.base.driving.controllers.models.LoginResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name="Authentication Api", description = "Authentication api")
@RequestMapping("auth")
public interface AuthenticationApi {

    @GetMapping("/login")
    LoginResponseDto login(LoginRequestDto requestDto);

}