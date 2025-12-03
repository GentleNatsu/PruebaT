package com.mercadona.pruebat.base.application.ports.driven;

public interface UserDbPort {

    boolean isRegistered(String username, String password);

}