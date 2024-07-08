package com.kh.polymorphism.controller;

import com.kh.polymorphism.model.child.Engineer;
import com.kh.polymorphism.model.parent.Employee;

public class EmployeeController {
	Employee e = new Employee();
	
	
	// 이름으로 사람 찾기 
	public Employee findEmployeeByName (String name, Employee[] empArr) {
		
		for (int i = 0; i < empArr.length; i++) { // 배열 index 도는 for문 
			if (empArr[i].getName().equals(name)) { // index 별로 name 일치하는지 찾음
				return empArr[i]; // 일치하는 index 번호의 employee 확보 
			}
		}
		return null; //new Employee();
		
	}
	// 찾는 사람의 연봉은?
	public int getAnnualSalary(Employee e) {
		if(e instanceof Engineer) { // 특정 자식 객체 찾는 방법!
			Engineer engineer = (Engineer) e; // 부모 -> 자식 : 강제 형 변환 !!
			return e.getSalary()*12 + engineer.getBonus(); 
		}
		return e.getSalary()*12; // 찾아둔 index 번호의 employee의 salary 값에서 12를 곱함
	}
	// 전체 사람들의 연봉 총합은?
	public int getTotalSalary(Employee[] empArr) {
		int sum = 0;
		for(int i = 0; i< empArr.length; i ++) {
			sum += getAnnualSalary(empArr[i]);
		}
		return sum;
	}


}
