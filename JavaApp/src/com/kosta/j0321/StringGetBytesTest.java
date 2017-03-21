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
		
		//버퍼에 있는 데이터를 비워주는(출력해주는) 기능
		//System.out.flush();//flush() ---> 출객체쪽에 존재
		System.out.close();
		
	}

}
