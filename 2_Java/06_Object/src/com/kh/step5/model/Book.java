package com.kh.step5.model;

public class Book {
	
	
	/*
	 * 캡슐화(Encapsulation)
	 * - 정보은닉 : 외부에서 객체 접근하는데 있어서 정보를 숨기고
	 * 			 객체의 연산을 통해서만 접근이 가능하게 하는 것 
	 * - 객체 내 정보손상, 오용을 방지하고, 데이터가 변경되어도 다른 객체에 영향을 주지 X
	 * - 독립성이 좋고, 하나의 모듈처럼 사용이 가능 
	 * */
	
	private String title;
	private int price;
	private double discountRate;
	private String author;
	
	
	// 알트 시프트 S  <super class > 기본생성 
	public Book() {
	}
	

	//  알트 시프트 S <Using field> 기본생성 
	public Book(String title, int price, double discountRate, String author) {
		this.title = title;
		this.price = price;
		this.discountRate = discountRate;
		this.author = author;
	}
	
	// setter : 특정 객체 값 넣을 때 사용
//	public void setTitle(String title) {
//		this.title = title;
//	}
	
	// getter : 특정 객체 값 가져 올 때 사용 
//	public String getTitle() {
//		return title;
//	}
	
	// 알트 시프트 S <Getter and Setter>
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public double getDiscountRate() {
		return discountRate;
	}


	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	

	// 알트 시프트 S  toString() 생성 
	@Override
	public String toString() {
		return  "Book ------- \ntitle : " + title + "\nprice : " + price +  "\ndiscountRate : "
	+ discountRate + "\nauthor : " +author + "\n";
	}
	
	// 할인된 가격을 알기위한 메서드 생성
	public int discountPrice() {
		return (int) (price - (price* discountRate));
		
	}



	

}
