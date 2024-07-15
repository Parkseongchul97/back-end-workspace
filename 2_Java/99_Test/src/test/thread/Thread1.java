package test.thread;

public class Thread1 extends Thread {
	Check ck = new Check();
	
	public void run() {
		for(int i = 30; i > 0; i--) {
			if(ck.isCheck())break;
			System.out.println("카운트 : " + i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}System.out.println("카운트 다운 끝 !");
	}

}
