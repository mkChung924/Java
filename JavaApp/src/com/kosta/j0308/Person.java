package com.kosta.j0308;

import java.io.Serializable;

public class Person{ //�ڹٺ���(JavaBeans): ���� ���ü� �ִ� �Ӽ��� �����ִ� Ŭ����
	
	//1.�Ӽ��� private���� ����
	
	
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
