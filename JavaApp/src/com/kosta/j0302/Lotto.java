package com.kosta.j0302;

import java.util.Arrays;
import java.util.Random;

/*문제6)
행운의 로또번호 생성기
	1. 서로 겹치지 않는(중복되지 않는) 숫자 6개 생성
	2. 각 숫자는 1~45 범위내의 숫자
	3. 매번 실행시 다른 숫자 출력
	4. 다섯회 출력
	5. 각 번호는 오름차순 정렬
	
	출력형태)

**금주 행운의 로또번호**
1회:
2회:
3회:
4회:
5회:
6회:*/

public class Lotto {
	
	static Random rand;
	
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		
		Lotto lot = new Lotto();		
		
		int lotto[] = new int[6];		//로또번호 담을 배열 생성
		int lucky[][] = new int[5][6];	//5개의 6자리 로또번호 담을 2차원 배열 생성
		
		for(int i = 0; i < lucky.length; i++){
			lotto = lot.generate
					(lotto);
			for(int j = 0; j < lucky[i].length; j++){
				lucky[i][j] = lotto[j];
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("★★금주 행운의 로또번호★★");
		
		for(int i = 0; i < lucky.length; i++){
			System.out.print(i+1+"회: ");
			for(int j = 0; j < lucky[i].length; j++){
				String z = "";
				if(lucky[i][j] < 10){ z = " ";}
				if(j < 5) {System.out.print(z+ lucky[i][j] + ", ");}
				else {System.out.print(z + lucky[i][j]+" ");}
			}
			System.out.println();
		}
		System.out.println();
		
		
		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 + "s");
		
	}
	
	public int[] generate(int lotto[]){
		
		rand = new Random();
		System.out.println();
	
		for(int i = 0; i < lotto.length; i++){
			int temp = rand.nextInt(45)+1;
			lotto[i] = temp;
		}
		Arrays.sort(lotto);
		
		for(int i = 0; i < lotto.length; i++){
			String z = "";
			if(lotto[i] < 10){z = " ";}
			System.out.print(z + lotto[i] + " ");
		}
		
		//비교 for문
		for(int i = 0; i < lotto.length; i++){
			for(int j = 0; j < lotto.length; j++){
				if(i == j) continue;
				if(lotto[i] == lotto[j]){
					lotto[i] = rand.nextInt(45)+1;
				}
			}
		}
		Arrays.sort(lotto);
		return lotto;
		
	}

}
