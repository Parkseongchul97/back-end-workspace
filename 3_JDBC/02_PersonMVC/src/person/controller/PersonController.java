package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import person.model.Person;

public class PersonController {
		String queryInsert = "INSERT INTO person (name, age, addr ) VALUES ( ?, ?, ?) ";
		String queryUpdate = "UPDATE person SET name = ? ,age = ?, addr = ? WHERE id = ?";
		String queryDelete = "DELETE FROM person WHERE id = ?";
		String querySelectAll = "SELECT * FROM person";
		String querySelect = "SELECT * FROM person WHERE id = ?";
	
	// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경 가능!
	/* 1. 드라이버 로딩
	 * 2. DB 연결
	 * 3. PrearedStatement - 쿼리
	 * 4. 쿼리 실행
	 * 5. 자원 반납
	 * 
	 * */
		
		
		public PersonController() { // 생성할때 드라이버 로딩
			try {
				Class.forName(ServerInfo.DRIVER_NAME);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	// 고정적인 반복 -- DB 연결, 자원 반납 -> 공통적인 메서드 정의
	public Connection link () { // db연결 ~ 쿼리
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
	
	
	// 변동적인 반복 -- 비지니스 로직 DAO(Database Access Object)
	
	// person 테이블의 데이터 추가 - INSERT
	public int addPerson(String name, int age, String addr ) {
		
		try {
			Connection con = link();
			PreparedStatement ps = con.prepareStatement(queryInsert);
			
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
			int num = ps.executeUpdate() ;
			closeAll(ps,con);
			return num;
		} catch (SQLException e) {
			
			return 0;
		}		
	}
	
	// person 테이블의 데이터 수정 - UPDATE
	public String updatePerson(int updateId, String name, int age, String addr) {
		try {
			Connection con = link();
			PreparedStatement ps = con.prepareStatement(queryUpdate);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
			ps.setInt(4, updateId);

			String str = null;
			if(ps.executeUpdate() == 1) {
				str =  name + " 님 수정 완료";
				
			}else {
				str = "수정할 회원 : "+ name +"님을 찾지 못했습니다.";
				
			}
			closeAll(ps,con);
			return str;
		} catch (SQLException e) {
			
			return "수정할 회원 : "+ name +"님을 찾지 못했습니다.";
		}
	}
	
	// person 테이블의 데이터 삭제 - DELETE
	public String removePerson(int deleteId) {
		try {
			String str = "" ;
			Person person = searchPerson(deleteId);
			Connection con = link();
			PreparedStatement ps = con.prepareStatement(queryDelete);
			ps.setInt(1, deleteId);
			
			if (ps.executeUpdate()== 1) 
				str = person.getName() + " 님이 회원탈퇴 하셨습니다.";
			else 
				str = "탈퇴할 회원 ID : "+ deleteId +"를 찾지 못했습니다.";
			closeAll(ps,con);
			return str;
		} catch (SQLException e) {
			
			return "탈퇴할 회원 ID : "+ deleteId +"를 찾지 못했습니다.";
		}
		
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<Person> searchAllPerson() {
		try {
			Connection con = link();
			PreparedStatement ps = con.prepareStatement(querySelectAll);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Person> list = new ArrayList<Person>();
			while(rs.next()) {// 다음꺼가 없으면 false
				
				Person person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setAge(rs.getInt("age"));
				person.setAddr(rs.getString("addr"));
				list.add(person);	
			}
			closeAll(ps,con);
			return list;
			
		} catch (SQLException e) {
			
			return null;
		}
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public Person searchPerson(int idInfo) {
			String str = "" ;
		try {
			Connection con = link();
			PreparedStatement ps = con.prepareStatement(querySelect);
			ps.setInt(1 ,idInfo);
			ResultSet rs = ps.executeQuery();
			
			Person person = null;
			if(rs.next()) {
				person = new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr") );
				
			}	
			closeAll(ps,con,rs);
			return person;
		} catch (Exception e) {
			return null;
		}
		
	}

}
