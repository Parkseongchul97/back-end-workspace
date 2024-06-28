package com.kh.operator;

public class C_Arithmetic {
	
	/*
	 * 산술 연산자
	 * + : 더하기
	 * - : 빼기
	 * * : 곱하기
	 * / : 나누기
	 * % : 나머지
	 * */

	public static void main(String[] args) {
		C_Arithmetic c = new C_Arithmetic();
//		c.method1();
		c.method2();

	}
	public void method1() {
		
		int num1 = 10;
		int num2 = 3;
		System.out.println("+ : " + (num1 + num2)); // 13
		System.out.println("- : " + (num1 - num2)); // 7
		System.out.println("* : " + (num1 * num2)); // 30
		System.out.println("/ : " + (num1 / num2)); // 3
		System.out.println("% : " + (num1 % num2)); // 1
	}
	
	/* 코드정렬 깔끔하게 하고 싶으면 영역잡고 
	 * ctrl + shift + f */
	public void method2() { 
		int a = 5; // 5 6 7
		int b = 10; // 10 9
		int c = (++a) + b; // 16 15 14
		int d = c / a; // 2 1
		int e = c % a; // 4 5 6
		int f = e++; // 4
		int g = (--b) + (d--); // 11 10
		int h = c-- * b; // 144
		int i = (a++) +b / (--c / f) * (g-- - d) % (++e + h);
				// 6 + 9 / (14 / 4) * (11 - 1) % (6 + 144) 식 잘새우고 왜틀림?
		  		// 6 + 9 / 3 * 10 % 150
				// 6 + 9 / (30 % 150) -- 9 나누기 3을 하고 진행했어야함!!!!
				// 15 / 30 = 0.5 -- 더하기에 괄호가 없는데 9 계싼을 나중에할 이유가 없음 
				// 0.5 = 0
		
				// 9 / 3 * 10 % 150
				// 6 + 30 
				// 36 
		System.out.println(6 + 9 / (14 / 4) * (11 - 1) % (6 + 144));// 36
		System.out.println(i); // 36
	}
}
