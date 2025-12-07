package com.mercadona.pruebat.base.application.ports.driven;

import com.mercadona.pruebat.base.domain.users.User;

import java.util.Optional;

public interface UserDbPort {

    boolean isRegistered(String username, String password);

    Optional<User> getUser(String username, String password);

}