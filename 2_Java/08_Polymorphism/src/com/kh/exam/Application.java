package com.kh.exam;

import java.util.Scanner;
import java.util.Set;

import com.kh.exam.controller.BookControoller;
import com.kh.exam.modle.Book;
import com.kh.exam.modle.Member;

public class Application {
	Book book[] =  new Book[4];
	
	BookControoller bc = new BookControoller();
	Scanner sc = new Scanner(System.in);
	Member member = new Member();
	int num = 0;
	

	public static void main(String[] args) {
		Application app = new Application();
		app.bookinster();
		app.myinfo();
		app.menu();
		

	}
	// 책 정보 넣기 
	public void bookinster() {
		Book book1= new Book("밥을지어요", true, 0);
		bc.settingBook(book1);
		Book book2= new Book("오늘은 아무래도 덮밥", false, 0);
		bc.settingBook(book2);
		Book book3= new Book("원피스 108", false, 15);
		bc.settingBook(book3);
		Book book4= new Book("귀멸의 칼날 23", false, 19);
		bc.settingBook(book4);
	}
	public void myinfo() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("나이 : ");
		int age = Integer.parseInt(sc.nextLine()) ;
		member.setName(name);
		member.setAge(age);
	}
	public void menu() {
		boolean ck = true;
		while(ck) {
		System.out.printf("==== 매뉴 ====\n1. 마이페이지\n2. 도서 대여하기 \n3. 프로그램 종료하기\n매뉴 번호 : ");
		int num = Integer.parseInt(sc.nextLine()) ;
		switch (num) {
			case 1 : 
				myPage();
				break;
			case 2 :
				rentBook();
				
				break;
			case 3 :
				System.out.println("프로그램을 종료합니다");
				ck = false;
				break;
			default :
				System.out.println("올바른 번호를 입력해 주십시오.");
				break;
			}
		}
	
	}
	public void myPage() {
		System.out.println(member);	
	}
	
	public void rentBook() {
	
		bc.bookselect();
		System.out.print("대여할 도서 번호 선택 : ");
		int bookNum = Integer.parseInt(sc.nextLine());
		if(num >= 2 ) {
		System.out.println("더이상 대여할 수 없습니다.");
		return;
		}// else if(member의 book의 0번이 현재 선택한 book의 타이틀과 같을시){
		//System.out.println("이미 대여한 책입니다.");}
			
	
		
		
		//else if(member의 age랑 book의 accesAge랑 비교 해서 높을 경우){ 
		// System.out.println("나이제한으로대여불가능입니다.");}
		else {
//		member.setBook(bc.copyBook(bookNum,num));
		System.out.println("성공적으로 대여했습니다.");
		// member가 가지고 있는 Book의 쿠폰이 true면 member의 쿠폰값이 +1 
		num++;
		}
			
		}
		
		
		
	}
	




