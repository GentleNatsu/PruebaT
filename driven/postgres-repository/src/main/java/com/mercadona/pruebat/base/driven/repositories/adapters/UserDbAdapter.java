package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.ports.driven.UserDbPort;
import com.mercadona.pruebat.base.driven.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDbAdapter implements UserDbPort {

    private final UserRepository repository;

    @Override
    public boolean isRegistered(String username, String password) {
        return repository.isRegistered(username, password);
    }
}