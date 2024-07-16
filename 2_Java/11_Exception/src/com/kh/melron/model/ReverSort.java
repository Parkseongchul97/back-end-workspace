package com.kh.melron.model;
import java.util.Comparator;

public class ReverSort implements Comparator<Music> {

    @Override
    public int compare(Music m1, Music m2) {
        return m2.getName().compareTo(m1.getName()); // name을 기준으로 내림차순 정렬
    }
}


