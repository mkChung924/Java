package com.coding.baekjun;

import java.util.Scanner;

public class BOJ2579 {

	int n;
	int d[][];
	int a[];
	public BOJ2579() {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		d = new int[n+1][2];
		a = new int[n+1];
		for(int i = 1; i <= n; i++){
			a[i] = sc.nextInt();
		}
		
		d[1][0] = d[1][1] = a[1];
		
		for(int i = 2; i <=n; i++){
			
			d[i][0] = d[i-1][1] +a[i];
			d[i][1] = Math.max(d[i-2][0], d[i-2][1]) + a[i];
			
//			System.out.println("d["+i+"][0]: " + d[i][0]);
//			System.out.println("d["+i+"][1]: " + d[i][1]);
			
		}

		System.out.println(Math.max(d[n][0], d[n][1]));
		
	}
	
	public static void main(String[] args) {
		new BOJ2579();
	}
}
