package com.kosta.j0306;

public class StringTest2 {
	public static void main(String args[]){
		
		long start = System.currentTimeMillis();
		
		String str = "Java3Prog7rammi9ng";
		
		int cnt = 0;
		for(int i = 0; i<str.length(); i++){
			char ch = str.charAt(i);
			
			if(ch >= '0' && ch <= '9'){
				cnt++;
			}
		}
		System.out.println("숫자 갯수: " + cnt);
		
		System.out.println("str대문자 변환 : " + str.toUpperCase());
		System.out.println("str소문자 변환 : " + str.toLowerCase());
		
		
/*	str.getBytes[]			<---						--->		to.toCharArray()
 * byte b[]	= {97,98,99}		String str = "abc"			char ch[] = {'a', 'b', 'c'}
 * 						--->							<---				
 * String s1 = new String(b);							String s2 = new String(ch);
 * 
*/		
		byte b[] = str.getBytes();
		int count = 0;
		for(int i = 0; i < b.length; i++){
			if(b[i] >= 48 && b[i] <= 57){
				count++;
			}
			
		}
		
		char ch[] = str.toCharArray();
		count = 0;
		for(int i = 0; i < ch.length; i++){
			if(ch[i] >= '0' && ch[i] <= '9'){
				count++;
			}
			
		}
		System.out.println("str내의 숫자 갯수 : " + count);
		
		byte b2[] = {65,66,67,68};
		String str2 = new String(b2); //바이트배열 ---> 문자열 변환
		System.out.println(str2);
		
		String s1 = "java";
		String s2 = "JAVA";
		
		//s1과 s2 문자열 비교
		if(s1.equals(s2)){
			System.out.println("TRUE - 문자열 같음");
		} else {
			System.out.println("FALSE - 문자열 다름");
		}
		
		//s1과 s2문자열 (내용)비교 - 대소문자 구분없이
		
		if(s1.equalsIgnoreCase(s2)){
			System.out.println("TRUE - (대소문자 구분없이)내용 같음");
		}else{
			System.out.println("FALSE - (대소문자 구분없이)내용 다름");
		}
		
		//문제2) String tel = "010-123-4567"
		//새로 선언되는 String tel1, tel2, tel3 변수에 각각 "010", "123", "4567"을 저장하시오.
		
		String tel = "010-9474-6430";
//		String tel1 = tel.substring(0, 3);
//		String tel2 = tel.substring(4,7);
//		String tel3 = tel.substring(8,12);
//		System.out.println(tel1 +" "+ tel2 +" "+ tel3);
		
		//방법1.split 메소드
		String tels[] = tel.split("-");
		System.out.println("split: " + tels[0] + " " + tels[1] + " " + tels[2]);
		
		//방법2. indexOf로 '-' 인덱스 파악 후 substring
		int front = tel.indexOf('-');
		int back = tel.lastIndexOf('-');
		
		System.out.print("substring: ");
		System.out.print(tel.substring(0, front) + " ");
		System.out.print(tel.substring(front + 1, back)+ " ");
		System.out.println(tel.substring(back+1));
		
		
		long end = System.currentTimeMillis();
		System.out.println("\n실행 시간: " + (end - start)/1000.0 + "s");
		
	}

}
