package com.kosta.j0307;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {
	
	//파일(안의 내용)을 읽어서 콘솔에 출
	void readFile() {
		/*
		 * <자바 입출력 4대 클래스> - 추상클래스
		 * 		입력					출
		 * -InputStream			OutputStream	: byte단위의 입력, 출
		 * -Reader				Writer			: char(2byte) 단위의 입력, 출력
		 * 
		 * FileInputStream
		 * FileReader
		 */
		
		//FileReader fr = new FileReader("파일의경로와파일명");
		
		try{ //만약에 try 내에서 예외가 발생한다면~
		FileReader fr = new FileReader("/Users/myungkyuchung/git/Java/JavaApp/a.txt");//FileNotFoundException
		
		int i;
		while((i = fr.read()) != -1){
			System.out.print((char)i);//IOException
		}

		System.out.println("파일 읽기 성공!!");
		} catch(FileNotFoundException fe) {
			System.out.println("파일을 찾지 못했습니다!");
		} catch(IOException ie){
			
		} finally {
			System.out.println("finally 성공/실패 상관없이 항상 실행(?) YES!");
		}
		
	} //readFile
	
	public static void main(String args[]){
		ExceptionTest et = new ExceptionTest();
		et.readFile();
		
	}

}
