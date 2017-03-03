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
		
		//숫자 섞기(0번지와 다른번지)
		int temp;
		for(int i = 0; i < 100; i++){ //섞어주는 횟 수
			int idx = r.nextInt(44) + 1;
			int idx2 = r.nextInt(44) + 1;
			temp = lotto[idx2];
			lotto[idx2] = lotto[idx];
			lotto[idx] = temp;
		}
		//Arrays.sort(lotto);
		
		System.out.println("★★금주 행운의 로또번호★★");
		for(int i = 0; i <5; i++){
			System.out.print(i+1+"회: ");
			
			int st = r.nextInt(40) + 1;
			for(int j = st - 1; j < st + 5; j++){
				if(j < st + 4){System.out.print(lotto[j] + ", ");}
				else {System.out.print(lotto[j]);}
				
			}
			System.out.println();
		}		
		
		long end = System.currentTimeMillis();
		System.out.println( "\n실행 시간 : " + ( end - start )/1000.0 + "s");
	}

}
