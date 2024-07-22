package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.vo.Member;

public class MemberDAO {
	DAO c = new DAO();
	
	// 1-1. 아이디 체크
		public boolean idCheck(String memberId) throws SQLException {
			boolean check = false;
			Connection con = c.link();
			String query = "SELECT member_id FROM member WHERE member_id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1 ,memberId);
			ResultSet rs = ps.executeQuery();

			check = rs.next() 	;			
			c.closeAll(ps,con,rs);
			return check;
	}
		// 1-2. 회원가입
		
		public void signUpMember(String memberId, String memberPwd, String memberName) throws SQLException {
			Connection con = c.link();
			String query ="INSERT INTO member(member_id, member_pwd, member_name) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, memberId);
			ps.setString(2, memberPwd);
			ps.setString(3, memberName);
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
				member.setMemberName(rs.getString("member_name"));
				member.setMemberNum(rs.getInt("member_no"));	
				member.setStatus(rs.getString("status").charAt(0));
			}
			c.closeAll(ps,con,rs);
			return member;
			
		}
		// 회원 탈퇴 
		public int deleteMember(int memberNum) throws SQLException {
			Connection con = c.link();
			String query = "DELECT FORM member WHERE member_no = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, memberNum);
			int num = ps.executeUpdate();
			c.closeAll(ps, con);
			return num;
			
		}

}
