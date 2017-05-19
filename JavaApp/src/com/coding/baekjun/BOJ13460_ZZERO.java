package com.coding.baekjun;

import java.io.IOException;
import java.util.Scanner;


public class BOJ13460_ZZERO {

    // map info
	final int WALL = -1;
	final int HOLE = -10;
	final int BLANK = 0;
	final int LIMIT = 10;
	
	int map[][] = new int[11][11];
	int dp[][][][][] = new int[11][11][11][11][11];
   
    // direction
	final int LEFT = 0;
	final int UP = 1;
	final int RIGHT = 2;
	final int DOWN = 3;

    // result
	
	final int NONE = 0;
	final int SUCC = 1;
	final int FAIL = 2;
	
	int ret = NONE;
	int INF = 100;
	
	int N,M;
	
	public BOJ13460_ZZERO() {
		
		int rRow = -1, rCol = -1;
		int bRow = -1, bCol = -1;
    	
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	
    	sc.nextLine();
    	for(int i = 0; i < N; i++){
    		String maze = sc.nextLine().trim();
    		
    		for(int j = 0; j < M; j++){
    			
    			char ch = maze.charAt(j);
    			
    			switch(ch){
    			
    			case '#':
    				map[i][j] = WALL;
    				
    				break;
    				
    				
    			case '.':
    				map[i][j] = BLANK;
    				
    				break;
    				
    				
    			case 'R':
    				map[i][j] = BLANK;
    				rRow = i;
    				rCol = j;
    				
    				break;
    				
    			case 'B':
    				map[i][j] = BLANK;
    				bRow = i;
    				bCol = j;
    				
    				break;
    				
    				
    			case 'O':
    				map[i][j] = HOLE;
    				
    				break;
    			}
	
    		}
    	}//for
    	
    	
    	//solve
    	dfs(rRow,rCol,bRow,bCol,0);
    	
    	if(dp[rRow][rCol][bRow][bCol][0] > LIMIT){
    		System.out.println(-1);
    	} else {
    		System.out.println(dp[rRow][rCol][bRow][bCol][0]);
    	}
    	
        //System.out.println(dp[rRow][rCol][bRow][bCol][0] > LIMIT ? -1 : dp[rRow][rCol][bRow][bCol][0]);

    	
	}
	public int dfs(int rRow, int rCol, int bRow, int bCol, int step){
		
		int temp = INF;
		
		//memoization
		if(dp[rRow][rCol][bRow][bCol][step] > 0){
			return dp[rRow][rCol][bRow][bCol][step];
		}
		
		//종료
		if(step >= LIMIT){
			
			return dp[rRow][rCol][bRow][bCol][step] = INF;
		}
		
		for(int direction = 0; direction < 4; direction++){
			
			PointInfo2 info = action(rRow, rCol, bRow, bCol, direction);
			
			if(ret > 0){
				
				if(ret == SUCC){
					
					ret = NONE;
					dp[info.rRow][info.rCol][info.bRow][info.bCol][step + 1] = step + 1;
					
					return dp[rRow][rCol][bRow][rCol][step] = step +1;
					
				} else {
					
					ret = NONE;
					
					dp[rRow][rCol][bRow][rCol][step + 1] = INF;
					continue;
				}
			}
			
			temp = Math.min(temp, dfs(info.rRow, info.rCol, info.bRow, info.bCol, step + 1));
		}
		
		
		return dp[rRow][rCol][bRow][bCol][step] = temp;
		
	}
	
	public PointInfo2 action(int rRow, int rCol, int bRow, int bCol, int dir){
		
		PointInfo2 init = new PointInfo2(rRow, rCol, bRow, bCol);
		
		switch(dir){
		
		case LEFT:
			
			//red
			while(map[rRow][rCol - 1] != WALL){
				
				rCol--;
				
				if(map[rRow][rCol] == HOLE){
					
					//ret = ret > NONE ? ret : SUCC;
					if(ret <= NONE) ret = SUCC;
					
					break;
				}
				
			}
			
			//blue
			while(map[bRow][bCol - 1] != WALL){
				bCol--;
				
				if(map[bRow][bCol] == HOLE){
					
					ret = FAIL;
					break;
				}
			}
			
			//red와 blue가 같은 위치일때
			if(ret == NONE && rRow == bRow && rCol == bCol){
				if(init.rCol < init.bCol){
					bCol++;
				} else {
					rCol++;
				}
			}
			
			break;
			
		case UP:
			
			while(map[rRow - 1][rCol] != WALL){
				
				rRow--;
				
				if(map[rRow][rCol] == HOLE){
					
					//ret = ret > NONE ? ret : SUCC;
					if(ret <= NONE) ret = SUCC;
					break;
				}
			}
			
			while(map[bRow - 1][bCol] != WALL){
				bRow--;
				
				if(map[bRow][bCol] == HOLE){
					ret = FAIL;
					break;
				}
			}
			
			if(ret == NONE && rRow == bRow && rCol == bCol){
				
				if(init.rRow < init.bRow){
					bRow++;
				} else {
					rRow++;
				}
			}
			
			break;
			
		case RIGHT:
			
			while(map[rRow][rCol + 1] != WALL){
				rCol++;
				
				if(map[rRow][rCol] == HOLE){
					
					//ret = ret > NONE ? ret : SUCC;
					if(ret <= NONE) ret = SUCC;
					break;
				}
			}
			
			while(map[bRow][bCol + 1] != WALL){
				bCol++;
				
				if(map[bRow][bCol] == HOLE){
					ret = FAIL;
					break;
				}
			}
			
			if(ret == NONE && rRow == bRow && rCol == bCol){
				if(init.rCol < init.bCol){
					rCol--;
				} else {
					bCol--;	
				}
			}
			
			break;
			
			
		case DOWN:
			
			while(map[rRow + 1][rCol] != WALL){
				rRow++;
				
				if(map[rRow][rCol] == HOLE){
					
					//ret = ret > NONE ? ret : SUCC;
					if(ret <= NONE) ret = SUCC;
					break;
				}
			}
			
			while(map[bRow + 1][bCol] != WALL){
				
				bRow++;
				
				if(map[bRow][bCol] == HOLE){
					ret = FAIL;
					break;
				}
			}
			
			if(ret == NONE && rRow == bRow && rCol == bCol){
				if(init.rRow < init.bRow){
					rRow--;
				} else {
					bRow--;
				}
			}
			
			break;
		}
		
		return new PointInfo2(rRow, rCol, bRow, bCol);
	}

    public static void main(String[] args){
    	new BOJ13460_ZZERO();


    } // main
}


class PointInfo2 {

    int rRow, rCol, bRow, bCol;

    PointInfo2(int rRow, int rCol, int bRow, int bCol) {

        this.rRow = rRow;
        this.rCol = rCol;
        this.bRow = bRow;
        this.bCol = bCol;
    }
}
