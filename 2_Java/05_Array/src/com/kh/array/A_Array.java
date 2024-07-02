package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class A_Array {
	
	Scanner sc = new Scanner(System.in);
	/*
	 * 변수 : 하나의 공간에 하나의 값을 담음
	 * 배열 : 하나의 공간에 "여러개의 값"(같은 자료형의 값)을 담음
	 * 
	 * 배열의 선언 
	 * 자료형[] 배열명;
	 * 자료형 배열명[];
	 * - 배열을 선언한다고 해서 값을 저장할 공간이 생성되는 것이 아니라
	 * 	 배열을 다루는데 필요한 변수가 생성
	 * 
	 * 배열의 초기화
	 * 배열명 = new 자료형[배열크기];
	 * - 생성된 배열에 처음으로 값을 저장 
	 * 
	 * 배열의 선언과 초기화가 동시 진행
	 * 자료형[] 배열명 = new 자료형[배열크기];
	 * */

	public static void main(String[] args) {
		A_Array a = new A_Array();
//		a.method1();
//		a.method2();
//		a.method3();
//		a.method4();
//		a.method5();
//		a.method6();
//		a.method7();
		a.method8();

	}
	public void method1() {
		int[] nums = new int[5]; // 배열크기는 반드시 지정!! 안할시 오류  nums 라는 배열에 숫자 5개가 들어가는 공간 
		System.out.println(nums); // 배열의 주소값이 출력 
		
		
		System.out.println(nums[0]); // 공간만 지정하고 값을 지정 X
		System.out.println(nums[1]); // 기본값 0 모두 출력!
		System.out.println(nums[2]); // 정수형 기본값 : 0  , 문자형 : \u0000
		System.out.println(nums[3]); // 실수형 기본값 : 0.0, 논리형 : false, 참조형 : null
		System.out.println(nums[4]);
		
		nums[0] = 100;
		nums[1] = 70;
		nums[2] = 90;
		nums[3] = 80;
		nums[4] = 60;
		
		System.out.println(nums[0]); 
		System.out.println(nums[1]); 
		System.out.println(nums[2]);
		System.out.println(nums[3]); 
		System.out.println(nums[4]);
	}
	// 배열 선언과 동시에 값들 초기화 
	public void method2() {
		int[] nums = {100, 70, 90, 80, 60};
		
		for (int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
		
		System.out.println("------");
		
		for(int value : nums) { // 배열이라 향상된 for 문 사용 가능 
			System.out.println(value);
		}
		
	
	}
	
	/*
	 * 3명의 키를 입력받아 배열에 저장하고 명의 키의 평균값을 구하시오
	 * 키입력 180
	 * 키입력 177.3
	 * 키입력 168.2
	 * 평균 175.2
	 * */
	public void method3() {
		
		double sum = 0;
		double[] arr = new double[3];
		for(int i = 0; i < arr.length; i++) { // 사실상 배열과 for문은 세트 
			System.out.print("키 입력 : ");
			arr[i] = sc.nextDouble();
			sum += arr[i];
		}
		System.out.printf("평균 키 : %.1f\n" , sum / arr.length);
		System.out.println(Arrays.toString(arr));
		
	}
	// 배열의 복사
	// 1. 얕은 복사 : 배열의 주소만 복사
	public void method4() {
		
		int[] number = { 1, 2, 3, 4, 5 };
		int[] copy = number;
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
		copy[1] = 20; // 같은 주소를 향하기 때문에 둘 중 하나만 바꿔도 값이 같이 바뀜 
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
	}
	// 2. 깊은 복사 : 동일한 새로운 배열을 하나 생성해서 내부 값들도 함께 복사
	// 1) for 문을 이용한 깊은 복사 
	public void method5() {
		int[] number = { 1, 2, 3, 4, 5 };
		int[] copy = new int[number.length];
		for(int i = 0; i < number.length; i++) {
			copy[i] = number[i];
		}
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
		copy[1] = 20; // copy의 1번째 배열만 바뀜 
		// 값을 복사한것 이기 떄문에 서로 완전히 다른 배열임 
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
			
	}
	// 2) System 클래스에서 제공하는 arraycopy() 메서드를 이용한 깊은 복사
	//    System.arraycopy(원본배열, 복사시작인덱스, 복사본배열, 복사시작인덱스, 복사할길이);
	public void method6() {
		int[] number = { 1, 2, 3, 4, 5 };
		int[] copy = new int[number.length];
		System.arraycopy(number, 0, copy , 0, number.length);
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
		copy[1] = 20; // 마찬가지로 값을 복사한 것이라 copy의 1번째 배열만 바뀜
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));
		
	}
	// 3) Array 클래스에서 제공하는 copyOf() 매서드를 이용한 깊은 복사 
	//	  Arrays.copyOf(원본배열, 복사본배열길이);
	public void method7() {
		int[] number = { 1, 2, 3, 4, 5 };
		int[] copy = Arrays.copyOf(number, number.length);
		
		System.out.println(Arrays.toString(number));
		System.out.println(Arrays.toString(copy));		
	}
	// 4) 배열의 clone() 매서드를 이용한 깊은 복사 !!이것만 알아도 충분 !!
	// 배열 초기화때 배열 = 복사할배열.clone();
	public void method8() {
		int[] number = { 1, 2, 3, 4, 5 };
		int[] copy = number.clone();
	}
}
