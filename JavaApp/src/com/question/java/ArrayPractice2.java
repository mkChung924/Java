package com.question.java;

import java.util.Arrays;

public class ArrayPractice2 {
	
	public static void main(String args[]){
		
//		* 1������. "4,23,21,46,57,86,14,29,45,22"�� �迭�� ��� ���� 3�� ����� ����϶� 
//		 * 2������. "4,23,21,46,57,86,14,29,45,22"�� �迭�� ��� ���������϶�
		
		int array[] = {4,23,21,46,67,86,14,29,45,22};
		
		System.out.println("##1�� ����. {4,23,21,46,57,86,14,29,45,22}�� �迭�� ��� ���� 3�� ����� ����϶�##");
		for(int i = 0; i < array.length; i++){
			if(array[i]%3 == 0){
				System.out.println("3�� ����� " + array[i]);
			}
		}
		System.out.println();
		System.out.println("##2�� ����. {4,23,21,46,57,86,14,29,45,22}�� �迭�� ��� ���������϶�##");
		Arrays.sort(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i]+ " ");
		}
		
		System.out.println();
		int array2[] = new int[array.length];
		array2[0] = 10;
		System.out.println(array2[0]);
		
//		for(int i = 0; i < array.length; i++){
//			for(int j = 0; j < array.length; j++){
//				if(array[i] < array[j]){
//					array2[i] = (int) array[i];
//				} else if(array[i] > array[j]){
//					array2[i] = array[j];
//				}
//			}
//		}
//		System.out.println(array2[0]);
		
		
	}//main

}//class
