package com.kh.exam.modle;

import java.util.Arrays;

public class Member {
	
	private String name;
	private int age;
	private int coupon;
	private Book book[] = new Book[2];
	public Member() {
	}
	public Member(String name, int age, int coupon, Book[] book) {
		this.name = name;
		this.age = age;
		this.coupon = coupon;
		this.book = book;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public Book[] getBook() {
		return book;
	}
	public void setBook(Book[] book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", coupon=" + coupon + ", book=" + Arrays.toString(book) + "]";
	}
	
}
