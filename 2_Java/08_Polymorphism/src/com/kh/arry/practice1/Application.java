package com.kh.arry.practice1;

import java.util.Arrays;

import com.kh.arry.practice1.modle.Student;

public class Application {

	public static void main(String[] args) {
		
		
		Student [] arr = new Student[5];
		
		arr[0] = new Student("박성철", "자바", 100);
		arr[1] = new Student("이진우", "디비", 95);
		arr[2] = new Student("이준용", "자바", 97);
		arr[3] = new Student("김경주", "화면", 98);
		arr[4] = new Student("김현호", "자바", 95);
		System.out.println(Arrays.toString(arr));
		System.out.println("-----------------------");
		for(int i = 0; i < arr.length; i++) {
		System.out.println(arr[i]);
		}
		System.out.println("-----------------------");
		for(Student student : arr) { // 향상된 for문 타입은 Student
			System.out.println(student);
		}
	}

}
