package com.kosta.j0321;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class SpeedTest { // ���� ����� Ŭ������ ���� ���� ���� ----> �ɸ��� �ð� ����!!
	
	//case1) byte���� �����
	FileInputStream fis;
	FileOutputStream fos;
	
	//case2) ���ڴ��� �����
	FileReader fr;
	FileWriter fw;
	
	//case3) Buffer ��� �����
	BufferedReader br;
	BufferedWriter bw;
	
	//case4) 
	FileInputStream fis2;
	FileOutputStream fos2;
	byte b[];
	
	public SpeedTest() throws IOException{
		//case1)
		fis = new FileInputStream("a.txt");
		fos = new FileOutputStream("b.txt");
		
		int i;
		
		long start = System.currentTimeMillis();
		while((i=fis.read()) != -1){ //���� �� �ִ� byte �����Ͱ� �����Ѵٸ�
			fos.write(i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("���� ���� ����(����Ʈ ����)~~!!");
		System.out.println("�ɸ��ð�: " + (end-start)/1000.0+"��");
		
		fos.close();
		fis.close();
		
		//case 2)
		fr = new FileReader("a.txt");
		fw = new FileWriter("b.txt");
		
		start = System.currentTimeMillis();
		while((i = fr.read()) != -1){
			fw.write(i);
		}
		end = System.currentTimeMillis();
		
		fw.close();
		fr.close();
		
		System.out.println("���� ���� ����(���� ����)~~!!");
		System.out.println("�ɸ��ð�: " + (end-start)/1000.0+"��");
		
		//case 3)
		
		br = new BufferedReader(new FileReader("a.txt"));
		bw = new BufferedWriter(new FileWriter("b.txt"));
		
		String str;
		start = System.currentTimeMillis();
		while((str = br.readLine()) != null){
			bw.write(str);
		}
		end = System.currentTimeMillis();
		
		bw.close();
		br.close();
		
		System.out.println("���� ���� ����(���� ���)~~!!");
		System.out.println("�ɸ��ð�: " + (end-start)/1000.0+"��");
		
		//case4)
		
		fis2 = new FileInputStream("a.txt");
		fos2 = new FileOutputStream("b.txt");
		b = new byte[1024];
		
		int i2;
		
		start = System.currentTimeMillis();
		while((i2=fis2.read(b)) != -1){ //���� �� �ִ� byte �����Ͱ� �����Ѵٸ�
			fos2.write(b,0,i2);
		}
		end = System.currentTimeMillis();
		
		System.out.println("���� ���� ����(����Ʈ �迭)~~!!");
		System.out.println("�ɸ��ð�: " + (end-start)/1000.0+"��");
		
		fos.close();
		fis.close();
		
	}
	
	public static void main(String[] args) throws IOException{
		new SpeedTest();
	}

}
