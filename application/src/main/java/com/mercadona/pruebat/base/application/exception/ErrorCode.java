package com.mercadona.pruebat.base.application.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    PROVETA_ERROR("T-01"),
    TOKEN_ERROR("T-02");

    private final String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}

