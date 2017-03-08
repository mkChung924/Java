package com.kosta.j0308;

import java.io.Serializable;

public class Person{ //자바빈즈(JavaBeans): 서로 관련성 있는 속성을 묶어주는 클래스
	
	//1.속성을 private으로 지정
	
	
	private String name;
	private int age;
	private String job;
	

	public Person(String name, int age, String job) {
		this.name = name;
		this.age = age;
		this.job = job;
	}

	@Override
		public String toString() {
			return "["+name+", "+age+", "+job+"]";
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	
	

}
