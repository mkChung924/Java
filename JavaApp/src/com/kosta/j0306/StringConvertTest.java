package com.kosta.j0306;

public class StringConvertTest {

	void convert1(){
//		long start = System.currentTimeMillis();
		String s1 = "�츮����";
		String s2 = "���ѹα�����!!";
		
		s1 = s1 + s2;
		/*
		 *String Ŭ����: �������ڿ�!!
		 *1. String Ŭ���� ��ü ����
		 *2. ���ڿ� ��ȯ�� ���ؼ� �ӽ÷� StringBufferŬ���� ��ü ����
		 *3. append()�޼ҵ� ȣ��
		 *4. StringBuffer��ü�� String ��ü�� ��ȯ
		 *5. �ӽû����� StringBuffer��ü�� �Ҹ�.
		 */
		System.out.println(s1);
		
//		long end = System.currentTimeMillis();
//		System.out.println("���� �ð�: " + (end - start)/1000.0 + "s");
	}
	
	void convert2(){
//		long start = System.currentTimeMillis();
		StringBuffer s1 = new StringBuffer("�츮����");
		s1.append("���ѹα�����!!");
		s1.append("�ѱ�¯¯��");
		/*
		 *StringBufferŬ���� : �������ڿ�
		 *1. StringBufferŬ���� ��ü ����
		 *2. append()�޼ҵ� ��
		 */
		System.out.println(s1);
//		long end = System.currentTimeMillis();
//		System.out.println("���� �ð�: " + (end - start)/1000.0 + "s");

		
	}
		public static void main(String args[]){
			
			StringConvertTest sct = new StringConvertTest();
			sct.convert1();
			sct.convert2();
		
	}
	
	
}
