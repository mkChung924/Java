package com.coding.baekjun;

import java.awt.Point;
import java.util.Map;
import java.util.Scanner;

public class BOJ14499_Dice {

	Map<Point, Integer> q;
	int map[][];
	int orders[], res[];
	int row, col, x, y, order;
	
	int diceH[] = new int[3];
	int diceV[] = new int[4];
	
	
	public BOJ14499_Dice() {
		
		Scanner sc = new Scanner(System.in);
		
		row = sc.nextInt();
		col = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		order = sc.nextInt();
		orders = new int[order];
		res = new int[order];
		
		map = new int[row][col];
		
		for(int i = 0 ; i < row ; i++){
			for(int j = 0; j< col; j++){
				int coord = sc.nextInt();
				map[i][j] = coord;
			}
		}
				
		for(int i = 0; i < order; i++){
			int dir = sc.nextInt();
			if(!diceIt(dir)){
				continue;
			}
			
			if(map[x][y] == 0){
				map[x][y] = getBottom();
			} else {
				setBottom(map[x][y]);
				map[x][y] = 0;
			}
			
			System.out.println(getTop());
		}
		
	}
	

	public boolean diceIt(int direction){
		
		switch(direction){
		
		case 1:
			
			if(y+1 >= col) return false;
			y = y+1;
			diceEast();
			
			break;
			
		case 2:
			
	
			if(y-1 < 0) return false;
			y = y-1;
			diceWest();
			break;
			
		case 3:
			
			if(x-1 < 0) return false;
			x = x-1;
			diceNorth();
			
			break;
			
			
		case 4:
			
			if(x+1 >= row) return false;
			x = x+1;
			diceSouth();
			
			break;
		}
		
		return true;
	}
	

	public void diceEast(){
		int temp = diceH[2];
		for(int i = 2; i > 0; i--){
			diceH[i] = diceH[i-1];
		}
		
		diceH[0] = diceV[3];
		diceV[3] = temp;
		diceV[1] = diceH[1];
		
	}
	
	public void diceWest(){
		int temp = diceH[0];
		for(int i = 0 ; i < 2; i++){
			diceH[i] = diceH[i+1];
		}
		
		diceH[2] = diceV[3];
		diceV[3] = temp;
		diceV[1] = diceH[1];
		
	}
	
	public void diceNorth(){
		int temp = diceV[0];
		for(int i = 0; i < 3 ; i++){
			diceV[i] = diceV[i+1];
		}
		
		diceV[3] = temp;
		diceH[1] = diceV[1];
		
	}
	
	public void diceSouth(){
		int temp = diceV[3];
		for(int i = 3; i > 0 ; i--){
			diceV[i] = diceV[i-1];
		}
		
		diceV[0] = temp;
		diceH[1] = diceV[1];
	}
	
	public int getTop(){
		
		return diceV[1];
	}
	
	public int getBottom(){
		
		return diceV[3];
	}
	
	public void setBottom(int r){
		
		diceV[3] = r;
	}
	public static void main(String[] args) {
		new BOJ14499_Dice();
	}
}
