package com.kh.inheritance;

import com.kh.inheritance.child.Notebook;
import com.kh.inheritance.child.SmartPhone;

public class Application {

	public static void main(String[] args) {
		
		Notebook notebook = new Notebook("애플", "app-01", "맥북 프로 16", 3400000  ,"M3");
		SmartPhone smartphone = new SmartPhone("삼성", "sam-02", "갤럭시 S24 울트라",1500000,"SKT");
		
		SmartPhone smartphone2 = new SmartPhone();
		smartphone2.setAgency("KT");
		smartphone2.setBrand("삼성");
		smartphone2.setName("갤럭시 Z 플립 5");
		smartphone2.setpCode("sam-03");
		smartphone2.setPrice(12000000);
		
		System.out.println(notebook);
		System.out.println(smartphone);
		System.out.println(smartphone2);

	}

}
