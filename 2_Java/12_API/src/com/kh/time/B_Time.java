package com.kh.time;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class B_Time {
	Scanner sc = new Scanner(System.in);
	/*
	 * java.time 패키지
	 * - Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공(JDK 1.8)
	 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 클래스 포함
	 * - 날짜와 시간에 대한 다양한 메서드를 제공 
	 * */

	public void method1(){
		
		/*
		 * LocalDateTime
		 * - 날짜와 시간 정보를 모두 저장 
		 * */
		LocalDateTime now = LocalDateTime.now();
		System.out.println("today : " + now);
		
		// 날짜 지정 
		LocalDateTime when = LocalDateTime.of(2024, 7,12,17,50,0);
		System.out.println("when : " + when);
		
		// ZonedDateTime : LocalDateTime + 시간대(그리니치 표준시 기준 +09 아시아/서울) 
		System.out.println("ZonedDateTime : " + ZonedDateTime.now());
		
		// 년, 월, 일, 요일, 시 , 분 ,초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonth()); // JULY
		System.out.println(now.getMonthValue() + "월");
		System.out.println(now.getDayOfMonth() + "일"); // 월을 기준으로 +n 일
		System.out.println(now.getDayOfWeek()); // THURSDAY
		System.out.println(now.getHour() + "시");
		System.out.println(now.getMinute() + "분");
		System.out.println(now.getSecond() + "초");
		
		System.out.println("----------------------");
		
		// 날짜 조작 
		LocalDateTime plusDays = now.plusDays(1).plusMonths(2).plusYears(1);
		System.out.println("plusDays : " + plusDays); // 11일 -> 12일/7월 -> 9월
		
		LocalDateTime minusDays = now.minusDays(1).minusMonths(1).minusYears(1);
		System.out.println("minus : " + minusDays);
		
		LocalDateTime withDays = now.withYear(2025).withMonth(8).withDayOfMonth(10);
		System.out.println("with : " + withDays);
		
		System.out.println("----------------");
		System.out.println("isAfter : " + now.isAfter(withDays)); // 오늘(now)이 해당 날짜보다 이후인가?
		System.out.println("isBefore : " + now.isBefore(withDays)); // 오늘(now)이 해당 날짜보다 이전인가?
		
		// LocalDate : 날짜 정보를 저장 
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate1 : " + localDate);
		localDate = LocalDate.of(2024, 11, 13);
		System.out.println("LocalDate2 : " + localDate);
		
		// LocalTime : 시간 정보를 저장 
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime1 : " + localTime);
		localTime = LocalTime.of(17, 49,59);
		System.out.println("LocalTime2 : " + localTime);
	}
	
	/*
	 * Period와 Duration
	 * - 날짜와 시간 간격을 표현하기 위한 클래스 
	 * - Period : 두 날짜 간의 차이 
	 * - Duration : 시간의 차이 
	 * */
	public void method2(){
		LocalDate date1 = LocalDate.of(2024,1,1);
		LocalDate date2 = LocalDate.of(2025,12,31);
		Period pe = Period.between(date1, date2);
		System.out.println("Period : " + pe); // P1Y11M30D
		
		System.out.println("years : " + pe.getYears() + "년");
		System.out.println("months : " + pe.getMonths() + "월");
		System.out.println("days : " + pe.getDays() + "일");
		System.out.println("-------------------");
		System.out.println("years : " + pe.get(ChronoUnit.YEARS) + "년");
		System.out.println("months : " + pe.get(ChronoUnit.MONTHS) + "월");
		System.out.println("days : " + pe.get(ChronoUnit.DAYS) + "일");
		
		LocalTime time1 = LocalTime.of(1, 2, 3);
		LocalTime time2 = LocalTime.of(11, 59, 59);
		Duration du = Duration.between(time1, time2);
		System.out.println(du); // PT11H59M59S
		System.out.println("hours : " + du.toHours() + "시");
		System.out.println("minutes : " + du.toMinutes() + "분");
		System.out.println("seconds : " + du.toSeconds() + "초");
		
		// 문자열을 LocalDate 객체로 파싱
		LocalDate date = LocalDate.parse("2024-11-13");
		System.out.println(date);
		
		// DateTimeFormatter
		// 날짜와 시간을 포멧팅(Formatting)된 문자열로 변환하는 메서드를 제공하는 클래스
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String formatDate = today.format(dtf);
		System.out.println(formatDate);
		
	}
	
	/*
	 * D-Day 계산기 : 년 월 일을 각각 입력하여 디데이 계산 
	 * ChronoUnit.DAYS.between(날짜, 날짜)
	 * 또는 날짜.until(날짜, ChronoUnit.DAYS)
	 * */
	public void method3(){
		
		
			LocalDate today = LocalDate.now();
			System.out.printf("날짜를 입력하시오\n년 : ");
			String years = sc.nextLine();
			if(years.length() != 4){
				years = "20" + years;	
				}
			System.out.print("월 : ");
			String months = sc.nextLine();
			
			if(months.length() != 2){
				months = "0" + months;	
				}
			System.out.print("일 : ");
			String dates = sc.nextLine();
			if(dates.length() != 2){
				dates = "0" + dates;	
				}
			try {
				LocalDate dDay = LocalDate.parse(years + "-" + months + "-" + dates) ;
//				LocalDate dDay = LocalDate.of(years,months,dates); // int 값으로 받으면 가능 
				long when = today.until(dDay, ChronoUnit.DAYS);
				when = ChronoUnit.DAYS.between(today, dDay);
				if(when == 0) {
					System.out.println("오늘은 D-DAY("+ dDay +")입니다.");
					
				}else if(when>0) {
				System.out.println("D-DAY("+ dDay +")까지 남은 날짜는 " + when + "일 입니다.");
				
				}else {
					System.out.println("D-DAY("+ dDay +")로 부터 " + -when + "일이 지났습니다.");
					method3();
				}
				} catch (Exception e) {
					System.out.println("올바른 값이 아닙니다.\n");
					method3();
				}	
				
		
	}
	
	
	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();


	}

}
