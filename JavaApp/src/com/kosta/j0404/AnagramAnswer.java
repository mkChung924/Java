package com.kosta.j0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramAnswer {
	
	BufferedReader br;
	String word1;
	String word2;
	
	public AnagramAnswer() {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while(true){
			System.out.println("## ANAGRAM TEST ##");
			
			System.out.println("1번째 문자를 입력하세요.");
			word1 = br.readLine().replace(" ", "").trim();
			System.out.println("2번째 문자를 입력하세요.");
			word2 = br.readLine().replace(" ", "").trim();
			
			Anagram(word1, word2);
			
			
			System.out.println();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		new AnagramAnswer();
	}
	
	public void Anagram(String w1, String w2){
		int l1 = w1.length();
		int l2 = w2.length();
		int count = 0;
		int w1duple = 0;
		int w2duple = 0;
		
		if(l1 == l2){
			for(int i = 0 ; i < l1; i++){
				for(int j = 0; j < l2; j++){
					if(w1.charAt(i) == w2.charAt(j)){
						count++;
					}
				}
				
				for(int j = i+1; j < l2; j++){
					if(w1.charAt(i) == w1.charAt(j)){
						w1duple++;
					}
					if(w2.charAt(i) == w2.charAt(j)){
						w2duple++;
					}
				}
			}
			if(w1duple == w2duple){
				count -= (w1duple + w1duple);
			}
			
			if(count == l1 && count == l2){
				System.out.println("애너그램입니다.");
			} else {
				System.out.println("애너그램이 아닙니다.");
			}
		} else {
			System.out.println("애너그램이 아닙니다.");
		}
	}

}
