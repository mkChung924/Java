package com.coding.baekjun;

import java.util.Scanner;

public class DFSMaze2 {
	
	int map[][];
	int row, col, min;
	
	public DFSMaze2() {
		
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		min = row*col;
		
		map = new int[row][col];
		
		sc.nextLine();
		for(int i = 0; i < row; i++){
			String str = sc.nextLine();
			for(int j = 0; j < col; j++){
				String strs[] = str.split("");
				map[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
//		for(int i = 0; i < row; i++){
//			for(int j = 0; j < col; j++){
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		dfs(0,0,1);
		System.out.println(min);
		
	}
	
	public void dfs(int x, int y, int length){
		
		if(x == col-1 && y == row-1){
			if(min > length) min = length;
			return;
		}
		
		map[y][x] = 0;
		
		if(x < col-1 && map[y][x+1] == 1){//오른쪽
			dfs(x+1,y,length+1);
		}
		
		if(x > 0 && map[y][x-1] == 1){//왼쪽
			dfs(x-1,y,length+1);
		}
		
		if(y > 0 && map[y-1][x] == 1){//위
			dfs(x,y-1,length+1);
		}
		
		if(y < row-1 && map[y+1][x] == 1){//아래
			dfs(x,y+1, length+1);
		}
		
		map[y][x] = 1;
		
	}
	
	public static void main(String[] args) {
		new DFSMaze2();
	}

}
