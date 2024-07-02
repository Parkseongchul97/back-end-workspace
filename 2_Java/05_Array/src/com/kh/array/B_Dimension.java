package com.kh.array;

import java.util.Arrays;

public class B_Dimension {
	
	/*
	 * 다차원 배열 : '[]'의 개수가 차원의 수를 의미 
	 * 
	 * * 2차원 배열의 선언 
	 * 자료형[][] 배열명;
	 * 자료형 배열명[][];
	 * 자료형[] 배열명[];
	 * 
	 * * 2차원 배열의 생성
	 * 배열명 = new 자료형[행크기][열크기];
	 * 
	 * * 2차원 배열의 선언과 초기화를 동시진행 
	 * 자료형[][] 배열명 = new 자료형[행크기][열크기];
	 * 
	 * 배열명[0][0] = 값;
	 * 배열명[0][1] = 값;
	 * ....
	 * 
	 * */

	public static void main(String[] args) {
		B_Dimension b = new B_Dimension();
//		b.method1();
		b.method2();
	}
	
	// 선언과 동시에 초기화 
	public void method1() {
		int[][] arr = { 
				{ 1, 2, 3, 4, 5 }, 
				{ 6, 7, 8, 9, 10 }, 
				{ 11, 12, 13, 14, 15 } 
		};
		// 2차원 배열의 각 행의 값출력하기 
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}

		// 2차원 배열의 값을 각 출력 
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
		// 향상된 for문 
		for(int[] i : arr) {
			//System.out.println(Arrays.toString(arr[i]));
			for(int j : i) {
				System.out.println(j);
			}	
		}
	}
	// 가변배열 : 다차원 배열에서 마지막 차수의 크기를 지정하지 않고 다르게 지정 
	/*[HTML, CSS, JavaScript]
	 *[MySQL, Java, JDBC, Servlet, JSP]
	 *[JQuery, MyBatis, Spring]
	 *[Spring Boot, React]
	 * 
	 * */
	public void method2() {
		String [][] strArr = {
				{"HTML", "CSS", "JavaScript"},
				{"MySQL", "Java", "JDBC", "Servlet", "JSP"},
				{"JQuery", "MyBatis", "Spring", "Spring Security"},
				{"Spring Boot", "JPA", "QueryESL", "React", "StyledComponents", "Redux"}
		};
		for(String[] i : strArr) System.out.println(Arrays.toString(i));
		
		System.out.println("\n--------------------------------------\n");
		
		for(int i = 0; i < strArr.length; i++) {
			for(int j = 0; j < strArr[i].length; j++) {
				System.out.println(strArr[i][j]);
			}
	}
}}
