package com.kosta.j0322;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadTest {//객체 읽기 테스트
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		FileInputStream fis = new FileInputStream("person.ser");
		//ObjectInputStream ois = new ObjectInputStream(InputStream in); 
		ObjectInputStream ois = new ObjectInputStream(fis); 
		Person p = (Person) ois.readObject();
		System.out.println("이름: " + p.name);
		System.out.println("나이: " + p.age);
		System.out.println("직업: " + p.job);
		System.out.println("=========================");
		Person p2 = (Person) ois.readObject();
		System.out.println("이름: " + p2.name);
		System.out.println("나이: " + p2.age);
		System.out.println("직업: " + p2.job);
		
		System.out.println("=========================");
		int su = ois.readInt();
		System.out.println("su = " + su);
		
		ois.close();
		fis.close();
	}

}
