package com.mercadona.pruebat.base.application.services;

import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
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
        var isRegistered = userService.isRegistered(username, password);
        if (!isRegistered) {
            throw new PruebaTeException(ErrorCode.PROVETA_ERROR, username);
        }
        return JwtUtil.generateToken(username);
    }
}