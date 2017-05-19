package com.coding.baekjun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
	int x;
	int y;
	Pos(int x, int y) {
		this.x = x; 
		this.y = y;
		}
}

public class BOJ3190 {
	
	static int[][] board = new int[101][101];	// 0:아무것도 없음 1: 뱀 부위, 2:사과 
	static int N;
	
	public BOJ3190() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int AppleNum = sc.nextInt();
		int x; int y; 
		
		// 사과 위치 입력
		for(int i=1; i<=AppleNum; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			board[x][y] = 2;
		}
		
		int conNum = sc.nextInt();
		
		// 위치 이동 시간 + 좌/우 입력
		Queue <Integer> timeCondition = new LinkedList<Integer>();
		Queue <String> moveCondition = new LinkedList<String>();
		
		for(int i=1; i<=conNum; i++) {
			timeCondition.add(sc.nextInt());
			moveCondition.add(sc.nextLine());
		}
		
		LinkedList <Pos> q = new LinkedList<Pos>();
		
		board[1][1] = 1;
		q .add(new Pos(1,1));
		
		int timecon = timeCondition.poll();
		int movePoser = 0;	//0: 오른, 1:아래, 2:왼, 3:위
		int moveCount = 0;
		Pos[] moveCal = new Pos[4];  // 0: 오른, 1:아래, 2:왼, 3:위
		
		moveCal[0] = new Pos(0,1);	// 오른
		moveCal[1] = new Pos(1,0);	// 아래
		moveCal[2] = new Pos(0,-1);	// 왼쪽
		moveCal[3] = new Pos(-1,0);	// 위
		
		int tmpX, tmpY;
		
		while(true) {
			
			if(timecon == moveCount) {
				// 좌/우 변경 시간
				if(moveCondition.peek().equals(" L")) {
					if(movePoser <= 0)
						movePoser = 3;
					else
						movePoser--;
				}
				
				if(moveCondition.peek().equals(" D")) {
					if(movePoser >= 3)
						movePoser = 0;
					else
						movePoser++;
				}
				
				if(timeCondition.isEmpty()==false && moveCondition.isEmpty()==false) {
					timecon = timeCondition.poll();
					moveCondition.poll();
				}
			}
			
			tmpX = q.peekLast().x + moveCal[movePoser].x;
			tmpY = q.peekLast().y + moveCal[movePoser].y;
			
			
			// NxN 넘었을 경우
			if(tmpX > N || tmpX < 1 || tmpY > N || tmpY < 1 || board[tmpX][tmpY] == 1) {
				if(moveCount!=0)
					moveCount++;
				break;
			}
			else {
				q .add(new Pos(tmpX,tmpY));
				
				if(board[tmpX][tmpY] != 2) {
					board[q.peekFirst().x][q.peekFirst().y] = 0;
					q.removeFirst();
				}
				
				board[tmpX][tmpY] = 1;
				moveCount++;
			}	
		}

		System.out.println(moveCount);
	}
	
	public static void main(String[] args) {
		new BOJ3190();
	}

}
