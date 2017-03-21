package com.kosta.j0321;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		
		//���ǥ�� ���(��ü���, ������ ���, ������� ���)
		//---------> �ڹ��� ��δ� '��ü���'�� �⺻!!
		//			-------> �ڹ��� ��ξ��� ���ڴ� ��ҹ��ڸ� �������� ����.
		
		File f = new File("\\Users\\myungkyuchung\\git\\Java\\JavaApp\\a.txt");
		System.out.println("f ������������: " + f.exists());
		
		File f2 = new File("/Users/myungkyuchung/git/Java/JavaApp/a.txt");
		f2 = new File("a.txt");
		f2 = new File("."); // .��� : current directory(������)
		f2 = new File("../.."); // .. �θ���
		System.out.println("f ������������: " + f2.exists());
		
		//������� ������
		System.out.println(f2.getPath());
		System.out.println(f2.getAbsolutePath());
		System.out.println(f2.getCanonicalPath());
		
		File f3 = new File("a.txt");
		System.out.println("f ������������: " + f3.exists());
		//��Ŭ�������� JavaProject�� ������ Project������ ������Ʈ����� �����ϴ� ���� ����
		
		File f4 = new File("src/com/kosta/j0321/b.txt");
		System.out.println("f ������������: " + f4.exists());
		
		if(f4.isFile()){ //f4�� �����̸� ���� true
			System.out.println("�����̴�.");
		}
		
		if(f4.isDirectory()){ //f4�� ���丮�̸� ���� true
			System.out.println("�����̴�.");
		}
		
		File f5 = new File("scr/com/kosta/j0321");
		if(f5.isDirectory()){
			System.out.println("f5�� ���丮��.");
		}
		
		String path = "gildong/my/";
		String fileName = "c.txt";
		File f6 = new File(path);
		
		if(!f6.exists())
		f6.mkdirs();//���丮 �������
		
		//����
		//FileWriter, FileOutputStream(������°�ü)�� ������ �����Ѵ�.
		FileOutputStream fos = new FileOutputStream(path+fileName); //���ϻ���
		
		//�ڿ���ȯ
		fos.close();
		
		File f7 = new File(path+fileName);
		System.out.println("����: "+f7.delete());//�����̳� ���丮 �����ϴ� ���
	}

}
