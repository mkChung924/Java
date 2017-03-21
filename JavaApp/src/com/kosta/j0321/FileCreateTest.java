package com.kosta.j0321;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCreateTest {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("<<파일 만들기>>");
		
		System.out.print("생성폴더: ");
		String dir = br.readLine();
		
		File file = new File(dir);
		if(!file.exists()) file.mkdirs();
		
		System.out.print("(확장자명 없는)생성파일: ");
		String fileName = br.readLine() + ".txt";
		
		FileWriter fw = new FileWriter(dir + "/" + fileName);
		
		System.out.print("파일내용: ");
		String str = br.readLine();
		
		fw.write(str);
		
		fw.close();
		
//		FileOutputStream fos = new FileOutputStream(dir + fileName);
//		fos.close();
//		
//		File myFile = new File(dir+fileName);

		//FileOutputStream을 사용할 경우 byte값을 전달하여야함.
//		byte a[] = str.getBytes();
//		for(int i = 0; i < a.length; i++){
//			fos.write(a[i]);
//		}
//		fos.close();
		
		
		
		
	}

}
