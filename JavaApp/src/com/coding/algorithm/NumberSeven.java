package com.coding.algorithm;

import java.util.Vector;

/*�Ҽ��� ũ�� ������ �����ϸ� 2, 3, 5, 7, 11, 13, ... �� ���� �˴ϴ�.

�� �� 10,001��°�� �Ҽ��� ���ϼ���.*/

public class NumberSeven {
	int count;
	int sosu;
	Vector v;
	
	public NumberSeven() {
		v = new Vector();
		
		for(int i = 2; i < Integer.MAX_VALUE; i++){
			count = 0;
			for(int j = 1; j <= i; j++){
				if(i%j == 0){
					++count;
				}
			}
			
			if(count == 2){
				sosu = i;
				//System.out.print(sosu + ", ");
				v.add(sosu);
				if(v.size() == 10001){
					System.out.println(v.get(v.size()-1));
					return;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new NumberSeven();
	}

}
