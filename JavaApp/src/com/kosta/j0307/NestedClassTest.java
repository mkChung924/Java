package com.kosta.j0307;


class NestingClass{
	
	static int i = 10;
	
	void hello(){
		System.out.println("hello");
		NestedClass nested = new NestedClass();
		nested.print(); //내부클래스의 메소드를 호출하기 위해서는 우선 객체생성을 먼저 해야 함!
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
		System.out.println("간접호출");
		nesting.hello();//외부클래스 내에서 내부클래스의 print()메소드 호출!
		
		//내부클래스 - print()메소드 직접 호출!
		//외부클래스명.내부클래스명 참조변수 = new 외부클래스명().내부클래스명();
		//NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		NestingClass.NestedClass nested = new NestingClass.NestedClass(); //static을 붙였을 때
		System.out.println("직접호출");
		nested.print();
		
		
		
	}

}
