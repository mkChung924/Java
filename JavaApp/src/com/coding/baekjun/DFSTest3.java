package com.coding.baekjun;

import java.util.Scanner;

public class DFSTest3 {
	
	int point, way;
	int map[][];
	int visit[];
	
	public DFSTest3() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �� �Է�: ");
		point = sc.nextInt();
		System.out.println("������ �� �Է�: ");
		way = sc.nextInt();
		
		map = new int[point+1][point+1];
		visit = new int[point +1];
		
		for(int i = 0 ; i < way; i++){
			System.out.println("���� ����");
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = map[to][from] = 1;
		}
		
		dfs(1);
		
	}
	
	public void dfs(int start){
		
		visit[start] = 1;
		
		for(int i = 1; i <= point; i++){
				
			if(map[start][i] == 1 && visit[i] == 0){
				System.out.println(start +" ���� " + i);
				dfs(i);
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new DFSTest3();
	}

}
