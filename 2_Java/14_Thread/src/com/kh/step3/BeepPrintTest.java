package com.kh.step3;

import java.awt.Toolkit;

public class BeepPrintTest {

	public static void main(String[] args) {
		// 어짜피 메인메서드로도 돌릴수 있으니 굳이 스레드를 2개 사용할 필요는 X
		TextThread text = new TextThread();
		SoundThread sound = new SoundThread();
		text.start();
//		sound.start();
		
		// 경고음 5번 울리는 작업 
		Toolkit tool = Toolkit.getDefaultToolkit();
		for(int i = 0; i< 5; i++) {
			tool.beep();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
//		// 띵띵띵띵띵을 5번 출력하는 작업 
//		for(int i = 0; i< 5; i++) {
//			System.out.println("띵~");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
//		}

	}

}
