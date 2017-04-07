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
				System.out.println("��й�ȣ ��ȿ�˻�(������������ 8���̻�)");
				System.out.print("��й�ȣ: ");
				String str = br.readLine();
				
				if(str.length() < 8){
					System.out.println("��й�ȣ 8�ڸ� �̻� ������.");
				} else {
					if(numCount(str)){
						System.out.println("��ȿ�մϴ�.");
					} else {
						System.out.println("�ּ� ���� ������ 2���Դϴ�.");
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
