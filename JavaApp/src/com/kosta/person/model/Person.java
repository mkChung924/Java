package com.kosta.person.model;

public class Person {//JavaBeans
	
	private int no;
	private String name;
	private int age;
	private String job;
	
	public Person(int no, String name, int age, String job) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	public Object[] toObjectArray(){
		
		Object row[] = {no, name, age, job};
		
		return row;
		
	}
	
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
