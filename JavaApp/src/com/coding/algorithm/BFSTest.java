package com.coding.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTest {
	
	int map[][];
	boolean isVisited[];
	int point, way;
	
	public BFSTest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정점과 간선의 수 결정");
		point = sc.nextInt();
		way = sc.nextInt();
		
		map = new int[point+1][point+1];
		isVisited = new boolean[point+1];
		
		for(int i = 0; i < way; i++){
			System.out.println("간선 결정");
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = map[to][from] = 1;
			
		}
		
		bfs(1);
		
		
	}
	
	public void bfs(int v){
		Queue<Integer> q = new LinkedList<>();
		isVisited[v] = true;
		q.offer(v);
		
		if(q.isEmpty()){
			return;
		} else {
			
			q.poll();
			for(int i = 1; i <= point; i++){
				
				if(map[v][i] == 1 && isVisited[i] == false){
					System.out.println(v+"에서 "+i+"로 이동");
					isVisited[i] = false;
					q.offer(i);
					bfs(i);
				}
			}
			
		}
		

		
	}
	
	public static void main(String[] args) {
		new BFSTest();
	}

}
