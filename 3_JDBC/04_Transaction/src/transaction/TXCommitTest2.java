package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class TXCommitTest2 {

	public static void main(String[] args) {
		
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. DB 연결
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
			
			con.setAutoCommit(false);
			String query1  = "UPDATE bank SET balance = balance - ? WHERE name = ? ";
//			String query2  = "UPDATE bank SET balance = balance + ? WHERE name = ? ";
			String query3  = "SELECT balance FROM bank WHERE name = ?";
			
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setInt(1, 30000);
			ps1.setString(2, "동엽");
			ps1.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement(query1);
			ps2.setInt(1, -30000);
			ps2.setString(2, "동호");
			ps2.executeUpdate();
			PreparedStatement ps3 = con.prepareStatement(query3);
			ps3.setString(1, "동엽");
			ResultSet rs = ps3.executeQuery();
			
			/*
			 * 동엽(10만)-> 동호(0원) : 3만원씩 이체 
			 * 동엽님의 잔액이 마니어스가 되면 이체 취소!
			 * */
			if (rs.next()) {
				if (rs.getInt("balance") > 0) {
					con.commit();
					System.out.println("이체 성공!");
				} else {
					con.rollback();
					System.out.println("이체 실패 ㅠㅠ");
			}	
			}
			con.setAutoCommit(true);
			con.close();
			ps1.close();
			ps2.close();
			ps3.close();
			rs.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
					

	}

}
