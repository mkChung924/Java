package com.praictice.java;

import java.util.Arrays;

public class ArrayTest {
	
	public static void main(String[] args) {
		
		int arr[][] = new int[4][4];
		int arrCopy[][] = new int[4][4];
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				arr[i][j] = 1;
			}
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i = 0 ; i < 4; i++){
			arrCopy[i] = Arrays.copyOf(arr[i], 4);
		}
		
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(arrCopy[i][j]+" ");
			}
			System.out.println();
		}
	}

}
