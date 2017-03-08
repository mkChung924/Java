package com.kosta.j0308;

class MyException extends Exception{
	//	자식 			is a 	부모
	public MyException(String message) {
		//상위 클래스 생성자호출
		super(message);
		
	}
	
}

public class MyExceptionTest {
	
	public static void main(String[] args) {
		try {
			throw new MyException("당신 에러~!!");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
