package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.vo.Member;

public class MemberDAO {
	public MemberDAO () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
	
	}
	
	public void close(PreparedStatement ps, Connection con) throws SQLException {
			ps.close();
			con.close();	
	}
	
	public void close(PreparedStatement ps, Connection con, ResultSet rs) throws SQLException {
			close(ps,con);
			rs.close();	
	}
	
	// DAO 개발의 중요한점
	// 매개변수를 뭘 가지고 와야되는지, 리턴타입 결과 출력이 어떤게 필요한지
	
	// 회원가입 기능 
	public void memberSignUp(Member mem) throws SQLException {
		
		Connection con = connect();
		String query = "INSERT INTO member VALUES(?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, mem.getId());
		ps.setString(2, mem.getPwd());
		ps.setString(3, mem.getName());
		ps.executeUpdate();
		
		close(ps, con);
		
	}
	public Member memberLogin(String id, String pwd) throws SQLException {
		Connection con = connect();
		String query = "SELECT * FROM member WHERE id = ? AND password = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member(rs.getString("id"),rs.getString("password"), rs.getString("name"));
		}
		close(ps, con, rs);
		return member;
	}
	public Member memberSearch(String id) throws SQLException {
		Connection con = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member member = null;
		if(rs.next()) {
			member = new Member(rs.getString("id"),rs.getString("password"), rs.getString("name"));
		}
		close(ps, con, rs);
		return member;
	}
	public ArrayList<Member>  memberAllInfo() throws SQLException {
		Connection con = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		 ArrayList<Member> list = new ArrayList();
		while(rs.next()) {
			Member member = new Member(rs.getString("id"),rs.getString("password"), rs.getString("name"));
			list.add(member);
		}
		close(ps, con, rs);
		return list;


}
	}

