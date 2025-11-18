package com.mercadona.pruebat.base.mercaceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Locale;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public final class LocaleMercaceptor implements HandlerInterceptor {

    public static final String LANG_PARAMETER = HttpHeaders.ACCEPT_LANGUAGE;
    public static final Locale DEFAULT_LOCALE = Locale.forLanguageTag("es-es");

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,
        @NonNull HttpServletResponse response, @NonNull Object handler) {

        var locale = getRequestLocale(request).map(this::strToLocale).orElse(DEFAULT_LOCALE);
        LocaleContextHolder.setLocale(locale);
        return true;
    }

    private Optional<String> getRequestLocale(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(LANG_PARAMETER));
    }

    private Locale strToLocale(String localeStr) {
        Locale locale = Locale.forLanguageTag(localeStr);
        return StringUtils.isBlank(locale.getLanguage()) ? DEFAULT_LOCALE : locale;
    }
}
