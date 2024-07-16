package com.kh.soket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 키보드로 입력받은 데이터를 읽어서 서버로 보낸다 
 * 서버가 받은 메시지를 받아서 클라이언트 자신의 콘솔창에 출력한다
 * 
 * 로직!
 * 1. 소켓생성
 * 2. 스트림
 * */

public class ChattClient {
	

	public static void main(String[] args) {
		try {
			// 서버에 연결 
			Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 60000);
			
			// 키보드로 입력받은 데이터를 읽어서 서버에 보냄
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			
			
			// 다시가 서버가 보낸 메시지를 받아서 클라이언트 자신의 콘솔창에 출력 
			BufferedReader br2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String line = br.readLine();
				pw.println(line);
				
				String serverMsg = br2.readLine();
				System.out.println("나 : " + serverMsg);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} // 서로 서버 열어서 접속?

	}

}
