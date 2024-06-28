package com.kh.variable;

public class C_Printf {

	public static void main(String[] args) {
		
	
//		System.out.print(출력할 값) -- 출력만 함 (줄바꿈 발생X)
		System.out.print("hello\n"); // \n 줄바꿈 
		
//		System.out.println(출력할 값); -- 출력후 줄바꿈 발생 O 
		System.out.println("hello");
		
		System.out.println("---------------------");
		
		int iNum1 = 10;
		int iNum2 = 20;
		System.out.println(iNum1 + "% " + iNum2 + "%");
		
//		System.out.printf("출력하고자하는형식(포멧)", 출력하고자하는값, 값,....);
		// 출력하고자 하는 값들이 제시한 형식에 맞춰서 출력만 진행
		
		/*
		 * 포맷에 쓰이는 키워드
		 * %d : 정수
		 * %f : 실수
		 * %c : 문자
		 * %s : 문자열(문자도 가능)
		 * %b : 참|거짓 
		 * %는 포맷에 사용하는 키워드기때문에 %%해야지 출력!
		 * 자주쓰는 키워드 \n 줄바꿈 키워드 \t 4칸 띄어쓰기 (탭키랑같음)
		 * */
		System.out.printf("%d%% %d%%\n", iNum1, iNum2);
		
		System.out.printf("------------------------\n");
		
		System.out.printf("%5d\n", iNum1); //  5칸 공간 확보 후 양수 우측 정렬
		System.out.printf("%-5d\n", iNum2); // 5칸 공간 확보 후 음수 좌측 정렬
		
		System.out.println("------------------------");
		
		double dNum1 = 1.23456789;
		double dNum2 = 4.53;
		
		System.out.printf("%f\t%f\n" , dNum1, dNum2); //  %f는 기본적으로 소수점 아래 6번째까지 출력 
		System.out.printf("%.3f\t%.2f\n" , dNum1, dNum2); // %f 사이에 %.(원하는 자릿수)f 입력하면 그 수만큼 출력
		
		System.out.println("-------------------------");
		
		char ch = 'a';
		String str = "Hello";
		
		// a      Hello a 출력하기!
		System.out.printf("%c\t%s %c\n",ch ,str ,ch);
		
		System.out.printf("%C %S",ch, str); // A HELLO --> %c나 %s를 대문자로 하면 대문자로 출력!
	}

}

















                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       