package com.kh.exam.controller;


import com.kh.exam.modle.Book;
import com.kh.exam.modle.Member;

public class BookControoller {
	private Book bArr[] =  new Book[4];
	private int count = 0;
	private Book mArr[] = new Book[2];
	
	
	public void settingBook (Book b) {// 책 정보 넣기
		bArr[count++] = new Book(b.getTitle(), b.isCoupon(), b.getAccessAge());
		
	}
	

	public Book[] bookinfo() { // 책목록 다가져오는거
		return bArr;
	}	
	public void bookselect() {
		Book[] bArr = bookinfo();
		for(int i = 0; i < bArr.length; i++) {
			if(bArr[i] != null)System.out.println(i+1 + "번 도서 : " + bArr[i]);
			}
	}
	public Book getbook(int i) {// 책 목록에서 1권만 뽑아오는거
		Book[] bArr = bookinfo();
		return bArr[i];
	}
	public Book[] copyBook(int i, int j) { // 책을 member Book[]에 복사해서 가져오는거
		System.arraycopy(bArr, i, mArr, j, 1);
		return mArr;	
	}
	
	public void Membercoupon(Member member) { // 쿠폰카운트
        int couponCount = 0;
        for (Book b : member.getBook()) {
            if (b != null && b.isCoupon()) {
                couponCount++;
            }
        }
        member.setCoupon(couponCount);
    }
	 public boolean reRant(Member member, String title) {//책 이름확인
	        for (Book b : member.getBook()) {
	            if (b != null && b.getTitle().equals(title)) {
	                return true;
	            }
	        }
	        return false;
	    }
}



