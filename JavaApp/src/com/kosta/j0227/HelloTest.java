package com.kosta.j0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class HelloTest {
	
	public static void main(String args[]){
		
		/*ctrl + 1 : 제안 기능
		ctrl + space : 자동완성 기능
		ctrl + alt + 아래화살표 : 복사붙여넣기*/
		
		System.out.println("hi");
		System.out.println("안녕, 이클립스!");
		
		BufferedReader br;
		br = new BufferedReader(new InputStreamReader(System.in));
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
	}

}
