package acom.sds.samsung;

import java.util.Scanner;

public class FrogJump {
	
	
	
	public FrogJump() {
		
		Scanner sc = new Scanner(System.in);
		
		int numStone;
		int stones[];
		int maxJump;
		int frog = 0;
		int candi = 0;
		int move = 0;
		
		numStone = sc.nextInt();
		stones = new int[numStone];
		for(int i = 0; i < numStone; i++){
			stones[i] = sc.nextInt();
		}
		maxJump = sc.nextInt();
		
		for(int i = 0; i < stones.length; i++){
			System.out.println(i);
			
			if((stones[i]-frog) <= maxJump){
				candi = stones[i];
				if(i+1 == stones.length){
					move++;
				}
			} else if(candi > frog){
				//System.out.println("candi: "+candi);
				frog = candi;
				move++;
				i--;
			} else {
				move--;
				break;
			}
			//System.out.println("move: " + move);
		}
		
		System.out.println("move: "+move);
		
		
	}
	
	public static void main(String[] args) {
		new FrogJump();
	}

}
