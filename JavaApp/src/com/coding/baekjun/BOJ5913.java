package com.coding.baekjun;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BOJ5913 {
	
	Map<Point,Integer> q;
	Map<Point,Integer> q1;
	int wall, row, col, count, min, length;
	int map[][] = new int[6][6];
	
	public BOJ5913() {
		
		q = new LinkedHashMap<>();
		q1 = new LinkedHashMap<>();
		
		Scanner sc = new Scanner(System.in);
		wall = sc.nextInt();
		min = 25;
		
		for(int i = 1; i <= wall; i++){
			row = sc.nextInt();
			col = sc.nextInt();
			map[row][col] = 1;
		}
		
//		for(int i = 1; i <=5; i++){
//			for(int j = 1; j <=5; j++){
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}	
//		q.put(new Point(1,2), new Point(2,3));

		bfs(1,1,5,5,1);
		System.out.println(count);
	}
	
	public void bfs(int x, int y, int x1, int y1, int leng){
		
		q.put(new Point(x,y), leng);
		q1.put(new Point(x1,y1), leng);
		
		map[x][y] = map[x1][y1] = 1;
		length = leng;
		
		while(!q.isEmpty() && !q1.isEmpty()){
						
			Map.Entry<Point, Integer> entry = q.entrySet().iterator().next();
			Point p = entry.getKey();
			int length = entry.getValue();
			
			Map.Entry<Point, Integer> entry2 = q1.entrySet().iterator().next();
			Point p2 = entry2.getKey();
			int length2 = entry.getValue();
			
			q.remove(p);
			q1.remove(p2);
			
			int px = p.x;
			int py = p.y;
			int p2x = p2.x;
			int p2y = p2.y;
					
			if(px == p2x && py == p2y){
				if(min > (length+length2)){
					min = length+length2;
					count++;
				}
			}
			
			map[px][py] = 1;
			map[p2x][p2y] =1;
			
			if(py < 5 && map[px][py+1] == 0){
				q.put(new Point(px,py+1), length+1);
			}
			
			if(py > 1 && map[px][py-1] == 0){
				q.put(new Point(px, py-1), length+1);
			}
			
			if(px < 5 && map[px+1][py] == 0){
				q.put(new Point(px+1, py), length+1);
			}
			
			if(px > 1 && map[px-1][py] == 0){
				q.put(new Point(px-1, py), length+1);
			}
			
			if(p2y < 5 && map[p2x][p2y+1] == 0){
				q1.put(new Point(p2x,p2y+1), length2+1);
			}
			
			if(p2y > 1 && map[p2x][p2y-1] == 0){
				q1.put(new Point(p2x, p2y-1), length2+1);
			}
			
			if(p2x < 5 && map[p2x+1][p2y] == 0){
				q1.put(new Point(p2x+1, p2y), length2+1);
			}
			
			if(p2x > 1 && map[p2x-1][p2y] == 0){
				q1.put(new Point(p2x-1, p2y), length2+1);
			}
			
			for(int i = 1; i <=5; i++){
				for(int j = 1; j <=5; j++){
					System.out.print(map[i][j]+ " ");
				}
			System.out.println();
		}	
			
			
		}
		
		
	}
	
	public static void main(String[] args) {
		new BOJ5913();
	}

}
