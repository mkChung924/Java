package com.coding.baekjun;

import java.util.Scanner;

public class DFSMazeTest {
	
	int map[][];
	int size;
	int min;
	
	public DFSMazeTest() {
		
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		map = new int[size+1][size+1];
		min = size * size;
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,1);
		
		System.out.println("최소 거리: " + min);
	
	}
	
	public void dfs(int x, int y, int length){

		if(x == size -1 && y == size -1){
			if(min > length) min = length;
			return;
		}
		
		map[y][x] = 0;
		
		if(x > 0 && map[y][x-1] == 1){//왼쪽
			dfs(x-1, y, length+1);
		}
		
		if(x < size && map[y][x+1] == 1){//오른쪽
			dfs(x+1, y, length+1);
		}
		
		if(y > 0 && map[y-1][x] == 1){//위로
			dfs(x, y-1, length+1);
		}
		
		if(y < size && map[y+1][x] == 1){//아래로
			dfs(x, y+1, length+1);
		}
			
		map[y][x] = 1;
		
	}
	
	public static void main(String[] args) {
		new DFSMazeTest();
	}

}
