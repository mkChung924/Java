package com.kosta.j0302;

public class ArrayTest {
	public static void main(String args[]){
		//int su[];
		//	  su[] = {11,22,33}; //에러: 배열초기값은 반드시 선언과 함께 해야 함.
		int su[] = {11,22,33,44,55};
		
		//배열 내의 데이터를 출력!!
		System.out.println(su[0]); //첫번째 데이터
		System.out.println(su[1]); //두번째 데이터
		System.out.println(su[2]); //세번째 데이터
		
		System.out.println("배열의 크기(요소갯수): " + su.length);
		
		for(int i = 0; i < su.length; i++){
			System.out.println("su["+i+"]번지 = " + su[i]);
		}
		
			/*main() 메소드의 args[]배열을 사용
			 * java ArrayTest 엔터
			 * String args[] = {};
			 * java ArrayTest "홍길동" "길라임" "김주원" 엔터
			 * String args[]={"홍길동", "길라임", "김주원"};
			 * java ArrayTest 길동 라임 주원 엔터
			 * String args[]={"길동", "라임", "주원"};*/
		
		for(int i = 0; i<args.length; i++){
			System.out.println("args["+i+"]번지 = " + args[i]);
			System.out.println(Integer.parseInt(args[i]) + 10);
		}
		
		//행 		  [0]	[1]		[2]
		int su2[][]= {{1}, {2,3}, {4,5,6}};
		//열			  [0]  [0][1] [0][1][2]
		System.out.println("su2배열의 크기: "+su2.length);//행의 수가 출력
		System.out.println("su2[1]번지의 크기: " + su2[1].length);//su2[1]번지의 크
		//System.out.println(su2[1][1]);
		
		for(int i = 0; i < su2.length; i++){
			for(int j = 0; j < su2[i].length; j++){
				System.out.print("su2["+i+"]["+j+"]번지 = "+su2[i][j] + " ");
			}
			System.out.println();
		}

	}

}
