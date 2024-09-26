package com.semi.youtube.model.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.lang.Collections;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// 스프링 시큐리티 에서 제공하는 UserDetails 인터페이스 상속

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Member implements UserDetails{
	private String id, password, email, phone;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return java.util.Collections.emptyList();
	}

	@Override
	public String getUsername() {
		
		return id;
	}

}
