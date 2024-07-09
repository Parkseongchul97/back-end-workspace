package com.kh.set.model;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private String name;
	private int age;
	
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}



	@Override
	public int compareTo(Person o) {
//		return this.age - o.age; 나이 적은순서 정렬
		return o.age -  this.age ; // 나이 많은 순서로 정렬 (비교해서 -1 0 1 로 결과 반환)
	}

	
}