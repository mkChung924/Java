package com.kosta.j0306;

public class StringTest2 {
	public static void main(String args[]){
		
		String str = "Java3Prog7rammi9ng";
		
		int cnt = 0;
		for(int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			
			if(ch >= '0' && ch <= '9'){
				cnt++;
			}
		}
		System.out.println("¼ýÀÚ °¹¼ö: " + cnt);
		
	}

}
