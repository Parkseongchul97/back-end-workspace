package com.kh.security.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.kh.security.model.vo.Member;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenProvider tokenProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 클라이언트에서 보낸 토큰을 받아서 사용자 확인 후 인증 처리
		
		String token = parseBearerToken(request);
		if(token != null && !token.equalsIgnoreCase("null")) {
			Member member = tokenProvider.validate(token);
			// 추출된 인증 정보를 필터링에서 사용할 수 있도록 SecurityContext에 등록
			AbstractAuthenticationToken authentication 
			= new UsernamePasswordAuthenticationToken(member, member.getPassword(), member.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			
			SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
			securityContext.setAuthentication(authentication);
			
			SecurityContextHolder.setContext(securityContext);
		}
		
		filterChain.doFilter(request, response);
		
	}
	private String parseBearerToken(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		System.out.println("토큰만 남기기 전 : " + bearerToken);
		// 토큰넣을때 Bearer라는 인증되었다는 의미의 글씨를 추가함 그경우
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) { 
			// 토큰넣을때 "Bearer " 를 추가해서 인덱스 0~6은 버리고 리턴
			return bearerToken.substring(7);
		}
		return null;
	}

}
