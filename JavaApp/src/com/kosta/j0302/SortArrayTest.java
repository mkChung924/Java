package com.kosta.j0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortArrayTest {
	
	BufferedReader br;
	int su[];
	int su2[];
	String str[] = {"첫","두","세","네", "다섯"};
	
	//배열객체 생성: 자료형 배열명[] = new 자료형[배열크기];
				//자료형 배열명[][] = new 자료형[행크기][열크기];
	
	public SortArrayTest(){
		
		su = new int[5];
		su2 = new int[5];
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void inputArray() throws IOException{//데이터 입력
		System.out.println("#정렬하고자 하는 다섯개의 정수 입력");
		for(int i = 0; i < su.length; i++){
			System.out.print(str[i]+"번째 데이터: ");
			su[i] = Integer.parseInt(br.readLine());
		}

	}
	
	public void printArray(){
		
		System.out.print("정렬 전 데이터 : [");
		for(int i = 0; i < su.length; i++){
			System.out.print(su[i]);
			if(i < su.length - 1) System.out.print(", ");
		}
		System.out.println("]");
	}
	
	public void sortArray2(){
		Arrays.sort(su);
		for(int i = 0; i < su.length; i++){
			System.out.print(su[i] + " ");
		}
	}
	
	public void sortArray(){
		
		int temp;
		for(int i = 0; i < su.length - 1; i++){
			for(int j = i + 1; j < su.length; j++){
				if(su[i] > su[j]){
					temp = su[i];
					su[i] = su[j];
					su[j] = temp;
					}
			}
		}
		
		System.out.print("정렬 후 데이터 : [");
		for(int i = 0; i < su.length; i++){
			System.out.print(su[i]);
			if(i < su.length - 1) System.out.print(", ");
		}
		System.out.println("]");

	}
	
	public static void main(String args[]) throws IOException{
		
		SortArrayTest sat = new SortArrayTest();
		sat.inputArray();
		sat.printArray();
		sat.sortArray();
		
		//정렬전 데이터: [22,33,19,4,25]
		//정렬후 데이터: [4,19,22,25,33]
		
	}

}
