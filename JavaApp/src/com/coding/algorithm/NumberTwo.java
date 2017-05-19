package com.coding.algorithm;

import java.util.Vector;

public class NumberTwo {
	int first = 0;
	int second = 1;
	int third;
	int sum;
	int evenSum;
	
	Vector v = new Vector();
	
	public NumberTwo() {
		
		do{
			
			third = first + second;
			if(third > 4000000) break;
			
			sum += third;
			System.out.println(third);
			
			first = second;
			second = third;
			
			if(third%2 == 0){
				evenSum += third;
			}
			
		} while(third <= 4000000);
		System.out.println("모든 합: " + sum);
		System.out.println("짝수 합: " + evenSum);
	}
	
	public static void main(String[] args) {
		new NumberTwo();
	}

}
