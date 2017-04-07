package com.kosta.j0323;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	
	//Server클래스: 소켓을 통한 접속서비스, 접속한 클라이언트 관리
	
	 Vector<Service> v; //접속클라이언트(=Service) 정보 저장 ---> 관리
	
	public Server(){
		
		//Thread t = new Thread(this);
		//t.start();
		v = new Vector<>();
		new Thread(this).start();
		
	}//생성자
	
	public void run() {
		
		try{
		
		ServerSocket ss = new ServerSocket(8282);
		//현재 실행중인 ip + 명시된 port -----> 소켓 서비스
		
		System.out.println("Starting Server...");
		while(true){
			Socket s = ss.accept();
			
			//s: 접속한 클라이언트의 소켓 정보
			
			Service ser = new Service(s,v);
			v.add(ser);
		}
		
		
		} catch(IOException e){
			e.printStackTrace();
		}//try-catch
		
	}//run
	
	public static void main(String[] args) {
		new Server();
		
		
	}

}
