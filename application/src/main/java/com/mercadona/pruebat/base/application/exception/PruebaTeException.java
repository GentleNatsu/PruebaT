package com.mercadona.pruebat.base.application.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PruebaTeException extends RuntimeException {

    private final ErrorCode code;
    private List<String> details;
    private final Object[] parameters;

    public PruebaTeException(ErrorCode code, Object... parameters) {
        super();
        this.code = code;
        this.parameters = parameters;
        this.details = new ArrayList<>();
    }

    public static PruebaTeException withDetails(ErrorCode code, List<String> details) {
        var exception = new PruebaTeException(code);
        exception.setDetails(details);
        return exception;
    }
}
