package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	
	Scanner sc = new Scanner(System.in);
	
	/*
	 * 삼항 연산자
	 * 
	 * 조건식 ? 값1 : 값2;
	 * 
	 * - 조건식에는 주로 비교, 논리 연산자가 사용된다.
	 * - 조건식의 결과가 true 이면 값 1을 반환한다.
	 * - 조건식의 결과가 false 이면 값 2를 반환한다.
	 * */

	public static void main(String[] args) {
		
		F_Triple t = new F_Triple();
//		t.method1();
//		System.out.printf("------------Q1---------------\n\n");
//		t.practice1();
//		System.out.printf("------------Q2---------------\n\n");
//		t.practice2();
		System.out.printf("------------Q3---------------\n\n");
		t.practice3();

	}
	public void method1() {
		
		// 입력받은 정숙 양수인지 음수인지 판단 
		System.out.print("정수를 입력하시오 : ");
		int num = sc.nextInt();
		 
		// 양수 true 
		
		String result = (0 == num ? "0" : 
						(0 < num ? "양수" : "음수") ) ;
		System.out.println("입력받은 정수는 '" + result + "'입니다.");
		
		
	}
	/*
	 * 실습문제 1
	 * 사용자한테 두개의 정수값을 입력받아서 두 정수의 곱셈 결과 100보다 크거나 같은경우
	 * 결과가 100이상입니다  아닌경우 결과가 100보다 작습니다.
	 * */
	public void practice1() {
		System.out.print("곱하기를 할 첫 번째 정수를 입력하시오 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("곱하기를 할 두 번째 정수를 입력하시오 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		String result = num1 * num2 >= 100 ? "결과가 100 이상입니다." : "결과가 100보다 작습니다.";
		System.out.println(result);
			
	}
	
	/*
	 * 실습문제 2
	 * 사용자한태 문자를 하나 입력받아서 입력한 문자가 대문자이면 
	 * 알파벳 대문자이다 아닌경우 알파벳 대문자가 아니다
	 * */
	
	public void practice2() {
		System.out.print("문자를 입력하시오 : ");
		char ch = sc.nextLine().charAt(0);
		String result = 'A' <= ch && ch <= 'Z' ? "알파벳 대문자입니다." : "알파벳 대문자가 아닙니다.";
		System.out.println(result);
	}
	
	/*
	 * 실습문제 3 
	 * 두 정수를 입력받고 + 또는 -를 입력받아서 계산을 출력
	 * 단 + 또는 - 이외의 문자를 입력하는 경우 잘못 입력했습니다 출력 
	 * 
	 * 예시)
	 * 첫번째 수 : 3
	 * 두번째 수 : 4
	 * 연산자 입력(+ or -) : +
	 * 
	 * 3 + 4 = 7
	 * 
	 * 연산자 입력(+ or -) : *
	 * 
	 * 잘못 입력했습니다.
	 * 
	 * */
	public void practice3() {
		
		System.out.print("계산 할 첫 번째 정수를 입력하시오 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("계산 할 두 번째 정수를 입력하시오 : ");
		int num2 = Integer.parseInt(sc.nextLine());

		System.out.print("연산자를 입력하시오 : ");
		char ch = sc.nextLine().charAt(0);
		int num3 = num1 + num2 ;
		int num4 = num1 - num2 ;
		

		/*String result = ch != '+' && ch != '-' ? "잘못 입력했습니다." : 
						ch == '+' ? num1 + " + " + num2 + " = " + (num1 + num2) : 
									num1 + " - " + num2 + " = " + Integer.toString(num4) ;*/
		//System.out.print(result);
		
		/*System.out.printf("%d %s %d = %d", num1 , ch, num2, 
				ch == '+' ? (num1 + num2) : (num1 - num2)); // - 가 안댐 */
		
		// 조건문 사용 !!!
		if(ch == '+' || ch == '-' || ch == '*'|| ch == '/' || ch == '%') {
			System.out.printf("%d %s %d = %d", num1 , ch, num2, 
					ch == '+' ? (num1 + num2) : 
					ch == '-' ? (num1 - num2) :
					ch == '*' ? (num1 * num2) :	
					ch == '/' ? (num1 / num2) :	
								(num1 % num2)
					);
		}else {
			System.out.println("잘못 입력 했습니다.");
		}
		// 다른방법 printf 형식으로 String.format 이용하면 형식을 string으로 만들수 있음!
		
		/*result = ch != '+' && ch != '-' ? "잘못 입력했습니다." : 
			ch == '+' ? String.format("%d + %d = %d", num1, num2, num1+num2) : 
						String.format("%d - %d = %d", num1, num2, num1-num2) ;
		System.out.println(result);*/

	}
}	
	
		 // int랑 string이랑 같이 ? 따로 ?
//		String result = ch != '+' && ch != '-' ? "잘못 입력했습니다." : 
//					 ch == '+' ? result = (num3) :     ;
		
//		System.out.println(result + num3);
//		boolean a == '+' || ch == '-' ?  System.out.println(num1 + ch + num2 + "=" + (num1+num2)) :
//				ch == '-' ? System.out.println(num1 + ch + num2 + "=" + (num1-num2)) : 
//						  System.out.println("잘못 입력했습니다.");


/*
 *  System.out.println(num1 + ch + num2 + "=" + (num1+num2)) :
						ch == '-' ? System.out.println(num1 + ch + num2 + "=" + (num1-num2)) : 
								  System.out.println("잘못 입력했습니다.");
		
		
				/* ch != '+' && ch != '-' ? "잘못 입력했습니다." : 
		 ch == '+' ? System.out.println(num1 + ch + num2 + "=" + num3) : System.out.println(num1 + ch + num2 + "=" + num4);*/
 
