package com.kosta.j0228;

class Parent{
	
	Parent(){
		System.out.println("�θ������(�⺻)");
	}
	Parent(String str){
		System.out.println("�θ������(�����ε�)");
	}
	
	
}

class Child extends Parent{
	
	Child(){
		//����Ŭ���� ������ ȣ��
		super("���ڿ�");
		System.out.println("�ڽĻ�����");
	}
	
}

public class InheritanceTest {
	public static void main(String args[]){
		Child c = new Child();
	}

}
