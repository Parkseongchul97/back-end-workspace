package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	
	public MemberDAO () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection connect() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close(PreparedStatement ps, Connection con) {
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void close(PreparedStatement ps, Connection con, ResultSet rs) {
		try {
			close(ps,con);
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 회원가입
	public boolean registerMember(String id, String pwd, String name) throws SQLException {
		
		
			Connection con = connect();
			String query = "INSERT INTO member VALUES(?,?,?) ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,id );
			ps.setString(2, pwd);
			ps.setString(3, name);
			int i = ps.executeUpdate();
			
			close(ps, con);
			if(i >= 1) {
				return true;
			}
			return false;
	
	}
	public ArrayList<Member> listMember() throws SQLException{
			Connection con = connect();
			String query = "SELECT * FROM member";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ArrayList<Member> list = new ArrayList<Member>();
			while(rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("password"));
				m.setName(rs.getString("name"));
				list.add(m);
			}
			close(ps, con, rs);
		return list;
		
	}
	public Member searchMember(String id) throws SQLException{
		Connection con = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member mem = new Member();
		if(rs.next()) {
			
			mem.setId(rs.getString("id"));
			mem.setPwd(rs.getString("password"));
			mem.setName(rs.getString("name"));
		}
		close(ps, con, rs);
	return mem;
	
}

}
