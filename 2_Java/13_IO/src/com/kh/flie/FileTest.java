package com.kh.flie;

import java.io.File;
import java.io.IOException;

/*
 * File 클래스
 * - 파일과 디렉터리를 다루는데 사용되는 클래스 
 * */
public class FileTest {

	public static void main(String[] args) {
		File file = new File("src/test.txt");
		
		System.out.println("파일명 : " + file.getName());
		System.out.println("절대 경로 : " + file.getAbsolutePath());
		System.out.println("상대 경로 : " + file.getPath());
		System.out.println("파일 용량 : " + file.length());
		System.out.println("파일 존재 여부 : " + file.exists());
		System.out.println("디렉터리 여부 : " + file.isDirectory());
		
		File newFile = new File("src/temp/test.txt");
		try {
			// 파일은 만들어 주는데 폴더는 X라 temp 폴더를 만들지 않으면 에러! 즉 경로는 안만들어줌
			// 존재하지 않는 폴더부터 만들기
			File tempDir = new File("src/temp");
			if(!tempDir.isDirectory()) { // 해당 경로가 존재하지 않을때
				tempDir.mkdir(); // 폴더 생성!
			}
			if(newFile.exists()) { //newfile이 존재하지 않을때 
			newFile.createNewFile(); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
