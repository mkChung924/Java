package com.kosta.j0321;

public class StringGetBytesTest {
	
	public static void main(String[] args) {
		
		/*
		 * 			getBytes()							toCharArray()
		 * <------------------------			--------------------------->
		 * byte[] b 				String str					char[] ch
		 * ={97,98,99}				='abc';						={'a','b','c'}
		 * ------------------------->			<---------------------------
		 * 			new String(b);
		 */
		String str = "java is wonderful programming!!!!??";
		byte b[] = str.getBytes();
		for(int i = 0; i < b.length; i++){
			System.out.write(b[i]);
			if(i%3== 2) System.out.write('\n');
		}
		
		//���ۿ� �ִ� �����͸� ����ִ�(������ִ�) ���
		//System.out.flush();//flush() ---> �ⰴü�ʿ� ����
		System.out.close();
		
	}

}
