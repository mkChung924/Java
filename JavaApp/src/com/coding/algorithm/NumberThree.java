package com.coding.algorithm;

// 600851475143�� ���μ� �߿��� ���� ū ���� ���ϼ���.

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
