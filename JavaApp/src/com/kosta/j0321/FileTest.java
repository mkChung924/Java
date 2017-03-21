package com.kosta.j0321;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args) throws IOException{
		
		//경로표현 방법(전체경로, 생략된 경로, 상대적인 경로)
		//---------> 자바의 경로는 '전체경로'가 기본!!
		//			-------> 자바의 경로안의 문자는 대소문자를 구분하지 않음.
		
		File f = new File("\\Users\\myungkyuchung\\git\\Java\\JavaApp\\a.txt");
		System.out.println("f 파일존재유무: " + f.exists());
		
		File f2 = new File("/Users/myungkyuchung/git/Java/JavaApp/a.txt");
		f2 = new File("a.txt");
		f2 = new File("."); // .경로 : current directory(현재경로)
		f2 = new File("../.."); // .. 부모경로
		System.out.println("f 파일존재유무: " + f2.exists());
		
		//경로정보 얻어오기
		System.out.println(f2.getPath());
		System.out.println(f2.getAbsolutePath());
		System.out.println(f2.getCanonicalPath());
		
		File f3 = new File("a.txt");
		System.out.println("f 파일존재유무: " + f3.exists());
		//이클립스에서 JavaProject로 생성산 Project에서만 프로젝트명까지 생략하는 것이 가능
		
		File f4 = new File("src/com/kosta/j0321/b.txt");
		System.out.println("f 파일존재유무: " + f4.exists());
		
		if(f4.isFile()){ //f4가 파일이면 리턴 true
			System.out.println("파일이다.");
		}
		
		if(f4.isDirectory()){ //f4가 디렉토리이면 리턴 true
			System.out.println("폴더이다.");
		}
		
		File f5 = new File("scr/com/kosta/j0321");
		if(f5.isDirectory()){
			System.out.println("f5는 디렉토리다.");
		}
		
		String path = "gildong/my/";
		String fileName = "c.txt";
		File f6 = new File(path);
		
		if(!f6.exists())
		f6.mkdirs();//디렉토리 생성기능
		
		//응용
		//FileWriter, FileOutputStream(파일출력객체)는 파일을 생성한다.
		FileOutputStream fos = new FileOutputStream(path+fileName); //파일생성
		
		//자원반환
		fos.close();
		
		File f7 = new File(path+fileName);
		System.out.println("삭제: "+f7.delete());//파일이나 디렉토리 삭제하는 기능
	}

}
