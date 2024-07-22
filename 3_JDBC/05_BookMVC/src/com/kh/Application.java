package com.kh;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookController;
import com.kh.controller.MemberController;
import com.kh.controller.RentController;
import com.kh.model.vo.Member;


public class Application {
	
	
	// 스키마 : sample
	// 테이블 : member, book, publisher ,rent
	/*
	  FROM book; 	bk_no 프라이머리키 
//	  FROM member; 	member_no 프라이머리키 
//    FROM publisher; 	pub_no(프라이머리키) = book.bk_pub_no  
//   *FROM rent;  rent_no 프라이머리 
//				  rent_mem_no = member_no
//				  rent_book_no = bk_no 
//	 * */

	private Scanner sc = new Scanner(System.in);
	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();
	//로그인 할시 사용자 정보를 담는 객체 !
	private Member member = new Member();

	public static void main(String[] args) {

		Application app = new Application();
		
			app.mainMenu();
		

	}

	public void mainMenu() {
		System.out.println("===== 도서 관리 프로그램 =====");

		boolean check = true;
		while (check) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 등록");
			System.out.println("3. 책 삭제");
			System.out.println("4. 회원가입");
			System.out.println("5. 로그인");
			System.out.println("9. 종료");
			System.out.print("메뉴 번호 입력 : ");
			int num = 0;
			try {
				num = Integer.parseInt(sc.nextLine());
				
			} catch (Exception e) {
				System.out.println("매뉴 번호를 똑바로 입력해 주십시오.");
				mainMenu();
			}
			switch (num) {
			case 1:
				printBookAll();
				break;
			case 2:
				registerBook();
				break;
			case 3:
				sellBook();
				break;
			case 4:
				registerMember();
				break;
			case 5:
				login();
				break;
			case 9:
				check = false;
				System.out.println("프로그램 종료");
				break;
			default :
				System.out.println("매뉴 번호를 똑바로 입력해 주십시오.");
				break;
			}
		}
	}

	// 1. 전체 책 조회
	public void printBookAll() {
		// 반복문을 이용해서 책 리스트 출력
		
		try {
		ArrayList<String> list = bc.printBookAllInfo();
			if(list.get(0) !=null) {
				System.out.println("***** 책 리스트 *****");
				for(String b : list) {
					System.out.println(b);
		}
				}
		} catch (Exception e) {
			System.out.println("책이 없습니다.");
		}
		 
		
		}
	

	// 2. 책 등록
	public void registerBook() {
		System.out.println("******신규 책 등록******");
		// 책 제목, 책 저자를 사용자한테 입력 받아
		System.out.print("책 제목 : ");
		String bookTitle = sc.nextLine();
		System.out.print("책 저자 : ");
		String bookAuthor = sc.nextLine();
		
		if(bc.bookInsert(bookTitle, bookAuthor)) {
				System.out.println("성공적으로 책을 등록했습니다.");
		}else {
				System.out.println("책을 등록하는데 실패했습니다.");
		}	
		
		// 기존 제목, 저자 있으면 등록 x 
		// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
		// 실패하면 "책을 등록하는데 실패했습니다." 출력
	}

	// 3. 책 삭제
	public void sellBook() {
		// printBookAll로 전체 책 조회를 한 후
			printBookAll();
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
			System.out.print("삭제할 책 번호 : ");
			int num = 0;
			try {
				num = Integer.parseInt(sc.nextLine());
				int i = bc.bookDelete(num);
				switch(i) {
					case 0 :
						System.out.println("성공적으로 책을 삭제했습니다.");
						break;
					case 1 :
						System.out.println("해당 책이 현재 대여중이라 삭제할수 없습니다.");
						break;
					case 2 :
						System.out.println("해당 번호의 책이 존재하지 않습니다.");
						break;
			}} catch (Exception e) {
				System.out.println("!!책 번호를 입력하십시오!!");
			}
		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
		
	}

	// 4. 회원가입
	public void registerMember(){
		System.out.println("***** 회원가입 *****");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		if(mc.signUpMember(memberId, memberPwd, memberName)) {
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		}else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패했습니다." 출력
	}

	// 5. 로그인
	public void login(){
		System.out.println("***** 로그인 *****");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		
		// 아이디, 비밀번호를 사용자한테 입력 받아 
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
		
		if(mc.login(memberId, memberPwd) != null) {
			member = mc.login(memberId, memberPwd);
			System.out.println(member.getMemberName() + "님, 환영합니다!" );
			memberMenu();
		}else 
			System.out.println("로그인 실패!");

		
	}

	public void memberMenu()  {
		boolean check = true;
		while (check) {
			System.out.println("1. 책 대여");
			System.out.println("2. 내가 대여한 책 조회");
			System.out.println("3. 대여 취소");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");
			System.out.print("메뉴 번호 입력 : ");
			int num = 0;
			try {
				num = Integer.parseInt(sc.nextLine());
				
			} catch (Exception e) {
				System.out.println("매뉴 번호를 똑바로 입력해 주십시오.");
				memberMenu();
			}
			switch (num) {
			case 1:
				rentBook();
				break;
			case 2:
				printRentBook();
				break;
			case 3:
				deleteRent();
				break;
			case 4:
				check = false;
				member = new Member();
				break;
			case 5:
				deleteMember();
				check = false;
				break;
			default :
				System.out.println("매뉴 번호를 똑바로 입력해 주십시오.");
				break;
			}
		}
	}

	// 1. 책 대여
	public void rentBook() {
		// printBookAll 메서드 호출하여 전체 책 조회 출력 후
		printBookAll();
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		System.out.print("대여할 책 번호 : ");
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("!!책 번호를 입력하십시오!!");
		}
			int i = rc.rentBook(member.getMemberNum(), num);
			switch(i) {
				case 0 :
					System.out.println("성공적으로 책을 대여했습니다.");
					break;
				case 1 :
					System.out.println("이미 대여된 책입니다.");
					break;
				case 2 :
					System.out.println("책 정보가 없습니다.");
					break;
				case 3 : 
					System.out.println("책을 대여하는데 실패했습니다.");
					break;
			}
		
		
		
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook()  {
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 14일 조회
		
		 ArrayList<String> list = rc.printRentBook(member.getMemberNum());
		 try {
			System.out.println("***** 내가 대여한 책 목록 *****");
			 for(String s : list) {
				System.out.println(s);
			}
			 
		} catch (Exception e) {
			System.out.println("대여한 책이 없습니다.");
		}

	}

	// 3. 대여 취소
	public void deleteRent() {
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		printRentBook();
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		System.out.print("반납할 책 번호 : ");
		int num = 0;
		try {
			num = Integer.parseInt(sc.nextLine());
		}catch (Exception e) {
			System.out.println("!!책 번호를 입력하십시오!!");
		}
			if(rc.deleteRent(num,member.getMemberNum())) {
				  System.out.println("성공적으로 대여를 취소했습니다.");
				
			}else {
				System.out.println("대여를 취소하는데 실패했습니다.");
			}
		 
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
	}

	// 4. 회원탈퇴
	
	
	
	public void deleteMember() {
		System.out.println("ㅠㅠㅠㅠㅠ 회원탈퇴 ㅠㅠㅠㅠㅠ");
		// 회원 탈퇴할 때 대여중인 책 있으면 탈퇴 불가
		System.out.print("정말로 탈퇴하시겠습니까 ? (Y/N) : ");
		char ch = sc.nextLine().charAt(0);
		switch (ch) {
			case 'Y' :
				rc.printRentBook(member.getMemberNum());
				realDeleteMember();
				break;
			case 'N' :
				memberMenu();
				break;
			default :
				System.out.println("Y 또는 N을 입력해주십시오!");
				deleteMember();
				break;
			}
		
		
		// 대여중인 책을 모두 반납하시겠습니까?
		// y n 으로 기록 삭제후 탈퇴
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	}
	public void realDeleteMember() {
		
		if(rc.deleteMemberRent(member.getMemberNum())) {
			System.out.println("현재 대여중인 책이 있습니다.");
			System.out.println("모두 반납해야만 탈퇴 가능합니다.");
			System.out.print("모두 반납후 정말로 탈퇴하시겠습니까 ? (Y/N) : ");
			char ch = sc.nextLine().charAt(0);
			switch (ch) {
				case 'Y' :
					mc.deleteMember(member.getMemberNum());
					member = new Member();
					System.out.println("성공적으로 반납후 탈퇴처리 되었습니다.");
					break;
				case 'N' :
					memberMenu();
					break;
				default :
					System.out.println("Y 또는 N을 입력해주십시오!");
					deleteMember();
					break;
		}
		
	}else {
		mc.deleteMember(member.getMemberNum());
		member = new Member();
		System.out.println("성공적으로 탈퇴처리 되었습니다.");
		return;
	}

}
}
