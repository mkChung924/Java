package com.kosta.j0323;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	
	public static void main(String[] args) {
		
		//InetAddress ia = InetAddress.getByName(String host);
		String host = "kosta.or.kr";
		//ȣ��Ʈ: ���񽺸� �����ϴ� �ܸ�(PC)
		//naver.com: ������(ip�ּҿ� �����ϴ� ����)
		try {
			
			InetAddress ia = InetAddress.getByName(host);
			//System.out.println(ia);
			String name = ia.getHostName();
			String address = ia.getHostAddress();
			
			System.out.println("ȣ��Ʈ�̸�: "+name); //������ �̸�
			System.out.println("ȣ��Ʈ�ּ�: "+address); // �����ο� ���ε� ���� ip�ּ�
			
			System.out.println("============================");
			//�����ο� ���ε� ��� ����ip ������
			String host2 = "facebook.com";
			System.out.println(host2);
			InetAddress ia1[] = InetAddress.getAllByName(host2);
			for(int i = 0; i < ia1.length; i++){
				//System.out.println("ȣ��Ʈ�̸�: " + ia1[i].getHostName());
				System.out.println("ȣ��Ʈ�ּ�: " + ia1[i].getHostAddress());
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
