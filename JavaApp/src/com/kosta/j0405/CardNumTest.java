package com.kosta.j0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardNumTest {
	
	BufferedReader br;
	
	public CardNumTest() {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while(true){
				
				System.out.println("ī���ȣ ��ȿ�˻�");
				System.out.print("ī���ȣ: ");
				String str = br.readLine();
				str = str.replace("-", "").trim();
				//str = "1234123412340068";
				
				int oddSum = 0;
				int evenSum = 0;
				
				for(int i = 1 ; i <= str.length(); i++){
					int strNum = str.charAt(i-1)-48;
					
					if(i%2 == 1){//Ȧ��
						if(strNum*2 >= 10){
							oddSum += ((strNum*2)/10 + (strNum*2)%10);
						} else {
							oddSum += strNum*2;
						}
						
					} else if(i%2 == 0){//¦��

						
						evenSum += strNum;
						
					}
				}
				
				if((oddSum + evenSum)%10 == 0){
					System.out.println("ī����ȿ��");
				} else {
					System.out.println("ī����ȿ��������");
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void main(String[] args) {
		new CardNumTest();
	}
}
