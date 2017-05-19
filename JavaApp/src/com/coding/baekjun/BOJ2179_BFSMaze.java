package com.coding.baekjun;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2179_BFSMaze {
	
	int map[][];
	int row, col, min;
	Map<Point, Integer> q;
	
	public BOJ2179_BFSMaze() {
		
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		map = new int[row][col];
		min = row*col;
		
		sc.nextLine();
		for(int i = 0; i < row; i++){
			
			String st = sc.nextLine();
			for(int j = 0; j < col; j++){
				String str[] = st.split("");
				map[i][j] = Integer.parseInt(str[j]);
				
			}
		}
		
		bfs(0,0,1);
		System.out.println(min);
		
	}
	
	public void bfs(int x, int y, int length){
		
		q = new LinkedHashMap<>();
		map[y][x] = 1;
		q.put(new Point(x,y), length);
		
		while(!q.isEmpty()){
			
			Map.Entry<Point, Integer> entry = q.entrySet().iterator().next();
			Point p = entry.getKey();
			int leng = entry.getValue();
			int px = p.x;
			int py = p.y;
			q.remove(p);
			
			map[py][px] = 0;
			
			if(px == col-1 && py == row-1){
				if(min > leng) min = leng;
				return;
			}
			
			if(px < col-1 && map[py][px+1] == 1){//¿À¸¥ÂÊ
				q.put(new Point(px+1,py), leng+1);
			}
			
			if(px > 0 && map[py][px-1] == 1){//¿ÞÂÊ
				q.put(new Point(px-1,py), leng+1);
			}
			
			if(py > 0 && map[py-1][px] == 1){
				q.put(new Point(px,py-1), leng+1);
			}
			
			if(py < row-1 && map[py+1][px] == 1){
				q.put(new Point(px,py+1), leng+1);
			}
			
		}
		
	}

	
	public static void main(String[] args) {
		new BOJ2179_BFSMaze();
	}
    

}

