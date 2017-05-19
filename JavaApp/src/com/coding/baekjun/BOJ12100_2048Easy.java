package com.coding.baekjun;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ12100_2048Easy {
	
	int N, max;
	int map[][];
	int Max = 5;

	public BOJ12100_2048Easy() {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(map,0);
		System.out.println(max);
		
	}
	
	public void dfs(int[][] map, int step){
		
		if(step == Max){
			
			maxValue(map);
			return;
		}
		
		for(int i = 0; i < 4; i++){
			
			int[][] mapCopy = new int[N][N];
			
			for(int j = 0; j < N; j++){
				
				mapCopy[j] = Arrays.copyOf(map[j], N);
				
			}
			
			dfs(action(mapCopy,i),step+1);
		}
		
		
		
	}
	
	public int[][] action(int[][] mapC, int dir){
		
		switch(dir){
		
		
		case 0://left
			
			
			
			for(int row = 0; row < N; row++){
				int nb = 0;
				
				for(int col = 1; col < N; col++){
					
					if(mapC[row][col] == 0){
						nb++;
						continue;
					} else {
						
						if(mapC[row][col] == mapC[row][col-1-nb]){
							mapC[row][col-1-nb] *= 2;
							mapC[row][col] = 0;
						
						} else if(mapC[row][col-1-nb] == 0){
							mapC[row][col-1-nb] = mapC[row][col];
							mapC[row][col] = 0;
							nb++;
							
						} else {
							mapC[row][col-nb] = mapC[row][col];
							if(nb != 0)
								mapC[row][col] = 0;
						}	
					}
				}
			}
			
			break;
			
			
		case 1://up
			
			for(int col = 0; col < N; col++){
				
				int nb = 0;
				
				for(int row = 1; row < N; row++){
					
					if(mapC[row][col] == 0){
						
						nb++;
						continue;
					} else {
						
						if(mapC[row][col] == mapC[row-1-nb][col]){
							mapC[row-1-nb][col] *= 2;
							mapC[row][col] = 0;
						} else if(mapC[row-1-nb][col] == 0){
							mapC[row-1-nb][col] = mapC[row][col];
							mapC[row][col] = 0;
							nb++;
							
						} else {
							mapC[row-nb][col] = mapC[row][col];
							if(nb != 0)
								mapC[row][col] = 0;
						}

					}
					
				}
			}
			
			break;
			
			
		case 2://right
			
			for(int row = 0; row < N; row++){
				int nb = 0;
				for(int col = N-2; col >= 0; col--){
					
					if(mapC[row][col] == 0){
						nb++;
						continue;
					} else {
						
						if(mapC[row][col+1+nb] == mapC[row][col]){
							mapC[row][col+1+nb] *= 2;
							mapC[row][col] = 0;
						} else if(mapC[row][col+1+nb] == 0){
							mapC[row][col+1+nb] = mapC[row][col];
							mapC[row][col] = 0;
							nb++;
						} else {
							mapC[row][col+nb] = mapC[row][col];
							if(nb != 0)
								mapC[row][col] = 0;
							
						}
						
						
					}
					
					
				}
			}
			
			break;
			
			
		case 3://down
			
			for(int col = 0; col < N; col++){
				int nb = 0;
				for(int row = N-2; row >=0; row--){
					
					if(mapC[row+1+nb][col] == mapC[row][col]){
						mapC[row+1+nb][col] *= 2;
						mapC[row][col] = 0;
 					} else if(mapC[row+1+nb][col] == 0){
 						mapC[row+1+nb][col] = mapC[row][col];
 						mapC[row][col] = 0;
 						nb++;
 					} else {
 						mapC[row+nb][col] = mapC[row][col];
 						if(nb != 0)
 							mapC[row][col] = 0;
 					}
					
				}
			}
			
			break;
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j< N; j++){
				String z = "";
				if(mapC[i][j] < 10) z = " ";
				System.out.print(z+ mapC[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		return mapC;
	}
	
	public void maxValue(int[][] map){
		
		int temp = 0;
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				
				if(temp < map[i][j])
					temp = map[i][j];
			}
		}
		
		if(max < temp) max = temp;
	}
	
	public static void main(String[] args) {
		new BOJ12100_2048Easy();
	}

}
