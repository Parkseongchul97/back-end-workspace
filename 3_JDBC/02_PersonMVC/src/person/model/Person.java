package person.model;


import lombok.Data;
import lombok.NoArgsConstructor;


// @NoArgsConstructor - 기본 생성자
// @AllArgsConstructor - 모든 필드값 파라미터로 받는 생성자
// @Data : NoArgsConstructor와 AllArgsConstructor 를 제외한 나머지들 한꺼번에 만들어줌
// @RequiredArgsConstructor - 필드값에 final이 붙어이거나 
//							@NonNull이 붙어있는 필드들을 파라미터로 받는 생성자

// @Getter - Getter
// @Setter - Setter
// @ToString - toString

@NoArgsConstructor @Data 
public class Person {
	
	private int id;
	private String name;
	private int age;
	private String addr;
	public Person(int id, String name, int age, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	

}
