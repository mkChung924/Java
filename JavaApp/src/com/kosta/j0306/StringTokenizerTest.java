package com.kosta.j0306;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	public static void main(String args[]){
		//StringTokenizer : 문자열을 특정구분자로 분리해주는 클래스
		String tel = "010--6430";
		
		//StringTokenizer st = new StringTokenizer(String str, String delim)
		//str: 구분하고나 하는 문자열(기준 문자열), delim : delimeter,구분자 문자열
		//token: 구분자를 통해 분리된 각각의 데이터
		
		StringTokenizer st = new StringTokenizer(tel, "-");
		//System.out.println(st.hasMoreTokens());
		
		System.out.println(">StringTokenizer 사용");
		do{
			System.out.println(st.nextToken());
		} while(st.hasMoreTokens());
		
//		while(st.hasMoreElements()){
//			System.out.println(st.nextToken());
//		}
		
		//특정 문자를 통해 데이터를 분리!!
		System.out.println(">split 사용");
		String tels[] = tel.split("-");
		for(int i = 0; i < tels.length; i++){
			System.out.println("tels["+i+"] "+tels[i]);
		}
		
			
	}//main

}
