package com.kosta.j0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortArrayTest {
	
	BufferedReader br;
	int su[];
	int su2[];
	String str[] = {"ù","��","��","��", "�ټ�"};
	
	//�迭��ü ����: �ڷ��� �迭��[] = new �ڷ���[�迭ũ��];
				//�ڷ��� �迭��[][] = new �ڷ���[��ũ��][��ũ��];
	
	public SortArrayTest(){
		
		su = new int[5];
		su2 = new int[5];
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public void inputArray() throws IOException{//������ �Է�
		System.out.println("#�����ϰ��� �ϴ� �ټ����� ���� �Է�");
		for(int i = 0; i < su.length; i++){
			System.out.print(str[i]+"��° ������: ");
			su[i] = Integer.parseInt(br.readLine());
		}

	}
	
	public void printArray(){
		
		System.out.print("���� �� ������ : [");
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
		
		System.out.print("���� �� ������ : [");
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
		
		//������ ������: [22,33,19,4,25]
		//������ ������: [4,19,22,25,33]
		
	}

}
