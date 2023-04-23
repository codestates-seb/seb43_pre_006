package com.codestates.PreProject.config;

import com.codestates.PreProject.auth.filter.JwtAuthenticationFilter;
import com.codestates.PreProject.auth.filter.JwtVerificationFilter;
import com.codestates.PreProject.auth.handler.*;
import com.codestates.PreProject.auth.interceptor.JwtParseInterceptor;
import com.codestates.PreProject.auth.jwt.JwtTokenizer;
import com.codestates.PreProject.auth.utils.CustomAuthorityUtils;
import com.codestates.PreProject.auth.utils.JwtUtils;
import com.codestates.PreProject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtTokenizer jwtTokenizer;

    private final CustomAuthorityUtils authorityUtils;

    private final MemberService memberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()

//                .cors(withDefaults())
                .cors()
                .configurationSource(corsConfigurationSource())

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()

                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())  // 추가
                .accessDeniedHandler(new MemberAccessDeniedHandler())            // 추가

//                .and()
//                .formLogin().defaultSuccessUrl("/") //로그인 성공시 이동할 페이지

                .and()//로그아웃 구현
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                .logoutSuccessUrl("/")

                .and()
                .apply(new CustomFilterConfigurer())

                .and()
                .authorizeHttpRequests(authorize -> authorize
                                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                                .antMatchers("/members/*").permitAll()
//                                .antMatchers("/auth/*").permitAll()
//                                .antMatchers(HttpMethod.POST, "/questions").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.POST, "/questions/**").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.POST, "/commentsOfQuestion/**").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.POST, "/commentsOfAnswer/**").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.PATCH, "/questions/**").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.PATCH, "/answers/**").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.PATCH, "/commentsOfQuestion/**").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.PATCH, "/commentsOfAnswer/**").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.GET, "/questions/*").permitAll()
//                                .antMatchers(HttpMethod.GET, "/questions").permitAll()
//                                .antMatchers(HttpMethod.GET, "/answers").permitAll()
//                                .antMatchers(HttpMethod.GET, "/answers/*").permitAll()
//                                .antMatchers(HttpMethod.DELETE, "/questions/*").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.DELETE, "/answers/*").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.DELETE, "/commentsOfQuestion/*").hasAnyRole("USER","ADMIN")
//                                .antMatchers(HttpMethod.DELETE, "/commentsOfAnswer/*").hasAnyRole("USER","ADMIN")
                                .anyRequest().permitAll()
                )
                .oauth2Login(oauth2 -> oauth2
                        .successHandler(new OAuth2MemberSuccessHandler(jwtTokenizer,memberService))
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
        corsConfiguration.setAllowedMethods(Arrays.asList("*"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
        corsConfiguration.setExposedHeaders(Arrays.asList("*"));
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(false);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {

        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager,jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/auth/login");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer, authorityUtils);

            builder
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class)
                    .addFilterAfter(jwtVerificationFilter, OAuth2LoginAuthenticationFilter.class);

        }
    }


//    @Bean
//    public JwtUtils jwtUtils() { return new JwtUtils(jwtTokenizer()); }
//
//    @Bean
//    public JwtTokenizer jwtTokenizer() { return new JwtTokenizer(); }

}