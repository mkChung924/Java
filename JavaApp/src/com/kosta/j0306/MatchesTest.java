package com.kosta.j0306;

public class MatchesTest {
	public static void main(String args[]){
		
		//String str ="";
		String str = "b";
		
		//boolean str.matches(String regex)
		//regex ---> regular expression (���� ǥ����)
		//regex�� ���� ���޵Ǵ� ���Ͽ� str�� ����(match)�Ǹ� true�� ����
		
		System.out.println(str.matches("[a]"));// a���� �ѹ�
		System.out.println(str.matches("[a]?"));// a���� 0,1
		System.out.println(str.matches("[a]*"));// a���� 0~���Ѵ�
		System.out.println(str.matches("[a]+"));// a���� 1~���Ѵ�
		//?,*,+ : Ƚ���� ǥ���ϴ� ��ȣ
		
		System.out.println(str.matches("[abc]"));// a �Ǵ� b �Ǵ� c ���� �� 1�� ����
		
		String name = "gildong";
		
		//name ������ ���� ������ üũ!!
		System.out.println(name.matches("[a-zA-Z]+"));
		
		String number = "12345";
		System.out.println(number.matches("[0-9]+"));
		
		String korean = "���ѱ�";
		
		System.out.println(korean.matches("[��-�R]+"));
		
		String id = "mkchung924";
		//id ������ 8~12�ڸ�, �����ڿ� ���� ����
		
		System.out.println(id.matches("[a-zA-Z0-9]{8,12}"));
	}

}
