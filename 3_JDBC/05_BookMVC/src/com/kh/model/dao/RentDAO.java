package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;
import com.kh.model.vo.Rent;


public class RentDAO {
DAO c = new DAO();
	

	
	
	// 1. 책 대여
		public void rentBook(int memberNum , int bookNum) throws SQLException {
			// printBookAll 메서드 호출하여 전체 책 조회 출력 후
			// 대여할 책 번호 선택을 사용자한테 입력 받아
			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
			// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
			Connection con = c.link();
			String query ="INSERT INTO rent(rent_mem_no, rent_book_no) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, memberNum);
			ps.setInt(2, bookNum);
			ps.executeUpdate() ;
			c.closeAll(ps,con);
			
		}
		// 랜트에 book no를 돌려서 내가 고른 번호랑 일치시 대여 불가 
		public boolean rentNumCheck(int rentNum) throws SQLException {
			boolean check = false;
			Connection con = c.link();
			String query = "SELECT rent_book_no FROM rent ";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				check = (rentNum == rs.getInt("rent_book_no"));
				if(check)break;
			}
			c.closeAll(ps,con,rs);
			return check;

		}
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 14일 조회
		// 2. 내가 대여한 책 조회
		public ArrayList<Rent> printRentBook(int memberNum) throws SQLException {
			Connection con = c.link();
			String query = "SELECT rent_no, bk_title, bk_author , adddate(rent_date, interval 14 day) as return_date FROM rent JOIN book ON (rent_book_no = bk_no) WHERE rent_mem_no = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, memberNum);
			ResultSet rs = ps.executeQuery();
			ArrayList<Rent> list = new ArrayList<Rent>() ;
			while(rs.next()) {
				Rent rent = new Rent();
				rent.setRentNum(rs.getInt("rent_no"));
				Book book = new Book();
				book.setBookTitle(rs.getString("bk_title"));
				book.setBookAuthor(rs.getString("bk_author"));
				rent.setRentBookKey(book);
				rent.setRentDate( rs.getDate("return_date"));
		
				list.add(rent);
			}
			c.closeAll(ps, con);
			return list;
		}
		//3-1. 대여 번호 존재하나 확인
		public boolean rentNumCheck(int rentBookNum ,int memberNum) throws SQLException {
			boolean check = false;
			Connection con = c.link();
			String query = "SELECT rent_no FROM rent WHERE rent_no = ? and rent_mem_no = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1 ,rentBookNum);
			ps.setInt(2 ,memberNum);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {				
				check = (rentBookNum == rs.getInt("rent_no"));
				if(check)break;
			}
			c.closeAll(ps,con,rs);
			return check;
			
		}


		// 3. 대여 취소
		public void deleteRent(int rentBookNum) throws SQLException {
			// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
			// 취소할 대여 번호 선택을 사용자한테 입력 받아
			Connection con = c.link();
			String query = "DELETE FROM rent WHERE rent_no = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rentBookNum);
			ps.executeUpdate();
			c.closeAll(ps, con);
			
			// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
			// 실패하면 "대여를 취소하는데 실패했습니다." 출력
		}
		// 렌트 체크 
		public boolean allDeleteMemberRentCheck(int memberNum) throws SQLException {
			boolean check = false;
			Connection con = c.link();
			String query = "SELECT * FROM rent WHERE rent_mem_no = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1 ,memberNum);
			ResultSet rs = ps.executeQuery();
			check = rs.next();
			return check;
		}
		// 4-1 해당 맴버의 대여한 모든 책 반납
		public void deleteMemberRent(int rentMemberNum) throws SQLException {
			Connection con = c.link();
			String query = "DELETE FROM rent WHERE rent_mem_no = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, rentMemberNum);
			ps.executeUpdate();
			c.closeAll(ps, con);
			

		}


}
