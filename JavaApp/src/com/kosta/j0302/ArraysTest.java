package com.kosta.j0302;

import java.util.Arrays;

public class ArraysTest {
	
public void printArray(Object su[]){
		
		for(int i = 0; i < su.length; i++){
			System.out.print(su[i]);
			if(i < su.length - 1) System.out.print(", ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		ArraysTest at = new ArraysTest();
		
		Integer su[] = {22,35,17,4,25};
		at.printArray(su);
		Arrays.sort(su); //자바 기본 sort메소
		at.printArray(su);
		
		Character ch[] = {'나','가','타','c','a','o','A','Z','Y','t'};
		Arrays.sort(ch);
		at.printArray(ch);
		
		String str[] = {"홍길동", "길라임", "김주원", "김유신", "정철"};
		Arrays.sort(str);
		at.printArray(str);
/*	
		기본자료형				Wrapper클래스(java.lang패키지)
		char		-----> Character
		byte		-----> Byte
		short		-----> Short
		int			-----> Integer
		long		-----> Long
		float		-----> Float
		double		-----> Double
		boolean		-----> Boolean
		
		Integer a = 13;	----> 내부에서 Integer a = new Integer(13); 오토박싱
		int b = new Integer(13);	----> 내부에서 int b = 13; 언박싱
		*/
		
		
		
	}
}
