package com.kh.controller;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.dao.BookDAO;
import com.kh.model.dao.DAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Publisher;

import config.ServerInfo;

public class BookController {
	
	DAO c = new DAO();
	private BookDAO dao = new BookDAO();
	
	
	// 책 출력
	public ArrayList<String> printBookAllInfo() {
		try {
			ArrayList<Book> list = dao.bookAllInfo();
			ArrayList<String> s = new ArrayList<String>();
			for(Book b : list) {
				String str = "";
				str +=  "책번호 : "+ b.getBookNum() + "번";
				str +=  "\t이름 : "+ b.getBookTitle();
				str +=  "\t저자 : "+ b.getBookAuthor();
				if(b.getPublisher().getPublisherName() == null) {
					str +=  "\t출판사 이름 : 추가필요!" ;
				}else {
				str +=  "\t출판사 이름 : "+ b.getPublisher().getPublisherName();
				}
				s.add(str);
			}
			
			return s;
		} catch (SQLException e) {
			return null;
		}
		
	}
	


	// 2-2. 책 정보 삽입
	public boolean bookInsert(String bookTitle ,String bookAuthor) {
		try {
			if(!dao.bookCheck(bookTitle, bookAuthor)){
				dao.bookInsert(bookTitle, bookAuthor);
				return true;
			}else return false;
		} catch (SQLException e) {
			return false;
		}

	}
	
	// 3-1. 책 삭제
	public int bookDelete(int bookNum)  {
		try {
			if(dao.bookNumCheck(bookNum)) {
				if(!dao.rentBookCheck(bookNum)) {
						dao.bookDelete(bookNum);
						return 0;
		}else {
			return 1;
		}
				}else {
					return 2;
		}
			}catch (SQLException e) {
				return 3;
			
		}
		
		

	}
}

