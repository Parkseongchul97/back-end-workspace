package com.kh.example.practice2.controller;

import java.time.format.FormatStyle;

import com.kh.example.practice2.model.Snack;

public class SnackController {
	private Snack s = new Snack();
	
	

	//데이터를 setter를 이용해 저장하고 “저장 완료되었습니다.” 결과를 반환하는 메서드 
	// 백단에서 데이터를 받지는 X 컨트롤러에 넣는 기능이 아님!!
//	public Snack saveData() {
//		String kind,  name,  flavor; int numOf, price ;
//		System.out.printf("스낵류를 입력하세요.\n종류 : ");
//		kind = sc.nextLine();
//		s.setKind(kind);
//		System.out.print("이름 : ");
//		name = sc.nextLine();
//		s.setName(name);
//		System.out.print("맛 : ");
//		flavor = sc.nextLine();
//		s.setFlavor(flavor);
//		System.out.print("개수 : ");
//		numOf = Integer.parseInt(sc.nextLine());
//		s.setNumOf(numOf);
//		System.out.print("가격 : ");
//		price = Integer.parseInt(sc.nextLine());
//		s.setPrice(price);
//		
//		System.out.println("저장 완료 되었습니다.");
//		return s;
//	}
//	// 저장한 데이터 반환
//	
//	public Snack comfirmData() {
//		System.out.printf("%s(%s - %s) %d 개 %d원\n",s.getKind(), s.getName(), s.getFlavor() ,s.getNumOf() , s.getPrice());
//		return s;
//	}
// 풀이******************************************
	public String saveData2(String kind, String name, String flavor, int numOf, int price) { 
		// 데이터를 setter를 이용해 저장하고 “저장 완료되었습니다.” 결과를 반환하는 메서드
		s.setKind(kind);
		s.setName(name);
		s.setFlavor(flavor);
		s.setNumOf(numOf);
		s.setPrice(price);
		
		return "저장 완료되었습니다.";
	}
	public String comfirmData2() {
		
		return String.format("%s(%s - %s) %d 개 %d원\n",s.getKind(), s.getName(), s.getFlavor() ,s.getNumOf() , s.getPrice());
//				s.getKind() + "( " + s.getName() + " - " + s.getFlavor() + " ) "+ 
//				s.getNumOf() + "개 " + s.getPrice() + "원";
		
	}
}
