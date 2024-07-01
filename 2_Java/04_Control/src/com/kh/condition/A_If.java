package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * if문
	 * 
	 * if(조건식){
	 * 	조건식이 참(true) 일 때 실행 
	 * }
	 *
	 * - 보통 조건식에는 비교연산자, 논리연산자를 주로 사용 
	 * */

	public static void main(String[] args) {
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.practice1();
//		a.practice2();
		a.practice3();
		
	}
	/*
	 * 사용자에게 점수 0~100을 입력받아서 점수별로 등급 출력
	 * 90점 이상 A 등급
	 * 90~80 B등급
	 * 80~70 C
	 * 70~60 D
	 * 60 F
	 * */
	public void practice1 () {
		
		
		System.out.print("점수를 입력하시오 : ");
		int score = sc.nextInt();
		if(score < 0 || 100 < score) {
			System.out.println("점수를 잘못 입력했습니다.");
		}else if (score >= 90) {
			System.out.println("A등급 입니다.");
		}else if (score >= 80) {
			System.out.println("B등급 입니다.");
		}else if (score >= 70) {
			System.out.println("C등급 입니다.");
		}else if (score >= 60) {
			System.out.println("D등급 입니다.");
		}else {
			System.out.println("F등급 입니다.");
		}
		
		String str = score < 0 || 100 < score ? "점수를 잘못 입력했습니다." : 
					 score >= 90 ? "A등급 입니다. " :
					 score >= 80 ? "B등급 입니다. " :
					 score >= 70 ? "C등급 입니다. " :
					 score >= 60 ? "D등급 입니다. " :
						 		   "F등급 입니다";
		System.out.println(str);
		
		// 이게더 깔끔
		String result = "";
		
		if(score < 0 || 100 < score) {
			result = "점수를 잘못 입력했습니다.";
		}else if (score >= 90) {
			result = "A등급 입니다.";
		}else if (score >= 80) {
			result = "B등급 입니다.";
		}else if (score >= 70) {
			result = "C등급 입니다.";
		}else if (score >= 60) {
			result = "D등급 입니다.";
		}else {
			result = "F등급 입니다.";
		}
		System.out.println(result);
		
	
		
		
	}
	
	/*
	 * 세 정수를 입력 했을 때 짝수만 출력
	 * 
	 * 
	 * */
	public void practice2 () {
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세번째 정수 입력 : ");
		int num3 = sc.nextInt();
		
		// 조건을 따로걸면 해결!!! 각기 다른 if문에서 돌고 끝나도록 
		if (num1 % 2 == 0) {
			System.out.println(num1);
		}if (num2 % 2 == 0) {
			System.out.println(num2);
		}if (num3 % 2 == 0) {
			System.out.println(num3);
		}
		
		
		// 하나의 if문에서 끝내려고 굳이 안해도댐 
		if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 == 0  ) {
			System.out.println(num1);
			System.out.println(num2);
			System.out.println(num3);
		}else if (num1 % 2 == 0 && num2 % 2 != 0 && num3 % 2 != 0 ) {
			System.out.println(num1);
		}else if (num1 % 2 != 0 && num2 % 2 == 0 && num3 % 2 != 0 ) {
				System.out.println(num2);
		}else if (num1 % 2 != 0 && num2 % 2 != 0 && num3 % 2 == 0 ) {
			System.out.println(num3);		
		}else if (num1 % 2 == 0 && num2 % 2 == 0 && num3 % 2 != 0 ) {
			System.out.println(num1);
			System.out.println(num2);
		}else if (num1 % 2 == 0 && num2 % 2 != 0 && num3 % 2 == 0 ) {
			System.out.println(num1);
			System.out.println(num3);
		}else if (num1 % 2 != 0 && num2 % 2 == 0 && num3 % 2 == 0 ) {
			System.out.println(num2);
			System.out.println(num3);
		}
		
	}
	
	/*
	 * 정수를 1개 입력했을때 음수,양수,0 구별 짝, 홀 출력 
	 * */
	public void practice3 () {
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		String result;
		
		if(num == 0) {
			result = "0";
		}else if (num > 0) {
			result = "plus";
		}else {
			result = "minus";
		}
		if(num % 2 == 0) {
			result += "\neven";
		}else {
			result += "\nodd";
		}
		System.out.println(result);
	
		
		if(num == 0) {
			System.out.printf("0\neven"); 
		}else if (num > 0 && num % 2 == 0) {
			System.out.printf("plus\neven");
		}else if (num < 0 && num % 2 == 0) {
			System.out.printf("minus\neven");
		}else if (num > 0 && num % 2 != 0) {
			System.out.printf("plus\nodd");
		}else if (num < 0 && num % 2 != 0) {
			System.out.printf("minus\nodd");
		}
		
		
	}
	public void method1 () {
		
		// 입력받은 성적이 60점 이상이면 합격입니다 출력
		
		System.out.print("성적 입력란 : ");
		int score = Integer.parseInt(sc.nextLine());
		
		if(score >= 60) {
			System.out.println("합격입니다.");
		}
		// 자바도 한줄만 넣을때 중괄호 생략 가능 !!
		if(score >= 60) System.out.println("합격입니다.");
	}
	
	/*
	 * if-else문 
	 * 
	 * if(조건식){
	 * 	조건식이 참 일 때 실행
	 * }else{
	 * 	조건식이 거짓 일 때 실행 
	 * }
	 * */
	public void method2 () {
		
		// 입력받은 성적이 60점 이상이면 합격입니다 출력
		
		System.out.print("성적 입력란 : ");
		int score = Integer.parseInt(sc.nextLine());
		
		if(score >= 60) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
		
		String str = score >= 60 ? "합격입니다." : "불합격입니다." ;
		System.out.println(str);
	}
	
	public void method3 () {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다"
		System.out.print("이름을 입력하시오 : ");
		String name = sc.nextLine();

		
		System.out.println("name 의 주소값 : " + System.identityHashCode(name));
		System.out.println("내이름의 의 주소값 : " + System.identityHashCode("박성철"));
		
		/*
		char name1 = name.charAt(0);
		char name2 = name.charAt(1);
		char name3 = name.charAt(2);
		if(name1 == '박' && name2 == '성' && name3 == '철') {
			System.out.println("본인이다");
		}else {
			System.out.println("본인이 아니다");
		}
		*/
		// 문자열.equals 문자열 비교할때 사용함!! 문자열은 주소를 기록하는거기 때문에 !!
		if(name.equals("박성철")) {
			System.out.println("본인이다");
		}else {
			System.out.println("본인이 아니다");	
		}
	}
	
	/*
	 * if - else if - else 문 
	 * 
	 * if(조건식1){
	 * 	조건식 1이 참일 경우 실행
	 * }else if (조건식2){
	 * 	조건식1이 거짓이고 조건식2가 참일경우 실행
	 * }else{
	 * 	조건식1,2가 모두 거짓일때 실행
	 * }
	 * 
	 * - else if 는 수가 제한이 없다 
	 * */
	public void method4 () {
		
		// 입력받은 숫자가 0보다 크면 양수 0이면 0 이다 작으면 음수 출력
		
		// if else if else문 
		System.out.print("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		if(num == 0) {
			System.out.println("0이다.");
		}else if (num < 0) {
			System.out.println("음수");
		}else {
			System.out.println("양수");
		}
		
		// 삼항 연산자 
		String str = num == 0 ? "0이다." : num < 0 ? "음수" : "양수";
		System.out.println(str);
		
		// if 안에 if 문 좋은 코드는 X 
		if (num == 0) {
			System.out.println("0이다.");
		} else {
			if (num < 0) {
				System.out.println("음수");
			} else {
				System.out.println("양수");
			}
		}
	}
	
	
}
		



