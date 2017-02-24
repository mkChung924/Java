package com.kosta.gildong; //현재 클래스의 위치(패키지)를 정의

public class Greetings
{
	public void hello(String name){
		System.out.println("Hello, "+ name);
	}

	protected void hi(String name){
		System.out.println("Hi, "+ name);
	}

	void goodBye(String name){
		System.out.println("Good Bye, "+ name);
	}

	private void yahoo(){
		System.out.println("Yahoo~~!!");
	}
}
