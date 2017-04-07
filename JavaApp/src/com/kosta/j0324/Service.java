package com.kosta.j0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
	//Service == 접속 클라이언트 한명!!
	
	Room myRoom; //클라이언트가 입장한 방
	
	//소켓 관련 입출력 서비스
	
	BufferedReader in;
	OutputStream out;
	
	Vector<Service> allV; //전체 사용자(대기실 + 대화방)
	Vector<Service> waitV;
	Vector<Room> roomV;
	
	Socket s;
	
	String nickName;

	
	public Service(Socket s, Server server) {
	
		this.s = s;
		allV = server.allV;
		waitV = server.waitV;
		roomV = server.roomV;
		
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
			
			while(true){
				
				String msg = in.readLine();
				
				if(msg == null) return; //비정상적인 종료
				
				if(!msg.trim().isEmpty()){
				
					System.out.println("From Client :" + msg + ":" + s.getInetAddress().getHostAddress());
					//out.write( ("From Server >> "+msg+"\n").getBytes() );//클라이언트에서 메시지 보내기
					
					
					String msgs[] = msg.split("\\|");
					String protocol = msgs[0];
					switch(protocol){
					
						case "150"://최초 닉네임 설정시
							nickName = msgs[1];
							
							msgWait("150|"+getWaitingList());
							
							break;
							
						case "155":
							nickName = msgs[1];
							break;
							
						case "160": //방만들기
							myRoom = new Room();

							myRoom.title = msgs[1];
							myRoom.count = 1;
							myRoom.boss = nickName;
							
							roomV.add(myRoom);
							
							//대기실 ====> 대화방 이동
							waitV.remove(this);
							myRoom.userV.add(this);
							
							msgWait("150|"+getWaitingList());
							msgWait("160|"+getRoomInfo());
							msgRoom("200|"+nickName+"|"+msgs[1]+"|"+getNameInRoom(msgs[1]));
							
							break;
							
						case "161"://최초 접속시
							
							msgWait("150|"+getWaitingList());
							msgWait("160|"+getRoomInfo());
							
							break;
							
						case "200": //방들어가기 ====> msgs = "200|자바방"
							for(int i = 0; i < roomV.size(); i++){
								Room r = roomV.get(i);
								if(r.title.equals(msgs[1])){//일치하는 방 찾음!!
									myRoom = r;
									myRoom.count++;//인원수 증가
									break;
								}
							}
							//대기실 ----> 대화방 이동
							waitV.remove(this);
							myRoom.userV.add(this);
							
							msgRoom("200|"+nickName+"|"+msgs[1]+"|"+getNameInRoom(msgs[1]));
							System.out.println("200|"+nickName+"|"+msgs[1]+"|"+getNameInRoom(msgs[1]));
							msgWait("160|"+getRoomInfo());
							msgWait("150|"+getWaitingList());
							
							break;
							
						case "250":

							System.out.println(getNameInRoom(msgs[1]+"\n"));
							out.write(("250|"+getNameInRoom(msgs[1])+"\n").getBytes());
							break;
							
						case "300": //메시지
							msgRoom("300|[" + nickName + "]>> "+ msgs[1]);
							
							//클라이언트에게 메시지 보내기
							break;
							
							
						case "900": //방에서 나갔을 때
							for(int i = 0; i < roomV.size(); i++){
								Room r = roomV.get(i);
								if(r.title.equals(msgs[1])){
									myRoom.count--;
								
									break;
								}
							}
							
							myRoom.userV.remove(this);
							waitV.add(this);
							
							msgRoom("900|"+nickName+"|"+getNameInRoom(msgs[1]));
							msgWait("160|"+getRoomInfo());
							msgWait("150|"+getWaitingList());
							
							break;

							
					}
					
					
					
				}
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch
		
	}//run
	
	public String getNameInRoom(String roomName){
		
		String str = "";
		for(int i = 0; i < roomV.size(); i++){
			Room r = roomV.get(i);
			if(r.title.equals(roomName)){
				for(int j = 0 ;j < r.userV.size(); j++){
					Service service = r.userV.get(j);
					str += service.nickName;
					if((j < r.userV.size()-1)){
						str+=",";
					}
				}
				break;
			}
		}
		
		return str;
	}
	
	public String getWaitingList(){
		
		String str ="";
		for(int i = 0; i < waitV.size(); i++){
			Service service = waitV.get(i);
			str += service.nickName;
			if(i < (waitV.size()-1)){
				str += ",";
			}
		}
		return str;
	}
	
	public String getRoomInfo(){
		
		String str = "";
		for(int i = 0 ; i < roomV.size(); i++){
			
			Room r = roomV.get(i);
			str += r.title +"--"+r.count;
			if(i < roomV.size()-1){
				str += ",";
			}
			
		}
		return str;
	}
	public void msgAll(String msg){//벡터에 저장된 모든 클라이언트(Service)에게 메시지 전달
		//접속돈 모든 클라이언트(대기실+채팅방)에게 메시지 전달
		
		for(int i = 0; i < allV.size(); i++){ //벡터 인덱스
			Service service = allV.get(i); //각각의 클라이언트 얻어오기
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//에러발생 ---> 클라이언트가 접속을 끊었기 때문에 발생
				//문제를 일으킨 클라이언트를 관리 벡터로부터 삭제함.
				allV.remove(i--);
				System.out.println("클라이언트 접속 끊음!!");
				
			}
			
		}
		
	}//msgAll
	
	public void msgWait(String msg){//대기실 사용자
		
		for(int i = 0; i < waitV.size(); i++){ //벡터 인덱스
			Service service = waitV.get(i); //각각의 클라이언트 얻어오기
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//에러발생 ---> 클라이언트가 접속을 끊었기 때문에 발생
				//문제를 일으킨 클라이언트를 관리 벡터로부터 삭제함.
				waitV.remove(i--);
				System.out.println("클라이언트 접속 끊음!!");
				
			}
			
		}
		
	}//msgWait
	
	public void msgRoom(String msg){//채팅방 사용자
		
		for(int i = 0; i < myRoom.userV.size(); i++){ //벡터 인덱스
			Service service = myRoom.userV.get(i); //각각의 클라이언트 얻어오기
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//에러발생 ---> 클라이언트가 접속을 끊었기 때문에 발생
				//문제를 일으킨 클라이언트를 관리 벡터로부터 삭제함.
				myRoom.userV.remove(i--);
				System.out.println("클라이언트 접속 끊음!!");
				
			}
			
		}
		
	}//msgRoom
	
	
	
	public void msgTo(String msg) throws IOException{
		//특정 클라이언트에게 메시지 전달(실제 서버 ---> 클라이언트 메시지 전달)
		out.write((msg + "\n").getBytes());
		
	}

}
