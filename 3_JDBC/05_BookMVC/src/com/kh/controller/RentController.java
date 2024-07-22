package com.kh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

import com.kh.model.dao.BookDAO;
import com.kh.model.dao.DAO;
import com.kh.model.dao.RentDAO;
import com.kh.model.vo.Book;
import com.kh.model.vo.Rent;

public class RentController {
	DAO c = new DAO();
	RentDAO dao = new RentDAO();
	BookDAO bdao = new BookDAO();
	
	// 1. 책 대여
		public int rentBook(int memberNum , int bookNum){
			try {
				
				if(bdao.bookNumCheck(bookNum) ) {
					if(!dao.rentNumCheck(bookNum)) {
						dao.rentBook(memberNum, bookNum);
					// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
					return 0 ;
					
				}else {
					return 1;
					// 이미 대여된 책일떄
				}
				}else {
					return 2;
				}// 책정보 없을떄
		
			} catch (Exception e) {
				return 3;
			}
			
		}
		
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 14일 조회
		// 2. 내가 대여한 책 조회
		public ArrayList<String> printRentBook(int memberNum)  {
			
			try {
				ArrayList<String> s = new ArrayList<String>();
				for(Rent r : dao.printRentBook(memberNum)) {
					String str = "";
					LocalDate localDate = new Date(r.getRentDate().getTime()).toLocalDate();
					
					str +=  "대여번호 : "+ r.getRentNum() + "번";
					str +=  "\t책 이름 : "+ r.getRentBookKey().getBookTitle();
					str +=  "\t책 저자 : "+ r.getRentBookKey().getBookAuthor();
					str +=  "\t대여 일 : "+ r.getRentDate();
					str +=  "\t반납 일 : " + localDate.plusDays(14);
					s.add(str);
				}
				
				return s;
				
			} catch (SQLException e) {
				return null;
			}
			
			
		
		}



		// 3. 대여 취소
		public boolean deleteRent(int rentBookNum, int memberNum)  {
			try {
				if(dao.rentNumCheck(rentBookNum,memberNum)) {
				dao.deleteRent(rentBookNum);
				return true;
				}else {
					return false;
				}
					
			} catch (SQLException e) {
				return false;
			}
			
		}
		
		// 4-1 해당 맴버의 대여한 모든 책 반납
		public boolean deleteMemberRent(int rentMemberNum) {
			try {
				if(dao.allDeleteMemberRentCheck(rentMemberNum)) {
					
					
						dao.deleteMemberRent(rentMemberNum);
						return true;
					}else 
						return false;
			} catch (SQLException e) {
				return false;
			}
			

		}
		
}
