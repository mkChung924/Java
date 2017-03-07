package com.question.java;

import java.util.Arrays;

public class ArrayPractice2 {
	
	public static void main(String args[]){
		
//		* 1번문제. "4,23,21,46,57,86,14,29,45,22"를 배열에 담고 이중 3의 배수만 출력하라 
//		 * 2번문제. "4,23,21,46,57,86,14,29,45,22"를 배열에 담고 오름차순하라
		
		int array[] = {4,23,21,46,67,86,14,29,45,22};
		
		System.out.println("##1번 문제. {4,23,21,46,57,86,14,29,45,22}를 배열에 담고 이중 3의 배수만 출력하라##");
		for(int i = 0; i < array.length; i++){
			if(array[i]%3 == 0){
				System.out.println("3의 배수는 " + array[i]);
			}
		}
		
		
		System.out.println();
		System.out.println("##2번 문제. {4,23,21,46,57,86,14,29,45,22}를 배열에 담고 오름차순하라##");
		System.out.print("기존 배열: ");
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ", ");
		}
		System.out.println();
		Arrays.sort(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+ " ");
		}
		
		System.out.println();
		int array2[] = new int[array.length];
		
		for(int i = 0; i < array.length; i++){
			for(int j = i ; j < array.length; j++){
				if(array[i] <= array[j]){
					array2[i] = (int) array[i];
				} else if(array[i] >= array[j]){
					array2[i] = array[j];
				}
			}
		}
		for(int i = 0; i < array2.length; i++){
		System.out.print(array2[i] + " ");
		}
		
		
	}//main

}//class
