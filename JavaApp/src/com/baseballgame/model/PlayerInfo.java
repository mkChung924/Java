package com.baseballgame.model;

public class PlayerInfo {
	
	private String id;
	private String name;
	private int age;
	private int score;
	
	public PlayerInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public PlayerInfo(String id, String name, int age, int score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public Object[] toObjectArray(){
		
		Object row[] = {id, name, age, score};
		
		return row;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	

}
