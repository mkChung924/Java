package com.kosta.j0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//<Ŭ���� �ۼ�>
//1. NameMenu.java(�̸� �߰�, ����, ����, �˻� ��� �޼ҵ带 ��ġ)
//	- ���: �迭��ü String names[];
//	- �߰�(add, append, plus, insert)
//	- �˻�(search, find, select)
//	- ����(modify, change, update, replace, rename)
//	- ����(delete, remove, clear, truncate, erase)

//2. NameMenuTest.java(main()�޼ҵ� ����, �ݺ��Ǵ� �޴� ���)
public class NameMenuTest {
	
	
	public NameMenuTest() { //�⺻ ����
	}
	

	public static void main(String args[]) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		
		NameMenu nm = new NameMenu();
		
		do{

		System.out.println("<�̸��޴�>");
		System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");
		System.out.print("��ȣ�Է� ==> ");
		num = Integer.parseInt(br.readLine()); // "1", "2", "3", "4", "5"
		
		switch(num){

		case 1: 
			String name;
			System.out.print("�̸� �Է�: ");
			name = br.readLine();
			nm.insert(name);
			
			break;
			
		case 2:
			nm.select();
			
			break;
		
		case 3:
			String oldName;
			String newName;
			if(nm.listCheck()){
			System.out.print("���� �̸�: ");
			oldName = br.readLine();
			System.out.print("�� �̸�: ");
			newName = br.readLine();
			
			nm.update(oldName, newName);
			}
			break;
			
			
		case 4:
					
			String delName;
			if(nm.listCheck()){
			System.out.print("�̸� �Է�: ");
			delName = br.readLine();
			nm.delete(delName);
			}
			break;
			
		case 5:
			
			break;
			
			
		}

			System.out.println();
			
		} while(num != 5); //�Է� �޴� ��ȣ�� 5���� �ƴҶ� ��� loop
		
		System.out.println("-- END --");
		

	}//main

} //NameMenuTest Ŭ����

