package com.kh.practice;

import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		LoopPractice l = new LoopPractice();
		System.out.println("\n-------------Q1-----------\n");
		l.method1();
		System.out.println("\n-------------Q2-----------\n");
		l.method2();
		System.out.println("\n-------------Q3-----------\n");
		l.method3();
		System.out.println("\n-------------Q4-----------\n");
		l.method4();
		System.out.println("\n-------------Q5-----------\n");
		l.method5();
		System.out.println("\n-------------Q6-----------\n");
		l.method6();
		

	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("사용자 입력 : ");
    	int num = Integer.parseInt(sc.nextLine());
    	
		if (1 <= num && num <= 100) {
			for (int i = num; i > 0; i--) {
				System.out.println(i);
			}
		} else
			System.out.println("1 ~ 100 사이의 수가 아닙니다.");

    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	int sum = 0;
    	
    	for(int i = 1; i != 0; i++) {
    		if(i % 2 == 0) {
    			sum += (-i);
    		}else {
    			sum += i;
    		}
    		if(sum >= 100) {
    			System.out.printf("1+(-2)+3+(-4)+.. 식으로 %d까지 더하면 총합이 100 이상이다\n",i);
    			break;
    			}
    	}

    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String str = sc.nextLine();
    	
    	System.out.print("문자 : ");
    	char ch = sc.nextLine().charAt(0);
    	
    	int count = 0;
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == ch) {
    			count++;
    		}
    	}
		System.out.printf("%s 안에 포함된 %c 개수 : %d\n", str, ch, count);

    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	
    	
    	for(int i = 1; i != 0; i++) {
    		int random = (int)(Math.random()* 11); // 0 ~ 10 11개의 숫자  
    		System.out.println(random);
    		if(random == 0) {
    			break;
    		}
    	}
  
    	
    }

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {

    	int[] num = new int[6];
    	int dice = 0;
		for (int i = 1; i <= 10; i++) {
			dice = (int) (Math.random() * 6 + 1); // 1 ~ 6 6개의 숫자
			switch (dice) {
					case 1:
						num[0]++;
						break;
					case 2:
						num[1]++;
						break;
					case 3:
						num[2]++;
						break;
					case 4:
						num[3]++;
						break;
					case 5:
						num[4]++;
						break;
					case 6:
						num[5]++;
						break;
			}

		}
		for (int i = 1; i <= 6; i++) {
			System.out.printf("%d : %d\n", i,num[i-1]);
		}
	}

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터 : 바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	System.out.print("당신의 이름을 입력해 주세요 : ");
    	String name = sc.nextLine();
    	String str = "";
    	
    	
    	String[] com = {"가위", "바위","보"};
    	int random = 0;
    	int win = 0;
    	int lose = 0;
    	int drow = 0;
    	
		for (int i = 1; i != 0; i++) {
			System.out.print("가위바위보 : ");
			str = sc.nextLine();
			if ((str.equals("가위")) || (str.equals("바위")) || (str.equals("보"))) {
				random = (int) (Math.random() * 3);
				System.out.println("컴퓨터 : " + com[random]);
				System.out.println(name + " : " + str);
				if (	(str.equals("가위") && com[random].equals("가위")) || 
						(str.equals("바위") && com[random].equals("바위"))|| 
						(str.equals("보") && com[random].equals("보"))) {
					drow++;
					System.out.println("비겼습니다.\n\n");
				} else if ((str.equals("가위") && com[random].equals("바위"))
						|| (str.equals("바위") && com[random].equals("보"))
						|| (str.equals("보") && com[random].equals("가위"))) {
					lose++;
					System.out.println("졌습니다. ㅠㅠ\n\n");
				} else {
					win++;
					System.out.println("이겼습니다 !");
					System.out.printf("비긴 횟수 : %d, 진 횟수 : %d, 이긴 횟수 : %d", drow, lose, win);

				}
				if (win >= 1)
					break;
			} else {
				System.out.println("가위, 바위, 보 를 정확히 입력하십시오.\n\n");

			}

		}

	}
    }