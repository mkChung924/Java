package com.coding.algorithm;

import java.util.ArrayList;
import java.util.List;

/*1���� n������ �ڿ����� ���ʷ� ���Ͽ� ������ ���� �ﰢ����� �մϴ�.
���� ��� 7��° �ﰢ���� 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28�� �˴ϴ�.
�̷� ������ �ﰢ���� ���� ������ ������ �����ϴ�.

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
�� �ﰢ������ ����� ���غ��ô�.

 1: 1
 3: 1, 3
 6: 1, 2, 3, 6
10: 1, 2, 5, 10
15: 1, 3, 5, 15
21: 1, 3, 7, 21
28: 1, 2, 4, 7, 14, 28
������ ������, 5�� �̻��� ����� ���� ù��° �ﰢ���� 28�Դϴ�.

�׷��� 500�� �̻��� ����� ���� ���� ���� �ﰢ���� ���Դϱ�?*/
public class Problem12 {
	
	int temp;
	int a1,a2;
	List<Integer> list = new ArrayList<Integer>();
	
	public Problem12() {
		
		for(int i = 1; i < 10; i++){
			
			temp += i;
			list.add(temp);
		}
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		System.out.println(list.get(5));
	}
	
	public static void main(String[] args) {
		new Problem12();
	}

}
