package com.codestates.PreProject.auth.interceptor;

import com.codestates.PreProject.auth.utils.ErrorResponder;
import com.codestates.PreProject.auth.utils.JwtUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Component
public class JwtParseInterceptor implements HandlerInterceptor {

    private final JwtUtils jwtUtils;

    private static final ThreadLocal<Long> authenticatedMemberId = new ThreadLocal<>();

    public JwtParseInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public static long getAuthenticatedMemberId() { return authenticatedMemberId.get(); }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            Map<String, Object> claims = jwtUtils.getJwsClaimsFromRequest(request);
            authenticatedMemberId.set(Long.valueOf(claims.get("memberId").toString()));
            return true;
        } catch (Exception e) {
            ErrorResponder.sendErrorResponse(response, HttpStatus.UNAUTHORIZED);
            return false;
        }
    }
}
