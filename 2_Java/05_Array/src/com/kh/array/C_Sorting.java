package com.kh.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;


public class C_Sorting {
	

	public static void main(String[] args) {
		C_Sorting c = new C_Sorting();
//		c.method1();
//		c.method2();
		c.method3();
	}
	public void method1() {
		
		int[] arr = { 7, 5, 9, 0, 3, 1, 6, 2, 4, 8 };
		
		System.out.println(Arrays.toString(arr));
		
		// 1. 오름차순 정렬 (작은숫자 -> 큰숫자)
		Arrays.sort(arr); // Dual-Pivot QuickSort 
		System.out.println(Arrays.toString(arr));
		
		// 2. 내림차순 정렬 (큰숫자 -> 작은숫자)
		// 원본 배열을 오름차순 정렬한 다음 값을 반대로 새로운 배열에 대입 
		int[] copy = new int[arr.length];
		
		for(int i = 0; i < arr.length; i ++) {
			copy[arr.length -1 - i] = arr[i];	// i가 0일때는 길이의 -1에 대입, i가 1이면 길이의 -1 -i(1) 해서 뒤에서 2번째 대입 이런식 
			}
		System.out.println(Arrays.toString(copy));
		
		}
	
	public void method2() {
			
		String[] arr = {"사과", "Orange", "배", "banana", "Lemon", "kiwi"};
		System.out.println(Arrays.toString(arr));
		
		// 오름차순 정렬 대문자 - 소문자 - 한글 순으로 정렬 
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		// 내림차순 정렬 
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));

	}
	// 최대값과 최소값 구하기 
	public void method3() {
		
		int[] score = { 79, 88, 91, 44, 100, 55, 95 };
		Arrays.sort(score);
		
		System.out.printf("최소 값 : %d\n",score[0]);
		System.out.printf("최대 값 : %d\n",score[score.length - 1]);

	}
	/*
	 * 선택 정렬 
	 * */
	
	public void method4() {}
	/*
	 * 삽입 정렬 
	 * */
	public void method5() {}
	
	/*
	 * 버블정렬
	 * */
	public void method6() {}
}
