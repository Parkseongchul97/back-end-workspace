package com.kh.soket2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 클라이언트가 보낸 메세지를 받아서
 * 다시 클라이언트에게 받은 메시지를 보내기 
 * 
 * 로직
 * 1. 서버소켓 포트 60000
 * 2. 클라이언트가 서버에 접속하면 accept로 받아서 Socket 하나 리턴
 * 3. 소켓으로부터 스트림 리턴
 * */
public class ChattServer {

	public static void main(String[] args) {
		
		
		try {
			ServerSocket server = new ServerSocket(60000); // 포트 6만 소켓 생성
			
			Socket socket = server.accept(); // 서버 접속시 accept로 받음
			System.out.println(socket.getInetAddress() + "님이 접속하셨습니다.");
			
			 // 클라이언트가 보낸 메시지를 받음
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));	
		
			// 다시 클라리언트에게 받은 메시지를 보낸다
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			

			String line = null;
		 
			while((line = br.readLine()) != null) {
				System.out.println("[" + socket.getInetAddress() + "] 님이 보낸 메시지 : " + line);
				pw.println(line);
			
				
			}
			
			
		 
		 // 받은걸 다시저장?
		 
		} catch (IOException e) {
			
			System.out.println("서버 에러!");
		} 

	}

}
