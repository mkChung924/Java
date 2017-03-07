package com.kosta.j0307;

import java.util.Vector;

public class NameMenu {
	
	Vector<String> names;
	final int MAX = 5;
	
	public NameMenu() {
		
		names = new Vector<>();
	}
	
	public boolean existName(String name){
		
		if(names.contains(name)){
			System.out.println("�̹� �̸��� ��ϵǾ��ֽ��ϴ�.");
			return true;
		}
		
		return false;
	}
	
	public boolean emptyCheck(){
		
		if(names.isEmpty()){
			System.out.println("��ϵ� �̸��� �����ϴ�.");
			return true;
		}
		return false;
	}
	
	public void insert(String addName){ //�̸� �߰�
		
		if(names.size() == MAX){
			System.out.println("������ �ʰ��Ͽ����ϴ�.");
			return;
		} 
		names.add(addName);
		System.out.println("���� �Ϸ�!");
		
	}
	
	public void select(){ // �̸� ����Ҹ� ȭ�� ���; ����̸� ���
		
		long start = System.currentTimeMillis();
		int count = 1;
		
		if(emptyCheck()){
			//System.out.println("��ϵ� �̸��� �����ϴ�.");
		} else {
		
			System.out.println("#�˻� ���");
			for(int i = 0; i < names.size(); i++){
				if(i == 6*count){
					System.out.println();
					count++;
				}
				System.out.print("["+i+"] "+names.get(i)+ " ");
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("\n���� �ð�: " + (end - start)/1000.0 + "s");
		
		
		}
		

	public boolean oldNameCheck(String oldName){
		if(!names.contains(oldName)){
			System.out.println("��ġ�ϴ� �̸��� �����ϴ�.");
			return true;
		}
		return false;
		
	}

	public void update(String oldName, String newName){ // �̸� ����
		
		if(emptyCheck()){
						
		} else if(names.contains(newName)){
			System.out.println("���ο� �̸��� �̹� �����մϴ�.");
			return;
			
		} else{
			
			if(names.contains(oldName)){
				names.set(names.indexOf(oldName), newName);
				System.out.println("���� �Ϸ�!");
			} else {
				System.out.println("��ġ�ϴ� �̸��� �����ϴ�.");
			}
		}
	}
	
	public void delete(String delName){ // �̸� ����
		
		long start = System.currentTimeMillis();
		
		if(emptyCheck()){
			return;
		}
		
		if(names.contains(delName)){
			names.remove(delName);
			System.out.println("���� �Ϸ�!");
		} else {
			System.out.println("�������� �ʴ� �̸��Դϴ�.");
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println( "\n*���� �ð� : " + ( end - start )/1000.0 + "s");
		
	}

}
