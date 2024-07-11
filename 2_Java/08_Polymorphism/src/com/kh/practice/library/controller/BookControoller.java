package com.kh.practice.library.controller;

import com.kh.practice.library.model.Book;
import com.kh.practice.library.model.Member;

public class BookControoller {
	private Book bArr[] =  new Book[4];
	private int count = 0;
	private Book mArr[] = new Book[2];
	private Member member;
	
	public void memberInfoPuls(String name, int age) { // member에 이름과 나이 추가
		Member mem = new Member();
		mem.setName(name);
		mem.setAge(age);
		member = mem;	
	}
	public void memberAllInfo() { // member에 모든 정보 출력
		System.out.println(this.member);
	}

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
		member.setBook(mArr);
		return mArr;	
	}
	
	public void memberCoupon() { // 쿠폰카운트
        int couponCount = 0;
        for (Book b : member.getBook()) {
            if (b != null && b.isCoupon()) {
                couponCount++;
            }
        }
        member.setCoupon(couponCount);
    }
	 public boolean reRant(String title) {//책 이름확인
	        for (Book b : member.getBook()) {
	            if (b != null && b.getTitle().equals(title)) {
	                return true;
	            }
	        }
	        return false;
	    }
	 public boolean ageAccess (int i) { //나이제한 확인
		if (member.getAge() < getbook(i).getAccessAge()) {
			return true;
		}else {
			return false ;
		}
		
	
		}
}



