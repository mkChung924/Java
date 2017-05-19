package com.kosta.j0200;

class Abc
{

	Abc(){ //�⺻������
		System.out.println("�⺻������");
	}

	Abc(String name){
		System.out.println("�����ε� ������ : "  + name);
	}

	void hello(){
		System.out.println("���ݸ� �ȳ�~");
	}
	void goodBye(){
		System.out.println("�߰�~~");
	}

}
//-------------------------------------------------------------------------------------------

class A{
	   String str;

	   A(){ //�⺻������
		this("�ڹ�");
	   }
	   A(String str){ //�����ε� ������
		this.str = str;
	   }

	   void print(){
		System.out.println("STR = " + str);
	   }

	}

//-------------------------------------------------------------------------------------------

class Parent
{
	int a = 10;

	Parent(){
		System.out.println("��ü ���� : �θ��Դϴ�.");
	}

	void print()
	{
		System.out.println("�θ�����Ʈ");
	}
}

class Child extends Parent
{
	int b = 20;

	Child(){
		System.out.println("��ü ���� : �ڽ��Դϴ�");
	}

	void print()
	{
		System.out.println("�ڽ�����Ʈ");
	}

	void hello()
	{
		System.out.println("�ȳ�!");
	}

	void hello(String name)
	{
		System.out.println("�ȳ�, " + name);
	}
}

//-----------------------------------------------------------------------------------
class ConstructorTest
{
	public static void main(String args[]){
		Abc abc = new Abc();
		abc.hello();
		abc.goodBye();

		Abc abc2 = new Abc("�����");
		abc2.hello();

		A a = new A();
		a.print();

		Parent p = new Parent();
		p.print();

		Child c = new Child();
		c.print();

		Parent p2 = new Child();

		p2.print();

	}
}