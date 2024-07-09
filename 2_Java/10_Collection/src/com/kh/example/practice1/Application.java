package com.kh.example.practice1;

import java.util.Arrays;

public class Application {
					
	

	public static void main(String[] args) {
		int count = 0;
		int random ;
		// 중복 X 로또는 1회만 계산 나는 각 값이 모두 일치 전까지는 무한루프
		// 내 번호 1회 나올때마다 count +1
		int lotto[] = new int[6];
		int me[] = new int[6];
		int two = 0;
		int five = 0;
		int four = 0;
		int three = 0;
		boolean ck = true;
		boolean bonusCheck = true;
		int bonusCount = 0;
		int bonus = 0;
		int random2;
		
		for (int i = 0; i < lotto.length; i++) {
			random = (int) (Math.random() * 45) + 1;// 1~45의 랜덤값
			lotto[i] = random;
			for (int j = 1; j < i; j++) {
				if (lotto[i] == lotto[j])i--;
					}
				}
		random2 = (int) (Math.random() * 45) + 1;
		
		
		for (int i = 0; i < lotto.length; i++) {
			if(lotto[i] == random2) {
				random2 = (int) (Math.random() * 45) + 1;
			}else 
				random2 = bonus;
		} 
			
		
			
		// 로또 번호 생성
		random2 = (int) (Math.random() * 45) + 1;
		System.out.println("로또 번호 : " + Arrays.toString(lotto) + " 보너스번호 : " + bonus);
		
		int[] lottoCopy = new int[lotto.length];
		System.arraycopy(lotto, 0, lottoCopy, 0, lotto.length);
		Arrays.sort(lottoCopy); // 비교용 로또 번호
		
		int[] meCopy = new int[me.length];
		while(ck) {
			
			for (int i = 0; i < lotto.length; i++) {
				random = (int) (Math.random() * 45) + 1;
				me[i] = random;
				for (int j = 1; j < i; j++) {
					if (me[i] == me[j])i--;
					System.arraycopy(me, 0, meCopy, 0, me.length);
					Arrays.sort(meCopy);
					// random이랑 me[i]랑 비교해서 숫자가 다른 경우에만 따른변수로 추가?
					

				}
			}
				
				count++;
				System.out.println("로또 번호 : " + Arrays.toString(lotto) + "보너스번호 : " + random2);
				System.out.println("내 번호 : " + Arrays.toString(me));
				
				int num = 0;
				for (int i = 0; i < lottoCopy.length; i++) {
					if (lottoCopy[i] == meCopy[i]) ++num;
						}
				if(num == 3)five++;
				
				if(num == 4)four++;
				if(num == 5) {
					for (int i = 0; i < me.length; i++) {
						if(me[i] == random2) {
						two++;
						}else three++;
					} 
		
				}
				
				if (num == 6) {
					System.out.println("로또 1등까지 내가 구매한 로또 숫자 : " + count);
					System.out.println("그동안 당첨된 2등 숫자 : " + two);
					System.out.println("그동안 당첨된 3등 숫자 : " + three);
					// 3등인 경우에만 변수랑 me i랑 비교해서 같을시 2등?
					System.out.println("그동안 당첨된 4등 숫자 : " + four);
					System.out.println("그동안 당첨된 5등 숫자 : " + five);
					
					ck = false;
					}			
				}
			}
			// 2등도 추가? 보너스 숫자까지 로또번호 1개 더받고,  
	
	
	
	}				
					
			/*
			 * public static void main(String[] args) {
		int count = 0;
		int random ;
		// 중복 X 로또는 1회만 계산 나는 각 값이 모두 일치 전까지는 무한루프
		// 내 번호 1회 나올때마다 count +1
		int lotto[] = new int[6];
		int me[] = new int[6];
		int five = 0;
		int four = 0;
		int three = 0;
		boolean ck = true;
		boolean bonusCheck = true;
		
		for (int i = 0; i < lotto.length; i++) {
			random = (int) (Math.random() * 45) + 1;// 1~45의 랜덤값
			lotto[i] = random;
			for (int j = 1; j < i; j++) {
				if (lotto[i] == lotto[j])i--;
			}
		}// 로또 번호 생성
		
		int[] lottoCopy = new int[lotto.length];
		System.arraycopy(lotto, 0, lottoCopy, 0, lotto.length);
		Arrays.sort(lottoCopy); // 비교용 로또 번호
		
		int[] meCopy = new int[me.length];
		while(ck) {
			int bonus = 0;
			for (int i = 0; i < lotto.length; i++) {
				random = (int) (Math.random() * 45) + 1;
				me[i] = random;
				for (int j = 1; j < i; j++) {
					if (me[i] == me[j])i--;
					System.arraycopy(me, 0, meCopy, 0, me.length);
					Arrays.sort(meCopy);
					// random이랑 me[i]랑 비교해서 숫자가 다른 경우에만 따른변수로 추가?
					

				}
			}
				
				count++;
				System.out.println("로또 번호 : " + Arrays.toString(lotto) + "보너스번호 : " + bonus);
				System.out.println("내 번호 : " + Arrays.toString(me));
				
				int num = 0;
				for (int i = 0; i < lottoCopy.length; i++) {
					if (lottoCopy[i] == meCopy[i]) ++num;
						}
				if(num == 3)five++;
				if(num == 4)four++;
				if(num == 5)three++;
				
				if (num == 6) {
					System.out.println("로또 1등까지 내가 구매한 로또 숫자 : " + count);
					System.out.println("그동안 당첨된 3등 숫자 : " + three);
					// 3등인 경우에만 변수랑 me i랑 비교해서 같을시 2등?
					System.out.println("그동안 당첨된 4등 숫자 : " + four);
					System.out.println("그동안 당첨된 5등 숫자 : " + five);
					
					ck = false;
					}			
				}
			}
			// 2등도 추가? 보너스 숫자까지 로또번호 1개 더받고, 
			 * */
		


