package com.coding.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSTest {
	
	int map[][];
	int visit[];
	
	int point, way;
	
	public BFSTest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �� �Է�: ");
		point = sc.nextInt();
		System.out.println("������ �� �Է�: ");
		way = sc.nextInt();
		map = new int[point+1][point+1];
		visit = new int[point+1];
		
		for(int i = 0; i < way; i++){
			System.out.println("���� ����");
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = map[to][from] = 1;
			
		}
		
		bfs(1);
		
	}
	
	public void bfs(int v){
		Queue<Integer> q = new LinkedList<>();
		visit[v] = 1;
		q.offer(v);
		
		while(!q.isEmpty()){
			
			q.poll();
			for(int i = 1; i <= point; i++){
				
				if(map[v][i] == 1 && visit[i] == 0){
					System.out.println(v+"���� "+i+"�� �̵�");
					visit[i] = 0;
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
