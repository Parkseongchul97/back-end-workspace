package com.kh.loop;

import java.util.Scanner;

public class D_While {
	Scanner sc = new Scanner(System.in);
	
	/*
	 * while 문
	 * 
	 * while(조건식){
	 * 		조건이 true일 경우 계속 실행 
	 * }
	 * */
	
	// 1~5 까지 출력 

	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
		d.method5();
	}
	public void method1() {
		
		int num = 1; // 초기값
		
		while(num <= 5) { // 조건식
			System.out.println(num); // 결과
			num++; // 증감식
		}
	}
	/*
	 * 무한루프 & break 문 
	 * - switch, 반복문의 실행을 중지하고 빠져나갈 때 사용 
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다.
	 * */
	public void method2() {
		while(true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			if (num == 0) break;
		}
	
	}
	/*
	 * do-while문
	 * 
	 * do {
	 * 		실행 코드 
	 * }while(조건식);
	 * 
	 * - 조건과 상관없이 무조건 한번은 실행
	 * - 거의 쓸일이 없음...
	 * */
	public void method3() {
		
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {	// 조건이 안맞지만 한번은 실행해서 출력!
			System.out.println("do-while");
		}while(number == 0);
	}
	
	
	/*
	 * 숫자 맞히기 게임
	 * 1~100 사이의 값을 입력해서 임의로 지정한 random 값을 맞추면 게임끝
	 * 게임이 끝나면 몇번만에 맞혔는지 출력
	 * 
	 * 예 57
	 * 1 100 사이의 값 입력 > 35
	 * 더 큰수를 입력하세요
	 * 1 100 사이의 값 70
	 * 더 작은수를 입력하시오
	 * 1 100 사이의 값 57
	 * 3번 만에 맞첬습니당
	 * 
	 * */
	public void method4() {
		int random = (int) (Math.random() * 100 + 1);
		System.out.println("정답 : " + random);
		
		int count = 0;
		// num을 밖에 따로 지정하고 안에서 num = sc.nextInt로 대입으로 사용하면 조건문안에 넣기 가능 
		while(true) { // num은 while문 안의 지역변수라 안걸림! num != random 으로도 가능 !
			System.out.print("1 ~ 100 사이의 값을 입력하세요 : ");
			int num = sc.nextInt();
			count++ ;
			if (1 > num || num > 101) {
				System.out.println("*1 ~ 100 사이의 올바른 범위의 숫자를 입력하시오.\n");
				count-- ; // 범위 벗어난 값은 카운트 X 
			}else if(num > random) {
				System.out.println("*더 작은 수를 입력하시오.\n");
			}else if(num < random) {
				System.out.println("*더 큰 수를 입력하시오.\n");			
			}else { 
				System.out.printf("*%d번 만에 맞추셨습니다 축하합니다!\n*프로그램을 종료합니다!" ,count);
				break; // 무한루프 끝내기 위해서 break
			}

		}

	}
	/*
	 * -----------------------------------	
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * -----------------------------------
	 * 선택 : 1
	 * 예금액 : 5000
	 * -----------------------------------	
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * -----------------------------------
	 * 선택 : 2
	 * 출금액 : 2000
	 * 	-----------------------------------	
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * -----------------------------------
	 * 선택 : 3
	 * 잔고 : 3000
	 * 	-----------------------------------	
	 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
	 * -----------------------------------
	 * 선택 : 4
	 * 프로그램 종료 
	 * 

	 * */
	
	public void method5() {
		
		 int num1 = 0;
		 int num2 = 0;
		 int num3 = 0;
		
		while(true) {
			System.out.printf("----------------------------------\n 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료\n----------------------------------\n선택 : ");
			int selrte = Integer.parseInt(sc.nextLine());
			
			if(selrte == 1) {
				System.out.print("예금액 : ");
				num1 = Integer.parseInt(sc.nextLine());
				if(num1 > 0)num3 += num1;
				else System.out.println("올바른 금액을 입력하시오.");
				
			} else if (selrte == 2) {
				System.out.print("출금액 : ");
				num2 = Integer.parseInt(sc.nextLine());
				if (num2 > 0) {
					if (num3 < num2) {
						System.out.printf("잔고가 부족하여 출금 할 수 없습니다!\n보유 잔고 : %d\n", num3);
					} else
						num3 -= num2;
				} else
					System.out.println("올바른 금액을 입력하시오.");

			}else if (selrte == 3) {
				System.out.println("잔고 : " + num3);	
				
			}else if (selrte == 4) {
				System.out.println("프로그램을 종료합니다.");	
				break;
			}else {
				System.out.println("올바른 매뉴번호를 입력하십시오.");
			}
			
		}
	
		// 입출금 내역 조회 추가?
		

	}
}
