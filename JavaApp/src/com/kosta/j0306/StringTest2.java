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
		System.out.println("���� ����: " + cnt);
		
		System.out.println("str�빮�� ��ȯ : " + str.toUpperCase());
		System.out.println("str�ҹ��� ��ȯ : " + str.toLowerCase());
		
		
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
		System.out.println("str���� ���� ���� : " + count);
		
		byte b2[] = {65,66,67,68};
		String str2 = new String(b2); //����Ʈ�迭 ---> ���ڿ� ��ȯ
		System.out.println(str2);
		
		String s1 = "java";
		String s2 = "JAVA";
		
		//s1�� s2 ���ڿ� ��
		if(s1.equals(s2)){
			System.out.println("TRUE - ���ڿ� ����");
		} else {
			System.out.println("FALSE - ���ڿ� �ٸ�");
		}
		
		//s1�� s2���ڿ� (����)�� - ��ҹ��� ���о���
		
		if(s1.equalsIgnoreCase(s2)){
			System.out.println("TRUE - (��ҹ��� ���о���)���� ����");
		}else{
			System.out.println("FALSE - (��ҹ��� ���о���)���� �ٸ�");
		}
		
		//����2) String tel = "010-123-4567"
		//���� ����Ǵ� String tel1, tel2, tel3 ������ ���� "010", "123", "4567"�� �����Ͻÿ�.
		
		String tel = "010-9474-6430";
//		String tel1 = tel.substring(0, 3);
//		String tel2 = tel.substring(4,7);
//		String tel3 = tel.substring(8,12);
//		System.out.println(tel1 +" "+ tel2 +" "+ tel3);
		
		//���1.split �޼ҵ�
		String tels[] = tel.split("-");
		System.out.println("split: " + tels[0] + " " + tels[1] + " " + tels[2]);
		
		//���2. indexOf�� '-' �ε��� �ľ� �� substring
		int front = tel.indexOf('-');
		int back = tel.lastIndexOf('-');
		
		System.out.print("substring: ");
		System.out.print(tel.substring(0, front) + " ");
		System.out.print(tel.substring(front + 1, back)+ " ");
		System.out.println(tel.substring(back+1));
		
		
		long end = System.currentTimeMillis();
		System.out.println("\n���� �ð�: " + (end - start)/1000.0 + "s");
		
	}

}
