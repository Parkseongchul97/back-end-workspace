package com.kh.step1.model;


/*
 * MVC 형태 (Model View Controller)
 * 기본 형태 
 * Model : MySQL에서 table 느낌
 * View : 프론트 앤드 영역으로 "화면단" 역할 
 * Controller : 기능 개발   
 * */
public class Tv {
	
	// TV 기능이 더 있지만 당장 프로그래밍화 하는데 필요한 속성과 기능만
	// 선택하여 작성하는 것을 추상화!
	
	// 속성(property) : 맴버변수(member variable), 특성(attribute), 필드(field)
	public boolean power; // 전원 상태(on/off)
	public int channel; // 채널 
	
	// 기능(function) : 메서드(method), 함수(function)
	public void power() {
		power = !power; // TV를 끄거나 키는 기능 
	}
	
	public void channelUp() {
		++channel; // channel 번호를 높이는 기능 
	}
	
	public void channelDown() {
		--channel; // channel 번호를 내리는 기능 
	}
	
}
