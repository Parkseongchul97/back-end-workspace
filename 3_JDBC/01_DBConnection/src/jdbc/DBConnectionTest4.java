package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import com.mysql.cj.protocol.Resultset;

import config.ServerInfo;

public class DBConnectionTest4 {
	


	public static void main(String[] args) {
		DBConnectionTest4 db = new DBConnectionTest4();
		db.deleteEmployee(300);		
	}
	
	public void deleteEmployee(int empId) {
		try {
			
			Properties p = new Properties(); //객체 생성하고 
			p.load(new FileInputStream("src/config/jdbc.properties")); // 아까만든 파일 불러오고 
			
			Class.forName(ServerInfo.DRIVER_NAME);
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER,ServerInfo.PASSWORD);
			
			String query = p.getProperty("delete"); // "DELETE FROM employee WHERE emp_id = ?" 들어있는 파일
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);// 삭제할 대상의 emp_id
			System.out.println(ps.executeUpdate() + "명을 삭제 했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


