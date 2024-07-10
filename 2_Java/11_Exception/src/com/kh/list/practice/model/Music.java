package com.kh.list.practice.model;

public class Music implements Comparable<Music> {
	private String song;
	private String name;
	
	
	
	public Music(String song, String name) {
		this.song = song;
		this.name = name;
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public Music() {
	}
	@Override
	public String toString() {
		return "Music [song=" + song + ", name=" + name + "]";
	}
	@Override
	public int compareTo(Music o) {
		
		return this.song.compareTo(o.song);
	}
	
	

}

