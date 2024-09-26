package com.semi.youtube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.cj.Session;

import com.semi.youtube.model.vo.Member;
import com.semi.youtube.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService member;
	
	// 로그인, 로그아웃은 스프링 시큐리티가 다해줌
	 
	// 중복체크
	@ResponseBody
	@PostMapping("/check")
	public boolean idCheck(String id) {
		
		return member.idCheck(id);
		
	
	}
	
	// 회원가입
	@PostMapping("/signup")
	public String signup(Member vo) {
		System.out.println("서비스전"+vo);
		member.signup(vo);
		System.out.println("서비스 후" + vo);
		
		return "redirect:/";
		
	}
	
	// 로그인
		
	// 
}
