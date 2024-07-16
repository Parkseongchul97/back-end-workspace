package com.kh.step5;

public class User1 extends Thread {
	
	private Calculator calculator;
	
	public void setCalclator(Calculator calculator) {
		setName("CaculatorUser1");
		this.calculator = calculator;
	}

	public void run() {
		calculator.setMemory(100);
		
	}
}
