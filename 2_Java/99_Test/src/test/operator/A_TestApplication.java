package test.operator;

import test.operator.modle.B_TestModle;

public class A_TestApplication {

	public static void main(String[] args) {
		B_TestModle test = new B_TestModle();
		B_TestModle studunt1 = new B_TestModle("홍길동", "서울시" , 18, "010-1234-5678");
		B_TestModle studunt2 = new B_TestModle();
		studunt2.setStuduntAge(20);
		studunt2.setStuduntName("임꺽정");
		
		System.out.println(studunt1);
		System.out.println(studunt2.getStuduntName());
		studunt1.studuntInformation();
		studunt2.studuntInformation();
		
		
	}

	
}
