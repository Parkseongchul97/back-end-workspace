package com.semi.youtube.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;





@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

	
	// 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.formLogin(login -> 
					login.loginPage("/login") // 로그인 페이지 등록
						.defaultSuccessUrl("/", true) // 성공시 위치
						.permitAll()
						) // 로그인 시큐리티에 맡기고 세션처리 하겟다
				.logout(logout ->
					logout
						.logoutUrl("/logout")// 로그아웃 요청 url
						.logoutSuccessUrl("/")
						.permitAll()
						)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
				.authorizeHttpRequests(authorize ->
					authorize
						.requestMatchers("/like", "/unlike").authenticated()
						.anyRequest().permitAll()// 일단전부허용
						)				
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

