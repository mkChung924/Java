package com.kosta.j0321;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {
	
	public static void main(String[] args) throws IOException{
		//파일 복사 테스트
		
		
		//파일을 읽어서 콘솔에 출력(파일(a.txt) ----> 콘솔)
		FileReader fr = new FileReader("a.txt");
		
		//fr.read();//읽은 문자에 대한 아스키코드(숫자) 값을 리턴
//		System.out.println(fr.read());
//		System.out.println(fr.read());
//		System.out.println(fr.read());
//		System.out.println(fr.read());
		
		//비교: (fr.read() == -1) ----> 더이상 읽을 문자가 없다면 true 리턴
		//비교: (fr.read() != -1) ----> 더이상 읽을 문자가 있다면 true 리턴
		
		FileWriter fw = new FileWriter("b.txt");
		//FileWriter는 파일생성이 가능하지만 디렉토리는 생성이 불가능
		int i;
		
		while((i=fr.read()) != -1){
			System.out.print((char) i);
			//fw.write((char)i);
			fw.write(i);
		}
		//사용한 입출력 객체에 대한 자원 반환
		fw.close();
		fr.close();
		
		System.out.println("파일복사 성공~~!");
		
		
		//파일을 읽어서 파일에 출력(파일1 ----> 파일2) : File Copy
			
	}

}
