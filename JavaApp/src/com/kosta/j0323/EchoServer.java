package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public static void main(String[] args) throws IOException{
		//ServerSocket ss = new ServerSocket(int port);
		//ServerSocket: 소켓서비스를 하는 서버객체
		ServerSocket ss = new ServerSocket(5000); // **1. 서버소켓객체 생성
		//현재 JVM이 갖는 ip주소와 명시된 port번호로 소켓서비스를 시작할 준비
		
		System.out.println("서버 시작(접속대기중)....");
		
		while(true){
		
		Socket s = ss.accept();// **2. 클라이언트 접속 대기 메도스
		InetAddress ia = s.getInetAddress();
		//System.out.println("클라이언트 접속 ["+ia.getHostAddress()+"]");
		
		//**4. 입출력 객체 생성
		OutputStream out = s.getOutputStream();//출력객체 (메시지를 보낼 때 사용)
		InputStream in = s.getInputStream();//입력객체 (메시지를 받을 때 사용)
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		//**6. 메시지 읽기
		System.out.println(br.readLine());
		
		//**7. 메시지 보내기
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String msg = "모두를 사랑합니다.^^\n";
//		msg = "이현재: "+ br2.readLine() + "\n";
//		out.write(msg.getBytes());
		out.write(("["+ia.getHostAddress()+"]"+msg).getBytes());
		
		}
		
		
	} //main

} //class
