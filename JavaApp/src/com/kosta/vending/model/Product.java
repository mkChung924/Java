package com.kosta.vending.model;

import java.io.Serializable;

public class Product implements Serializable{
	
	private String pName;
	private int pCount;
	private int pPrice;
	
	public Product(String pName, int pPrice, int pCount) {
	
			this.pName = pName;
			this.pCount = pCount;
			this.pPrice = pPrice;
	
	}
	
	public Object[] toObjectArray(){
		
		Object row[] = {pName, pCount, pPrice};
		return row;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
	

}
