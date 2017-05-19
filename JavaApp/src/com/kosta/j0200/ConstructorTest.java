package com.kosta.j0200;

class Abc
{

	Abc(){ //기본생성자
		System.out.println("기본생성자");
	}

	Abc(String name){
		System.out.println("오버로드 생성자 : "  + name);
	}

	void hello(){
		System.out.println("초콜릿 안녕~");
	}
	void goodBye(){
		System.out.println("잘가~~");
	}

}
//-------------------------------------------------------------------------------------------

class A{
	   String str;

	   A(){ //기본생성자
		this("자바");
	   }
	   A(String str){ //오버로딩 생성자
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
		System.out.println("객체 생성 : 부모입니다.");
	}

	void print()
	{
		System.out.println("부모프린트");
	}
}

class Child extends Parent
{
	int b = 20;

	Child(){
		System.out.println("객체 생성 : 자식입니다");
	}

	void print()
	{
		System.out.println("자식프린트");
	}

	void hello()
	{
		System.out.println("안녕!");
	}

	void hello(String name)
	{
		System.out.println("안녕, " + name);
	}
}

//-----------------------------------------------------------------------------------
class ConstructorTest
{
	public static void main(String args[]){
		Abc abc = new Abc();
		abc.hello();
		abc.goodBye();

		Abc abc2 = new Abc("정명규");
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