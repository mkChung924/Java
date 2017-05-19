package com.coding.baekjun;

import java.util.Scanner;

public class BOJ2579_2 {
	
	int n;
	int dp[][];
	int a[];

	public BOJ2579_2() {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1][2];
		a = new int[n+1];
		
		for(int i = 1; i <= n; i++){
			a[i] = sc.nextInt();
		}
		
		dp[1][0] = dp[1][0] = a[1];
		
		for(int i = 2; i <=n; i++){
			
			dp[i][0] = dp[i-1][1] + a[i];
			dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + a[i];
			
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
		
	}
	
	public static void main(String[] args) {
		new BOJ2579_2();
	}
}
