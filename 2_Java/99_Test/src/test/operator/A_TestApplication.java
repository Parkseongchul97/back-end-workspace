package test.operator;

import java.util.Scanner;

import test.operator.controller.Controller;
import test.operator.modle.B_TestModle;

public class A_TestApplication {
	Scanner sc = new Scanner(System.in);
	Controller ct = new Controller();

	public static void main(String[] args) {
		A_TestApplication app = new A_TestApplication();
		app.mainMenu();
	
	
		
		
	}
	public void mainMenu() {
		boolean ckeck = true;
		while(ckeck) {
			System.out.println("*** 학사정보관리 시스템 ***");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 목록 출력");
			System.out.println("3. 학생 정보 수정");
			System.out.println("4. 성적 관리");
			System.out.println("5. 시스템 종료");
			System.out.print("매뉴 번호 : ");
			int num = 0;
			try {
				num = Integer.parseInt(sc.nextLine());
				
			} catch (Exception e) {
				System.out.println("!!!! 오류 !!!!");
				System.out.println("매뉴 번호를 정확히 입력하십시오.");
			}
			switch (num) {
			case 1: 
				menu1();
				break;
			case 2: 
				menu2();
				break;
			case 3: 
				menu3();
				break;
			case 4: 
				menu4();
				break;
			case 5: 
				System.out.println("시스템 종료");
				ckeck = false;
				break;
			default:
				System.out.println("해당 매뉴가 없습니다.");
				break;
			}
		}
		
	}
	public void menu1() {
		String name = "";
		String addr = "";
		int age = 0;
		String phoen = "";
		System.out.println("### 학생 추가 ###");
	
		try {	System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("주소 : ");
		addr = sc.nextLine();
		System.out.print("나이 : ");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("전화번호 : ");
		phoen = sc.nextLine();
		ct.insertStudunt(name, addr, age, phoen);
			
		} catch (Exception e) {
			System.out.println("오류!");
			return;
		}
	
	}
	public void menu2() {
		
	}
	public void menu3() {

	}

	public void menu4() {

	}
	
}
