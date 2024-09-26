package com.kh.security.config;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.kh.security.model.vo.Member;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenProvider {
	
	
	private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
	
	public String create(Member member) {
		
		return Jwts.builder()
				.signWith(secretKey)
				.setClaims(Map.of(
						"id", member.getId(),
						"name" , member.getName(),
						"role" , member.getRole()
						))
				.setIssuedAt(new Date()) // 토큰 생성날짜
				.setExpiration(Date.from(Instant.now().plus(1,ChronoUnit.DAYS))) // 토큰 유효기간 오늘부터 1일만
				.compact() ;
	}
	
	public Member validate(String token) { // 토큰으로 맴버 정보 가져오기
		Claims claims = Jwts
					.parser()
					.setSigningKey(secretKey)
					.parseClaimsJws(token)
					.getBody();
		
		return Member.builder()
				.id((String)claims.get("id"))
				.name((String)claims.get("name"))
				.role((String)claims.get("role"))
				.build();
		
	}
}
