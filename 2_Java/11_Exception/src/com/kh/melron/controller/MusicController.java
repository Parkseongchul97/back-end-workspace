package com.kh.melron.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.melron.compare.Ascending;
import com.kh.melron.model.Music;
import com.kh.melron.model.ReverSort;

public class MusicController {
	Music music = new Music();
	List<Music> list = new ArrayList();
	String str ;
	
	
	public String lastInsert (String song, String name) { // 마지막위치 곡추가
		list.add(new Music(song, name));
		return "추가 성공!";
	}
	
	public String fristInsert (String song, String name) { // 제일 앞에 곡추가
		list.add(0, new Music(song, name));
		return "추가 성공!";
	}
	
	public List<Music> musicAllInfo() { // 곡 출력
		return list;
	}// toString을 변경해서 출력 바로할수있게
	
	
	// 해당 인덱스 배열 번호를 int  값으로 받기
	public int musicSelect(String search) { // 곡 찾기
		int j = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSong().contains(search)) { // contains 포함 되어있으면
				j = i;
				
			}
		}
		return j;
	}
	public int musicPerpactSelect(String search) { // 곡 찾기
		int j = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSong().equals(search)) {
				j = i;
				
			}
		}
		return j;
	}
	
	public String musicSearch(String search) { // 곡 검색
   int i = musicSelect(search); 
    if (i == -1) return "검색된 곡이 없습니다";
     else return list.get(i).getName() + " - " +list.get(i).getSong() + "을(를) 검색했습니다.\n";
}	// 반환타입 Music으로 해서 Music 받고 어플리케이션에서 if else로 출력해도 좋음
	// 원하는 메서드 결과값의 리턴값을 이용하면 유연하게 메서드 사용가능
	
	public Music musicRemove(String remove) { // 곡 삭제
		for (Music music : list) {
			if (music.getSong().equals(remove)) {
				return list.remove(list.indexOf(music));	
			}
		}    
		return null;	
	}
	public String musicSet(String set,String song, String name) { // 곡 수정
		int i = musicPerpactSelect(set);
		if (i == -1) str = "수정할 곡이 없습니다";
		else {
			str = list.get(i).getName() + " - " + list.get(i).getSong() + "의 값이 변경되었습니다. ";
			list.set( i, new Music(song, name));		  	 	
	}
		return str;
	}
	
	public List<Music> sortReverse() {// 가수명 내림차순
		Collections.sort(list,new ReverSort());
		return musicAllInfo();
		// 전체를 그대로로 하고 싶으면 복사용 배열 만들어서 사용 
	}
	public List<Music> musicSort() { // 곡명 오름차순 
		Collections.sort(list, new Ascending());
		return musicAllInfo();
	}	
}


//	public String musicSearch(String search) { // 곡 검색
//	String str = "";
//	for(int i = 0; i < list.size(); i++) {
//		if(list.get(i).getSong().equals(search)) {
//			str = list.get(i).getName() + " - " + list.get(i).getSong() + "을(를) 검색했습니다.\n";  		
//	}else  {
//		str= "검색된 곡이 없습니다";	
//		}
//	}	
//	return str;
//	}

//	public String musicRemove(String remove) { // 곡 삭제
//		String str = "";
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getSong().equals(remove)) {
//				str = list.get(i).getName() + " - " + list.get(i).getSong() + "을(를) 삭제했습니다.\n"; 
//				list.remove(i);
//			}else {
//				str = "검색된 곡이 업습니다.";
//					}	
//				}
//		return str;	
//			
//	}
//	public String musicSet(String set,String song, String name) { // 곡 수정
//		String str = "";
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getSong().equals(set)) {
//				str = list.get(i).getName() + " - " + list.get(i).getSong() + "의 값이 변경되었습니다. ";
//			  	list.set( i, new Music( song, name ));
//			}else {
//			  		str =  "수정할 곡이 없습니다";	
//			  	}		  	 	
//	}return str;
//	}
	
	


// 곡검색 기능으로 메서드 다중사용? // list <Music>으로 받아서 검색, 수정, 삭제 하는곳에 사용될 list를 특정해서 
// 메서드안에 사용!?? 아마가능?  트라이캐치로 그냥 빠져나갈수 있도록??
//public List<Music> musicSelect(String search) {
//    List<Music> selectedMusic = new ArrayList<>();
//    for (Music music : list) {
//        if (music.getSong().equals(search)) {
//            selectedMusic.add(music);
//        }
//    }
//    return selectedMusic;
//}
// 차라리 musicJList에 인덱스 값을 찾아오는 메서드를 만들어서?  list +  인덱스로 for문 추가없이?

//public String musicSearch(String search) {
//    List<Music> SearchMusic = musicSelect(search); // 검색은 효?율이 나쁘지 않아진거 같음
//    if (SearchMusic.isEmpty()) return "검색된 곡이 없습니다";
//     else return SearchMusic.get(0).getName() + " - " + SearchMusic.get(0).getSong() + "을(를) 검색했습니다.\n";
//}
//public String musicRemove(String remove) {
//List<Music> removeMusic = musicSelect(remove); // 리무브 뮤직에 곡 선택 메서드 값넣고
//if (removeMusic.isEmpty()) return "검색된 곡이 없습니다.";
// else {
//	for (int i = 0; i < list.size(); i++) {
//		if (list.get(i).getSong().equals(remove))  // 제거
//			list.remove(i);		
//	}
//}return removeMusic.get(0).getName() + " - " + removeMusic.get(0).getSong() + "을(를) 삭제했습니다.\n"; // 길이차이는 별로안나고 효율 X
//}
