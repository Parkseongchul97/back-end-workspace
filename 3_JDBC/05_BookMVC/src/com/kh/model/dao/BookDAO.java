package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

/*
 * DAO(Data Access Object)
 * - DB에 접근하는 역할을 하는 객체 (CRUD)
 * */
public class BookDAO {
	DAO c = new DAO();
	
	// 책정보
	public ArrayList<Book> bookAllInfo() throws SQLException {
		Connection con = c.link();
		String query = "SELECT * FROM book "
				+ "LEFT Join publisher ON (pub_no = bk_pub_no) ";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<Book>() ;
		while(rs.next()) {
			Book book = new Book();
			book.setBookNum(rs.getInt("bk_no"));
			book.setBookTitle(rs.getString("bk_title"));
			book.setBookAuthor(rs.getString("bk_author"));
			Publisher publisher = new Publisher();
			publisher.setPublisherName(rs.getString("pub_name"));
			book.setPublisher(publisher);
			
			list.add(book);		
		}
		c.closeAll(ps, con);
		return list;
	}
	// 중복 책이 있느 체크
	
	public boolean bookCheck(String bookTitle ,String bookAuthor) throws SQLException {
		boolean check = false;
		Connection con = c.link();
		String query = "SELECT bk_title, bk_author FROM book WHERE bk_title = ? and bk_author = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1 ,bookTitle);
		ps.setString(2 ,bookAuthor);
		
		ResultSet rs = ps.executeQuery();

		check = rs.next();				
		c.closeAll(ps,con,rs);
		return check;
		
	}
	// 2-2. 책 정보 삽입
	public void bookInsert(String bookTitle ,String bookAuthor) throws SQLException {
	
		Connection con = c.link();
		String query = "INSERT INTO book(bk_title, bk_author) VALUES (? , ?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, bookTitle);
		ps.setString(2, bookAuthor);
		ps.executeUpdate();
		c.closeAll(ps, con);
	
	}
	// 3-1. 책 번호 존재하나 확인
	public boolean bookNumCheck(int bookNum) throws SQLException {
		boolean check = false;
		Connection con = c.link();
		String query = "SELECT bk_no FROM book WHERE bk_no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1 ,bookNum);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {				
			check = (bookNum == rs.getInt("bk_no"));
			if(check)break;
		}
		c.closeAll(ps,con,rs);
		return check;
		
	}
	// 3-2. 이미 빌린 책인지 확인
	public boolean rentBookCheck(int rentBookNum ) throws SQLException {
		boolean check = false;
		Connection con = c.link();
		String query = "SELECT rent_book_no FROM rent WHERE rent_book_no = ? ";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1 ,rentBookNum);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {				
			check = (rentBookNum == rs.getInt("rent_book_no"));
			if(check)break;
		}
		c.closeAll(ps,con,rs);
		return check;
		
	}
	
	
	// 3-3. 책 삭제
	public void bookDelete(int bookNum) throws SQLException {
		
		Connection con = c.link();
		String query = "DELETE FROM book WHERE bk_no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, bookNum);
		ps.executeUpdate();
		c.closeAll(ps, con);

	}
	

}
