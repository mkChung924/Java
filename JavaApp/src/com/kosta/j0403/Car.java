package com.kosta.j0403;

abstract public class Car {
	
	String name;
	int number;
	
	public String getName(){
		return name;
	}
	
	public int getNumber(){
		return number;
	}
	
	abstract void drive();
	
	public Car() {
		
	}
	
	public Car(String name, int number){
		this.name = name;
		this.number = number;
	}
		

	public void driveAndParking(){
		drive();
		System.out.println("ÁÖÂ÷~");
	}

}
