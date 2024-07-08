package com.kh.exam.controller;


import com.kh.exam.modle.Book;
import com.kh.exam.modle.Member;

public class BookControoller {
	private Member mem = new Member();
	private Book bArr[] =  new Book[4];
	private int count = 0;
	
	public void settingBook (Book b) {
		bArr[count++] = new Book(b.getTitle(), b.isCoupon(), b.getAccessAge());
		
	}
	public int couponCount(Book b){
		if(b.isCoupon() == true) {
			count++;
			return count ;
		}else 
			return count;
		
		}
	public void coponCheck() {
		mem.setCoupon(count);
		
	}
	public Book[] bookinfo() {
		return bArr;
			
		
	}	
		
	}
	


