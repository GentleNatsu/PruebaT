package com.mercadona.pruebat.base.application.services;

import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.ports.driven.UserDbPort;
import com.mercadona.pruebat.base.domain.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDbPort userDbPort;

    public boolean isRegistered(String username, String pasword) {
        return userDbPort.isRegistered(username, pasword);
    }

    public User getUser(String username, String password) {
        return userDbPort.getUser(username, password)
                .orElseThrow(() -> new PruebaTeException(ErrorCode.TOKEN_ERROR));
    }
}