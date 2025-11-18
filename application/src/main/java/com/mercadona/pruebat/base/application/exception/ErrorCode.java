package com.mercadona.pruebat.base.application.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    PROVETA_ERROR("T-01");

    private final String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}

