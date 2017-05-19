package acom.sds.samsung;

import java.util.Scanner;


public class DartTest {
	
	public DartTest() {
	
		
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
			
			//반지름 계산
		
			Double xys[][] = new Double[num][2];
			for(int i = 0; i < num; i++){
				String xy = sc.nextLine();
				String axy[] = xy.split(" ");

				for(int j = 0; j < 2; j++){
					
					xys[i][j] = Double.parseDouble(axy[j]);
				}
				
			}
			
			
			int score = 0;
			for(int i = 0; i < xys.length; i++){
				
				Double ang = Math.toDegrees(Math.atan2(xys[i][1],xys[i][0]));
				Double lengs = Math.sqrt((xys[i][0]*xys[i][0]) + xys[i][1] * xys[i][1]);

					if(a > lengs){
						score += 50;
					} 
					
					if(ang < 9 && ang > 0){
						score += 6;
						
					} else if(ang > 9 && ang < 27){
						
						int scr = 13;
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					} else if(ang > 27 && ang < 45){
						
						int scr = 4;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang > 45 && ang < 63){
						
						int scr = 18;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
						
					}else if(ang > 63 && ang < 81){
						
						int scr = 1;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang > 81 && ang < 99){
						
						int scr = 20;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang > 99 && ang < 117){
						
						int scr = 5;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}
					
					else if(ang > 117 && ang < 135){
						
						int scr = 12;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang > 135 && ang < 153){
						
						int scr = 9;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang > 153 && ang < 172){
						
						int scr = 14;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}
					else if(ang > 172 && ang < 181){
						
						int scr = 11;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					} else if(ang > -9 && ang < 0){
						
						score += 6;
					} else if(ang < -9 && ang > -27){
						
						int scr = 10;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					} else if(ang < -27 && ang > -45){
						
						int scr = 15;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang < -45 && ang > -63){
						
						int scr = 2;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang < -63 && ang > -81){
						
						int scr = 17;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang < -81 && ang > -99){
						
						int scr = 3;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang < -99 && ang > -117){
						
						int scr = 19;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang < -117 && ang > -135){
						
						int scr = 7;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}else if(ang < -135 && ang > -153){
						
						int scr = 16;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}
					
					else if(ang < -153 && ang > -172){
						
						int scr = 8;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
					}
					
					else if(ang < -172 && ang > -181){
						
						int scr = 11;
						
						if(b < lengs && c > lengs){
							score = score + scr*3;
						} else if(d < lengs && e > lengs){
							score = score + scr*2;
						} else if(lengs > e){
							score = score + 0;
						} else {
							score += scr;
						}
						
					}
					}
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(score);
		}
	}
		
	
	public static void main(String[] args) {
		new DartTest();
	}

}
