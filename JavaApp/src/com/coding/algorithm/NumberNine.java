package com.coding.algorithm;

/*�� �ڿ��� a, b, c �� ��Ÿ��� ���� a2 + b2 = c2 �� �����ϸ� ��Ÿ��� ����� �θ��ϴ� (���⼭ a < b < c ).
���� ��� 32 + 42 = 9 + 16 = 25 = 52�̹Ƿ� 3, 4, 5�� ��Ÿ��� ���Դϴ�.

a + b + c = 1000 �� ��Ÿ��� �� a, b, c�� �� ���� ���Դϴ�. �� ��, a �� b �� c �� ���Դϱ�?*/
public class NumberNine {
	
	int a,b,c;
	
	public NumberNine() {
		
		for(int a = 1; a < 1000; a++){
			for(int b = 1; b < 1000; b++){
				for(int c = 1; c < 1000; c++){
					if(a<b && b<c && a<c){
						if(a + b + c == 1000){
							if(a*a + b*b == c*c){
							System.out.println(a +", " + b + ", " + c);
							System.out.println("��: " + (a*b*c));
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new NumberNine();
	}

}
