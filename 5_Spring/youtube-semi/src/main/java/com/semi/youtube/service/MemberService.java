package com.semi.youtube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.semi.youtube.model.vo.Member;

import mapper.MemberMapper;

@Service
public class MemberService implements UserDetailsService {
	@Autowired 
	private MemberMapper member;
	
	@Autowired
	private PasswordEncoder bcpe;
	
	public boolean idCheck (String id) {
		Member vo = member.idCheck(id);
		
		if(vo != null) {
			return true;
		}else {
			return false;
		}
		
		
	}
	public void signup(Member vo) {
		// 비밀번호 암호화
		vo.setPassword(bcpe.encode(vo.getPassword()));
		System.out.println(bcpe.encode(vo.getPassword()));
		member.signup(vo);
		
		
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("로그인!");
		System.out.println("유저네임 : " + username);
		return member.idCheck(username);
	}
}
