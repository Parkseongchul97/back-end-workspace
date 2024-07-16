package com.kh.step5;

public class User2 extends Thread {
	
	private Calculator calculator;
	
	public void setCalclator(Calculator calculator) {
		setName("CaculatorUser2");
		this.calculator = calculator;
	}

	public void run() {
		calculator.setMemory(50);
		
	}
}
