package com.kosta.j0228;

public class HWGuGuDan {
	
	public static void main(String args[]){
		
		int mult;
		
		for(int i = 1; i < 10; i++){
			for(int j = 1; j < 10; j++){
				mult = j*i;
				String zero = "";
				if(mult < 10) zero = " ";
				System.out.print(j + "x" + i + " = " + zero + mult + "  ");
			}
			System.out.println();
		}
		
	}

}
