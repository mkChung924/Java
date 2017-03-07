package com.kosta.j0307;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
	
	//����(���� ����)�� �о �ֿܼ� ��
	void readFile() {
		/*
		 * <�ڹ� ����� 4�� Ŭ����> - �߻�Ŭ����
		 * 		�Է�					��
		 * -InputStream			OutputStream	: byte������ �Է�, ��
		 * -Reader				Writer			: char(2byte) ������ �Է�, ���
		 * 
		 * FileInputStream
		 * FileReader
		 */
		
		//FileReader fr = new FileReader("�����ǰ�ο����ϸ�");
		
		try{ //���࿡ try ������ ���ܰ� �߻��Ѵٸ�~
		FileReader fr = new FileReader("/Users/myungkyuchung/git/Java/JavaApp/a.txt");//FileNotFoundException
		
		int i;
		while((i = fr.read()) != -1){
			System.out.print((char)i);//IOException
		}

		System.out.println("���� �б� ����!!");
		} catch(FileNotFoundException fe) {
			System.out.println("������ ã�� ���߽��ϴ�!");
		} catch(IOException ie){
			
		} finally {
			System.out.println("finally ����/���� ������� �׻� ����(?) YES!");
		}
		
	} //readFile
	
	public static void main(String args[]){
		ExceptionTest et = new ExceptionTest();
		et.readFile();
		
	}

}
