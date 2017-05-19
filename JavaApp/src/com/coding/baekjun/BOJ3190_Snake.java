package com.coding.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos1 {
	int x;
	int y;
	
	Pos1(int x, int y) {
		this.x = x; 
		this.y = y;
		}
}

public class BOJ3190_Snake {
	
	int map[][] = new int[101][101];
	int N;
	int appleNum;
	int moveNum;

	
	
	public BOJ3190_Snake() {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		appleNum = sc.nextInt();
		
		for(int i = 1; i <= appleNum; i++){
			int row = sc.nextInt();
			int col = sc.nextInt();
			map[row][col] = 2;
		}
		
		Queue<Integer> timeCondition = new LinkedList<>();
		Queue<String> moveCondition = new LinkedList<>();
		
		moveNum = sc.nextInt();
		
		for(int i = 0; i < moveNum; i++){
			timeCondition.add(sc.nextInt());
			moveCondition.add(sc.nextLine().trim());
		}
		
		int timeCon = timeCondition.poll();
		int movePoser = 0;
		int moveCount = 0; 
		
		Pos1 moveCal[] = new Pos1[4];
		moveCal[0] = new Pos1(0,1);
		moveCal[1] = new Pos1(1,0);
		moveCal[2] = new Pos1(0,-1);
		moveCal[3] = new Pos1(-1,0);
		
		map[1][1] = 1;
		LinkedList<Pos1> q = new LinkedList<>();
		q.add(new Pos1(1,1));
		
		int tmpX, tmpY;
		
		while(true){
			
			if(moveCount == timeCon){
				
				if(moveCondition.peek().equals("L")){
					if(movePoser <= 0)
						movePoser = 3;
					else
						movePoser--;
				}
				
				if(moveCondition.peek().equals("D")){
					if(movePoser >= 3)
						movePoser = 0;
					else
						movePoser++;
					
				}
				
				if(!timeCondition.isEmpty() && !moveCondition.isEmpty()){
					timeCon = timeCondition.poll();
					moveCondition.poll();
				}
			}
			
			tmpX = q.peekLast().x + moveCal[movePoser].x;
			tmpY = q.peekLast().y + moveCal[movePoser].y;
			
			
			if(tmpX > N || tmpX < 1 || tmpY > N || tmpY < 1 || map[tmpX][tmpY] == 1){
				if(moveCount!=0)
					moveCount++;
				break;
				
			} else {
				q.add(new Pos1(tmpX, tmpY));
				
				if(map[tmpX][tmpY] != 2){
					map[q.peekFirst().x][q.peekFirst().y] = 0;
					q.pollFirst();
				}
				
				map[tmpX][tmpY] = 1;
				moveCount++;
				
				
			}
			
			
		}
		System.out.println(moveCount);
		
	}
	
	public static void main(String[] args) {
		new BOJ3190_Snake();
	}

}
