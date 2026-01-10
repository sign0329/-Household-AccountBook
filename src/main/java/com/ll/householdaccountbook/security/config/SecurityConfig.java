package com.ll.householdaccountbook.security.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/loginPage",
                                "/login",
                                "/login_proc",
                                "/account-books",
                                "/h2-console",
                                "/categories"
                        ).permitAll()
                        .anyRequest().authenticated()
                );

                //  폼 로그인 설정
//                .formLogin(form -> form
//                        .loginPage("/loginPage")          // 커스텀 로그인 페이지
//                        .permitAll()
//
//                        //나중에 로그인 작업시 설정바꿔줄것
//                        .loginProcessingUrl("/login_proc")// 로그인 처리 URL
//                        .usernameParameter("userId")      // 아이디 파라미터
//                        .passwordParameter("passwd")      // 비밀번호 파라미터
//
//                         //로그인 성공 시
//                        .successHandler(this::onLoginSuccess)
//
//                         //로그인 실패 시
//                        .failureHandler(this::onLoginFailure)
//                )
//
//                // 로그아웃 (기본 설정)
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/loginPage")
//                )
//
//                // CSRF (필요 시 조정)
//                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // ===== 로그인 성공 핸들러 =====
    private void onLoginSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException {

        System.out.println("로그인 성공 사용자: " + authentication.getName());
        response.sendRedirect("/");
    }

    // ===== 로그인 실패 핸들러 =====
    private void onLoginFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
    ) throws IOException {

        System.out.println("로그인 실패 사유: " + exception.getMessage());
        response.sendRedirect("/login");
    }
}
