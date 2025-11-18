package com.mercadona.pruebat.base.application.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PruebaTeNoRollbackException extends PruebaTeException {

    public PruebaTeNoRollbackException(ErrorCode code, Object... parameters) {
        super(code, parameters);
    }
}
