package com.kosta.j0308;

public class PersonTest {
	public static void main(String[] args) {
		Person p = new Person("길라임", 13, "학생");
		
		//name과 age의 값을 설정(전달)
		//p.setName("haha");
		
		System.out.println("이름은 "+ p.getName());
		
		//============toString 메소드: 클래스의 상태를 표현하는 메소드 ==================
		
		System.out.println(p);

		
	}

}
