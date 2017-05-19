package com.coding.baekjun;

import java.util.Scanner;

public class DFSMaze {
	
	int map[][];
	int row, col, min;
	
	public DFSMaze() {
		
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		
		map = new int[row+1][col+1];
		min = row*col;
		
		sc.nextLine();
		for(int i = 0; i < row; i++){
			String line = sc.nextLine();
			String lines[] = line.split("");
			for(int j = 0; j < col; j++){
				map[i][j] = Integer.parseInt(lines[j]);
				
			}
		}
		
		dfs(0,0,1);
		System.out.println(min);
		
		
	}
	
	public void dfs(int x, int y, int length){
		
		if(x == col - 1 && y == row -1){
			if(min > length) min = length;
			return;
		}
		
		map[y][x] = 0;
		
		if(x > 0 && map[y][x-1] == 1){ //왼쪽
			dfs(x-1, y, length+1);
		}
		
		if(x < col && map[y][x+1] == 1){ //오른쪽
			dfs(x+1, y, length+1);
		}
		
		if(y > 0 && map[y-1][x] == 1){ //위로
			dfs(x, y-1, length+1);
		}
		
		if(y < row && map[y+1][x] == 1){ //아래로
			dfs(x, y+1, length+1);
		}
		
		map[y][x] = 1;
		
	}
	
	public static void main(String[] args) {
		new DFSMaze();
	}

}
