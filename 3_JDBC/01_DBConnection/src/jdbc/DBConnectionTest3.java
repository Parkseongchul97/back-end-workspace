package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import com.mysql.cj.protocol.Resultset;

import config.ServerInfo;

public class DBConnectionTest3 {
	


	public static void main(String[] args) {
		DBConnectionTest3 d = new DBConnectionTest3();
		d.dbUpdate("박성철", 900);
		
		
	}
	public void dbUpdate (String emp_name, int emp_id) {
			
			try {
				// 1. 드라이버 로딩
				Class.forName(ServerInfo.DRIVER_NAME);
				// 2. 데이터베이스 연결
				Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
				
				// 3. PreparedStatemnt - UPDATE
				String query = "    UPDATE employee "
							 + "    SET emp_name = ?"
							 + "	WHERE emp_id = ?";
				PreparedStatement ps = conn.prepareStatement(query);
				
				ps.setString(1, emp_name); // 변경할 이름
				ps.setInt(2, emp_id); // 변경할 대상의 아이디 
				
				System.out.println(ps.executeUpdate() + "명이 변경되었습니다.");
	
				
			} catch (Exception e) {
				System.out.println("오류 발생");
				e.printStackTrace();
			}
			
		}
	}


