package com.kosta.j0306;

public class StringTest {
	
	public static void main(String args[]){
		String str = "JavaProgramming";
		System.out.println("str = " + str);
		
		//���ڿ� ����
		System.out.println("str ���ڿ� ���� = " + str.length());
		
		//�κй��ڿ� ---> "Pro"���ڿ� ���
		System.out.println("str.substring(4, 7) = " + str.substring(4, 7));
		
		//�κй��ڿ� ---> "Programming"
		//str.substring(beginIndex); ---> beginIndex���� ������ �κй��ڿ� ���
		System.out.println("str.substring(4) = " + str.substring(4));
		
		//Ư�������� �ε��� ������ : str.indexOf(int ch) / str.indexOf(String str)

		System.out.println("str.indexOf(97) = " + str.indexOf(97));
		System.out.println("str.indexOf('P') = " + str.indexOf('P'));
		System.out.println("str.indexOf(\"am\") = " + str.indexOf("am"));
		System.out.println("str.lastIndexOf('a') = " + str.lastIndexOf('a'));
		System.out.println("str.substring(str.indexOf('P')) = " + str.substring(str.indexOf('P')));
		
		int idx = str.indexOf('p');
		if(idx != -1){
			System.out.println("str.substring(str.indexOf('P')) = " + str.substring(idx));
		} else {
			System.out.println("��ġ�ϴ� ���ڸ� ã�� ���߽��ϴ�."); 
		}
		
		//charAt(int index) ----> index�� �ش��ϴ� �ϳ��� ���ڸ� ����!!
		System.out.println("str.charAt(4) = " + str.charAt(4));
		
		//String str = "JavaProgrammaing"
		//���ڿ� ġȯ(��ü)
		//str.replace(oldChar, newChar)
		//str.replace(CharSequence target, CharSequence replacement)
		System.out.println("str.replace('a', 'o') = " + str.replace('a', 'o'));
		System.out.println("str.replace(\"Java\", \"�ڹ�\") = " + str.replace("Java", "�ڹ� "));
		System.out.println("str = " + str);
		
		//���ڿ� �����߰�!
		str = "  " + str + "  ";
		System.out.println("str���ڿ� ���� = " + str.length());
		
		//���ڿ� ����(���ڿ� �յڿ� ���ӵ� ������ ����) = trim()
		str.trim();
		System.out.println(str.trim().length());
		
		System.out.println((int)'A');
		
		String sss = "push";
		String ss[] = sss.split(" ");

	}

}
