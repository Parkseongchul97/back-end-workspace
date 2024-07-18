package com.kh.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Book;

import config.ServerInfo;

public class BookDMLControoller {
	
	Controoller c = new Controoller();
	
	// 1. 책 정보 출력
	public ArrayList<Book> bookAllInfo() throws SQLException {
		Connection con = c.link();
		String query = "SELECT * FROM book ";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<Book> list = new ArrayList<Book>() ;
		while(rs.next()) {
			list.add(new Book(rs.getInt("bk_no"), rs.getString("bk_title"), rs.getString("bk_author"), rs.getInt("bk_price"), rs.getInt("bk_pub_no")));
			
		}
		c.closeAll(ps, con);
		return list;
	}
	// 2-1. 책 저자, 제목 동일한지 확인
	public boolean bookCheck(String bookTitle ,String bookAuthor) throws SQLException {
		boolean check = false;
		Connection con = c.link();
		String query = "SELECT bk_title, bk_author FROM book WHERE bk_title = ? and bk_author = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1 ,bookTitle);
		ps.setString(2 ,bookAuthor);
		
		ResultSet rs = ps.executeQuery();

		if(rs.next()) 				
			check = rs.getString("bk_title").equals(bookTitle) 
				 && rs.getString("bk_author").equals(bookAuthor);
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
	// 3-1. 책 삭제
	public void bookDelete(int bookNum) throws SQLException {
		
		Connection con = c.link();
		String query = "DELETE FROM book WHERE bk_no = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, bookNum);
		ps.executeUpdate();
		c.closeAll(ps, con);

	}
}
