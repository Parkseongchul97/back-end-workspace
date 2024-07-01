package com.kh.condition;

import java.util.Scanner;

public class B_Switch {
	Scanner sc = new Scanner(System.in);
	
	/*
	 * switch문 
	 * 
	 * switch(조건식){
	 * 	case 값1 :
	 * 		조건식의 결과가 값1과 같은 경우 실행
	 * 		break;
	 * 	case 값2 :
	 * 		조건식의 결과가 값2과 같은 경우 실행
	 * 		break;
	 * 	default :
	 * 		조건식의 결과가 일치하는 case 문이 없을 때 실행 
	 * }
	 * 
	 * - case 문의 수는 제한 X 
	 * - 조건식 결과는 정수, 문자, 문자열 이어야 한다
	 * - 조건식을 빠져나가려면 break가 필요하다
	 * - default문은 생략이 가능하다!
	 * */

	public static void main(String[] args) {
		B_Switch b = new B_Switch();
//		b.method1();
//		b.practice1();
		b.practice2();
	}
	/*
	 * 주민번호를 입력받아 남자인지 여자인지 출력 그외는 사람아니야
	 * 
	 * */
	public void practice1() {
		System.out.print("주민등록번호 13자리를 - 포함하여 입력하십시오 : ");
		char gender = sc.nextLine().charAt(7);
		String result;
		switch(gender) {
			case '1' :
			case '3' :
				result = "남자";
				break;
			case '2' :
			case '4' :
				result = "여자";
				break;
			default : 
				result = "사람이 아닙니다.";
		}
		System.out.println(result);
		
		// String.valueOf() : 문자열로 변환 
		// Integer.parseInt() : 정수로 변환 
		switch(Integer.parseInt(String.valueOf(gender))) {
		case 1 :
		case 3 :
			result = "남자";
			break;
		case 2 :
		case 4 :
			result = "여자";
			break;
		default : 
			result = "사람이 아닙니다.";
	}
		System.out.println(result);
	}
	
	
	/*
	 * 등급별 권한
	 * 1. 관리권한, 글쓰기권환 읽기구너한
	 * 2. 글쓰긱 ㅝㄴ한, 읽기권한
	 * 3. 읽기권한
	 * */
	public void practice2() {
		System.out.print("등급을 입력하시오 : ");
		int rank = sc.nextInt();
		
		String result = "";
		
		switch(rank) {
			case 1 :
				result += "관리권한\n";
			case 2 :
				result += "글쓰기권한\n";
			case 3 :
				result += "읽기권한\n";
				break;
			default : 
				result = "권한이 없습니다";
		}
		System.out.println(result);
	}
	public void method1() {
		/*
		 * 숫자를 입력받아
		 * 1일 경우는 "빨간색"
		 * 2일 경우는 파란색
		 * 3일 경우는 초록색
		 * 나머지는 잘못 입력했습니다,
		 * */
		System.out.print("1 ~ 3  중의 숫자를 입력하시오 : ");
		int num = sc.nextInt();
		String result;
		
		switch(num) {
			case 1 :
				result = "빨간색 입니다.";
				break;
			case 2 :
				result = "파란색 입니다.";
				break;
			case 3 :
				result = "초록색 입니다.";
				break;
			default :
				result = "잘못 입력했습니다.";
		}
		System.out.println(result);
	}
	
}
