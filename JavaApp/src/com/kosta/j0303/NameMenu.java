package com.kosta.j0303;

public class NameMenu {
	
	String names[];
	
	public NameMenu() {
		
		names = new String[5];
		//System.out.println("haha");
	}
	
	public void insert(String addName){ //�̸� �߰�
		
		
		for(int i = 0; i < names.length; i++){
			
			if(names[i] != null){
				if(names[i].equals(addName)){
				System.out.println("������ �̸��� �����մϴ�.");
				return;
				}
			} else if(names[i] == null){
				names[i] = addName;
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
	
	public void update(String oldName, String newName){ // �̸� ����
		
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
				System.out.println("�̸��� ã�� �� �����ϴ�.");
				return;
			} else {
			if(names[i].equals(delName)){
				names[i] = null;
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
		System.out.println( "*���� �ð� : " + ( end - start )/1000.0 + "s");
		
	}

}
