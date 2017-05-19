package com.coding.algorithm;

import java.math.BigInteger;
import java.util.Scanner;

public class binomialTest2 {
	
	public binomialTest2() {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		binomial(n,k);
		
	}
	
	public void binomial(int n, int k){
		
		BigInteger res = f(n).divide((f(k).multiply(f(n-k))));
		System.out.println(res.remainder(BigInteger.valueOf(1000000007)));
		
	}
	
	public BigInteger f(int c){
		BigInteger result = BigInteger.ONE;
		
		
		for(int i = c ; i > 0; i--){
			result = result.multiply(BigInteger.valueOf(i));
			System.out.println(result);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		new binomialTest2();
	}

}
