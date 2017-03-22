package com.kosta.j0322;

import java.io.Serializable;

public class Person implements Serializable{ //객체 직렬화 가능 클래스 명시
	
	//transient : 데이터 전달을 하지 않을 변수
	String name = "홍길동";
	//transient int age = 27;
	int age = 27;
	String job = "학생";

}
