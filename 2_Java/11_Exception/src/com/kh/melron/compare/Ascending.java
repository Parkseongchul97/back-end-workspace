package com.kh.melron.compare;

import java.util.Comparator;

import com.kh.melron.model.Music;

public class Ascending implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		
		return o1.getSong().compareTo(o2.getSong()); // 노래제목 기준 오름차순을 따로 
	}

}
