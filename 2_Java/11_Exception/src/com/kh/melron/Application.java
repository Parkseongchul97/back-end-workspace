package com.kh.melron;

import java.util.Scanner;

import com.kh.melron.controller.MusicController;
import com.kh.melron.model.Music;

// 풀이
public class Application {
	MusicController mc = new MusicController();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Application app = new Application();
		app.mainMenu();
	}
	public void mainMenu() {
		try {
		boolean ck = true;
		while(ck) {
		System.out.printf("=====메인 메뉴=====\n"
				+ "1. 마지막 위치에 곡추가\n"
				+ "2. 첫 위치에 곡 추가\n"
				+ "3. 전체 곡 목록 출력\n"
				+ "4. 특정 곡 검색\n"
				+ "5. 특정 곡 삭제\n"
				+ "6. 특정 곡 수정\n"
				+ "7. 가수 명 내림차순 정렬\n"
				+ "8. 곡명 오름차순 정렬\n"
				+ "9. 종료\n매뉴 번호 입력 : ");
		
		switch(Integer.parseInt(sc.nextLine())) {
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
				menu5();
				break;
			case 6: 
				menu6();
				break;
			case 7: 
				menu7();
				break;
			case 8: 
				menu8();
				break;
			case 9: 
				ck = false;
				System.out.println("!!!!!!종료!!!!!!");
				break;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			
		
			}

		}

			
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			mainMenu();
		}

}
	
	public void menu1() {
		System.out.printf("****** 마지막 위치에 곡 추가 ******\n곡 명 : ");
		String song = sc.nextLine();
		System.out.print("가수 명 : ");
		String name = sc.nextLine();
		System.out.println(mc.lastInsert(song, name));
		
		
		
	}
	public void menu2() {
		System.out.printf("****** 첫번째 위치에 곡 추가 ******\n곡 명 : ");
		String song = sc.nextLine();
		System.out.print("가수 명 : ");
		String name = sc.nextLine();
		System.out.println(mc.fristInsert(song, name)); 
		
		
	}
	public void menu3() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for(int i = 0; i < mc.musicAllInfo().size();i++) {
			System.out.println(mc.musicAllInfo().get(i));
		}
		
	}
	public void menu4() {
		System.out.printf("****** 특정 곡 검색 ******\n검색할 곡 명 : ");
		String search = sc.nextLine();
		
		System.out.println(mc.musicSearch(search)); 
		
	}
	public void menu5() {
		System.out.printf("****** 특정 곡 삭제 ******\n삭제할 곡 명 : ");
		String remove = sc.nextLine();
		Music music = mc.musicRemove(remove);
		if(music != null) System.out.println(music + "(이)가 삭제되었습니다.");
		else System.out.println("삭제할 곡이 없습니다.");
		
	}
	public void menu6() {
		System.out.printf("****** 특정 곡 수정 ******\n검색할 곡 명 : ");
		String set = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String song = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String name = sc.nextLine();
		System.out.println(mc.musicSet(set, song, name));
		
	}
	public void menu7() {
		mc.sortReverse();
		System.out.println("*****가수명 기준 내림차순 정렬 완료*****");
		for(int i = 0; i < mc.musicAllInfo().size();i++) {
			System.out.println(mc.musicAllInfo().get(i));
		}
	}
	public void menu8() {
		mc.musicSort();
		System.out.println("*****곡명 오름차순 정렬 완료*****");
		for(int i = 0; i < mc.musicAllInfo().size();i++) {
			System.out.println(mc.musicAllInfo().get(i));
		}
	}
	
}