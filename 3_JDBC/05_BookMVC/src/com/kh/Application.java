package com.kh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.BookDMLControoller;
import com.kh.controller.MemberController;
import com.kh.model.Book;
import com.kh.model.Member;

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
	private BookDMLControoller bc = new BookDMLControoller();
	private MemberController mc = new MemberController();
	//로그인 할시 사용자 정보를 담는 객체 !
	private Member member = null;

	public static void main(String[] args) {

		Application app = new Application();
		try {
			app.mainMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void mainMenu() throws SQLException {
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
	public void printBookAll() throws SQLException {
		// 반복문을 이용해서 책 리스트 출력
		System.out.println("***** 책 리스트 *****");
		ArrayList<Book> list = bc.bookAllInfo();
		for(Book b : list) {
			System.out.println(b);
		}
	}

	// 2. 책 등록
	public void registerBook() throws SQLException {
		System.out.println("******신규 책 등록******");
		// 책 제목, 책 저자를 사용자한테 입력 받아
		System.out.print("책 제목 : ");
		String bookTitle = sc.nextLine();
		System.out.print("책 저자 : ");
		String bookAuthor = sc.nextLine();
		if(!bc.bookCheck(bookTitle, bookAuthor)) {
			bc.bookInsert(bookTitle, bookAuthor);
			System.out.println("성공적으로 책을 등록했습니다.");
		}else {
			System.out.println("책을 등록하는데 실패했습니다.");
		}
		
		// 기존 제목, 저자 있으면 등록 x 
		// 등록에 성공하면 "성공적으로 책을 등록했습니다." 출력
		// 실패하면 "책을 등록하는데 실패했습니다." 출력
	}

	// 3. 책 삭제
	public void sellBook() throws SQLException {
		// printBookAll로 전체 책 조회를 한 후
			printBookAll();
		// 삭제할 책 번호 선택을 사용자한테 입력 받아
			System.out.print("삭제할 책 번호 : ");
			int num = 0;
			try {
				num = Integer.parseInt(sc.nextLine());
				if(bc.bookNumCheck(num)) {
					bc.bookDelete(num);
					System.out.println("성공적으로 책을 삭제했습니다.");
				}else System.out.println("책을 삭제하는데 실패했습니다.");
			} catch (Exception e) {
				System.out.println("!!책 번호를 입력하십시오!!");
			}
		// 삭제에 성공하면 "성공적으로 책을 삭제했습니다." 출력
		// 실패하면 "책을 삭제하는데 실패했습니다." 출력
		
	}

	// 4. 회원가입
	public void registerMember() throws SQLException {
		System.out.println("***** 회원가입 *****");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		if(!mc.idCheck(memberId)) {
			mc.signUpMember(memberId, memberPwd, memberName);
			System.out.println("성공적으로 회원가입을 완료하였습니다.");
		}else {
			System.out.println("회원가입에 실패했습니다.");
		}
		
		// 아이디, 비밀번호, 이름을 사용자한테 입력 받아
		// 회원가입에 성공하면 "성공적으로 회원가입을 완료하였습니다." 출력
		// 실패하면 "회원가입에 실패했습니다." 출력
	}

	// 5. 로그인
	public void login() throws SQLException {
		System.out.println("***** 로그인 *****");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		member.setMemberId(mc.login(memberId, memberPwd).getMemberId());  
		member.setMemberPwd(mc.login(memberId, memberPwd).getMemberPwd()); 
		member.setMemberName(mc.login(memberId, memberPwd).getMemberName()); 
		
		if(member != null) {
			System.out.println(member.getMemberName() + "님, 환영합니다!" );
			memberMenu();
		}else 
			System.out.println("로그인 실패!");

		// 아이디, 비밀번호를 사용자한테 입력 받아 
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후 memberMenu() 호출
		// 로그인에 성공하면 "~~님, 환영합니다!" 출력 후
	}

	public void memberMenu() {
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
		// 대여할 책 번호 선택을 사용자한테 입력 받아
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		// 대여에 성공하면 "성공적으로 책을 대여했습니다." 출력
		
	}

	// 2. 내가 대여한 책 조회
	public void printRentBook() {
		// 내가 대여한 책들을 반복문을 이용하여 조회
		// 대여 번호, 책 제목, 책 저자, 대여 날짜, 반납 기한 14일 조회
	}

	// 3. 대여 취소
	public void deleteRent() {
		// printRentBook 매서드 호출하여 내가 대여한 책 조회 출력 후
		// 취소할 대여 번호 선택을 사용자한테 입력 받아
		// 취소에 성공하면 "성공적으로 대여를 취소했습니다." 출력
		// 실패하면 "대여를 취소하는데 실패했습니다." 출력
	}

	// 4. 회원탈퇴
	public void deleteMember() {
		// 회원탈퇴에 성공하면 "회원탈퇴 하였습니다 ㅠㅠ" 출력
		// 실패하면 "회원탈퇴하는데 실패했습니다." 출력
	}

}
