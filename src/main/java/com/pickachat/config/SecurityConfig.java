package com.pickachat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security 설정 클래스
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 개발 단계 설정: 모든 요청 허용
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // 모든 요청 허용
                )
                .csrf(AbstractHttpConfigurer::disable) // CSRF 보호 비활성화
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable) // 프레임 옵션 비활성화 (H2 Console 용)
                );

        // 배포 단계 설정 (주석 해제 필요)
//        http
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/", "/public/**").permitAll() // 공용 URL 허용
//                .anyRequest().authenticated() // 나머지 요청은 인증 필요
//            )
//            .formLogin(form -> form
//                .loginPage("/login") // 커스텀 로그인 페이지
//                .permitAll()
//            )
//            .csrf(csrf -> {}); // CSRF 보호 활성화

        return http.build();
    }
}
