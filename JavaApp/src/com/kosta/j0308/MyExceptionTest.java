package com.kosta.j0308;

class MyException extends Exception{
	//	�ڽ� 			is a 	�θ�
	public MyException(String message) {
		//���� Ŭ���� ������ȣ��
		super(message);
		
	}
	
}

public class MyExceptionTest {
	
	public static void main(String[] args) {
		try {
			throw new MyException("��� ����~!!");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
