package person.view;

import java.util.ArrayList;
import java.util.Scanner;

import person.controller.PersonController;
import person.model.Person;

public class PersonTest {
	PersonController pc = new PersonController();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		PersonTest p = new PersonTest();
		p.menu();
		
		// 이 부분은 테스트 용도로만 

	}
	public void menu() {
		boolean check = true;
		int num = 0;
		while(check) {
			System.out.println("******회원 관리 프로그램******");
			System.out.println("1. 회원가입");
			System.out.println("2. 회원정보 수정");
			System.out.println("3. 회원 탈퇴");
			System.out.println("4. 모든 회원 조회");
			System.out.println("5. 회원 조회");
			System.out.println("6. 프로그램 종료");
			System.out.print("매뉴 번호 : ");
			try {
				num = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("매뉴 번호 입력이 올바르지 않습니다.");
				menu();
			}
			switch(num) {
				case 1 :
					addPerson();
					break;
				case 2 :
					updatePerson();
					break;
				case 3 :
					removePerson();
					break;
				case 4 :
					searchAllPerson();
					break;
				case 5 :
					searchPerson();
					break;
				case 6 :
					check = false;
					System.out.println("!!! 종료 !!!");
					break;
				 default :
					System.out.println("매뉴 번호 입력이 올바르지 않습니다.");
					break;
			}
		}
	}
	
	// person 테이블의 데이터 추가 - INSERT
	public void addPerson() {
		// ㅇㅇ 님 회원가입 완료 
		int id = 0;
		int age = 0;
		String name = "";
		String addr = "";
		try {
			System.out.println("--- 회원가입 ---");
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("나이 : ");
			age =  Integer.parseInt(sc.nextLine());
			System.out.print("주소 : ");
			addr = sc.nextLine();
		} catch (Exception e) {
			System.out.println("올바른 값을 입력해 주십시오.");
			return;
		}
	
		int result = pc.addPerson(name, age, addr);	
		if(result == 1) {
			System.out.println(name + "님, 회원가입 완료!");
		}
	}
	
	// person 테이블의 데이터 수정 - UPDATE
	public void updatePerson() {
		// ~님 정보 수정 완료 
		int id = 0;
		int age = 0;
		String name = "";
		String addr = "";
		try {
			System.out.println("--- 정보 수정 ---");
			System.out.print("수정할 ID : ");
			id =  Integer.parseInt(sc.nextLine());
			System.out.println("\n--- 수정할 정보 ---");
			System.out.print("이름 : ");
			name = sc.nextLine();
			System.out.print("나이 : ");
			age =  Integer.parseInt(sc.nextLine());
			System.out.print("주소 : ");
			addr = sc.nextLine();
		} catch (Exception e) {
			System.out.println("올바른 값을 입력해 주십시오.");
			return;
		}
	
		System.out.println(pc.updatePerson(id, name, age, addr));
	}
	
	// person 테이블의 데이터 삭제 - DELETE
	public void removePerson() {
		// ~님 회원 탈퇴 
		int id = 0;
		try {
			System.out.println("--- 회원 탈퇴 ---");
			System.out.print("탈퇴할 ID : ");
			id =  Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("올바른 값을 입력해 주십시오.");
			return;
		}

		System.out.println(pc.removePerson(id));
		
	}
	
	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public void searchAllPerson() {
		ArrayList<Person> list = pc.searchAllPerson();
		for(Person p : list) {
			System.out.println(p);
		}
		
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson() {
		int id = 0;
		try {
			System.out.println("--- 회원 찾기 ---");
			System.out.print("찾고싶은 ID : ");
			id = Integer.parseInt(sc.nextLine());
			
		} catch (Exception e) {
			System.out.println("올바른 값을 입력해 주십시오.");
			return;
		}
		if(pc.searchPerson(id) == null)
			System.out.println("해당 회원이 존재하지 않습니다");
		else 
			System.out.println(pc.searchPerson(id));
	}

}
