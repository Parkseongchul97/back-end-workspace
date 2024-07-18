package com.kh.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.model.Member;

import config.ServerInfo;

public class MemberController {
	
	Properties p = new Properties();
	
	// 싱글톤 패턴(Singleton Pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴 
	
	// 1. 생성자는 private 
//	private MemberController() {}
	
	// 2. 유일한 객체를 담을 static 변수 
	private static MemberController instance;
	
	// 3. 객체를 반환하는 static 메서드
	public static MemberController getInstance() {
		if(instance == null) 
			instance = new MemberController();
		return instance;
	}
	
	
	
	// 구동,연결,마무리
	public MemberController() {
		try {
			
			p.load(new FileInputStream("src/config/jdbc.properties"));
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public Connection linkMember(){
		
		try {
			return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	 
		
	}

	public void closeAll(PreparedStatement ps, Connection con) {
		try {
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void closeAll(PreparedStatement ps, Connection con, ResultSet rs) {
		try {
			closeAll(ps,con);
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// 기본작업 끝 
	
	public boolean idCheck(String id) throws SQLException { // 아이디 채크
			boolean check = false;
			Connection con = linkMember();
			String query = "SELECT * FROM member WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1 ,id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) 				
				check = rs.getString("id").equals(id);
			closeAll(ps,con,rs);
			return check;
	}
	

	// 회원가입 기능 구현! 
	// -> 아이디가 기존에 있는지 체크 여부!
	// -> member 테이블에 데이터 추가! 
	public String signUp(String id, String password, String name) throws SQLException {
		
		Connection con = linkMember();
		PreparedStatement ps = con.prepareStatement(p.getProperty("signUp"));
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.executeUpdate() ;
		closeAll(ps,con);
		return "성공적으로 회원가입 완료하였습니다.";
		


	}
	
	// 로그인 기능 구현! 
	// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!
	public String login(String id, String password) throws SQLException {
		Connection con = linkMember();
		String query = "SELECT * FROM member WHERE id = ? and password = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1 ,id);
		ps.setString(2 ,password);
		ResultSet rs = ps.executeQuery();
		String name = null;
		if(rs.next()) 
			name = rs.getString("name");
		closeAll(ps,con,rs);
		return name;
	}
	
	public boolean changePassword(String id, String beforePassword, String afterPassword) throws SQLException {
		
		if(login(id, beforePassword) != null){
			Connection con = linkMember();
			String query = "UPDATE member SET password = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, afterPassword);
			ps.setString(2, id);
			ps.executeUpdate();
			closeAll(ps,con);
			return true;
		}
		 	return false;

		// 비밀번호 바꾸기 기능 구현!
		// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

	}
	
	// 이름 바꾸기 기능 구현!
	// -> member 테이블에서 id로 새로운 이름으로 변경 
	public String changeName(String id, String afterName) throws SQLException {

			Connection con = linkMember();
			String query = "UPDATE member SET name = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, afterName);
			ps.setString(2, id);
			ps.executeUpdate() ;
			closeAll(ps,con);
			return "이름변경에 성공하셨습니다.";
		}
	
		
	}
	










