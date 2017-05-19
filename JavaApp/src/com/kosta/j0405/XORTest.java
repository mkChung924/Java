package com.kosta.j0405;

public class XORTest {
	short x = 2;
	short y = 5;
	
	public XORTest() {
		
		short ans = (short) (x^y);
		
		System.out.println(ans);
		
	}
	
	public static void main(String[] args) {
		new XORTest();
	}

}
