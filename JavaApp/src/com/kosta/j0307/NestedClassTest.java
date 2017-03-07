package com.kosta.j0307;


class NestingClass{
	
	static int i = 10;
	
	void hello(){
		System.out.println("hello");
		NestedClass nested = new NestedClass();
		nested.print(); //����Ŭ������ �޼ҵ带 ȣ���ϱ� ���ؼ��� �켱 ��ü������ ���� �ؾ� ��!
	}
	
	
	static class NestedClass{
		int  j = 20;
		
		void print(){
			System.out.println("j = " + j);
			System.out.println("i = " + i);
		}
	}
	
} //NestingClass

public class NestedClassTest {
	public static void main(String args[]){
		
		NestingClass nesting = new NestingClass();
		System.out.println("����ȣ��");
		nesting.hello();//�ܺ�Ŭ���� ������ ����Ŭ������ print()�޼ҵ� ȣ��!
		
		//����Ŭ���� - print()�޼ҵ� ���� ȣ��!
		//�ܺ�Ŭ������.����Ŭ������ �������� = new �ܺ�Ŭ������().����Ŭ������();
		//NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		NestingClass.NestedClass nested = new NestingClass.NestedClass(); //static�� �ٿ��� ��
		System.out.println("����ȣ��");
		nested.print();
		
		
		
	}

}
