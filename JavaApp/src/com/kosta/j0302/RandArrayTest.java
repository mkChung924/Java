package com.kosta.j0302;

import java.util.Random;

public class RandArrayTest {
	int su[];
	//String su[];
	//boolean su[];
	
	public RandArrayTest() {//������: �ʱ�ȭ �޼ҵ�
		su = new int[5]; //���� ������ 5���� su��� �̸����� ����
		//�迭 ��ü������: �ڷ��� �迭��[] = new �ڷ���[�迭ũ��];
	}
	
	public void inputArray(){//�迭�� �����͸� �Է�(������: ������ ��)
		//�ڹ��� �������õ� Ŭ���� : java.util.Random-next(), java.lang.Math-random()
		Random random = new Random();
//		for(int i = 0; i < su.length; i++){
//			su[i] = random.nextInt(100);
//		}		
		
		for(int i = 0; i < su.length; i++){
			double rand = Math.random(); // 0.0 ~ 1.0 (exclusively)
			su[i] = (int) (rand * 100);
			//su[i] = (int) (Math.random() * 100) + 1;
			
		}
	}
	
	public void printArray(){//�迭���� ȭ�鿡 ���
		for(int i = 0; i < su.length; i++){
			System.out.println("su["+i+"]���� = " + su[i]);
		}
		
	}
	
	public static void main(String args[]){
		
		RandArrayTest randTest = new RandArrayTest();
		randTest.inputArray();
		randTest.printArray();
		
		
	}

}
