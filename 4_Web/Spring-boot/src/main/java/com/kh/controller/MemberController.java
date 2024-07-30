package com.kh.controller;

import java.net.http.HttpRequest;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;
import com.kh.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("register")
	public void register() {}// 앞뒤로 설정에 넣은 /WEB-INF/views + "register" + .jsp 를 스프링이 넣어줌
	
	@PostMapping("register")
	public String register(Member vo) {
		try {
			service.register(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	} 
	@GetMapping("login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		
		try {
			Member mem = service.login(vo);	
			
			HttpSession session = request.getSession();
			session.setAttribute("longinMember", mem);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "redirect:/";	
	}
	@GetMapping("search")
	public void search() {}
	
	@GetMapping("find")
	public String find(@RequestParam("id") String id, Model model) {
		System.out.println(id);
		try {
			Member member = null;
			member = service.search(id);	
			if(member != null) {
				model.addAttribute("memberinfo", member);
				return "search_ok";
			}
			
		} catch (SQLException e) {}
		return "redirect:/fail";	

	}
	@GetMapping("fail")
	public String fail() {
		return "search_fail";
	}
	
	@GetMapping("allMember")
	public String allMember(Model model) {
		
		ArrayList<Member> list = null;
		try {
			list =  service.allMember();
			
		} catch (SQLException e) {}
		model.addAttribute("memberList", list);
		
		return "allMember";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("longinMember");
		if(member != null) 
			session.invalidate();
		return "redirect:/";
		
	}
}




















