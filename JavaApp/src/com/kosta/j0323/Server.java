package com.kosta.j0323;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	
	//ServerŬ����: ������ ���� ���Ӽ���, ������ Ŭ���̾�Ʈ ����
	
	 Vector<Service> v; //����Ŭ���̾�Ʈ(=Service) ���� ���� ---> ����
	
	public Server(){
		
		//Thread t = new Thread(this);
		//t.start();
		v = new Vector<>();
		new Thread(this).start();
		
	}//������
	
	public void run() {
		
		try{
		
		ServerSocket ss = new ServerSocket(8282);
		//���� �������� ip + ��õ� port -----> ���� ����
		
		System.out.println("Starting Server...");
		while(true){
			Socket s = ss.accept();
			
			//s: ������ Ŭ���̾�Ʈ�� ���� ����
			
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
