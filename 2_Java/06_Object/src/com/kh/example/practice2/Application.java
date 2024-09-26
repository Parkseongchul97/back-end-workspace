package com.kh.example.practice2;


import java.util.ArrayList;
import java.util.Scanner;

import com.kh.example.practice2.controller.SnackController;

import com.kh.example.practice2.model.Snack;

public class Application {
	
	

	public static void main(String[] args) {
//		Snack snack1 = new Snack();
//		SnackController snack1 = new SnackController();
//		snack1.saveData();
//		snack1.comfirmData();
//		SnackController snack2 = new SnackController();
//		snack2.saveData();
//		snack2.comfirmData();
		Snack snack1 = new Snack();
		snack1.setName("홍길동1");
		snack1.setPrice(11);
		Snack snack2 = new Snack();
		snack2.setName("홍길동2");
		snack2.setPrice(11);		
		Snack snack3 = new Snack();
		snack3.setName("홍길동3");
		snack3.setPrice(11);		
		Snack snack4 = new Snack();
		snack4.setName("홍길동4");
		snack4.setPrice(11);		
		Snack snack5 = new Snack();
		snack5.setName("홍길동5");
		snack5.setPrice(15);
		ArrayList<Snack> list = new ArrayList<Snack>();
		list.add(snack1); list.add(snack2); list.add(snack3); list.add(snack4); list.add(snack5);
		int rank = 1; // 1 < 금 2< 은 3< 동 4 < 4 < 5 < 5
		for(int i = 0; i < list.size() - 1; i++) {
			 // 등수
			list.get(i).setNumOf(i +1);
			if(list.get(i).getPrice() == list.get(i+1).getPrice()){ // 다음 등수와 동률이 아니면	
				list.get(i).setNumOf(list.get(i-1).getNumOf());
			}else {
				
				
			}
			
			System.out.println("이름 : " + list.get(i).getName() + "  점수 : "  + list.get(i).getPrice() + "  순위 : " + list.get(i).getNumOf());	
		}
		list.get(4).setNumOf(list.size());
		System.out.println("이름 : " + list.get(4).getName() + "  점수 : "  + list.get(4).getPrice() + "  순위 : " + list.get(4).getNumOf());
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
