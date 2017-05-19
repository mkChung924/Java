package com.coding.baekjun;

import java.util.Scanner;

public class TriangleSumTest {
	
	/*
	 * 5
	 * 7 6
	 * 6 7 4
	 * 3 5 6 8
	 * 2 3 4 8 9
	 */

	
	public TriangleSumTest() {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[][] = new int[n+1][n+1];
		int max = 0;
		
		for(int i = 1; i <= n; i++){
		
			for(int j = 1; j <= i; j++){
				int next = sc.nextInt();
				
				dp[i][j] = next;
				
				if(j == 0){
					
					dp[i][j] = dp[i][j] + dp[i-1][j];
					
				} else if (j == i){
					
					dp[i][j] = dp[i][j] + dp[i-1][j-1];
					
				} else {
					
					dp[i][j] = dp[i][j] + bigger(dp[i-1][j-1], dp[i-1][j]);
					
				}
				
				if(max < dp[i][j]) max = dp[i][j];
				
			}
		}
		
		System.out.println(max);

	}
	
	public int bigger(int a, int b){
		if(a > b) return a;
		else return b;
	}
	

	
	public static void main(String[] args) {
		new TriangleSumTest();
	}

}
