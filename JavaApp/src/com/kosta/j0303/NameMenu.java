package com.kosta.j0303;

public class NameMenu {
	
	String names[];
	int count;
	
	public NameMenu() {
		
		names = new String[5];
		count = 0;
		//System.out.println("haha");
	}
	
	public boolean existName(String name){
		for(int i = 0; i < names.length; i++){
			if(name.equals(names[i])){
				return true;
			}
		}
		return false;
	}
	
	public void insert(String addName){ //�̸� �߰�
		
//		if(names[names.length-1] != null){
//			System.out.println("�� �̻� �Է��� �� �����ϴ�.\n �� �� �̻��� �̸��� ���� ������ �� �Է��ϼ���.");
//			return;
//		}
		if(count == 5){
			System.out.println("�� ��.");
			return;
		}
		
		for(int i = 0; i < names.length; i++){
			
			if(names[i] != null){
				if(names[i].equals(addName)){
				System.out.println("������ �̸��� �����մϴ�.");
				return;
				} 
			} else if(names[i] == null){
				names[i] = addName;
				count++;
				break;
			}			
		}
		System.out.println("����Ϸ�!");

	}
	
	public void select(){ // �̸� ����Ҹ� ȭ�� ���; ����̸� ���
		
		long start = System.currentTimeMillis();
		
		if(names[0] != null){
			System.out.println("#�̸����");
			for(int i = 0; i < names.length; i++){
				if(names[i] != null){
					System.out.println("["+i+"] "+ names[i]);
				} 
			}
			
			long end = System.currentTimeMillis();
			System.out.println( "*���� �ð� : " + ( end - start )/1000.0 + "s");
			
		} else {
			
				System.out.println("����� �̸��� �����ϴ�. ���� �߰��� �ּ���.");
				return;
			} 
		
		
		}
		
	public boolean listCheck(){

		if(names[0] != null){
			return true;
		} else {
			System.out.println("�̸� ����� ������ϴ�. ���� �߰��� �ּ���.");
			return false;
		}
		
	}
	
	public boolean oldNameCheck(String oldName){
		
		for(int i = 0; i < names.length; i++){
			if(names[i] != null){
				if(names[i].equals(oldName)){
					return true;
				} else {
					System.out.println("�������� �ʴ� �̸��Դϴ�!!\n");
					
				}
			} else {
				System.out.println("##");
				return false;
			}
		}
		return false;
		
	}
	
	public void update(String oldName, String newName){ // �̸� ����
		
		for(int i = 0; i < names.length; i++){
			if(newName.equals(names[i])){
				System.out.println("���ο� �̸��� �̹� �����մϴ�.");
				return;
			}
		}

		if(names[0] != null){
			for(int i = 0; i < names.length; i++){
				if(names[i].equals(oldName)){
					names[i] = newName;
					break;
				}
			}
				System.out.println("���� �Ϸ�!");
		} else {
			System.out.println("�̸��� �������� �ʽ��ϴ�.");
		}
	}
	

	public void delete(String delName){ // �̸� ����
		
		long start = System.currentTimeMillis();
		
		int i;
		for(i = 0; i < names.length; i++){
			if(names[i] == null){
				System.out.println("�������� �ʴ� �̸��Դϴ�!!");
				return;
			} else {
			if(names[i].equals(delName)){
				names[i] = null;
				count--;
				break;
				}
			}
		}

		for(int j = i; j < names.length; j++){
			if(j < names.length -1 ) {
				names[j] = names[j+1];
			}
		}
		
		System.out.println("���� �Ϸ�!");
		long end = System.currentTimeMillis();
		System.out.println( "\n*���� �ð� : " + ( end - start )/1000.0 + "s");
		
	}

}
