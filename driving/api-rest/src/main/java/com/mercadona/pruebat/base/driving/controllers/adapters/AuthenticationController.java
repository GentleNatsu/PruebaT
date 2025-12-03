package com.mercadona.pruebat.base.driving.controllers.adapters;

import com.mercadona.pruebat.base.application.ports.driving.AuthenticationPort;
import com.mercadona.pruebat.base.driving.controllers.api.AuthenticationApi;
import com.mercadona.pruebat.base.driving.controllers.models.LoginRequestDto;
import com.mercadona.pruebat.base.driving.controllers.models.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationPort port;

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        var token = port.login(requestDto.getUsername(), requestDto.getPassword());
        return new LoginResponseDto(token);
    }
}