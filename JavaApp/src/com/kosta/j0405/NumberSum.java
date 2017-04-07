package com.kosta.j0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberSum {
	BufferedReader br;
	
	public NumberSum() {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while(true){
				
				System.out.println("0~999 정수 입력");
				System.out.print("정수: ");
				String str = br.readLine();
				
				getSum(Integer.parseInt(str));
				//System.out.println("합: " + ((int)str.charAt(0)-48 + (int)str.charAt(1)-48 + (int)str.charAt(2)-48));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getSum(int number){
		
		int a=0;
		int b=0;
		int c=0;
		int sum = 0;
		if(number == 0){
			sum = 0;
		} else if(number < 10){
			sum += number/1;
		} else if(number >= 10 && number < 100){
			sum += number/10;
			
			sum += (number%10)/1;
			
			
		} else if(number >= 100){
			
			sum += number/100;
			sum += (number%100)/10;
			sum += (number%100)%10/1;
				
		}
		
		System.out.println(sum);
		
	}

	public static void main(String[] args) {
		new NumberSum();
	}
}
