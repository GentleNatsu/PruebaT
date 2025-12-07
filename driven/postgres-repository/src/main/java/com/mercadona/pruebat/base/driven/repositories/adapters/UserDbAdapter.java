package com.mercadona.pruebat.base.driven.repositories.adapters;

import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.ports.driven.UserDbPort;
import com.mercadona.pruebat.base.domain.users.User;
import com.mercadona.pruebat.base.driven.repositories.UserRepository;
import com.mercadona.pruebat.base.driven.repositories.mappers.UserDbMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDbAdapter implements UserDbPort {

    private final UserRepository repository;
    private final UserDbMapper userDbMapper;

    @Override
    public boolean isRegistered(String username, String password) {
        return repository.isRegistered(username, password);
    }

    @Override
    public Optional<User> getUser(String username, String password) {
        return repository.getUser(username, password).map(userDbMapper::toDomain);
    }
}