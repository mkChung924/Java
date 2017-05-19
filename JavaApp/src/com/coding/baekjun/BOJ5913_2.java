package com.coding.baekjun;

import java.util.Scanner;


public class BOJ5913_2 {

	int wall, row, col, count, min, length;
	int map[][] = new int[6][6];
	
	public BOJ5913_2() {

		Scanner sc = new Scanner(System.in);
		wall = sc.nextInt();
		min = 25;
		
		for(int i = 1; i <= wall; i++){
			row = sc.nextInt();
			col = sc.nextInt();
			map[row][col] = 1;
		}
		
		System.out.println(count);
	}
	
	public void junGyu(){
		
		
		
	}

	public static void main(String[] args) {
		new BOJ5913_2();
	}

}
