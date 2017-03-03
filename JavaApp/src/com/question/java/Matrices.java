package com.question.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Matrices {
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("정방행렬의 행/열 수: ");
		String num = br.readLine();
		int col = Integer.parseInt(num);
		int row = Integer.parseInt(num);
		int maxCol = col - 1;
		int minCol = 0;
		int maxRow = row - 1;
		int minRow = 0;
		int value = 1;
		int m[][] = new int[row][col];
//		int a = 0;
//		int aa = 0;
//		int b = a++;
//		int c = ++aa;
//		System.out.println(b + " " + c);
//		System.out.println(col);
//		System.out.println(row);
//		System.out.println(maxCol);
//		System.out.println(maxRow);
//		System.out.println(minCol);
//		System.out.println(minRow);
//		System.out.println(value);
		
		while(value <= col*row){
			
			for(int i = minCol; i < maxCol; i++){
				m[minRow][i] = value;
				value++;
			}
			for(int i = minRow; i <= maxRow; i++){
				m[i][maxCol] = value;
				value++;
			}
			for(int i = maxCol - 1; i >= minCol; i--){
				m[maxRow][i] = value;
				value++;
			}
			for(int i = maxRow - 1; i > minRow; i--){
				m[i][minCol] = value;
				value++;
			}
			maxCol--;
			maxRow--;
			minCol++;
			minRow++;
		}
	
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m.length; j++){
				String z = "";
				if(m[i][j] < 10){z = "  ";}
				else if(m[i][j] >= 10 && m[i][j] < 100){z = " ";}
				System.out.print(z + m[i][j] + " ");
			}
			System.out.println();
		}
	}
}
