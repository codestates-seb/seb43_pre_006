package com.codestates.PreProject.auth.interceptor;

import com.codestates.PreProject.auth.utils.ErrorResponder;
import com.codestates.PreProject.auth.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Component
@Slf4j
public class JwtParseInterceptor implements HandlerInterceptor {

    private final JwtUtils jwtUtils;

    private static final ThreadLocal<Long> authenticatedMemberId = new ThreadLocal<>();

    public JwtParseInterceptor(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    public static long getAuthenticatedMemberId() { return authenticatedMemberId.get(); }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("GET")) { // 조회할땐 거치지 않게
            return true;
        }
        try {
            Map<String, Object> claims = jwtUtils.getJwsClaimsFromRequest(request);
            authenticatedMemberId.set(Long.valueOf(claims.get("memberId").toString()));
            return true;
        } catch (Exception e) {
            log.info("에러남");
            ErrorResponder.sendErrorResponse(response, HttpStatus.UNAUTHORIZED);
            return false;
        }
    }
}
