package com.kosta.j0308;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person("�����", 13, "�л�");
		
		//name�� age�� ���� ����(����)
		//p.setName("haha");
		
		System.out.println("�̸��� "+ p.getName());
		
		//============toString �޼ҵ�: Ŭ������ ���¸� ǥ���ϴ� �޼ҵ� ==================
		
		System.out.println(p);

		
	}

}
