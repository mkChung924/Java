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
		
		System.out.println("<<���� �����>>");
		
		System.out.print("��������: ");
		String dir = br.readLine();
		
		File file = new File(dir);
		if(!file.exists()) file.mkdirs();
		
		System.out.print("(Ȯ���ڸ� ����)��������: ");
		String fileName = br.readLine() + ".txt";
		
		FileWriter fw = new FileWriter(dir + "/" + fileName);
		
		System.out.print("���ϳ���: ");
		String str = br.readLine();
		
		fw.write(str);
		
		fw.close();
		
//		FileOutputStream fos = new FileOutputStream(dir + fileName);
//		fos.close();
//		
//		File myFile = new File(dir+fileName);

		//FileOutputStream�� ����� ��� byte���� �����Ͽ�����.
//		byte a[] = str.getBytes();
//		for(int i = 0; i < a.length; i++){
//			fos.write(a[i]);
//		}
//		fos.close();
		
		
		
		
	}

}
