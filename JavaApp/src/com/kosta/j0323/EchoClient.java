package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws IOException{
		//서버접속
		while(true){
			
		//Socket s = new Socket(String host, int port);
		//host: 서버 ip, port: 서비스 구분 번호
		Socket s = new Socket("192.168.0.104", 8282); // **3. 서버접속 요청
		//System.out.println("서버접속 성공!!");
		
		//**4. 입출력 객체 생성
		OutputStream out = s.getOutputStream();//출력객체 (메시지를 보낼 때 사용)
		InputStream in = s.getInputStream();//입력객체 (메시지를 받을 때 사용)
		
		String msg = "";
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		//**5. 메시지 보내기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("메시지 입력: ");
		msg = " 이현재: "+br.readLine() + "\n";
		
		out.write(msg.getBytes());
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(in));
		System.out.println(" 이현재: "+br2.readLine()+"\n"); //**8. 메시지 읽기
				
		}
	}
}
