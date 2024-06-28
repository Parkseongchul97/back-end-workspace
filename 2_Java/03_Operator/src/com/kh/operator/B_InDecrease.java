package com.kh.operator;

public class B_InDecrease {

	public static void main(String[] args) {
		B_InDecrease b = new B_InDecrease();
//		b.method1();
		b.method2();
		
		/*
		 * 증감 연산자
		 * 
		 * 
		 *(증감연산자)값; 또는 값(증감연산자);
		 *
		 *	- 값을 1 증가시키거나 1감소시키는 연산자 
		 *	- ++ : 값을 1증가 
		 *	- -- : 값을 1 감소 
		 *	- (증감연산자)값 : 전위 연산으로 증감연산을 수행후 다른 연산을 수행한다. 
		 *	- 값(증감연산자) : 후위 연산으로 다른 연산을 수행후 증감연산을 수행한다.
		 * */

	}
	public void method1() {
		
		int number = 10;
		
		// 전위 연산자 
		System.out.println("1회 수행 후 값 : " + ++number); // 11
		System.out.println("2회 수행 후 값 : " + ++number); // 12
		System.out.println("전위 연산자 적용 후 : " + number); //12
		
		System.out.println("---------------------");
		
		System.out.println("1회 수행 후 값 : " + number++); // 12
		System.out.println("2회 수행 후 값 : " + number++); // 13
		System.out.println("후위 연산자 적용 후 : " + number); // 14
		
		
	}
	public void method2() {
		
		int number = 20;
		int result = number++ * 3; // 20 * 3 이지만 20값은 계산 다끝난후 +1 
		System.out.println(number); // 21
		System.out.println(result); // 60
		
		int number1 = 10;
		int number2 = 20;
		int number3 = 30;
		
		System.out.println(number1++);//
		System.out.println((++number1) + (number2++)); // 32 = 12 + 20
		System.out.println((number1++) + (--number2) + (number3--)); // 62 = 12 + 20 + 30 
		
		System.out.println(number1); // 13
		System.out.println(number2); // 20
		System.out.println(number3); // 29
		
		
	}
}
