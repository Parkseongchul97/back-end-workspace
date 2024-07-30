package com.kh.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	

	public void register(Member vo) throws SQLException {
			dao.memberSignUp(vo);
	} 

	public Member login(Member vo) throws SQLException {
			return dao.memberLogin(vo.getId(), vo.getPwd());	
	
	}

	public Member search(@RequestParam("id") String id) throws SQLException {
			return dao.memberSearch(id);	

	}

	public ArrayList<Member> allMember() throws SQLException {
			return dao.memberAllInfo();
			
	
	}
	

	
	

}
