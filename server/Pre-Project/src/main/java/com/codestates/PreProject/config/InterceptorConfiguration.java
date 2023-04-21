package com.codestates.PreProject.config;

import com.codestates.PreProject.auth.interceptor.JwtParseInterceptor;
import com.codestates.PreProject.auth.jwt.JwtTokenizer;
import com.codestates.PreProject.auth.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfiguration implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new JwtParseInterceptor(jwtUtils()))
                .addPathPatterns("/questions")
                .addPathPatterns("/questions/**")
                .addPathPatterns("/commentsOfQuestion/*");
    }


    @Bean
    public JwtUtils jwtUtils() { return new JwtUtils(jwtTokenizer()); }
    @Bean
    public JwtTokenizer jwtTokenizer() {
        return new JwtTokenizer();
    }

}
