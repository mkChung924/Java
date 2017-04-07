package com.kosta.j0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class Service extends Thread{
	//���� ���� ����� ����
	
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
	

	} //������

		
	public void run(){
		
		try {
			nickName = in.readLine();
			
			while(true){
				
				String msg = in.readLine();
				
				if(msg == null) return; //���������� ����
				
				if(!msg.trim().isEmpty()){
				
					System.out.println("From Client :" + msg + ":" + s.getInetAddress().getHostAddress());
					//out.write( ("From Server >> "+msg+"\n").getBytes() );//Ŭ���̾�Ʈ���� �޽��� ������
					
					System.out.println(v.size()+"");
					
					//msg <-- Ŭ���̾�Ʈ tf�� �Է� �޽���("�ȳ��ϼ���"), ���� ��ȭ��("@ȫ�浿")
					if(msg.startsWith("@")){
						nickName = msg.substring(1);
						
					} else {
					
						//���ӵ� ��üŬ���̾�Ʈ���� �޽��� ������
						msgAll("[" + nickName + "]>> "+msg);
					}
					
				}
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}//try-catch
		
	}//run
	
	public void msgAll(String msg){//���Ϳ� ����� ��� Ŭ���̾�Ʈ(Service)���� �޽��� ����
		for(int i = 0; i < v.size(); i++){ //���� �ε���
			Service service = v.get(i); //������ Ŭ���̾�Ʈ ������
			try {
				service.msgTo(msg);
			} catch (IOException e) {
				//�����߻� ---> Ŭ���̾�Ʈ�� ������ ������ ������ �߻�
				//������ ����Ų Ŭ���̾�Ʈ�� ���� ���ͷκ��� ������.
				v.remove(i--);
				System.out.println("Ŭ���̾�Ʈ ���� ����!!");
				
			}
			
		}
		
	}
	
	public void msgTo(String msg) throws IOException{
		//Ư�� Ŭ���̾�Ʈ���� �޽��� ����(���� ���� ---> Ŭ���̾�Ʈ �޽��� ����)
		out.write((msg + "\n").getBytes());
		
	}

}
