package acom.sds.samsung;

import java.util.Scanner;

public class DartTest2 {
	
	public DartTest2() {
		int scores[] = {6, 13, 4, 18, 1, 20, 5, 12, 9, 14, 11, 8, 16, 7, 19, 3, 17, 2, 15, 10};
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	int d = sc.nextInt();
        	int e = sc.nextInt();
  			int num = sc.nextInt();
  			sc.nextLine();
  			
  			Double xys[][] = new Double[num][2];
			for(int i = 0; i < num; i++){
				String xy = sc.nextLine();
				String axy[] = xy.split(" ");

				for(int j = 0; j < 2; j++){
					
					xys[i][j] = Double.parseDouble(axy[j]);
				}
			}
			
			int myScore = 0;
			
			for(int i = 0; i < xys.length; i++){
				Double ang = Math.toDegrees(Math.atan2(xys[i][1],xys[i][0])) + 9;
				
				if(ang < 0) ang += 360;
				
				Double length = Math.sqrt((xys[i][0]*xys[i][0]) + xys[i][1] * xys[i][1]);
				if(length > e){
					
					myScore += 0;
					
				} else if(length < e && length > d){
					double idx = ang/18;
					myScore += scores[(int)idx]*2;
					//System.out.println(ang + ", " + length + "," +scores[(int)idx] +", "+ myScore);
					
				} else if(length < d && length > c){
					double idx = ang/18;
					myScore += scores[(int)idx];
					//System.out.println(ang + ", " + length + "," +scores[(int)idx] +", "+ myScore);
				} else if(length < c && length > b){
					double idx = ang/18;
					myScore += scores[(int)idx]*3;
					//System.out.println(ang + ", " + length + "," + scores[(int)idx] + ", "+myScore);
				} else if(length < b && length > a){
					double idx = ang/18;
					myScore += scores[(int)idx];
					//System.out.println(ang + ", " + length + "," + scores[(int)idx] +", "+ myScore);
				} else if(length < a){
					myScore += 50;
					
					//System.out.println(ang + ", " + length + "," + myScore);
				}
			}
        
        
        

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(myScore);
		}
		
	}
	
	public static void main(String[] args) {
		new DartTest2();
	}

}
