package com.kosta.j0303;

import java.util.Arrays;
import java.util.Random;

public class GoodLuckLotto3 {
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		
		int lotto[] = new int[45];
		Random r = new Random();
		
		for(int i = 0; i < lotto.length; i++){
			lotto[i] = i + 1;
		}
		
		//���� ����(0������ �ٸ�����)
		int temp;
		for(int i = 0; i < 100; i++){ //�����ִ� Ƚ ��
			int idx = r.nextInt(44) + 1;
			int idx2 = r.nextInt(44) + 1;
			temp = lotto[idx2];
			lotto[idx2] = lotto[idx];
			lotto[idx] = temp;
		}
		//Arrays.sort(lotto);
		
		System.out.println("�ڡڱ��� ����� �ζǹ�ȣ�ڡ�");
		for(int i = 0; i <5; i++){
			System.out.print(i+1+"ȸ: ");
			
			int st = r.nextInt(40) + 1;
			for(int j = st - 1; j < st + 5; j++){
				if(j < st + 4){System.out.print(lotto[j] + ", ");}
				else {System.out.print(lotto[j]);}
				
			}
			System.out.println();
		}		
		
		long end = System.currentTimeMillis();
		System.out.println( "\n���� �ð� : " + ( end - start )/1000.0 + "s");
	}

}
