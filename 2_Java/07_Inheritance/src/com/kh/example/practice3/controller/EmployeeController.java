package com.kh.example.practice3.controller;

import com.kh.example.practice3.model.Employee;

public class EmployeeController {
	private Employee employee = new Employee();
	
	public void  add(int empNo, String name, char gender, String phone) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
	}
	public void  add(int empNo, String name, char gender, String phone, String dept, int salary, double bonus) {
		employee.setEmpNo(empNo);
		employee.setName(name);
		employee.setGender(gender);
		employee.setPhone(phone);
		employee.setDept(dept);
		employee.setSalary(salary);
		employee.setBonus(bonus);
	}
	public void  modify	(String phone) {
		employee.setPhone(phone);
	}
	public void  modify	(int salary) {
		employee.setSalary(salary);
	}
	public void  modify	(double bonus) {
		employee.setBonus(bonus);
	}
	public String info() {
		
		return String.format("사번 : %d \n이름 : %s \n성별 : %s \n전화번호 : %s \n부서명 : %s \n연봉 : %d \n보너스 율 : %.1f\n"
				,employee.getEmpNo(),employee.getName() ,employee.getGender() ,employee.getPhone(),employee.getDept(),employee.getSalary(),employee.getBonus());
	}
		
	}

