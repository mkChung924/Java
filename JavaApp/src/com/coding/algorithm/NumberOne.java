package com.coding.algorithm;

public class NumberOne {
	
	int sum;
	
	public NumberOne() {
		for(int i = 1; i < 1000; i++){
			if(i%3 == 0 || i%5 == 0){
				sum += i;
			}
		}
		System.out.println("1000���� ���� �ڿ��� �߿��� 3 �Ǵ� 5�� ����� ��� ���ϸ� ���ϱ��?");
		System.out.println("��: " + sum);
	}
	
	public static void main(String[] args) {
		new NumberOne();
	}

}
