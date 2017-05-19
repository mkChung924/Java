package com.coding.algorithm;

public class NumberOne {
	
	int sum;
	
	public NumberOne() {
		for(int i = 1; i < 1000; i++){
			if(i%3 == 0 || i%5 == 0){
				sum += i;
			}
		}
		System.out.println("1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?");
		System.out.println("답: " + sum);
	}
	
	public static void main(String[] args) {
		new NumberOne();
	}

}
