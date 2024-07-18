package com.kh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.Member;

public class MemberController {
	Controoller c = new Controoller();
	
	
	// 1-1. 아이디 체크
	public boolean idCheck(String memberId) throws SQLException {
		boolean check = false;
		Connection con = c.link();
		String query = "SELECT member_id FROM member WHERE member_id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1 ,memberId);
		ResultSet rs = ps.executeQuery();

		if(rs.next()) 				
			check = rs.getString("member_id").equals(memberId);
		c.closeAll(ps,con,rs);
		return check;
}
	// 1-2. 회원가입
	
	public void signUpMember(String memberId, String memberPwd, String MemberName) throws SQLException {
		Connection con = c.link();
		String query ="INSERT INTO member(member_id, member_pwd, member_name) VALUES (?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, memberId);
		ps.setString(2, memberPwd);
		ps.setString(3, MemberName);
		ps.executeUpdate() ;
		c.closeAll(ps,con);
		
	}

	// 2. 로그인
	public Member login(String memberId, String memberPwd) throws SQLException {
		Connection con = c.link();
		String query = "SELECT * FROM member WHERE member_id = ? and member_pwd = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1 ,memberId);
		ps.setString(2 ,memberPwd);
		ResultSet rs = ps.executeQuery();
		Member member = new Member();
		if(rs.next()) {
			member.setMemberId(rs.getString("member_id"));
			member.setMemberPwd(rs.getString("member_pwd"));
			member.setMemberName(rs.getString("member_name"));
			member.setMemberNum(rs.getInt("member_no"));	
		}
		c.closeAll(ps,con,rs);
		return member;
		
	}
	


}
