package com.kh.practice1;

import com.kh.practice1.model.Member;

public class Application {

	public static void main(String[] args) {
		Member member1 = new Member();
		member1.changeName("홍길동");
		member1.printName();
		
		Member member2 = new Member("abc1234", "1q2w3e4r!", "임꺽정" ,18, 'M', "010-1234-5678", "abc1234@gmail.com") ;
		
	}

}
