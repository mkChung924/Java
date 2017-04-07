package com.kosta.j0324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
	//Service == ���� Ŭ���̾�Ʈ �Ѹ�!!
	
	Room myRoom; //Ŭ���̾�Ʈ�� ������ ��
	
	//���� ���� ����� ����
	
	BufferedReader in;
	OutputStream out;
	
	Vector<Service> allV; //��ü �����(���� + ��ȭ��)
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
	

	} //������

		
	public void run(){
		
		try {
			
			while(true){
				
				String msg = in.readLine();
				
				if(msg == null) return; //���������� ����
				
				if(!msg.trim().isEmpty()){
				
					System.out.println("From Client :" + msg + ":" + s.getInetAddress().getHostAddress());
					//out.write( ("From Server >> "+msg+"\n").getBytes() );//Ŭ���̾�Ʈ���� �޽��� ������
					
					
					String msgs[] = msg.split("\\|");
					String protocol = msgs[0];
					switch(protocol){
					
						case "150"://���� �г��� ������
							nickName = msgs[1];
							
							msgWait("150|"+getWaitingList());
							
							break;
							
						case "155":
							nickName = msgs[1];
							break;
							
						case "160": //�游���
							myRoom = new Room();

							myRoom.title = msgs[1];
							myRoom.count = 1;
							myRoom.boss = nickName;
							
							roomV.add(myRoom);
							
							//���� ====> ��ȭ�� �̵�
							waitV.remove(this);
							myRoom.userV.add(this);
							
							msgWait("150|"+getWaitingList());
							msgWait("160|"+getRoomInfo());
							msgRoom("200|"+nickName+"|"+msgs[1]+"|"+getNameInRoom(msgs[1]));
							
							break;
							
						case "161"://���� ���ӽ�
							
							msgWait("150|"+getWaitingList());
							msgWait("160|"+getRoomInfo());
							
							break;
							
						case "200": //����� ====> msgs = "200|�ڹٹ�"
							for(int i = 0; i < roomV.size(); i++){
								Room r = roomV.get(i);
								if(r.title.equals(msgs[1])){//��ġ�ϴ� �� ã��!!
									myRoom = r;
									myRoom.count++;//�ο��� ����
									break;
								}
							}
							//���� ----> ��ȭ�� �̵�
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
							
						case "300": //�޽���
							msgRoom("300|[" + nickName + "]>> "+ msgs[1]);
							
							//Ŭ���̾�Ʈ���� �޽��� ������
							break;
							
							
						case "900": //�濡�� ������ ��
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
	public void msgAll(String msg){//���Ϳ� ����� ��� Ŭ���̾�Ʈ(Service)���� �޽��� ����
		//���ӵ� ��� Ŭ���̾�Ʈ(����+ä�ù�)���� �޽��� ����
		
		for(int i = 0; i < allV.size(); i++){ //���� �ε���
			Service service = allV.get(i); //������ Ŭ���̾�Ʈ ������
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//�����߻� ---> Ŭ���̾�Ʈ�� ������ ������ ������ �߻�
				//������ ����Ų Ŭ���̾�Ʈ�� ���� ���ͷκ��� ������.
				allV.remove(i--);
				System.out.println("Ŭ���̾�Ʈ ���� ����!!");
				
			}
			
		}
		
	}//msgAll
	
	public void msgWait(String msg){//���� �����
		
		for(int i = 0; i < waitV.size(); i++){ //���� �ε���
			Service service = waitV.get(i); //������ Ŭ���̾�Ʈ ������
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//�����߻� ---> Ŭ���̾�Ʈ�� ������ ������ ������ �߻�
				//������ ����Ų Ŭ���̾�Ʈ�� ���� ���ͷκ��� ������.
				waitV.remove(i--);
				System.out.println("Ŭ���̾�Ʈ ���� ����!!");
				
			}
			
		}
		
	}//msgWait
	
	public void msgRoom(String msg){//ä�ù� �����
		
		for(int i = 0; i < myRoom.userV.size(); i++){ //���� �ε���
			Service service = myRoom.userV.get(i); //������ Ŭ���̾�Ʈ ������
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//�����߻� ---> Ŭ���̾�Ʈ�� ������ ������ ������ �߻�
				//������ ����Ų Ŭ���̾�Ʈ�� ���� ���ͷκ��� ������.
				myRoom.userV.remove(i--);
				System.out.println("Ŭ���̾�Ʈ ���� ����!!");
				
			}
			
		}
		
	}//msgRoom
	
	
	
	public void msgTo(String msg) throws IOException{
		//Ư�� Ŭ���̾�Ʈ���� �޽��� ����(���� ���� ---> Ŭ���̾�Ʈ �޽��� ����)
		out.write((msg + "\n").getBytes());
		
	}

}
