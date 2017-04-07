package com.kosta.j0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AnagramTest {
	
	BufferedReader br;
	String word1;
	String word2;
	
	public AnagramTest() {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while(true){
			System.out.println("## ANAGRAM TEST ##");
			
			System.out.println("1번째 문자를 입력하세요.");
			word1 = br.readLine().trim();
			System.out.println("2번째 문자를 입력하세요.");
			word2 = br.readLine().trim();
			
			Anangram(word1, word2);
			
			
			System.out.println();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		new AnagramTest();
	}
	
	public void Anangram(String w1, String w2){
		int l1 = w1.length();
		int l2 = w2.length();
		int count = 0;
		int count2 = 0;
		String a[] = new String[l1];
		String b[] = new String[l2];
		
		//hello
		//olleh
		
		if(l1 != l2){
			System.out.println("애너그램 문자가 아닙니다.");
		} else if(l1 == l2){
			a = new String[l1];
			b = new String[l2];
//
//			
//			for(int i = 0; i< l1; i++){
//				for(int j = 0; j <l2; j++){
//					
//					if(w1.contains(String.valueOf(w2.charAt(i)))){
//						if(w1.charAt(j) == w2.charAt(i)){
//						count++;
//						} else count--;
//						
//					}
//					
//					if(w2.contains(String.valueOf(w1.charAt(i)))){
//						if(w2.charAt(j) == w1.charAt(i)){
//						count2++;
//						} else count2--;
//						
//					}
//					
//				}
//			}
//			if(count == count2){
//				System.out.println(w1);
//				System.out.println(w2);
//			}
			
			for(int i = 0; i < l1; i++){
				
				a[i] = String.valueOf(w1.charAt(i));
				b[i] = String.valueOf(w2.charAt(i));
				
			}
			
			//a[0] = String.valueOf(w1.charAt(0));
			
			
			Arrays.sort(a);
			Arrays.sort(b);
	
			
			for(int i = 0; i < l1; i++){
				//System.out.print(a[i]);
				
				if(a[i].equals(b[i])){
					System.out.println("아나그램");
				} else {
					System.out.println("애너그램 아님");
				}
			}
			
		}
	}

}
