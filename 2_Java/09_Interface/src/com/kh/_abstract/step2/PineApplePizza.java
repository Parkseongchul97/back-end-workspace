package com.kh._abstract.step2;

public class PineApplePizza extends Pizza {
	
	private String toping;
	
	public PineApplePizza(int price, String brand) {
		super(price, brand);
		this.toping = "파인애플";
		
	}
	@Override
	public void makePizza() {
		super.makePizza();
	}
	@Override
	public void info() {
		System.out.println( brand + "의 파인애플 피자 가격은 " + price + "원");
	}
	@Override
	public void topping() {
		System.out.println("토핑은 파인애플을 포함한다.");
	}
	

}
