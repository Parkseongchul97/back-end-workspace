package com.kh.exam.controller;


import com.kh.exam.modle.Book;
import com.kh.exam.modle.Member;

public class BookControoller {
	private Member mem = new Member();
	private Book bArr[] =  new Book[4];
	private int count = 0;
	
	public void settingBook (Book b) {// 책 정보 넣기
		bArr[count++] = new Book(b.getTitle(), b.isCoupon(), b.getAccessAge());
		
	}
	public int couponCount(Book b){ // 쿠폰 카운트
		if(b.isCoupon() == true) {
			count++;
			return count ;
			
		}else 
			return count;
		
		}
	public void coponCheck() {// 쿠폰 카운트 2
			
	}
	public Book[] bookinfo() { // 도서 대여하기 안내문구
		return bArr;
	}	
	public void bookselect() {
		Book[] bArr = bookinfo();
		for(int i = 0; i < bArr.length; i++) {
			if(bArr[i] != null)System.out.println(i+1 + "번 도서 : " + bArr[i]);
			}
	}
	public Book insertBook(int i) {
		Book[] bArr = bookinfo();
		return bArr[i];
	}
		
	public Book[] insertBook() {
		mem.setBook(insertBook());
		return bArr;
		
		
	}	
	}
	


