package com.kosta.j0303;

import java.util.Arrays;
import java.util.Random;

public class GoodLuckLotto2 {
	
	int lotto[];
	Random r;
	
	public GoodLuckLotto2() {
		
		lotto = new int[6];
		r = new Random();	
		
	}

	public void generateNum(){
		for(int i = 0; i < lotto.length; i++){
			lotto[i] = r.nextInt(45) + 1;
			boolean flag = duplicateCheck(i); //���� �Էµ� ���� ������ ����
			if(flag){ //��ġ�°� ������ true
				i--;
			}
		}
		
		Arrays.sort(lotto);

	}
	
	public boolean duplicateCheck(int idx){
		
		for(int i = idx - 1; i >= 0; i--){
			if(lotto[idx] == lotto[i]) 
				return true;
		}
		return false;
	}
	
	public void printNum(){
		
		for(int i = 0; i < lotto.length; i++){
			String z = "";
			if(lotto[i] < 10){ z = " "; }
			System.out.print(z + lotto[i]);
			if(i < lotto.length - 1){ System.out.print(", "); }
		}
		System.out.println();

		
	}//printNum
	
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		
		GoodLuckLotto2 luck = new GoodLuckLotto2();
		
		System.out.println("�ڡڱ��� ����� �ζǹ�ȣ�ڡ�");
		
		for(int i = 0; i < 5; i++){
			System.out.print(i+1+"ȸ: ");
			luck.generateNum();
			luck.printNum();
		}
		
		long end = System.currentTimeMillis();
		System.out.println( "\n���� �ð� : " + ( end - start )/1000.0 + "s");
		
		
	}

}
