package com.kh.list.practice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.list.practice.model.Music;
import com.kh.list.practice.model.ReverSort;

public class MusicController {
	Music music = new Music();
	List<Music> list = new ArrayList();
	
	
	public String lastInsert (String song, String name) { // 마지막위치 곡추가
		list.add(new Music(song, name));
		return "추가 성공!";
	}
	
	public String fristInsert (String song, String name) { // 제일 앞에 곡추가
		list.add(0, new Music(song, name));
		return "추가 성공!";
	}
	
	public List<String> musicAllInfo() { // 곡 출력
		
		List<String> musicList = new ArrayList<>();
		
		if(!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					musicList.add(list.get(i).getName() + " - " + list.get(i).getSong());
				}
			}
		}
		return musicList;
		
	}
	public String musicSeach(String seach) { // 곡 검색
		String str = "";
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(seach)) {
				str = list.get(i).getName() + " - " + list.get(i).getSong() + "을(를) 검색했습니다.\n";  		
		}else  {
			str= "검색된 곡이 없습니다";	
			}
		}	
		return str;
		}
	// 곡검색 기능으로 메서드 다중사용? // list <Music>으로 받아서 검색, 수정, 삭제 하는곳에 사용될 list를 특정해서 
	// 메서드안에 사용!?? 아마가능? BUT null인경우? 트라이캐치로 그냥 빠져나갈수 있도록!
	public List<Music> musicSelect(String seach) { // 곡 검색
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(seach)) {
				list.get(i); 		
		}else  {
		
	
		}}
		return null;}
	
	//
	public String musicRemove(String remove) { // 곡 삭제
		String str = "";
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(remove)) {
				str = list.get(i).getName() + " - " + list.get(i).getSong() + "을(를) 삭제했습니다.\n"; 
				list.remove(i);
			}else {
				str = "검색된 곡이 업습니다.";
					}	
				}
		return str;	
			
	}
	public String musicSet(String set,String song, String name) { // 곡 수정
		String str = "";
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(set)) {
				str = list.get(i).getName() + " - " + list.get(i).getSong() + "의 값이 변경되었습니다. ";
			  	list.set( i, new Music( song, name ));
			}else {
			  		str =  "수정할 곡이 없습니다";	
			  	}		  	 	
	}return str;
	}
	public void sortReverse() {// 가수명 내림차순??????????
		
		Collections.sort(list,new ReverSort());
		musicAllInfo();
	}
	public void musicSort() { // 곡명 오름차순 
		Collections.sort(list);
		musicAllInfo();
	}
	

}
