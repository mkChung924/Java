package com.kosta.j0324;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	
	//ServerŬ����: ������ ���� ���Ӽ���, ������ Ŭ���̾�Ʈ ����
	
	 Vector<Service> allV; //��� �����(���� ����� + ä�ù� �����)
	 
	 Vector<Service> waitV; //���� �����
	 Vector<Room> roomV; //������ ä�ù� Room - vs(Vector) : ä�ù� �����
	
	public Server(){
		
		//Thread t = new Thread(this);
		//t.start();
		allV = new Vector<>();
		waitV = new Vector<>();
		roomV = new Vector<>();
		
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
				
				Service ser = new Service(s, this);
				allV.add(ser);
				waitV.add(ser);
			}
		
		
		} catch(IOException e){
			e.printStackTrace();
		}//try-catch
		
	}//run
	
	public static void main(String[] args) {
		new Server();
		
		
	}

}
