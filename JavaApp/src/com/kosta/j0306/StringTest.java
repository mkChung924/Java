package com.kosta.j0306;

public class StringTest {
	
	public static void main(String args[]){
		String str = "JavaProgramming";
		System.out.println("str = " + str);
		
		//문자열 길이
		System.out.println("str 문자열 길이 = " + str.length());
		
		//부분문자열 ---> "Pro"문자열 얻기
		System.out.println("str.substring(4, 7) = " + str.substring(4, 7));
		
		//부분문자열 ---> "Programming"
		//str.substring(beginIndex); ---> beginIndex부터 끝까지 부분문자열 얻기
		System.out.println("str.substring(4) = " + str.substring(4));
		
		//특정문자의 인덱스 얻어오기 : str.indexOf(int ch) / str.indexOf(String str)

		System.out.println("str.indexOf(97) = " + str.indexOf(97));
		System.out.println("str.indexOf('P') = " + str.indexOf('P'));
		System.out.println("str.indexOf(\"am\") = " + str.indexOf("am"));
		System.out.println("str.lastIndexOf('a') = " + str.lastIndexOf('a'));
		System.out.println("str.substring(str.indexOf('P')) = " + str.substring(str.indexOf('P')));
		
		int idx = str.indexOf('p');
		if(idx != -1){
			System.out.println("str.substring(str.indexOf('P')) = " + str.substring(idx));
		} else {
			System.out.println("일치하는 문자를 찾지 못했습니다."); 
		}
		
		//charAt(int index) ----> index에 해당하는 하나의 문자를 리턴!!
		System.out.println("str.charAt(4) = " + str.charAt(4));
		
		//String str = "JavaProgrammaing"
		//문자열 치환(대체)
		//str.replace(oldChar, newChar)
		//str.replace(CharSequence target, CharSequence replacement)
		System.out.println("str.replace('a', 'o') = " + str.replace('a', 'o'));
		System.out.println("str.replace(\"Java\", \"자바\") = " + str.replace("Java", "자바 "));
		System.out.println("str = " + str);
		
		//문자열 공백추가!
		str = "  " + str + "  ";
		System.out.println("str문자열 길이 = " + str.length());
		
		//문자열 제거(문자열 앞뒤에 연속된 공백을 제거) = trim()
		str.trim();
		System.out.println(str.trim().length());
		
		System.out.println((int)'A');

	}

}
