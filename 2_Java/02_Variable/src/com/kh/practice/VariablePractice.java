package com.kh.practice;

import java.util.Scanner;

public class VariablePractice {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		VariablePractice variablePractice = new VariablePractice();
		System.out.println("--------------------Q1--------------------");
		variablePractice.method1();
		System.out.println("--------------------Q2--------------------");
		variablePractice.method2();
		System.out.println("--------------------Q3--------------------");
		variablePractice.method3();
		System.out.println("--------------------Q4--------------------");
		variablePractice.method4();
		System.out.println("--------------------Q5--------------------");
		variablePractice.method5();
		System.out.println("--------------------Q6--------------------");
		variablePractice.method6();
		System.out.println("--------------------Q7--------------------");
		variablePractice.method7();

	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */
	public void method1() {
		int man = 10000;
		int cld = 7000;
		int manCount = 2;
		int cldCount = 3;
		int sum = man * manCount + cld * cldCount;

	
		
		System.out.printf("티켓 가격은 성인 %d원 청소년 %d원 일때, \n성인 %d명과 청소년 %d명이 영화를 보면 지불해야할 총금액은 %d원이다.\n\n"
					, man, cld, manCount, cldCount, sum);
		
	}
	
	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */
	public void method2() {
		
		int x = 5;
		int y = 7;
		int z = 9;
		
		
		int var = x; // 변수하나로 돌려막기 
		x = y; 
		y = z;
		z = var;
		
		
		
		
		System.out.printf("x=%d\ny=%d\nz=%d\n\n"
				,x, y, z);
	}

	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */
	public void method3() {
		
		System.out.print("첫 번째 정수 : ");
		int frist = Integer.parseInt(sc.nextLine())  ;
		
		
		System.out.print("두 번째 정수 : ");
		int secend = Integer.parseInt(sc.nextLine())  ;
		
	
		System.out.printf("더하기 : %d \n빼기 : %d \n곱하기 : %d \n나누기 몫 : %d \n",
				frist + secend, frist - secend, frist * secend, frist / secend);

	}

	/*
	 * 키보드로 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */
	public void method4() {
		
		System.out.print("가로 : ");
		double width = Double.parseDouble(sc.nextLine())  ;
		
		
		System.out.print("세로 : ");
		double height =  Double.parseDouble(sc.nextLine())  ;
		
		
		System.out.printf("면적 : %.2f \n둘레 : %.1f \n",
				 width * height, (width + height) * 2 );

	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.langth())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		
		System.out.print("문자열을 입력하시오 : ");
		String string = sc.nextLine()  ;
		
		char frist = string.charAt(0);
		char second = string.charAt(1);
		char last = string.charAt(string.length()-1);
		
		System.out.printf("첫번째 문자 : %c\n두번째 문자 : %c\n마지막 문자 : %c\n",
				frist, second, last);
		
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		
		System.out.print("문자를 입력하시오 : ");
		char ch = sc.nextLine().charAt(0);
		int num = ch;

		System.out.printf("%c unicode : %d\n%c unicode : %d\n",
				ch, num, ch+1, num+1);
		

	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	public void method7() {
		
		System.out.print("국어 : ");
		int korean = Integer.parseInt(sc.nextLine())  ;
		
		
		System.out.print("영어 : ");
		int math = Integer.parseInt(sc.nextLine())  ;
		
		
		System.out.print("수학 : ");
		int english = Integer.parseInt(sc.nextLine())  ;
		
		
		int sum = korean + math + english;
		
		double avg = (double)(sum) / 3;
		
		System.out.printf("총점 : %d\n평균 : %.2f",
				sum, avg);
		

	}

}
