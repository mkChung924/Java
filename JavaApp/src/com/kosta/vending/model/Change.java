package com.kosta.vending.model;

public class Change {
	
	private int five;
	private int one;
	
	public Change(){
		
	}
	
	public Change(int five, int one){
		this.five = five;
		this.one = one;
	}
	
	public int getFive() {
		return five;
	}
	public void setFive(int five) {
		this.five = five;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	
	

}
