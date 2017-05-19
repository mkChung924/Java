package com.coding.algorithm;

public class RecursiveTest {
	int arr[][];
	public RecursiveTest() {
		
		int n = 11;
		
		//팩토리얼
		System.out.print(fact(n));
		
		System.out.println();
		//피보나치
		for(int i = 2; i <= n; i++){
			System.out.print(fibo(i) + " ");
		}
		
		System.out.println();
		desc(9);

	}
	
	public void desc(int n){
		
		if(n < 1){
			return;
		} else {
			System.out.print(n + " ");
			n--;
			desc(n);
		}
	}
	
	public int fact(int n){
		if( n <= 1){
			return 1;
		} else {
			
			return fact(n-1)*n;
			
		}
	}
	
	public int fibo(int n){
		if(n == 0) return 0;
		else if(n == 1 || n == 2) return 1;
		else return fibo(n-1) + fibo(n-2);
	}
	
	public static void main(String[] args) {
		new RecursiveTest();
	}

}
