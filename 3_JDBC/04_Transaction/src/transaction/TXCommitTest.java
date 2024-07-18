package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TXCommitTest {

	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2. DB 연결 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/member" ,"root", "qwer1234");
			
			// 3. PreparedStatement + 쿼리문
			String query1 = "INSERT INTO member VALUES(?,?,?)";
			String query2 = "SELECT * FROM member WHERE id = ?";
			
			// 트랜젝션 시작명시
			con.setAutoCommit(false); // MySQL에서 오토커밋 끈거처럼
			
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.setString(1, "test5");
			ps1.setString(2, "123");
			ps1.setString(3, "테스트3");
			
			ps1.executeUpdate();
			
			PreparedStatement ps2 = con.prepareStatement(query2);
			ps2.setString(1, "test4");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) { // 회원이 있을 때  
				con.rollback();
				System.out.println("회원이 존재하여 회원 추가 취소!");
			}else { // 회원이 없을 떄
				con.commit();
				System.out.println("회원이 없어서 추가!");
			}
			
			// 트랜잭션 끝! 다시 원래대루
			con.setAutoCommit(true);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
