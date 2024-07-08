package com.kh.polymorphism;

import java.util.Scanner;

import com.kh.polymorphism.controller.EmployeeController;
import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.child.Manager;
import com.kh.polymorphism.model.child.Secretary;
import com.kh.polymorphism.model.parent.Employee;

/*
 * 다형성(Polymorphism)
 * - 하나의 객체변수가 여러가지 모양과 모습을 가지는 능력 
 * - 부모 타입으로 자식 객체를 생성하는 것 
 * */

public class Application {
	Scanner sc = new Scanner(System.in);
	
	EmployeeController ec = new EmployeeController();
	Employee e1 = new Employee("우현성", 10000);
	
	Engineer e2 = new Engineer("이동엽", 5000, "자바", 200);
	Manager m1 = new Manager("윤유진", 7000, "개발팀");
	Secretary s1 = new Secretary("송준호", 6000, "우현성");
	

	// 다형성 + 객체 배열 (부모태그로 자식객체 생성)
	Employee e3 = new Engineer("이동엽", 5000, "자바", 200);
	Employee m2 = new Manager("윤유진", 7000, "개발팀");
	Employee s2 = new Secretary("송준호", 6000, "우현성");
	
	Employee[] empArr = {e1,e3,m2,s2};
	
	public static void main(String[] args) {
		Application app = new Application();
		app.print();
	}
	public void print() {
		
		System.out.print("찾는 사람의 이름을 입력하시오 : ");
		String name = sc.nextLine();
		System.out.println(ec.findEmployeeByName(name, empArr));
		System.out.println(name + "님의 연봉 :" + ec.getAnnualSalary(ec.findEmployeeByName(name, empArr)));
		System.out.println("전체 사람들의 연봉 총합 : " + ec.getTotalSalary(empArr));
		
	}
	

}
