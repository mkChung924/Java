package com.coding.baekjun;

import java.util.Scanner;

public class FiboTest {

	int count0, count1;
	
	public FiboTest() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++){
			count0 = 0;
			count1 = 0;
			int num = sc.nextInt();
			System.out.println(fibonacci(num));
			//System.out.println(count0 +" " + count1);
		}

		
	}
	
	
	public int fibonacci(int n) {
	    if (n==0) {
	        count0++;
	        return 0;
	    } else if (n==1) {
	        count1++;
	        return 1;
	    } else {
	        return fibonacci(n-1) + fibonacci(n-2);
	    }
	}
	
	public static void main(String[] args) {
		new FiboTest();
		
	}
}
