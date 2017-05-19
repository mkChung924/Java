package com.kosta.j0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

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
	
	public static boolean num_check(String str){//���� ������ ��� ���� true
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if(!(ch >= '0' && ch <= '9')){
				return false;
			}		
		}//for
		
		if(str.length()==0) return false;
		return true;
		
	}//num_check
	

	public static void main(String args[]) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		
		NameMenu nm = new NameMenu();
		
		do{

		System.out.println("<�̸��޴�>");
		System.out.println("1.�߰� 2.�˻� 3.���� 4.���� 5.����");
		System.out.print("��ȣ�Է� ==> ");
		String str = br.readLine();
		char a[] = str.toCharArray();
		
//		if(str.isEmpty()){
//			
//			System.out.println("���� �Է��ϼ���.\n");
//			continue;
//			
//		} else if(!(a[0] >= '1' && a[0] <= '5')){
//			
//			if(a[0] >= 'A'){
//			System.out.println("��ȣ�� �Է��ϼ���.");
//			} else if(a[0] < '1' || a[0] > '5'){
//				System.out.println("1~5���� ���� �����մϴ�.");
//			}
//			
//		} else {
//		}
		
		if(num_check(str)){
			num = Integer.parseInt(str); // "1", "2", "3", "4", "5"
		} else {
			num = 0;
			System.out.println("��ȣ�� �Է��ϼ���!");
		}
		
		switch(num){

		case 1: 
			String name;
			System.out.print("�̸� �Է�: ");
			name = br.readLine().trim();
			
			if(nm.insert(name)){
				System.out.println("���� ����!");
			} else {
				System.out.println("���� ����!");
			}
			break;
			
		case 2:
			Vector<String> v = nm.select();
			System.out.println("#�̸����");
			for(int i = 0; i < v.size(); i++){
				System.out.println("["+(i+1)+"] "+v.get(i));
			}
			
			break;
		
		case 3:
			String oldName;
			String newName;
			

				System.out.print("���� �̸�: ");
				oldName = br.readLine().trim();		

				System.out.print("�� �̸�: ");
				newName = br.readLine().trim();	
				
				
				if(nm.update(oldName, newName)){
					System.out.println("���ο� �̸��� ����Ǿ����ϴ�.");
					
				} else {
					System.out.println("�������� �ʴ� �̸��Դϴ�.");
				}

			break;

			
		case 4:
					
			String delName;

			System.out.print("�̸� �Է�: ");
			delName = br.readLine().trim();
			if(nm.delete(delName)){
				System.out.println("�����Ϸ�!");
			} else {
				System.out.println("������ �����Ͱ� �����ϴ�.");
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

