package com.kh.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtFilter;
	
	// 특정 http 요청에 대한 웹 기반 보안 구성. 인증/인가 및 로그아웃 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.csrf(csrf -> csrf.disable())
				.httpBasic(basic -> basic.disable()) // httpBasic은 기존 방식인데 안쓰니 잠가둠
				// 세션방식도 죽여둠
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize ->
					authorize
						.requestMatchers("/member").authenticated() // 맴버로 요청이올때 인증받은 사람들만!
						.requestMatchers("/admin").hasRole("ADMIN") // 권한이 앞부분 자동인식(ROLE_)ADMIN인 경우만 들어올 수 있음 
						.anyRequest().permitAll()
						)
				 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
					
					
				.build();
	}
}
