package com.kh.step5;

public class SharedMemoryTest {

	public static void main(String[] args) {
		
		// 스레드들은 공유 자원을 서로 공유한다
		Calculator cal = new Calculator();
//		cal.setMemory(0);
		User1 user1 = new User1();
		user1.setCalclator(cal);
		user1.start();
		
		User2 user2 = new User2();
		user2.setCalclator(cal);
		user2.start();

	}

}
