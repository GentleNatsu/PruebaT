package com.mercadona.pruebat.base.domain.users;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum Roles {

    ADMIN("ADMIN"), USER("USER");

    private final String codigo;
    private static final Map<String, Roles> tipos;

    Roles(String codigo) {
        this.codigo = codigo;
    }

    static {
        tipos = Arrays.stream(values()).collect(Collectors.toMap(Roles::getCodigo, Function.identity()));
    }

    public static Roles getRole(String tipo){
        return tipos.get(tipo);
    }


}
