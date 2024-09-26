package com.kh.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ajax.service.MemberService;
import com.kh.model.vo.Member;

@Controller
public class AjaxController {
	
	@Autowired
	private MemberService service;
	
	private int count = 0;
	
	
	@ResponseBody
	@GetMapping("/count")
	public int count() {
		System.out.println("ajax로 요청이 들어옴!");
		return ++count;
	}
	@ResponseBody
	@GetMapping("/encoding")
	public String encoding(String nickname) {
		System.out.println(nickname);
		
		return nickname;
	}
	
	@ResponseBody
	@PostMapping("/idCheck")
	public boolean idCheck(String id) {	
		Member mem = service.idCheck(id);
		
		if(mem == null) {
			return true;
		}else
			return false;
	}
	
	
	@ResponseBody
	@PostMapping("/serial")
	public Member serialize(Member member) {
		System.out.println("도착!");
		System.out.println(member);
		if(member.getName().length() >= 10) {
			System.out.println("이름이 10글자가 넘어 커팅");
			member.setName(member.getName().substring(0, 10));
		}
		if (idCheck(member.getId())) {
			service.serialize(member);
			System.out.println("가입성공?");
			return member;
		} else {
			System.out.println("중복아이디");
			return null;
		}
	}
	
}
