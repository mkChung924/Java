package com.kosta.j0306;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String args[]){
		//StringTokenizer : ���ڿ��� Ư�������ڷ� �и����ִ� Ŭ����
		String tel = "010--6430";
		
		//StringTokenizer st = new StringTokenizer(String str, String delim)
		//str: �����ϰ� �ϴ� ���ڿ�(���� ���ڿ�), delim : delimeter,������ ���ڿ�
		//token: �����ڸ� ���� �и��� ������ ������
		
		StringTokenizer st = new StringTokenizer(tel, "-");
		//System.out.println(st.hasMoreTokens());
		
		System.out.println(">StringTokenizer ���");
		do{
			System.out.println(st.nextToken());
		} while(st.hasMoreTokens());
		
//		while(st.hasMoreElements()){
//			System.out.println(st.nextToken());
//		}
		
		//Ư�� ���ڸ� ���� �����͸� �и�!!
		System.out.println(">split ���");
		String tels[] = tel.split("-");
		for(int i = 0; i < tels.length; i++){
			System.out.println("tels["+i+"] "+tels[i]);
		}
		
			
	}//main

}
