package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	
	/*
	 * 논리 연산자 
	 * - 두 개의 논리값을 연산해주는 연산자 
	 * - 논리 연산한 결과마저 논리값 
	 * 
	 * 논리값 && 논리값 : and(그리고)연산자 : 왼쪽, 오른쪽 둘다 true일 경우만 true 
	 * 논리값 || 논리값 : or(또는)연산자 : 왼쪽, 오른쪽 둘중 하나라도 true일 경우면 true
	 * */
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		E_Logical e = new E_Logical();
//		e.method1();
//		e.method2();
		e.practice();

	}
	
	public void method1() {
		// 사용자가 입력한 정수값이 1부터 100 사이의 값인지 확인
		System.out.print("정수값을 입력해 주시오 : ");
		int num = sc.nextInt();
		
		boolean result = 1 <= num && num <= 100;
		System.out.println("1부터 100사이의 값인가요 ? : " + result);
		
	}

	public void method2() {
		int number = 10;
		boolean result = false;
		
		// Short Cut Evaluation
		
		// &&
		// true && true = true
		// true && false = false
		// false && true = false
		// false && false = false
		
		// &&연산자를 기준으로 앞에서 이미 false 이기 때문에 뒤쪽은 연산수행 X
		result = (number < 5) && (++number > 0);
		
		System.out.println(result); // false
		System.out.println(number); // 10 : 앞이 false 여서 뒤에 ++을 실행 X 해서 
		
		
		// ||
		// true || true = true
		// true || false = true
		// false || true = true
		// false || false = false
		
		// ||연산자를 기준으로 앞에서 이미 true 이기 때문에 뒤쪽은 연산수행 X
		result = (number < 20) || (++number > 0);
		
		System.out.println(result); // true
		System.out.println(number); // 10 : 앞에서 true 처리여서 뒤에 ++ 실행 X 
		
	}
	/*
	 * 사용자가 입력한 문자 값이 알파벳인지 확인하기
	 * A ~ Z : 65 ~ 90 
	 * a ~ z : 97 ~ 122
	 * */
	public void practice() {
		System.out.print("문자를 입력하시오 : ");
		char ch = sc.nextLine().charAt(0);
		int num = ch; // 아래 비교 연산자 에서는 어짜피 자동으로 char를 int로 바꿔서 계싼해서 딱히 필요 X 
		boolean result = (65 <= num && num <= 90)||(97 <= num && num <= 122);
		result = ('A' <= num && num <= 'Z')||('a' <= num && num <= 'z');
		System.out.println("입력한 문자값은 알파벳인가요? : " + result);
		
	}

}
