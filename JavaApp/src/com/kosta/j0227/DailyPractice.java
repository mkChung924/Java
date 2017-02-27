package com.kosta.j0227;

class Pear {
	int a[] = {1,2,3};
	String b[] = {"a", "b", "c"};
}

public class DailyPractice {
	
	public static void main(String args[]){
				
		//1번//
		System.out.println("##1번##");
		for(int i = 0; i < 4; i++ ){
			for(int j = 0; j < i +1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		//2번//
		System.out.println("##2번##");
		for(int i = 4; i > 0; i--){
			
			for(int j = i - 1; j > 0; j--){
				System.out.print("*");
			}
			System.out.println("*");
		}
		
		/////////////////////////////////////
		Pear p = new Pear();
		int aa = p.a.length;
		int bb = p.b.length;
		System.out.println(aa);
		System.out.println(p.b[bb-1]);
		for(int i = 0; i < bb; i++){
			System.out.println(p.b[i]);
		}

	}

}
