package com.kosta.j0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class HelloTest {
	
	public static void main(String args[]){
		
		/*ctrl + 1 : ���� ���
		ctrl + space : �ڵ��ϼ� ���
		ctrl + alt + �Ʒ�ȭ��ǥ : ����ٿ��ֱ�*/
		
		System.out.println("hi");
		System.out.println("�ȳ�, ��Ŭ����!");
		
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
	}

}
