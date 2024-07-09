package com.kh.exam.controller;


import com.kh.exam.modle.Book;
import com.kh.exam.modle.Member;

public class BookControoller {
	private Member mem = new Member();
	private Book bArr[] =  new Book[4];
	private int count = 0;
	private Book mArr[] = new Book[2];
	
	public void settingBook (Book b) {// 책 정보 넣기
		bArr[count++] = new Book(b.getTitle(), b.isCoupon(), b.getAccessAge());
		
	}
	public int couponCount(Book[] b){ // 쿠폰 카운트
			int j = 0;
			b = mArr;
			for(int i = 0; i < b.length; i++) {
				if (b[i].isCoupon() == true) {
					j++;
				}
			}	 
			return j;		
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
	
		
	public Book[] copyBook(int i, int j) {
		System.arraycopy(bArr, i, mArr, j, 1);
		
		return mArr;
		
		
	}
	
	
	}
	


