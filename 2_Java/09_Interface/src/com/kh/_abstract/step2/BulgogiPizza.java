package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza {
	
	private String topping;

	public BulgogiPizza(int price, String brand ) {
		super(price, brand);
		this.topping = "불고기";
		
		
	}
	@Override
	public void makePizza() {
		super.makePizza();
	}
	@Override
	public void info() {
		System.out.println( brand + "의 불고기 피자 가격은 " + price + "원");
	}
	@Override
	public void topping() {
		System.out.println("토핑은 불고기를 포함한다.");
	}

}
