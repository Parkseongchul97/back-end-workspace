package com.kh.list.practice.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.list.practice.model.Music;
import com.kh.list.practice.model.ReverSort;

public class MusicController {
	Music music = new Music();
	List<Music> list = new ArrayList();
	
	
	public void lastInsert (String song, String name) { // 마지막위치 곡추가
		list.add(new Music(song, name));
		System.out.println("추가 성공!");
	}
	public void fristInsert (String song, String name) { // 제일 앞에 곡추가
		list.add(0, new Music(song, name));
		System.out.println("추가 성공!");
	}
	public void musicAllInfo() { // 곡 출력
		if (list.isEmpty()) {
			System.out.println("저장된 곡이 없습니다.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					System.out.println(list.get(i).getName() + " - " + list.get(i).getSong());

				}
			}
		}
		
	}
	public void musicSeach(String seach) { // 곡 검색
		boolean ck = false ;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(seach)) {
			System.out.println(list.get(i).getName() + " - " + list.get(i).getSong() + "을(를) 검색했습니다.\n");  	
			ck = true;
			break;
		}
		
	}
		if(!ck)System.out.println("검색된 곡이 없습니다");
	}
	public void musicRemove(String remove) { // 곡 삭제
		boolean ck = false ;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(remove)) {
				System.out.println(list.get(i).getName() + " - " + list.get(i).getSong() + "을(를) 삭제했습니다.\n"); 
				list.remove(i);
				ck = true;
				break;
				
			}if(!ck)System.out.println("삭제할 곡이 없습니다");
	}}
	public void musicSet(String set,String song, String name) { // 곡 수정
		boolean ck = false ;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getSong().equals(set)) {
				System.out.print(list.get(i).getName() + " - " + list.get(i).getSong() + "의 값이 ");
			  	list.set( i, new Music( song, name ));
			  	System.out.println(list.get(i).getName() + " - " + list.get(i).getSong() + "으로 변경되었습니다.");
			  	 
		}
			}if(!ck)System.out.println("수정할 곡이 없습니다");
		
		
	}
	public void sortReverse() {// 가수명 내림차순??????????
		
		Collections.sort(list,new  ReverSort());
	
	}
	public void musicSort() { // 곡명 오름차순 
		Collections.sort(list);
	}
	

}
