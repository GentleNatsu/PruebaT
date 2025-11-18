package com.mercadona.pruebat.base;


import com.mercadona.framework.cna.commons.rest.api.model.ErrorResource;
import com.mercadona.framework.cna.commons.rest.api.model.ErrorResourceResponse;
import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.lib.MessagesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static java.util.Optional.ofNullable;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class DomainExceptionHandler {

    private final MessagesService messagesService;

    @ExceptionHandler({PruebaTeException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResourceResponse handlePruebaTeException(PruebaTeException exception) {
        ErrorResource error = getError(exception);
        log.error("Procesada PruebaTeException: {}", error.getDescription());
        return new ErrorResourceResponse(error);
    }

    private ErrorResource getError(PruebaTeException exception) {
        String message = messagesService.getMessage(exception.getCode(), exception.getParameters());
        List<String> details = exception.getDetails();
        String errorCode = getErrorCode(exception);
        return getError(errorCode, message, details);
    }

    private static String getErrorCode(PruebaTeException exception) {
        return ofNullable(exception.getCode())
            .map(ErrorCode::getErrorCode)
            .orElse(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase());
    }

    private ErrorResource getError(String errorCode, String message, List<String> details) {
        return ErrorResource.builder()
            .code(errorCode)
            .description(message)
            .details(details)
            .build();
    }

}
