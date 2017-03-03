package com.kosta.j0302;

import java.util.Random;

public class RandArrayTest {
	int su[];
	//String su[];
	//boolean su[];
	
	public RandArrayTest() {//생성자: 초기화 메소드
		su = new int[5]; //정수 데이터 5개를 su라는 이름으로 저장
		//배열 객체생성식: 자료형 배열명[] = new 자료형[배열크기];
	}
	
	public void inputArray(){//배열에 데이터를 입력(데이터: 랜덤한 수)
		//자바의 랜덤관련된 클래스 : java.util.Random-next(), java.lang.Math-random()
		Random random = new Random();
//		for(int i = 0; i < su.length; i++){
//			su[i] = random.nextInt(100);
//		}		
		
		for(int i = 0; i < su.length; i++){
			double rand = Math.random(); // 0.0 ~ 1.0 (exclusively)
			su[i] = (int) (rand * 100);
			//su[i] = (int) (Math.random() * 100) + 1;
			
		}
	}
	
	public void printArray(){//배열값을 화면에 출력
		for(int i = 0; i < su.length; i++){
			System.out.println("su["+i+"]번지 = " + su[i]);
		}
		
	}
	
	public static void main(String args[]){
		
		RandArrayTest randTest = new RandArrayTest();
		randTest.inputArray();
		randTest.printArray();
		
		
	}

}
