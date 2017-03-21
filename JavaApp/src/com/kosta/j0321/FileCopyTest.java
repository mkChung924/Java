package com.kosta.j0321;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {
	
	public static void main(String[] args) throws IOException{
		//���� ���� �׽�Ʈ
		
		
		//������ �о �ֿܼ� ���(����(a.txt) ----> �ܼ�)
		FileReader fr = new FileReader("a.txt");
		
		//fr.read();//���� ���ڿ� ���� �ƽ�Ű�ڵ�(����) ���� ����
//		System.out.println(fr.read());
//		System.out.println(fr.read());
//		System.out.println(fr.read());
//		System.out.println(fr.read());
		
		//��: (fr.read() == -1) ----> ���̻� ���� ���ڰ� ���ٸ� true ����
		//��: (fr.read() != -1) ----> ���̻� ���� ���ڰ� �ִٸ� true ����
		
		FileWriter fw = new FileWriter("b.txt");
		//FileWriter�� ���ϻ����� ���������� ���丮�� ������ �Ұ���
		int i;
		
		while((i=fr.read()) != -1){
			System.out.print((char) i);
			//fw.write((char)i);
			fw.write(i);
		}
		//����� ����� ��ü�� ���� �ڿ� ��ȯ
		fw.close();
		fr.close();
		
		System.out.println("���Ϻ��� ����~~!");
		
		
		//������ �о ���Ͽ� ���(����1 ----> ����2) : File Copy
			
	}

}
