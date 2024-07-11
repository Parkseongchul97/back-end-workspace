package com.kh.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class A_Date {
	
	/*
	 * Date
	 * - java.util 패키지에 속한 날짜와 시간을 다룰 목적으로 만들어진 클래스 (JDK 1.0)
	 * - Date의 메서드는 대부분 deprecated(비권장) 되어있지만 여전히 사용 
	 * */
	
	public void method1() {
		// 기본 생성자로 객체를 생성하면 현재 시스템의 시간에 대한 정보를 가지고 객체 생성 
		Date today = new Date();
		System.out.println(today); // Thu Jul 11 11:46:27 KST 2024
		Date when = new Date(0);
		System.out.println(when);  // Thu Jan 01 09:00:00 KST 1970 기준시간
		
		System.out.println("getTime : " + today.getTime()); // 1720666173383 위 기준시간으로부터 오늘을 뜻함
		
		//Deprecated된 기능들!
		System.out.println("getYear : " + (today.getYear()+ 1900) + "년" ); // 124 + 1900년
		System.out.println("getMonth : " + (today.getMonth() +1) + "월"); // 0부터 시작이라 6 + 1 월
		System.out.println("getDate : " + today.getDate() + "일"); // 11일 
		System.out.println("getHours : " + today.getHours() + "시"); // 12시
		System.out.println("getMinutes : " + today.getMinutes() + "분"); // 5분
		System.out.println("getSeconds : " + today.getSeconds() + "초"); // 54초
		
		// simpleDateFormat : 날짜 데이터를 원하는 형태로 출력할 수 있도록 (H : 0~23, h : 1~12, a : 오전/오후)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 (E) a HH시 mm분 ss초");
		// 2024년 7월 11일 (목) 12시 8분 30초
		String formatDate = sdf.format(today);
		System.out.println(formatDate);
		
		
		
	}
	/*
	 * Calendar
	 * - Date 클래스를 개선한 추상 클래스(JDK 1.1)
	 * - 여전히 단점이 존재 
	 * */
	public void method2() {
		/*
		 * 추상 클래스이기 때문에 직접 객체 생성할 수 없다
		 * getInstance() 메서드로 Calendar 클래스를 구현한 클래스의 객체를 반환
		 * 태국 - BuddhistCalendar, 그 외 - GregorianCalendar 그리고리력 사용하는데 태국은 지들꺼 씀
		 * */
		Calendar today = Calendar.getInstance();
		today = new GregorianCalendar();
		System.out.println(today);
		
		// 년,월,일,시,분,초 
		System.out.println("YEAR : " + today.get(Calendar.YEAR) + "년");
		System.out.println("MONTH : " + (today.get(Calendar.MONTH)+1) + "월");
		System.out.println("DATE : " + today.get(Calendar.DATE) + "일");
		System.out.println("HOUR : " + today.get(Calendar.HOUR) + "시"); // 0 ~ 11
		System.out.println("HOUR_OF_DAY : " + today.get(Calendar.HOUR_OF_DAY) + "시"); // 0 ~ 23
		System.out.println("MINUTE : " + today.get(Calendar.MINUTE) + "분");
		System.out.println("SECOND : " + today.get(Calendar.SECOND) + "초");
		
		System.out.println("----------------------");
		
		// 날짜 지정 
		Calendar date = Calendar.getInstance();
		date.set(2024, Calendar.JULY, 11); // 월은 항상 +1로 계산 7월이면 6을 넣던가 Calendar.JULY
		System.out.println(date.getTime()); // Calendar를 Date 객체로 반환
		System.out.println("-----------------");
		
		//SimpleDateFormat 사용 가능 

		SimpleDateFormat sdf = new SimpleDateFormat("YY-MM-dd HH:mm:ss");
		String dateFormat = sdf.format(today.getTime());
		System.out.println(dateFormat);
	}
	public void method3() {
		
	}

	public static void main(String[] args) {
		A_Date a = new A_Date();
//		a.method1();
		a.method2();
		a.method3();
	}

}
