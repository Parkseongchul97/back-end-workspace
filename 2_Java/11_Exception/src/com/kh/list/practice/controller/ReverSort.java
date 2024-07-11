package com.kh.list.practice.controller;
import java.util.Comparator;

import com.kh.list.practice.model.Music;

public class ReverSort implements Comparator<Music> {

    @Override
    public int compare(Music m1, Music m2) {
        return m2.getName().compareTo(m1.getName()); // 이게 왜가능..?
    }
}


