package com.coding.algorithm;

public class Solution6Prac {
	
	public Solution6Prac() {
		
		int n = 6;
		
		int a[][] = new int[n][n];
		int count = n/n;
		
		for(int i = 0; i < n; i++){
			
			if(i%2 == 0){//짝수번지
				
				for(int j = 0; j <= i ; j++){
					//System.out.println(i);
					a[i-j][j] = count;
					count++;
				}
				
			} else {//홀수번지
				
				for(int j = i ; j >= 0; j--){
					//System.out.println(i);
					a[i-j][j] = count;
					count++;
				}		
			}
		}
		
		System.out.println("오른쪽 삼각형");
		count = n*n;
		
		if((n-2)%2 == 0){
			
			for(int i = n-1; i > 0; i--){
				
				if(i%2 == 0){//짝수로 시작할 때
					
					int o = 0;
					
					for(int j = i; j < n; j++){
						
						a[(n-1)-o][j] = count;
						o++;
						count--;
					}
					
		
				} else { //홀수로 시작할 때
					int o = 0;

					for(int j = n-1; j >= i; j--){
						a[i+o][j] = count;
						//2 4
						//3 3
						//4 2
						o++;
						count--;
					}
				}
				
			}
			
			
		} else {
		
		for(int i = n-1; i > 0; i--){
			
			if(i%2 == 0){//짝수로 시작할 때
				
				int o = 0;
				for(int j = n-1; j >= i; j--){
					a[i+o][j] = count;
					//2 4
					//3 3
					//4 2
					o++;
					count--;
				}
	
			} else { //홀수로 시작할 때
				int o = 0;
				
				for(int j = i; j < n; j++){
					
					a[(n-1)-o][j] = count;
					o++;
					count--;
				}
			}
			
		}
	}
	
		
		
		int b = 6;
		String c = "RRRDDD";
		
		String arr[] = new String[b];
		for(int i = 0; i < arr.length; i++){
			arr[i] = c.substring(i, i+1);
		}
		
		int x = 0;
		int y = 0;
		int total = 1;
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
			String move = arr[i];
			switch(move){
			case "D":
				
				x += 1;
				total += a[x][y];
				break;
				
			case "R":
				
				y+=1;
				total += a[x][y];
				
				break;
				
			case "U":
				
				x -= 1;
				total += a[x][y];
				
				break;
				
			case "L":
				
				y -= 1;
				total += a[x][y];
				
				break;
			}
		}
		
		System.out.println();
		System.out.println("total : " + total);

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				String z = "";
				if(a[i][j] < 10)  z = " ";
				System.out.print(z+ a[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new Solution6Prac();
	}

}
