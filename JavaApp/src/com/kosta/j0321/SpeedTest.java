package com.kosta.j0321;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class SpeedTest { // 여러 입출력 클래스를 통한 파일 복사 ----> 걸리는 시간 측정!!
	
	//case1) byte단위 입출력
	FileInputStream fis;
	FileOutputStream fos;
	
	//case2) 문자단위 입출력
	FileReader fr;
	FileWriter fw;
	
	//case3) Buffer 사용 입출력
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
		while((i=fis.read()) != -1){ //읽을 수 있는 byte 데이터가 존재한다면
			fos.write(i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("파일 복사 성공(바이트 단위)~~!!");
		System.out.println("걸린시간: " + (end-start)/1000.0+"초");
		
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
		
		System.out.println("파일 복사 성공(문자 단위)~~!!");
		System.out.println("걸린시간: " + (end-start)/1000.0+"초");
		
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
		
		System.out.println("파일 복사 성공(버퍼 사용)~~!!");
		System.out.println("걸린시간: " + (end-start)/1000.0+"초");
		
		//case4)
		
		fis2 = new FileInputStream("a.txt");
		fos2 = new FileOutputStream("b.txt");
		b = new byte[1024];
		
		int i2;
		
		start = System.currentTimeMillis();
		while((i2=fis2.read(b)) != -1){ //읽을 수 있는 byte 데이터가 존재한다면
			fos2.write(b,0,i2);
		}
		end = System.currentTimeMillis();
		
		System.out.println("파일 복사 성공(바이트 배열)~~!!");
		System.out.println("걸린시간: " + (end-start)/1000.0+"초");
		
		fos.close();
		fis.close();
		
	}
	
	public static void main(String[] args) throws IOException{
		new SpeedTest();
	}

}
