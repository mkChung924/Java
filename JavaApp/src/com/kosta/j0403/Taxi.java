package com.kosta.j0403;

public class Taxi extends Car{
	
	public Taxi() {
		super("º¥", 1234);
	}

	@Override
	public void drive() {
		System.out.println("½Â°´À» ÅÂ¿ì°í~");		
	}
	
	public static void main(String[] args) {
		
		new Taxi().driveAndParking();
		System.out.println(new Taxi().name + ", " + new Taxi().number);
	}

}
