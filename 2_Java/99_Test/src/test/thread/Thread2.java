package test.thread;

import java.util.Scanner;

public class Thread2 extends Thread {
	Check ck = new Check();
	
	Scanner sc = new Scanner(System.in);
	
	public void run() {
		System.out.print("아무거나 입력");
		String str = sc.nextLine();
		if(str.charAt(0)< -1)
			ck.setCheck(true);
		return;
		
		
	}
}
