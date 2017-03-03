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
		Arrays.sort(su); //�ڹ� �⺻ sort�޼�
		at.printArray(su);
		
		Character ch[] = {'��','��','Ÿ','c','a','o','A','Z','Y','t'};
		Arrays.sort(ch);
		at.printArray(ch);
		
		String str[] = {"ȫ�浿", "�����", "���ֿ�", "������", "��ö"};
		Arrays.sort(str);
		at.printArray(str);
/*	
		�⺻�ڷ���				WrapperŬ����(java.lang��Ű��)
		char		-----> Character
		byte		-----> Byte
		short		-----> Short
		int			-----> Integer
		long		-----> Long
		float		-----> Float
		double		-----> Double
		boolean		-----> Boolean
		
		Integer a = 13;	----> ���ο��� Integer a = new Integer(13); ����ڽ�
		int b = new Integer(13);	----> ���ο��� int b = 13; ��ڽ�
		*/
		
		
		
	}
}
