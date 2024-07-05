package com.kh.practice1.model;

public class Member {
	
	private String id;
	private String pwd;
	private String name;	
	private int age;
	private char gender; 
	private String phone;
	private String email;
	
	public Member() {}
	
	public void changeName(String name) {
		this.name = name;
	}
	public void printName() {
		System.out.println(this.name); // this가 생략도 가능 
	}
	
	public void memberInfomation() {
		System.out.printf("\t맴버 정보\n이름%s",name);
	}
	
	
	
	
	
	public Member(String id, String pwd, String name, int age, char gender, String phone, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
	}




}
