package com.kh.example.practice3;

import java.util.Scanner;

import com.kh.example.practice3.controller.EmployeeController;
import com.kh.example.practice3.model.Employee;

public class Application {

	 

	Scanner sc = new Scanner(System.in);
	Employee viewEmployee = new Employee();
	EmployeeController employeeController = new EmployeeController();
	public static void main(String[] args) {
		Application a = new Application();
		boolean check = true;
		while(check) {
		int select = a.employeeMenu();
		switch(select){
		case 1:
			a.insertEMP();
			break;
		case 2:
			a.updateEMP();
			break;
		case 3:
			a.printEMP();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			check = false;
			break;
			default :
				System.out.println("잘못 입력하셨습니다.");
			
		}
		
		
		}
		 
			
	}
			
	

	public int 	employeeMenu() {

			
		 
			System.out.println("\n-----------매인 매뉴------------");
			System.out.printf("1. 사원 정보 추가\n2. 사원 정보 수정\n3. 사원 정보 출력\n9. 프로그램 종료\n");
			System.out.print("매뉴 번호를 누르세요 : ");
			return Integer.parseInt(sc.nextLine());

		
				
			
		
	}
		
	public void insertEMP() {
		
	
		
		System.out.printf("\n-----------사원 정보 추가------------\n\n사원 번호 : ");
		// int empNo = Integer.parseInt(sc.nextLine());
		viewEmployee.setEmpNo(Integer.parseInt(sc.nextLine()));
		System.out.print("사원 이름 : ");
//		String name = sc.nextLine();
		viewEmployee.setName(sc.nextLine());
		System.out.print("성별 : ");
//		char gender = sc.nextLine().charAt(0);
		viewEmployee.setGender(sc.nextLine().charAt(0));
		System.out.print("전화 번호 : ");
//		String phone = sc.nextLine();
		viewEmployee.setPhone(sc.nextLine());
		
		
		System.out.print("추가 정보를 더 입력하시겠습니까? y/n : ");
		char add = sc.nextLine().charAt(0);
		
		
		if(add == 'y') {
			System.out.print("사원 부서 : ");
			String dept = sc.nextLine();
			
			System.out.print("사원 연봉 : ");
			int salary = Integer.parseInt(sc.nextLine());
			
			System.out.print("보너스 율 : ");
			double bonus = Double.parseDouble(sc.nextLine());
			
			employeeController.add(viewEmployee.getEmpNo(), 
									viewEmployee.getName(), 
									viewEmployee.getGender(), 
									viewEmployee.getPhone(), 
									dept, salary, bonus);
			
		}else {
			employeeController.add(viewEmployee.getEmpNo(), 
					viewEmployee.getName(), 
					viewEmployee.getGender(), 
					viewEmployee.getPhone() );
			
		}
		}
	
	public void updateEMP() {
		
			
			System.out.println("\n-----------사원 정보 수정------------\n");
			System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
			System.out.printf("1. 전화번호\n2. 사원 연봉\n3. 보너스 율\n9. 돌아가기\n매뉴 번호를 누르세요 : ");
			int update = Integer.parseInt(sc.nextLine()); 
			
			switch(update) {
			case 1 :
				System.out.print("전화 번호 입력 : ");
				String phone = sc.nextLine();
				employeeController.modify(phone);
				break;
				
			case 2 :
				System.out.print("사원 연봉 입력 : ");
				int salary = Integer.parseInt(sc.nextLine());
				employeeController.modify(salary);
				break;
					
			case 3 : 
				System.out.print("보너스 율 입력 : ");
				double bonus = Double.parseDouble(sc.nextLine());
				employeeController.modify(bonus);
				break;
				
			case 9 : 
				break;
				
				
			}
			
		}
		
	
		
	public void printEMP() {
		System.out.println("\n-----------사원 정보------------\n");
	
		System.out.println(employeeController.info());
			
		
	
		}
}
