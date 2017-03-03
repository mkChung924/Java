package com.kosta.j0302;

//int su[] = {1,2,3,4,5};
//문제1. 위 배열의 데이터를 차례대로 출력
//문제2. 위 배열의 데이터를 역순으로 출력
//문제3. int su2[][] = {{1},{1,2},{1,2,3}}; 배열의 데이터를 번지값과 함께 출력 예) su2[0][0] = 1
//문제4. int su[]={1,2,3,4,5}; su3이라는 배열을 만들어서 su배열의 값을 복사.
//  int su3[];
//        su3 = su; (x) // new int[5];
//    su3[2]=33;
//   syso su[2] --->3출력되도록!!
//문제 5. int su[]={1,2,3,4,5};
//--> for문을 통해 [0]번지~[4]번지까지 출력을 했을 때 5 4 3 2 1 과 같이 출력되도록 하시오.
//

public class DailyPractice {
	
	public static void main(String args[]){
		
		DailyPractice dp = new DailyPractice();
		
		// 1번
		System.out.println("int su[] = {1,2,3,4,5}");
		System.out.println("# 문제1. 위 배열의 데이터를 차례대로 출력");
		int su[] = {1,2,3,4,5};
		for(int i = 0; i < su.length; i++){
			System.out.print(su[i]);
			if(i < su.length - 1){
				System.out.print(", ");
			}
		}
		
		// 2번
		System.out.println();
		System.out.println("# 문제2. 위 배열의 데이터를 역순로 출력");
		for(int i = su.length - 1; i >= 0; i--){
			System.out.print(su[i]);
			if(i > 0){
				System.out.print(", ");
			}
		}
		
		//3번
		System.out.println();
		System.out.println("# 문제3. int su2[][] = {{1},{1,2},{1,2,3}}; 배열의 데이터를 번지값과 함께 출력 예) su2[0][0] = 1");
		int su2[][] = {{1},{1,2},{1,2,3}};
		for(int i = 0; i < su2.length; i++){
			for(int j = 0; j < su2[i].length; j++){
				System.out.print("su2["+i+"]["+j+"] = " + su2[i][j] + "\t");
			}
			System.out.println();
		}
		
		//4번
		System.out.println();
		System.out.println("# 문제4. int su[]={1,2,3,4,5}; su3이라는 배열을 만들어서 su배열의 값을 복사.");
		int su3[] = new int[su.length];
		
		su3 = dp.copy(su3, su);
		System.out.print("su3[] = {");
		for(int i = 0; i < su3.length; i++){
			System.out.print(su3[i]);
			if(i < su3.length - 1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
		System.out.println("su[2] = " + su[2]);
		
		// 5번
		System.out.println();
		System.out.println("# 문제 5. int su[]={1,2,3,4,5}\nfor문을 통해 [0]번지~[4]번지까지 출력을 했을 때 5 4 3 2 1 과 같이 출력되도록 하시오.");	
		
		int su4[] = new int[6];
		//int su5[] = {1,2,3,4,5,6};//6자리 확인절차
		su4 = dp.exchange(su);
		for(int i = 0; i < su.length; i++){
			System.out.print(su4[i] + " ");
		}
		
	}
	
	//메소드 정의
	public int[] copy(int num[], int num2[]){
		
		for(int i = 0; i < num.length; i++){
			num[i] = num2[i];
		}
		
		return num;
		
	}
	
	public int[] exchange(int su[]){

		for(int i = 0; i < su.length/2; i++){
			int temp;
			temp = su[i];
			su[i] = su[su.length - i - 1];
			su[su.length - i - 1] = temp;
				
		}
		
		return su;
		
	}
	

}
