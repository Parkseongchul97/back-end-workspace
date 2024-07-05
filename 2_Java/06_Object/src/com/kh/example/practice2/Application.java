package com.kh.example.practice2;


import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

import com.kh.example.practice2.model.Snack;

public class Application {
	
	

	public static void main(String[] args) {
		Snack snack1 = new Snack();
//		SnackController snack1 = new SnackController();
//		snack1.saveData();
//		snack1.comfirmData();
//		SnackController snack2 = new SnackController();
//		snack2.saveData();
//		snack2.comfirmData();
		
		// 한곳에 한 경우 
		Scanner sc = new Scanner(System.in);
		String kind,  name,  flavor; 
		int numOf, price ;
		// -----------------화면-----------------
		System.out.printf("스낵류를 입력하세요.\n종류 : ");
		kind = sc.nextLine();
		
		System.out.print("이름 : ");
		name = sc.nextLine();
		
		System.out.print("맛 : ");
		flavor = sc.nextLine();
		;
		System.out.print("개수 : ");
		numOf = Integer.parseInt(sc.nextLine());
		
		System.out.print("가격 : ");
		price = Integer.parseInt(sc.nextLine());
		//-------------------------------------
		// -> 즉 여기까지는 controller나 model에 직접 접근 X 
		
		// 데이터들을 서버한테 요청! 서버한태 전달할 때는 controller로 
		SnackController controller = new SnackController();
		
		// 서버에게 요청해서 응답받은 결과를 다시 화면으로 
		System.out.println(controller.saveData2(kind, name, flavor, numOf, price));
		System.out.println(controller.comfirmData2());
		
		
		
	}

}
