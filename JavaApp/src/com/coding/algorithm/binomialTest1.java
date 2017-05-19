package com.coding.algorithm;

import java.util.Scanner;

public class binomialTest1 {
	
	public binomialTest1() {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		binomial(n,k);
		
	}
	
	public void binomial(int n, int k){
		
		int res = f(n)/(f(k)*f(n-k));
		System.out.println(res);
		
	}
	
	public int f(int c){
		int result = 1;
		
		for(int i = c ; i > 0; i--){
			result *= i;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		new binomialTest1();
	}

}
