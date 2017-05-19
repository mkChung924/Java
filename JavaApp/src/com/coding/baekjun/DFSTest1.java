package com.coding.baekjun;

import java.util.Scanner;

public class DFSTest1 {
	
	boolean isVisited[];
	int adjacentMatrix[][];
	int point;
	int way;
	
	public DFSTest1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정점의 수와 간선의 수 설정");
		point = sc.nextInt();
		way = sc.nextInt();
		
		isVisited = new boolean[point];
		adjacentMatrix = new int[point][point];
		
		for(int i = 0; i < way; i++){
			System.out.println("간선 설정");
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjacentMatrix[from-1][to-1] = 1;
		}
		dfs(1);
		
//		for(int i = 0; i < isVisited.length; i++){
//			System.out.print(isVisited[i] +" ");
//		}
//		
//		System.out.println();
//		
//		for(int i = 0; i < point; i++){
//			for(int j = 0; j < point; j++){
//				System.out.print(adjacentMatrix[i][j]+ " ");
//			}
//			System.out.println();
//		}

		
	}
	
    public void dfs(int v){
    	isVisited[v-1] = true;
        for(int i=1;i<= point;i++)
        {
        	
            if(adjacentMatrix[v-1][i-1] == 1 && !isVisited[i-1]){
                System.out.println(v + " 에서 " + i + " 로 이동");
                dfs(i);
                
            }
            System.out.println("v : " + v + ", i: " +i);
            
        }
         
    }
    
    

	public static void main(String[] args) {
		new DFSTest1();
	}

}
