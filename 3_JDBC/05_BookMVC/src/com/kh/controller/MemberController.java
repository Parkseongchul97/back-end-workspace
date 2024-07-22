package com.kh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.DAO;
import com.kh.model.dao.MemberDAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Member;
import com.kh.model.vo.Rent;

public class MemberController {
	DAO c = new DAO();
	MemberDAO dao = new MemberDAO();
	RentDAO rdao = new RentDAO();
	
	// 1-1. 아이디 체크


	// 1-2. 회원가입
	
	public boolean signUpMember(String memberId, String memberPwd, String memberName) {
		try {
			if(!dao.idCheck(memberId)) { // idCheck는 DB단에서 유니크로 잡혀있어서 여기 try catch문에 잡혀서 필요없음...
				dao.signUpMember(memberId, memberPwd, memberName);
				return true;
			}else
				return false;
			
			
		} catch (SQLException e) {
				return false;
		}
		
	}

	// 2. 로그인
	public Member login(String memberId, String memberPwd)  {
		try {Member m = dao.login(memberId, memberPwd);
			if(m.getStatus() == 'N')return m;	
		} catch (SQLException e) {
			return null;
		}
		return null;
		
		
		
	}
	// 회원 탈퇸
	public boolean deleteMember(int memberNum) {
		try {
			// 따로 안만들고 rentController에 있는 내가 보유중인 책 확인하는 메서드 이용해도댐
//			ArrayList<Rent> list= rdao.printRentBook(memberNum);
//			if (list.size() > 0)// 조건으로 사이즈가 0보다 큰 조건으로 확인
			rdao.deleteMemberRent(memberNum);
			if(dao.deleteMember(memberNum) == 1)
			return true;
		} catch (SQLException e) {
			
		}
		return false;

	}
	


}
