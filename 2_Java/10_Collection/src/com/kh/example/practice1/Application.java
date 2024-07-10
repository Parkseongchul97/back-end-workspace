package com.kh.example.practice1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
					
	

	public static void main(String[] args) {
		
		
		
		
		int count = 0;
		int random ;
		// 중복 X 로또는 1회만 계산 나는 각 값이 모두 일치 전까지는 무한루프
		// 내 번호 1회 나올때마다 count +1
		int lotto[] = new int[7]; // 보너스 번호까지 뽑을 로또번호
		int lotto2[] = new int[6]; // 보너스 제거한 로또번호
		int me[] = new int[6]; // 내 번호 
		int two = 0; //2등
		int five = 0; //3등
		int four = 0; // 4등
		int three = 0; // 5등
		boolean ck = true;
		int bonus = 0; // 보너스 담을 값
		
		for (int i = 0; i < lotto.length; i++) {
			random = (int) (Math.random() * 45) + 1;// 1~45의 랜덤값
			lotto[i] = random;
			for (int j = 1; j < i; j++) {
				if (lotto[i] == lotto[j])i--;
					}
				}
		  bonus = lotto[lotto.length-1];
			
		
		  System.arraycopy(lotto, 0, lotto2, 0, lotto.length-1);	
		// 로또 번호 생성 보너스번호 추출, 로또2에 일반번호 6자리
		
		
		
		
		int[] lottoCopy = new int[lotto2.length];
		System.arraycopy(lotto, 0, lottoCopy, 0, lotto2.length);
		Arrays.sort(lottoCopy); // 비교용 로또 번호
		
		int[] meCopy = new int[me.length];
		while(ck) {
			
			for (int i = 0; i < me.length; i++) {
				random = (int) (Math.random() * 45) + 1;
				me[i] = random;
				for (int j = 1; j < i; j++) {
					if (me[i] == me[j])i--;
					System.arraycopy(me, 0, meCopy, 0, me.length);
					Arrays.sort(meCopy);
				}
			}// 내번호 랜덤 생성
				
				count++;
				System.out.println("로또 번호 : " + Arrays.toString(lotto2) + "보너스번호 : " + bonus);
				System.out.println("내 번호 : " + Arrays.toString(me));
				
				int num = 0;
				for (int i = 0; i < lottoCopy.length; i++) { // 당첨 번호랑 일치하는지 확인
					if (lottoCopy[i] == meCopy[i]) ++num;
						}
				if(num == 3)five++;// 3개 일치시 5등 카운트
				
				if(num == 4)four++; // 4개 일치시 4등 카운트 
				if(num == 5) {
					for (int i = 0; i < me.length; i++) { // 3등인 경우에 bonus 랑 같은 숫자 있나 비교 
						if(me[i] == bonus) {
						two++; // 보너스번호 보유중이면 2등 카운트
						}else three++; //없으면 3등 카운트
					} 
		
				}
				
				if (num == 6) { // 모두 일치시 종료 + 당첨내역 출력
					System.out.println("로또 1등까지 내가 구매한 로또 숫자 : " + count);
					System.out.println("그동안 당첨된 2등 숫자 : " + two);
					System.out.println("그동안 당첨된 3등 숫자 : " + three);
					System.out.println("그동안 당첨된 4등 숫자 : " + four);
					System.out.println("그동안 당첨된 5등 숫자 : " + five);
					
					ck = false;
					}			
				}
		
		
		
		// 풀이
		ArrayList<Integer> lotto3 = new ArrayList<Integer>();
		List<Integer> lottoList = new ArrayList<Integer>();
		
		// for문으로 기존은 6 보너스 번호를 위해 1개 더 추가 
		for(int i = 0; i < 7; i++) {
			int num = (int) (Math.random() * 45 +1);
			if(!lotto3.contains(num)) {
			lotto3.add(num);
			}else i--;
		}
		lottoList =  lotto3.subList(0,6);
		int lottoBonus = lotto3.get(6);
		int stopCount = 0;
		while(true) {
			ArrayList<Integer> my = new ArrayList<Integer>();
			// while 문으로	
			while(my.size() < 6) {
				int num = (int) (Math.random() * 45 +1);
				if(!my.contains(num)) {
				my.add(num);
				}
		}
			System.out.println("로또 번호 : " + lottoList + " 보너스 번호 : " + lottoBonus);
			System.out.println("내 번호 : " + my);
			stopCount++;
			Collections.sort(lottoList);// 출력후 정렬
			Collections.sort(my);
		
		
		int match = 0;
		for(Integer num : lottoList) {
			if(my.contains(num)) {
				match++;
			}
		}
		if(match == 6) {
			System.out.println("1등 당첨 !내 횟수 :" + stopCount);
			break;
		}else if(match == 5) {
			if (my.contains(lottoBonus)) {
				System.out.println("2등 당첨! 횟수 : " + stopCount);
				break;
			} else
				System.out.println("3등 당첨! 횟수 : " + stopCount);
				break;
		}else if(match == 4) {
			System.out.println("4등 당첨! 횟수 : " + stopCount);
			break;
		}else if(match == 3) {
			System.out.println("5등 당첨! 횟수 : " + stopCount);
			break;
		}
		
		
		
		
		
			}
			
	
	
	
	}				
					
}			


