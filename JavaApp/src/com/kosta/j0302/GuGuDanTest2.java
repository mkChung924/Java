package com.kosta.j0302;

public class GuGuDanTest2 {
	
	public static void main(String args[]){
			
		int mult;
		
		System.out.println("< 구구단 >");
		for(int i = 1; i < 10; i++){
			for(int j = 2; j < 10; j++){
				mult = j*i;
				String zero = "";
				if(mult < 10) zero = " ";
				System.out.print(j + "x" + i + " = " + zero + mult + "\t");
			}
			System.out.println();
		}
		
		//printf를 활용
		System.out.println("< 구구단 >");
		for(int i = 1; i < 12; i++){
			for(int j = 2; j < 10; j++){
				mult = j*i;
				String zero = "";
				if(mult < 10) zero = " ";
				//printf(String format, Object... args)
				//printf("%d%d",)
//				<출력패턴>
//				%d : 정수		---> %d   %3d(3자리 확보후 10진수 오른쪽정렬 출력)   %-3d(자리를 확보후 10진수 왼쪽정렬 출력)
//				%f : 실수		---> %f   %5.2f(전체자리수 5자리 확보, 소수점 이하 두 자리까지 출력)
//				%s : 문자열	---> 
//				%c : 문자
				
				System.out.printf("%d*%2d = %-3d  ",j,i,(j*i));
				//System.out.printf(j + "x" + i + " = " + zero + mult + "\t");
			}
			System.out.println();
		}
			
	}

}
