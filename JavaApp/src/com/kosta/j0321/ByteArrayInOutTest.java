package com.kosta.j0321;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInOutTest {
	
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("c.txt");
		FileOutputStream fos = new FileOutputStream("d.txt");
		byte []b = new byte[5];
		
		int i;
		
		long start = System.currentTimeMillis();
		while((i=fis.read(b)) != -1){ //���� �� �ִ� byte �����Ͱ� �����Ѵٸ�
			fos.write(b,0,i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("���� ���� ����(����Ʈ ����)~~!!");
		System.out.println("�ɸ��ð�: " + (end-start)/1000.0+"��");
		
		fos.close();
		fis.close();
	}

}
