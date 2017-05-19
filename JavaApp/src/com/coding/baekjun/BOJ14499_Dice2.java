package com.coding.baekjun;

import java.util.Scanner;

public class BOJ14499_Dice2 {
	
	int map[][];
	int row, col, x, y, order;
	int orders[];
	
	int diceH[] = new int[3];
	int diceV[] = new int[4];

	public BOJ14499_Dice2() {
		
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		order = sc.nextInt();
		
		map = new int[row][col];
		orders = new int[order];
		
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < order; i++){
			int dir = sc.nextInt();
			
			if(!diceIt(dir)){
				continue;
				
			} else {
				if(map[x][y] == 0){
					map[x][y] = getBottom();
				} else {
					setBottom(map[x][y]);
					map[x][y] = 0;
				}
			}
			System.out.println(getTop());
		}
		
		
	}
	
	public boolean diceIt(int direction){
		
		switch(direction){
		
		case 1:
			if(y+1 >= col) return false;
			y = y+1;
			right();
			
			break;
			
		case 2:
			if(y-1 < 0) return false;
			y = y-1;
			left();
			
			break;
			
		case 3:
			if(x-1 < 0) return false;
			x = x-1;
			up();
			
			break;
		case 4:
			if(x+1 >= row) return false;
			x = x+1;
			down();
			
			break;
			
		}
		return true;
	}
	
	public void up(){
		
		int temp = diceV[0];
		for(int i = 0; i < 3; i++){
			diceV[i] = diceV[i+1];
		}
		
		diceH[1] = diceV[1];
		diceV[1] = temp;
		
	}
	
	public void down(){
		
		int temp = diceV[3];
		for(int i = 3; i > 0 ; i--){
			diceV[i] = diceV[i-1];
		}
		diceH[1] = diceV[1];
		diceV[0] = temp;
		
	}
	
	public void right(){
		
		int temp = diceH[2];
		for(int i = 2; i > 0; i--){
			
			diceH[i] = diceH[i-1];
			
		}
		diceH[0] = diceV[3];
		diceV[3] = temp;
		diceV[1] = diceH[1];
	}
	
	public void left(){
		
		int temp = diceH[0];
		for(int i = 0; i < 2; i++){
			diceH[i] = diceH[i+1];
		}
		
		diceH[2] = diceV[3];
		diceV[3] = temp;
		diceV[1] = diceH[1];
		
	}
	
	public int getTop(){
		
		return diceH[1];
	}
	
	public void setBottom(int r){
		
		diceV[3] = r;
		
	}
	
	public int getBottom(){
		
		return diceV[3];
		
	}
	
	public static void main(String[] args) {
		new BOJ14499_Dice2();
	}
}
