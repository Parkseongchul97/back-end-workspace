package com.kh.overriding.model;

import java.util.Objects;

import com.kh.inheritance.parent.Product;

/*
 * 클래스 간의 관계 : 상속 vs 포함 
 * - 상속 관계 : ~은 ~이다.(is - a) 노트북은 상품이다
 * - 포함 관계 : ~은 ~을 가지고 있다. (has -a) 고객은 상품을 가지고있다.
 * - 자바는 단일상속만 허용 
 * - 클래스 간의 관계를 많이 맺을수록 재사용을 높이고 관리하기 쉽게 한다.(코드짜는건 더어려워질지도?)
 * */

public class Customer {
	
	protected String name, grade; // 이름 , 등급
	protected int bonusPiont;  	// 보너스 포인트
	protected double bonusRatio;  // 적립 비율 
	
	Product product; // 포함관계 
	
	public Customer() {}
	
	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";
		this.bonusRatio = 0.01;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getBonusPiont() {
		return bonusPiont;
	}
	public void setBonusPiont(int bonusPiont) {
		this.bonusPiont = bonusPiont;
	}
	public double getBonusRatio() {
		return bonusRatio;
	}
	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", grade=" + grade + ", bonusPiont=" + bonusPiont + ", bonusRatio="
				+ bonusRatio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonusPiont, bonusRatio, grade, name);
	}

	@Override // <-- 어노테이션! '이 메서드는 재 정의도니 매서드이다." 라고 명확히 알려주는 역할 
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		return this.name == c.name;
	}
	
	public int calcPrice(int price) {
		this.bonusPiont += price * bonusRatio; // 가격입력하면 보너스 포인트 계산 
		return price;
	}

	
	

}
