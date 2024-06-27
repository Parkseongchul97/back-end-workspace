package com.kh.variable;

import java.util.Scanner;

public class D_Scanner {
	
	/*
	 * Scanner 
	 * - 화면(Console)으로부터 데이터를 "입력" 받는 클래스
	 * 
	 * 1. import java.util.Scanner; 추가
	 * 
	 * 2. Scanner 객체 생성 
	 * 	  Scanner 변수명 = new Scanner(System.in);
	 * 
	 * 3. Scanner 메서드 사용 
	 * 	  입력값이
	 *		- 문자열일 때 : sc.next() - 공백이 있을 경우 공백 이전까지 
	 *					 sc.nextLine() - 공백 포함 엔터 전까지
	 *		- 정수일 때 : sc.nextInt()				
	 *		- 실수일 때 : sc.nextFloat() , sc.nextDouble()
	 *
	 *		=> 권장은 sc.nextLine() 만 사용하는 것을 권장!얘만 enter 처리 
	 * */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 먼저 import 안해도 경고 나온거 클릭하면 자동 import
		
		D_Scanner scanner = new D_Scanner(); 
		
		System.out.print("당신의 이름은 무엇입니까? > ");
		String name = sc.next(); // enter 처리 X 
		sc.nextLine(); // enter 처리용 
		
		System.out.print("당신의 나이는 몇살입니까? > ");
//		int age = sc.nextInt(); // enter 처리 X
//		sc.nextLine(); // 입력하는곳에 nextLine이 있으면 그 전에 한번 처리해주면 O
		
		int age = Integer.parseInt(sc.nextLine())  ; // string 을 int로 변환
		
		System.out.print("당신의 집은 어디십니까? > ");
		String addr = sc.nextLine();
		
		System.out.println("당신의 키는 몇입니까? (소숫점 첫째 자리까지 입력하시오) > ");
		
//		double height = sc.nextDouble();  // enter 처리 X 
//		sc.nextLine();
		double height =  Double.parseDouble(sc.nextLine()) ; // string을 double로 변환
		
		
		System.out.println("당신의 성별은 무엇입니까? (남/여) > ");
		
//		char gender = sc.nextLine().charAt(0); // 해당 문자열의 0번째 문자를 받아온다는 뜻 
		String input = sc.nextLine();
		char gender = input.charAt(0); // 를 위는 한줄로 압축한거 

		/*System.out.println("당신의 이름은 " + name 
				+ " 이고 사는곳은" + addr 
				+ " 이며 나이는 " + age
				+ "살, 성별은 " + gender
				+ "자 키는 " + height + "cm 입니다.");*/
		
		
		
		// printf 변경 
		System.out.printf("당신의 이름은 %s 이고 사는곳은 %s, 나이는 %d살, 키는 %.1fcm, 성별은 %c자 입니다.\n", 
					name, addr, age , height, gender);
		

	}

}
