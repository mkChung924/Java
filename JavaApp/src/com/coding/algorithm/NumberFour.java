package com.coding.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

// 세자리 수를 곱해 만들 수 있는 가장 큰 대칭수는 얼마입니까?

public class NumberFour {
	
	int multi;
	String str;
	int length;
	Vector v;
	
	public NumberFour() {

		v = new Vector();

		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
				//if(j+1 == i) j++;
				multi = i*j;
				isPalindrome(multi);
				
			}	
		}	
	}
	
	public void isPalindrome(int number){
		str = String.valueOf(number); 
		length = (int)(Math.log10(number)+1);
		boolean pal = true;
		
		for(int k = 0; k < length/2; k++){
			
			if(str.charAt(k) == str.charAt((length-1)-k) && pal){
				pal = true;

			} else {
				pal = false;
					
			}
			
		}
		
		if(pal){
			v.add(number);
			Collections.sort(v);
			System.out.println(v.get(v.size()-1));
			
		} else {
			//System.out.println("대칭아님");
		}
	}
	
	
	public static void main(String[] args) {
		new NumberFour();
	}
}
