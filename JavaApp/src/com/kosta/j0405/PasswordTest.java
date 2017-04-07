package com.kosta.j0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordTest {
	
		BufferedReader br;
		
	public PasswordTest() {
	

		br = new BufferedReader(new InputStreamReader(System.in));

		
		try {
			while(true){
				System.out.println("비밀번호 유효검사(영문숫자조합 8자이상)");
				System.out.print("비밀번호: ");
				String str = br.readLine();
				
				if(str.length() < 8){
					System.out.println("비밀번호 8자리 이상 쓰세요.");
				} else {
					if(numCount(str)){
						System.out.println("유효합니다.");
					} else {
						System.out.println("최소 숫자 갯수는 2개입니다.");
					}
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean numCount(String str){
		int count = 0;
		for(int i = 0; i < str.length(); i++){
			
			if((int)'0' <= str.charAt(i) && (int)'9' >= str.charAt(i) ){
				count++;
			}
		}
		if(count < 2){
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		new PasswordTest();
	}

}
