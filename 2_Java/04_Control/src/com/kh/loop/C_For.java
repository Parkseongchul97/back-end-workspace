package com.kh.loop;

import java.util.Scanner;

public class C_For {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
//		c.method11();
//		c.method12();
		c.method13();
	}
	/*
	 * for문
	 * 
	 * for(초기식; 조건식; 증감식){
	 * 		실행 코드 
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문 
	 * - 초기식 : 반복문이 수행될 때 단 한 번만 실행, 
	 * 			반복문 안에서 사용할 변수를 선언하고 초기값 대입
	 * - 조건식 : 결과가 true 이면  실행코드를 실행, 
	 * 			결과가 false 이면 실행하지 않고 반복문을 빠져나감
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용 (++)
	 * */
	
	
	// 1~5 출력 
	public void method1() {
		
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
		
	}
	public void method2() {
		
		for(int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}
	
	// 1~10 중 홀수만 출력
	public void method3() {
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 != 0) {
				System.out.println(i);
			}
		}
		System.out.println("----------------------");
		for(int i = 1; i <= 10; i+=2) {
			System.out.println(i);
		}
		System.out.println("----------------------");
		
		/*
		 * continue 문 
		 * - continue 문은 반복문 안에서 사용
		 * - 반복문 안에서 continue를 만나면 "현재 구문" 종료 
		 * - 반복문을 빠져나가는 건 아님! 다음 반복을 계속 수행 
		 * */
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				continue;
			}
			System.out.println(i);
		}
	}
	
	// 1~10 까지 합계
	public void method4() {
		
		int sum = 0;
		for(int i = 1; i<=10; i++) {
			sum += i;
		}
		System.out.println(sum);

	}
	
	public void method5() {
		
		int sum = 0;
		System.out.print("숫자를 입력하시오 : ");
		int num = sc.nextInt();
		for(int i = 1; i<=num; i++) {
			sum += i;
		}
		System.out.println(sum);
		
	}
	// 1부터 랜덤값 까지의 합계
	
	/*
	 * java.lang.math 클래스에서 제공하는 random()매서드
	 * 
	 * 0.0 <= random < 1.0
	 * */
	public void method6() {
		int sum = 0;
		int random = (int)Math.random()*10+ 1;
		
		for(int i = 1; i<=random; i++) {
			sum += i;
		}
		System.out.println(random);
		System.out.println(sum);
		
	}
	// 사용자에게 입력받은 문자열을 1글자씩 출력 
	public void method7() {
		System.out.print("단어를 입력하시오 : ");
		String str = sc.nextLine();
	
		for(int i = 0; i < str.length(); i++) {
		System.out.println(str.charAt(i));
		}
		
		System.out.println("---------");
		/*
		 * 향상된 for문

			for(데이터타입 변수 : 배열){
				변수 : 배열의 값을 하나씩 가지고 옴 
			
			}
			
			문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열 
			
			- String.charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환
			- String.toCharArray() : 모든 문자가 들어 있는 char[] 형식의 데이터 반환
		 * */
		for(char ch : str.toCharArray()) {
			System.out.println(ch);
			
		}
		

	}
	// 구구단 2단 출력 
	public void method8() {
		
		int num;
		
		for(int i = 1; i <= 9; i++) {
			num = i * 2;
			System.out.printf("2 X %d = %d \n",i,num);
		}
	
		
	}
	// 중첩 for 문 	
	// 2~9단의 구구단 출력! 
	public void method9() {
		
		System.out.println("------2단------");
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {	
				int num = i * j;
				System.out.printf("%d X %d = %d \n", i, j, num);
				if(i != 9 && i*9 == num) {
					System.out.printf("\n------%d단------\n",i+1);
				}
			}
		}

	}
	/*
	 * *****
	 * *****
	 * *****
	 * *****
	 * */
	public void method10() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 5; j++) {	
				System.out.print("*");
			}
				System.out.print("\n");
			}
		
	}
	
	/*
	 * 1****
	 * *2***
	 * **3**
	 * ***4*
	 * ****5
	 * 
	 * */
	public void method11() {
		
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == j) {
					System.out.print(i);
				} else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
		}
	}
	
	/*
	 * *
	 * **
	 * ***
	 * ****
	 * *****
	 * ******
	 * 
	 * 
	 * */
	public void method12() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (i < j) {
					System.out.print(" "); // 0.1 0.2 0.3 0.4 0.5  / 1.2 1.3 1.4 1.5 
				} else {
					System.out.print("*"); // 0.0 / 1.0 1.1
				}
			}
			System.out.print("\n");
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}

		}
		
	/*      *
	 *     **
	 *    ***
	 *   ****
	 *  *****
	 * ******
	 * */
	public void method13() {
		

		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 4; j >= 0; j--) {
				if(j > i) {
				System.out.print(" ");
				}else
					System.out.print("*");
			}
			System.out.print("\n");
		
		
		
		}
		
		


}}
