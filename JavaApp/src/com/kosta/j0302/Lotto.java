package com.kosta.j0302;

import java.util.Arrays;
import java.util.Random;

/*����6)
����� �ζǹ�ȣ ������
	1. ���� ��ġ�� �ʴ�(�ߺ����� �ʴ�) ���� 6�� ����
	2. �� ���ڴ� 1~45 �������� ����
	3. �Ź� ����� �ٸ� ���� ���
	4. �ټ�ȸ ���
	5. �� ��ȣ�� �������� ����
	
	�������)

**���� ����� �ζǹ�ȣ**
1ȸ:
2ȸ:
3ȸ:
4ȸ:
5ȸ:
6ȸ:*/

public class Lotto {
	
	static Random rand;
	
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		
		Lotto lot = new Lotto();		
		
		int lotto[] = new int[6];		//�ζǹ�ȣ ���� �迭 ����
		int lucky[][] = new int[5][6];	//5���� 6�ڸ� �ζǹ�ȣ ���� 2���� �迭 ����
		
		for(int i = 0; i < lucky.length; i++){
			lotto = lot.generate
					(lotto);
			for(int j = 0; j < lucky[i].length; j++){
				lucky[i][j] = lotto[j];
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("�ڡڱ��� ����� �ζǹ�ȣ�ڡ�");
		
		for(int i = 0; i < lucky.length; i++){
			System.out.print(i+1+"ȸ: ");
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
		System.out.println( "���� �ð� : " + ( end - start )/1000.0 + "s");
		
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
		
		//�� for��
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
