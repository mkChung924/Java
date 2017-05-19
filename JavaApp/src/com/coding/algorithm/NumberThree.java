package com.coding.algorithm;

// 600851475143의 소인수 중에서 가장 큰 수를 구하세요.

public class NumberThree {
	
	long a = 600851475143L;
	
	public NumberThree() {
		
		for(int i = 1; i < Integer.MAX_VALUE; i++){
			if(a%i == 0){
				a = a/i;
			System.out.println(i);	
			if(a == 1) break;
			}
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		new NumberThree();
	}

}
