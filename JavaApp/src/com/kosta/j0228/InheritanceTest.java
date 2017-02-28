package com.kosta.j0228;

class Parent{
	
	Parent(){
		System.out.println("부모생성자(기본)");
	}
	Parent(String str){
		System.out.println("부모생성자(오버로딩)");
	}
	
	
}

class Child extends Parent{
	
	Child(){
		//상위클래스 생성자 호출
		super("문자열");
		System.out.println("자식생성자");
	}
	
}

public class InheritanceTest {
	public static void main(String args[]){
		Child c = new Child();
	}

}
