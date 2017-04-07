package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
	//소켓 관련 입출력 서비스
	
	BufferedReader in;
	OutputStream out;
	
	Vector<Service> v;
	Socket s;
	
	String nickName;
	
	public Service(Socket s, Vector<Service> v) {
	
		this.s = s;
		this.v = v;
		
		try {
			
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
			
			start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	

	} //생성자

		
	public void run(){
		
		try {
			nickName = in.readLine();
			
			while(true){
				
				String msg = in.readLine();
				
				if(msg == null) return; //비정상적인 종료
				
				if(!msg.trim().isEmpty()){
				
					System.out.println("From Client :" + msg + ":" + s.getInetAddress().getHostAddress());
					//out.write( ("From Server >> "+msg+"\n").getBytes() );//클라이언트에서 메시지 보내기
					
					System.out.println(v.size()+"");
					
					//msg <-- 클라이언트 tf에 입력 메시지("안녕하세요"), 변경 대화명("@홍길동")
					if(msg.startsWith("@")){
						nickName = msg.substring(1);
						
					} else {
					
						//접속된 전체클라이언트에게 메시지 보내기
						msgAll("[" + nickName + "]>> "+msg);
					}
					
				}
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch
		
	}//run
	
	public void msgAll(String msg){//벡터에 저장된 모든 클라이언트(Service)에게 메시지 전달
		for(int i = 0; i < v.size(); i++){ //벡터 인덱스
			Service service = v.get(i); //각각의 클라이언트 얻어오기
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//에러발생 ---> 클라이언트가 접속을 끊었기 때문에 발생
				//문제를 일으킨 클라이언트를 관리 벡터로부터 삭제함.
				v.remove(i--);
				System.out.println("클라이언트 접속 끊음!!");
				
			}
			
		}
		
	}
	
	public void msgTo(String msg) throws IOException{
		//특정 클라이언트에게 메시지 전달(실제 서버 ---> 클라이언트 메시지 전달)
		out.write((msg + "\n").getBytes());
		
	}

}
