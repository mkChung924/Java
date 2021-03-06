package com.kosta.j0306;

public class MatchesTest {
	public static void main(String args[]){
		
		//String str ="";
		String str = "b";
		
		//boolean str.matches(String regex)
		//regex ---> regular expression (정규 표현식)
		//regex를 통해 전달되는 패턴에 str이 부합(match)되면 true를 리턴
		
		System.out.println(str.matches("[a]"));// a문자 한번
		System.out.println(str.matches("[a]?"));// a문자 0,1
		System.out.println(str.matches("[a]*"));// a문자 0~무한대
		System.out.println(str.matches("[a]+"));// a문자 1~무한대
		//?,*,+ : 횟수를 표현하는 부호
		
		System.out.println(str.matches("[abc]+"));// a 또는 b 또는 c 문자 중 1번 출현
		
		String name = "gildong";
		
		//name 변수에 대해 영문자 체크!!
		System.out.println(name.matches("[a-zA-Z]+"));
		
		String number = "12345";
		System.out.println(number.matches("[0-9]+"));
		
		String korean = "나한글";
		
		System.out.println(korean.matches("[ㄱ-힣]+"));
		
		String id = "mkchung924";
		//id 변수는 8~12자리, 영문자와 숫자 조합
		
		System.out.println(id.matches("[a-zA-Z0-9]{8,12}"));
	}

}
