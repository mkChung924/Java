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
		//��������
		while(true){
			
		//Socket s = new Socket(String host, int port);
		//host: ���� ip, port: ���� ���� ��ȣ
		Socket s = new Socket("192.168.0.104", 8282); // **3. �������� ��û
		//System.out.println("�������� ����!!");
		
		//**4. ����� ��ü ����
		OutputStream out = s.getOutputStream();//��°�ü (�޽����� ���� �� ���)
		InputStream in = s.getInputStream();//�Է°�ü (�޽����� ���� �� ���)
		
		String msg = "";
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		//**5. �޽��� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�޽��� �Է�: ");
		msg = " ������: "+br.readLine() + "\n";
		
		out.write(msg.getBytes());
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(in));
		System.out.println(" ������: "+br2.readLine()+"\n"); //**8. �޽��� �б�
				
		}
	}
}
