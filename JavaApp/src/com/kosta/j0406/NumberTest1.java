package com.kosta.j0406;

public class NumberTest1 {
	
	public NumberTest1() {

		System.out.println("첫번째");
		for(int i = 6; i > 0; i--){
			
			for(int k = i; k > 1; k--){
				System.out.print("  ");
			}
			
			for(int j = 6; j > i-1; j--){
				System.out.print(j-i+1 +" ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println("첫번째 배열");
		
		int x = 6;
		String array[][] = new String[x][x];
		
		for(int i = array.length-1; i >= 0; i--){
			for(int j = array.length-1; j >= array.length-1-i; j--){
				array[i][j] = array.length-j+"";
				
			}
		}
			
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length; j++){
				if(array[i][j] == null) array[i][j] = " ";
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("두번째");
		
		for(int i = 0 ; i < 6; i++){
			
			for(int j = 1; j < i+1; j++){
				System.out.print("  ");
			}
			
			for(int k = 1; k <= 6-i; k++){
				System.out.print(k + " ");
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println("두번째 배열");
		String arrays[][] = new String[x][x];

		for(int i = 0; i < arrays.length; i++){
			for(int j = i; j < arrays.length; j++){
				arrays[i][j] = j-i+1+"";
			}
		}
		
		for(int i = 0; i < arrays.length; i++){
			for(int j = 0; j < arrays.length; j++){
				if(arrays[i][j] == null) arrays[i][j] = " ";
				System.out.print(arrays[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("세번째");
		
		for(int i = 0; i < 6; i++){
			
			for(int k = 6-i ; k > 1; k-- ){
				System.out.print("   ");
			}
			for(int j = i*i+1; j <= i*(i+2)+1; j++){
				String zero = "";
				if(j < 10) zero = " ";
				System.out.print(zero + j + " ");
			}
			
			System.out.println();
	
		}
	
		
	}

	public static void main(String[] args) {
		new NumberTest1();
	}
}
