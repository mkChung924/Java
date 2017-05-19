package acom.sds.samsung;

import java.util.Scanner;

public class Solution6 {
	int o;
	String move;
	
	public Solution6() {
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
        
			int n = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine();
			String order = sc.nextLine();
			
			String arr[] = new String[k];
			for(int i = 0; i < k; i++){
				arr[i] = order.substring(i,i+1);
			}
			
			
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
			
			count = n*n;
			
			if((n-2)%2 == 0){
				
				for(int i = n-1; i > 0; i--){
					
					if(i%2 == 0){//짝수로 시작할 때
						
						o = 0;
						
						for(int j = i; j < n; j++){
							
							a[(n-1)-o][j] = count;
							o++;
							count--;
						}
						
			
					} else { //홀수로 시작할 때
						o = 0;

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
					
					o = 0;
					for(int j = n-1; j >= i; j--){
						a[i+o][j] = count;
						//2 4
						//3 3
						//4 2
						o++;
						count--;
					}
		
				} else { //홀수로 시작할 때
					o = 0;
					
					for(int j = i; j < n; j++){
						
						a[(n-1)-o][j] = count;
						o++;
						count--;
					}
				}
				
			}
		}
			
			int x = 0;
			int y = 0;
			int total = 1;
			for(int i = 0; i < arr.length; i++){
				
				move = arr[i];
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
        
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(total);
			
		}
		
	}
	
	public static void main(String[] args) {
		new Solution6();
	}

}
