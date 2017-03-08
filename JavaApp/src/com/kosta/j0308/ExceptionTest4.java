package com.kosta.j0308;

public class ExceptionTest4 {
	
	public static void main(String[] args) {
		
		//초기화를 안하면 컴파일러는 멍청해서 프린트를 못한다.
		int g = 0;
		
		try{
			g = 90;
			
		}catch(Exception ex){
			
		}
		
		System.out.println("g = " + g);
	}

}
