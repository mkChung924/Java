package com.kosta.j0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonMenuTest {
	
	public static void main(String[] args) throws IOException{
		
		PersonMenu pm = new PersonMenu();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		String name;
		int age;
		String job;
		
		do{
			
			System.out.println("<��� ���>\n1.�߰� 2.�˻� 3.���� 4.���� 5.����");
			System.out.print("=> ��ȣ�Է�: ");
			num = Integer.parseInt(br.readLine());
			
			switch(num){
			
			case 1:
				System.out.print("�̸�: ");
				name = br.readLine();
				System.out.print("����: ");
				age = Integer.parseInt(br.readLine());
				System.out.print("����: ");
				job = br.readLine();
				pm.insert(name, age, job);
				
				break;
				
			case 2:
				
				pm.select();
				
				break;
				
			case 3:
				
				if(pm.listEmpty()){
					System.out.println("��ϵ� ������ �����ϴ�.");
				} else {
					
				int idx;
				System.out.print("������ ��ȣ: ");
				idx = Integer.parseInt(br.readLine());
				if(pm.idxCheck(idx)){
					System.out.println("�߸��� �����Դϴ�.\n");
				} else {
				System.out.print("����: ");
				age = Integer.parseInt(br.readLine());
				System.out.print("����: ");
				job = br.readLine();
				
					pm.update(idx, age, job);
				}
				
				}
			
				break;
				
			case 4:
				
				if(pm.listEmpty()){
					System.out.println("��ϵ� ������ �����ϴ�.");
				} else {
					
				int idx;
				System.out.print("���� ��ȣ: ");
				idx = Integer.parseInt(br.readLine());
				if(pm.idxCheck(idx)){
					System.out.println("�߸��� �����Դϴ�.\n");
				} else {
				pm.delete(idx);
				}
				}
				
				break;
			
			case 5:
				
				break;
				
			default: break;
			
			}
			
		} while(num != 5);
		
		System.out.println("== END ==");
		
		
	}//main

}//class
