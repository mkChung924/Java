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
	
	static int[][] board = new int[101][101];	// 0:�ƹ��͵� ���� 1: �� ����, 2:��� 
	static int N;
	
	public BOJ3190() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		int AppleNum = sc.nextInt();
		int x; int y; 
		
		// ��� ��ġ �Է�
		for(int i=1; i<=AppleNum; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			board[x][y] = 2;
		}
		
		int conNum = sc.nextInt();
		
		// ��ġ �̵� �ð� + ��/�� �Է�
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
		int movePoser = 0;	//0: ����, 1:�Ʒ�, 2:��, 3:��
		int moveCount = 0;
		Pos[] moveCal = new Pos[4];  // 0: ����, 1:�Ʒ�, 2:��, 3:��
		
		moveCal[0] = new Pos(0,1);	// ����
		moveCal[1] = new Pos(1,0);	// �Ʒ�
		moveCal[2] = new Pos(0,-1);	// ����
		moveCal[3] = new Pos(-1,0);	// ��
		
		int tmpX, tmpY;
		
		while(true) {
			
			if(timecon == moveCount) {
				// ��/�� ���� �ð�
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
			
			
			// NxN �Ѿ��� ���
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
