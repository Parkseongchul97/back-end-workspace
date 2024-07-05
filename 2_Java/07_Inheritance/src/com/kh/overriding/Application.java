package com.kh.overriding;

import java.util.Scanner;

import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VIPCustomer;

public class Application {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		Customer cutomer1 = new Customer("김경주");
		Customer cutomer2 = new Customer("김경주");
		
		System.out.println(cutomer1);
		System.out.println(cutomer2);
		
		System.out.println(cutomer1 == cutomer2); // false 객체끼리의 비교는 주소값을 비교하기 때문 
		System.out.println(cutomer1.equals(cutomer2)); // false
	
		// ~~ 님의 등급은 ~~ 이며, 지불해야 하는 금액은 ~원이며, 적립된 포인트는 ~~점 입니다.
		
		System.out.print("물건 가격 : ");
		int price = sc.nextInt();
		cutomer1.calcPrice(price);
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점 입니다.\n",
				cutomer1.getName(), cutomer1.getGrade(), 
				price, cutomer1.getBonusPiont()); // 입력받는게 아니면 cutomer1.calcPrice(원하는금액); 하면댐 
		
		VIPCustomer customer3 = new VIPCustomer("김진주");
		VIPCustomer customer4 = new VIPCustomer("김진주");
		
		System.out.println(customer3);
		System.out.println(customer4);
		
		System.out.println(customer3.equals(customer4));
		
		System.out.printf("%s님의 등급은 %s이며, 지불해야 하는 금액은 %d원이며, 적립된 포인트는 %d점 입니다.\n",
				customer3.getName(), customer3.getGrade(), 
				customer3.calcPrice(1000000) , customer3.getBonusPiont());
		

	}

}
