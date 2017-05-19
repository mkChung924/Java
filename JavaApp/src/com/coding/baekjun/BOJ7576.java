package com.coding.baekjun;

import java.awt.Point;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class BOJ7576 {
	
	int tomato[][];
	int m,n,min;
	int count1, count2, count3;
	Map<Point, Integer> q;
	
	public BOJ7576() {
		
		q = new LinkedHashMap<Point, Integer>();
		
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		
		tomato = new int[n][m];
		min = m*n;
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				tomato[i][j] = sc.nextInt();
			}
		}
		
//		for(int i = 0; i < n; i++){
//			for(int j = 0; j < m; j++){
//				System.out.print(tomato[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		bfs(m-1,n-1,0);
	
	}
	
	public void bfs(int col, int row, int leng){
		
		q.put(new Point(col,row), leng);
		tomato[row][col] = 1;
//		System.out.println(col);
//		System.out.println(row);
		
		while(!q.isEmpty()){
			System.out.println("#"+(count2+1));

			Map.Entry<Point, Integer> entry = q.entrySet().iterator().next();
			Point p = entry.getKey();
			int length = entry.getValue();
			q.remove(p);
			
			if(p.x == 0 && p.y == 0){
				if(min > length) {
					min = length+1;
				}
				tomato[p.y][p.x] = 1;
				break;
			}
	
			tomato[p.y][p.x] = 1;
			
			//위로
			if(p.y > 0 && tomato[p.y-1][p.x] == 0){
				
				if(q.containsKey(new Point(p.x, p.y-1))){
					
				} else {
					q.put(new Point(p.x, p.y-1), length+1);
					System.out.println((p.x) +","+ (p.y-1));
					//tomato[p.y-1][p.x] = 1;
				}
			}
			
			//아래로
			if(p.y < n-1 && tomato[p.y+1][p.x] == 0){
				if(q.containsKey(new Point(p.x,p.y+1))){
					
				} else {
					q.put(new Point(p.x,p.y+1), length+1);
					System.out.println((p.x) +","+ (p.y+1));
					//tomato[p.y+1][p.x] = 1;
				}
			}
			
			//왼쪽
			if(p.x > 0 && tomato[p.y][p.x-1] == 0){
				
				if(q.containsKey(new Point(p.x-1,p.y))){
					
				} else {
					q.put(new Point(p.x-1,p.y), length+1);
					System.out.println((p.x-1) +","+ (p.y));
					//tomato[p.y][p.x-1] = 1;
				}
			}
			
			//오른쪽
			if(p.x < m-1 && tomato[p.y][p.x+1] == 0){
				
				if(q.containsKey(new Point(p.x+1,p.y))){
					
				} else {
					q.put(new Point(p.x+1,p.y), length+1);
					System.out.println((p.x+1) +","+ (p.y));
					//tomato[p.y][p.x+1] = 1;
				}
			}
			
			System.out.println("q: " + q.size());
			System.out.println("count1: "+count1);
			//int qSize = 0;
			if(count1 == 0) count1 = q.size();
			
			for(int i = 0; i < count1; i++){
				System.out.println("for 진입");
				
				Map.Entry<Point, Integer> entry2 = q.entrySet().iterator().next();
				Point p2 = entry2.getKey();
				int length2 = entry.getValue();
				q.remove(p2);
				int px = p2.x;
				int py = p2.y;
				System.out.println(px +","+ py);
				
				tomato[py][px] = 1;
				
				//위로
				if(py > 0 && tomato[py-1][px] == 0){
					//tomato[py-1][px] = 1;
					q.put(new Point(px,py-1), length2+1);
					System.out.println("q: "+px+","+(py-1));
				}
				
				//아래로
				if(py < n-1 && tomato[py+1][px] == 0){
					q.put(new Point(px,py+1), length2+1);
					System.out.println("q: "+px+","+(py+1));
				}
				
				//왼쪽
				if(px > 0 && tomato[py][px-1] == 0){
					q.put(new Point(px-1,py), length2+1);
					System.out.println("q: "+(px-1)+","+(py));
				}
				
				//오른쪽
				if(px < m-1 && tomato[py][px+1] == 0){
					q.put(new Point(px+1,py), length2+1);
					System.out.println("q: "+(px+1)+","+(py));

				}
				
			}
			count1 = q.size();
			count1--;
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					System.out.print(tomato[i][j]+" ");
				}
				System.out.println();
			}
			
			count2++;
		}
		
		System.out.println("min: " + min);
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				System.out.print(tomato[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		new BOJ7576();
	}

}
