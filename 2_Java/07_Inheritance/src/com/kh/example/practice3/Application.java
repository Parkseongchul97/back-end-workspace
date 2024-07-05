package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {
	int empNo;
	String name;
	char gender;
	String phone;
	String dept;
	int salary;
	double bonus;
	char agree;

	Scanner sc = new Scanner(System.in);
	Employee viewEmployee = new Employee();
	EmployeeController employeeController = new EmployeeController();
	public static void main(String[] args) {
		Application a = new Application();
		a.employeeMenu();
	}

	public int 	employeeMenu() {
		// 집가서 해볼것!!! 
		// while 문들 매번 반복 X 로 받는값 int니까 매뉴 번호를 저기에 입력받아서 맞춰 실행할 수 있도록 변경
		// 매뉴 번호 입력란을 main에 반복문 걸고 이동시켜주는거만 매뉴단 사용??
		
		while(true) {
			System.out.println("\n-----------매인 매뉴------------");
			System.out.printf("1. 사원 정보 추가\n2. 사원 정보 수정\n3. 사원 정보 출력\n9. 프로그램 종료\n");
			System.out.print("매뉴 번호를 누르세요 : ");
			int menu = Integer.parseInt(sc.nextLine()); 
			if(menu == 1) {
				insertEMP(); // 정보추가
			}else if (menu == 2) {
				updateEMP(); // 정보수정
			}else if (menu == 3) {
				printEMP(); // 정보 출력
			}else if (menu == 9) {
				break; // 프로그램 종료
			}else {
				System.out.println("매뉴 번호를 정확히 입력하십시오.\n");
			}
		}
		return 0;
		}
	public void insertEMP() {
		
	
		while(true) {
		System.out.printf("\n-----------사원 정보 추가------------\n\n사원 번호 : ");
		empNo = Integer.parseInt(sc.nextLine());
		
		System.out.print("사원 이름 : ");
		name = sc.nextLine();
		
		System.out.print("성별 : ");
		gender = sc.nextLine().charAt(0);
		
		System.out.print("전화 번호 : ");
		phone = sc.nextLine();
		
		
		System.out.print("추가 정보를 더 입력하시겠습니까? y/n : ");
		agree = sc.nextLine().charAt(0);
		
		
		if(agree == 'n') {
			employeeController.add(empNo, name, gender, phone);
			break;
		}else if(agree == 'y') {
			
			System.out.print("사원 부서 : ");
			dept = sc.nextLine();
			
			System.out.print("사원 연봉 : ");
			salary = Integer.parseInt(sc.nextLine());
			
			System.out.print("보너스 율 : ");
			bonus = Double.parseDouble(sc.nextLine());
			employeeController.add(empNo, name, gender, phone, dept, salary, bonus);
			break;
		}else {
			System.out.println("소문자 y/n을 정확히 입력하시오");
		}
		}
	}
	public void updateEMP() {
		while(true) {
			System.out.println("\n-----------사원 정보 수정------------\n");
			System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
			System.out.printf("1. 전화번호\n2. 사원 연봉\n3. 보너스 율\n9. 돌아가기\n");
			System.out.print("매뉴 번호를 누르세요 : ");
			int updateMenu = Integer.parseInt(sc.nextLine()); 
			if(updateMenu == 1) {
				System.out.print("전화 번호 입력 : ");
				phone = sc.nextLine();
				employeeController.modify(phone);
				break;
			}else if (updateMenu == 2) {
				System.out.print("사원 연봉 입력 : ");
				salary = Integer.parseInt(sc.nextLine());
				employeeController.modify(salary);
				break;	
			}else if (updateMenu == 3) {
				System.out.print("보너스 율 입력 : ");
				bonus = Double.parseDouble(sc.nextLine());
				employeeController.modify(bonus);
				break;
			}else if (updateMenu == 9) {
				break; // 프로그램 종료
			}else {
				System.out.println("매뉴 번호를 정확히 입력하십시오.");
			}
		
		
	}
		}
	public void printEMP() {
		System.out.println("\n-----------사원 정보------------\n");
		System.out.println(employeeController.info()); 
			
		
	
		}
}
