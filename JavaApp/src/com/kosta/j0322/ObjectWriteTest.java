package com.kosta.j0322;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteTest {
	
	public static void main(String[] args) throws IOException{
		
		FileOutputStream fos = new FileOutputStream("person.ser");
		//ObjectOutputStream oos = new ObjectOutputStream(OutputStream out)
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p = new Person();
		
		
		Person p2 = new Person();
		p2.name = "길라임";
		p2.age = 15;
		p2.job = "학생";
		
		int su = 123;
		
		oos.writeObject(p);
		oos.writeObject(p2);
		oos.writeInt(su);
		
		oos.close();
		fos.close();
		
		System.out.println("객체쓰기 성공!!");
		
	}

}
