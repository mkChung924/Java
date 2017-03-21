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
		while((i=fis.read(b)) != -1){ //읽을 수 있는 byte 데이터가 존재한다면
			fos.write(b,0,i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println("파일 복사 성공(바이트 단위)~~!!");
		System.out.println("걸린시간: " + (end-start)/1000.0+"초");
		
		fos.close();
		fis.close();
	}

}
