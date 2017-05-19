package com.coding.baekjun;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
	

	int map[][];
	int row, col, min;
	Map<Point, Integer> hs;
	
	public BOJ2178() {
		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();
		
		map = new int[row][col];
		min = row*col;
		hs = new LinkedHashMap<Point, Integer>();
		
		sc.nextLine();
		for(int i = 0; i < row; i++){
			String line = sc.nextLine();
			String lines[] = line.split("");
			for(int j = 0; j < col; j++){
				map[i][j] = Integer.parseInt(lines[j]);
						
			}
		}
		sc.close();
		bfs(0,0,1);
		System.out.println(min);
	}
	
	public void bfs(int x, int y, int leng){
		
		hs.put(new Point(x,y), leng);
		map[y][x] = 1;
	
		while(!hs.isEmpty()){
			
			 Map.Entry<Point,Integer> entry=hs.entrySet().iterator().next();
			 Point p1 = entry.getKey();
			 int count = entry.getValue();
			 hs.remove(p1);
						
			if(p1.x == col -1 && p1.y == row - 1){
				if(min > count) {
					min = count;
				}
				break;
			}
			
			map[p1.y][p1.x] = 0;

			if(p1.x > 0 && map[p1.y][p1.x-1] == 1){
				
				if(hs.containsKey(new Point(p1.x-1, p1.y))){
					
				} else {
					hs.put(new Point(p1.x-1, p1.y), count+1);
				}
				
		
			}
			
			if(p1.x < col-1 && map[p1.y][p1.x+1] == 1){
				
				if(hs.containsKey(new Point(p1.x+1, p1.y))){
					
				} else {
					hs.put(new Point(p1.x+1, p1.y), count+1);
				}

			}
			
			if(p1.y > 0 && map[p1.y-1][p1.x] == 1){
				
				if(hs.containsKey(new Point(p1.x, p1.y-1))){
					
				} else {
					hs.put(new Point(p1.x, p1.y-1), count+1);
				}
				
			}
			
			if(p1.y < row-1 && map[p1.y+1][p1.x] == 1){
				
				if(hs.containsKey(new Point(p1.x, p1.y+1))){
					
				} else {
					hs.put(new Point(p1.x, p1.y+1), count+1);
				}
						
			}
		}
	}
	
	public static void main(String[] args) {
		new BOJ2178();
	}
    

}

