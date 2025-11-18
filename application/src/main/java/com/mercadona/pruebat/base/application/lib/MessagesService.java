package com.mercadona.pruebat.base.application.lib;

import com.mercadona.pruebat.base.application.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessagesService {

    private final MessageSource messages;

    public String getMessage(ErrorCode code, Object[] parameters) {
        return getMessage(code.toString(), parameters);
    }

    public String getMessage(String code, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        try {
            return messages.getMessage(code, args, locale);
        } catch (NoSuchMessageException exception) {
            return code;
        }
    }
}
