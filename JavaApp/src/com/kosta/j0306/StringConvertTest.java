package com.kosta.j0306;

public class StringConvertTest {

	void convert1(){
//		long start = System.currentTimeMillis();
		String s1 = "우리나라";
		String s2 = "대한민국만세!!";
		
		s1 = s1 + s2;
		/*
		 *String 클래스: 고정문자열!!
		 *1. String 클래스 객체 생성
		 *2. 문자열 변환을 위해서 임시로 StringBuffer클래스 객체 생성
		 *3. append()메소드 호출
		 *4. StringBuffer객체를 String 객체로 변환
		 *5. 임시생성된 StringBuffer객체를 소멸.
		 */
		System.out.println(s1);
		
//		long end = System.currentTimeMillis();
//		System.out.println("실행 시간: " + (end - start)/1000.0 + "s");
	}
	
	void convert2(){
//		long start = System.currentTimeMillis();
		StringBuffer s1 = new StringBuffer("우리나라");
		s1.append("대한민국만세!!");
		s1.append("한국짱짱맨");
		/*
		 *StringBuffer클래스 : 가변문자열
		 *1. StringBuffer클래스 객체 생성
		 *2. append()메소드 실
		 */
		System.out.println(s1);
//		long end = System.currentTimeMillis();
//		System.out.println("실행 시간: " + (end - start)/1000.0 + "s");

		
	}
		public static void main(String args[]){
			
			StringConvertTest sct = new StringConvertTest();
			sct.convert1();
			sct.convert2();
		
	}
	
	
}
