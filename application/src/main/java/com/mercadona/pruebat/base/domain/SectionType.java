package com.mercadona.pruebat.base.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Getter;

import static java.util.Optional.ofNullable;

@Getter
public enum SectionType {

    FROZEN("1"), PALLETIZED("2"), COOLED("3"),NONE("999");

    private final String codigo;
    private static final Map<String, SectionType> tipos;

    static {
        tipos = Arrays.stream(values())
            .collect(Collectors.toMap(SectionType::getCodigo, Function.identity()));
    }

    SectionType(String codigo) {
        this.codigo = codigo;
    }

    public static SectionType getTipo(String codigo) {
        return ofNullable(tipos.get(codigo)).orElse(SectionType.NONE);
    }
}
