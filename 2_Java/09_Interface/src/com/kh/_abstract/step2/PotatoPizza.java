package com.kh._abstract.step2;

public class PotatoPizza extends Pizza {
	
	private String toping;
	
	public PotatoPizza(int price, String brand) {
		super(price, brand);
		this.toping = "포테이토";
		
	}@Override
	public void makePizza() {
		super.makePizza();
	}
	@Override
	public void info() {
		System.out.println( brand + "의 포테이토 피자 가격은 " + price + "원");
	}
	@Override
	public void topping() {
		System.out.println("토핑은 감자를 포함한다.");
	}

}
