package com.mercadona.pruebat.base.mercaceptors;

import com.mercadona.pruebat.base.application.exception.ErrorCode;
import com.mercadona.pruebat.base.application.exception.PruebaTeException;
import com.mercadona.pruebat.base.application.lib.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new PruebaTeException(ErrorCode.PROVETA_ERROR);
        }
        String token = authHeader.substring(7);

        try {
            Claims claims = JwtUtil.validateToken(token);
            request.setAttribute("username", claims.getSubject());
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            throw new PruebaTeException(ErrorCode.PROVETA_ERROR);
        }

        return true;
    }
}
 