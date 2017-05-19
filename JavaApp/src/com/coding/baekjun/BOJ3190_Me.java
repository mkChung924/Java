package com.coding.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Poos{
	int x,y;
	Poos(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ3190_Me {
	
	int map[][] = new int[101][101];
	int n;
	int appleNum;
	int moveNum;
	int x,y;
	
	public BOJ3190_Me() {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		appleNum = sc.nextInt();
		
		for(int i = 1; i <= appleNum; i++){
			x = sc.nextInt();
			y = sc.nextInt();
			map[x][y] = 2;
		}
		
		moveNum = sc.nextInt();
		
		Queue<Integer> timeCondition = new LinkedList<>();
		Queue<String> moveCondition = new LinkedList<>();
		
		for(int i = 1; i <= moveNum; i++){
			timeCondition.add(sc.nextInt());
			moveCondition.add(sc.nextLine());
		}
		
		LinkedList<Poos> q = new LinkedList<>();
		
		map[1][1] = 1;
		q.add(new Poos(1,1));
		
		int timeCon = timeCondition.poll();
		int movePoser = 0;
		int moveCount = 0;
		
		Poos moveCal[] = new Poos[4];
		
		moveCal[0] = new Poos(0,1);//오른쪽
		moveCal[1] = new Poos(1,0);//아래
		moveCal[2] = new Poos(0,-1);//왼쪽
		moveCal[3] = new Poos(-1,0);//위로
		
		int tmpX, tmpY;
		
//		for(int i = 1; i <= 6; i++){
//			for(int j = 1; j <=6; j++){
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
		
		
		while(true){
			
			if(timeCon == moveCount){
				
				if(moveCondition.peek().equals(" L")){
					if(movePoser <= 0) 
						movePoser = 3;
					else
						movePoser--;
				}
				
				if(moveCondition.peek().equals(" D")){
					if(movePoser >= 3){
						movePoser = 0;
					}else{
						
						movePoser++;
					}
				}
				
				if(!timeCondition.isEmpty() && !moveCondition.isEmpty()){
					
					timeCon = timeCondition.poll();
					moveCondition.poll();
				}
			}
			
			tmpX = q.peekLast().x + moveCal[movePoser].x;
			tmpY = q.peekLast().y + moveCal[movePoser].y;
			
			if(tmpX > n || tmpX < 1 || tmpY > n || tmpY < 1 || map[tmpX][tmpY] == 1){
				if(moveCount != 0)
					moveCount++;
				break;
			}
			else {
				q.add(new Poos(tmpX, tmpY));
				
				if(map[tmpX][tmpY] != 2){
					map[q.peekFirst().x][q.peekFirst().y] = 0;
					q.removeFirst();
				}
				
				map[tmpX][tmpY] = 1;
				moveCount++;
				
			}	
				
				
		}
		
		System.out.println(moveCount);
						
	}
		

	
	public static void main(String[] args) {
		new BOJ3190_Me();
	}

}
