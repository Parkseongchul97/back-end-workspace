package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {
		OperatorPractice o = new OperatorPractice();
		System.out.println("---------------Q1-------------");
		o.method1();
		System.out.println("---------------Q2-------------");
		o.method2();
		System.out.println("---------------Q3-------------");
		o.method3();
		System.out.println("---------------Q4-------------");
		o.method4();
		System.out.println("---------------Q5-------------");
		o.method5();
		System.out.println("---------------Q6-------------");
		o.method6();
		System.out.println("---------------Q7-------------");
		o.method7();
		

	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("연필 개수를 입력하시오 : ");
		int pan = Integer.parseInt(sc.nextLine());
		System.out.print("인원 수를 입력하시오 : ");
		int man = Integer.parseInt(sc.nextLine());
		
		System.out.printf("1인당 나눠가진 연필의 수는 %d이고 남은 연필의 개수는 %d 입니다\n\n",pan / man, pan % man);

	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("숫자를 입력하시오 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.printf("위 숫자의 10의 자리 이하값을 버린 값은 %d 입니다\n\n", num / 100 * 100);

	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("첫번째 숫자를 입력하시오 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력하시오 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		System.out.print("세번째 숫자를 입력하시오 : ");
		int num3 = Integer.parseInt(sc.nextLine());
		boolean one = num1 == num2 && num2 == num3;
		
		System.out.printf("위 3개의 수들의 값은 %b 입니다\n\n", one);
		

	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.print("숫자를 입력하시오 : ");
		int num = Integer.parseInt(sc.nextLine());
		String str = num % 2 == 0 ? "짝수 입니다" : "짝수가 아닙니다.";
		System.out.println("위 숫자는 " + str);
		System.out.println();
		
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	// char.AT로 풀기
	public void method5() {
		System.out.print("주민등록번호 13자리를 '-' 포함하여 입력하십시오. : ");
		char ch = sc.nextLine().charAt(7);
		String gender = ch == '1' || ch == '3' ? "남자 입니다." : 
						ch == '2' || ch == '4' ? "여자 입니다." : "잘못된 값입니다." ;
		
		System.out.println(gender);
		System.out.println();
		
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요.
	// 3항 연산자로 
	public void method6() {
		System.out.print("나이를 입력하시오 : ");
		int age = Integer.parseInt(sc.nextLine());
		String year = age <= 13 ? "어린이 입니다." :  
					  age <= 19 ? "청소년 입니다." : "성인 입니다." ;
		System.out.println("당신은 " + year);
		System.out.println();
		
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.print("사과의 숫자를 입력하시오 : ");
		int apple = Integer.parseInt(sc.nextLine());
		System.out.print("바구니의 크기를 입력하시오 : ");
		int boxSize = Integer.parseInt(sc.nextLine());
		
		int appleBox = apple % boxSize > 1 ? apple / boxSize : (apple / boxSize)+1;
		
		int appleBox2 = apple / boxSize + (apple % boxSize > 1 ? 0 : 1);
		
		
		System.out.printf("필요한 바구니의 숫자는 %d개 입니다.\n\n"
				+ 		  "필요한 바구니의 숫자는 %d개 입니다.\\n\\n", appleBox ,appleBox2);
		
		// 사과 100 바구니 사이즈 3 이면 바구니 34개 필요
		// 단순히 나눈게아니라 나머지 값이 1 이상이면 +1 해야함
		
		
	}
	
}