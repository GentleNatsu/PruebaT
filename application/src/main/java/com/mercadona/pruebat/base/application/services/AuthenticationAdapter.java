package com.mercadona.pruebat.base.application.services;

import com.mercadona.pruebat.base.application.lib.JwtUtil;
import com.mercadona.pruebat.base.application.ports.driving.AuthenticationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationAdapter implements AuthenticationPort {

    private final UserService userService;

    @Override
    public String login(String username, String password) {
        var usuario = userService.getUser(username, password);
        return JwtUtil.generateToken(usuario);
    }
}