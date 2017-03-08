package com.kosta.j0308;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest2 {
	
	public static void main(String args[]){
		
		try{
		FileReader fr = new FileReader("b.txt");
		System.out.println("������ ã�ҽ��ϴ�.");
		int i;
		while((i = fr.read()) != -1){
			System.out.print((char)i);
		}
		} catch(FileNotFoundException e){
			System.out.println("�� �޽���: ������ ã�� ���߽��ϴ�.");
			System.out.println("======================================================================================");
			//e: �����޽��� ��ü
			System.out.println("e.getMessage: "+e.getMessage());
			System.out.println("======================================================================================");
			System.out.println("e.toString: "+e.toString());
			System.out.println("======================================================================================");
			System.out.print("e.printStackTrace(): ");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
	}

}
