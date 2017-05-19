package com.coding.algorithm;

public class NumberSix {
	int sum1;
	int sum2;
	int sum3;
	
	public NumberSix() {
		
		for(int i = 0; i <= 100; i++){
			sum1 += i*i;
		}
		
		for(int i = 0; i <= 100; i++){
			
			sum2 += i;
			
		}
		
		sum3 = sum2*sum2;
		
		System.out.println("제곱의 합: " + sum1);
		System.out.println("합: " + sum2);
		System.out.println("합의 제곱: " + sum3);
		System.out.println("둘의 차: " + (sum3-sum1));
		
	}
	
	public static void main(String[] args) {
		new NumberSix();
	}

}
