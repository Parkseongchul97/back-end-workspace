package com.kh.stream.terminal;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class B_Aggregate {

	/*
	 * 기본 집계
	 * - 최종 처리 기능으로 요소들을 개수, 합계, 평균값, 최대값, 최소값 등과 같이
	 * 	 하나의 값으로 산출하는 역할 
	 * 		- count : 요소의 개수 리턴
	 * 		- sum : 요소들의 합계 리턴
	 * 		- average : 요소들의 평균 리턴
	 * 		- max : 최대요소 리턴
	 * 		- min : 최소 요소 리턴 
	 * 		- findFirst : 첫번째 요소 리턴
	 * 
	 * */
	public void method1() {
		int[] arr = {1,2,3,4,5,6};
		
		long count = Arrays.stream(arr).count();
		System.out.println("개수 : " + count);
		int sum = Arrays.stream(arr).sum();
		System.out.println("합계 : " + sum);
		
		/*Optional 클래스
		 * - 스트림의 최종 결과 값을 저장하는 객체
		 * - 단순히 값만 저장하는 것이 아니라, 값의 존재 여부를 확인하고
		 * 	 값이 존재하지 않을 경우 디폴트 값을 설정할 수 있는 객체 
		 * */
		
		// get : 저장되어 있는 값을 얻기 위해 사용 
		double avg = Arrays.stream(arr).average().getAsDouble(); // <- getAsXXX() : OptionalXXX 클래스를 더블 타입으로 바꿔주는 메서드
		System.out.println("평균 : " + avg);
		int max = Arrays.stream(arr).max().getAsInt();
		System.out.println("최대 : " + max);
		OptionalInt oMax = Arrays.stream(arr).max();
		
		//orElse : get과 동일하게 저장되어 있는 값을 얻어오는 매서드로
//				   값이 저장되어 있지 않을 경우 디폴트 값을 지정 
		int max2 = oMax.orElse(0);
		
		// isPresent : 값이 저장되어 있는지 검사 
		if(oMax.isPresent()) 
			 System.out.println("최대 : " + oMax.getAsInt());
		else System.out.println("최대 : 0");
		
		// ifPresent : 값이 저장되어 있을경우 처리 if+ isPresnt
		oMax.ifPresent(value -> System.out.println("최대 : "+ value));
		
		int min = Arrays.stream(arr).min().getAsInt();
		System.out.println("최소 : " + min);
		int first = Arrays.stream(arr).findFirst().getAsInt();
		System.out.println("첫번째 해당하는 숫자 : " + first);
	}
	
	/*
	 * 커스텀 집계
	 * - 스트림에서 기본 집계 메서드를 제공하지만 다양한 집계 결과물을 만들 수 있도록
	 * 	 reduce 메서드를 제공한다.
	 * */
	public void method2() {
		int[] values = {1,2,3,4,5,6};
		
		// 1*2*3*4*...
		int result = Arrays.stream(values).reduce((x, y) -> x * y).getAsInt();
		System.out.println(result);
		
	}
	
	public static void main(String[] args) {
		B_Aggregate b = new B_Aggregate();
//		b.method1();
		b.method2();

	}

}
