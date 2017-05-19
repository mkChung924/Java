package com.coding.baekjun;

import java.util.Scanner;

public class FactorialTest1 {
	
	public FactorialTest1() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		factorial(num);
	}
	
	public void factorial(int a){
		int mul = 1;
		for(int i = a; i > 0 ; i--){
			mul *= i;
		}	
		System.out.println(mul);
	}
	
	public static void main(String[] args) {
		new FactorialTest1();
	}

}
