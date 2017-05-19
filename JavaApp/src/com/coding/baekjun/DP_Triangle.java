package com.coding.baekjun;

import java.util.Scanner;

public class DP_Triangle {
	
	
/*5
7 6
6 7 4
3 5 6 8
2 3 4 8 9*/
 
	
	int n, max;
	int dp[][];
	
	public DP_Triangle() {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n; i++){
			
			for(int j = 1; j <= i; j++){
				
				int num = sc.nextInt();
				
				dp[i][j] = num;
				
				if(j == 0){
					
					dp[i][j] = dp[i][j] + dp[i-1][j];
				
				} else if(j == i){
					
					dp[i][j] = dp[i][j] + dp[i-1][j-1];
				
				} else {
					
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + dp[i][j];
				}
				
				if(max < dp[i][j]) max = dp[i][j];
				
			}
			
		}
		System.out.println(max);
		
	}
	
	public static void main(String[] args) {
		new DP_Triangle();
	}

}
