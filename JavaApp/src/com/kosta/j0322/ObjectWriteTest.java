package com.kosta.j0322;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ObjectWriteTest {
	
	public static void main(String[] args) throws IOException{
		
		FileOutputStream fos = new FileOutputStream("person.ser");
		//ObjectOutputStream oos = new ObjectOutputStream(OutputStream out)
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Vector<Person> vector = new Vector<>();
		
		Person p = new Person();
		
		
		Person p2 = new Person();
		p2.name = "�����";
		p2.age = 15;
		p2.job = "�л�";
		
		Person p3 = new Person();
		p3.name = "�����";
		p3.age = 27;
		p3.job = "������";
		
		int su = 123;
		
		vector.add(p);
		vector.add(p2);
		vector.add(p3);
		
		oos.writeObject(p);
		oos.writeObject(p2);
		oos.writeObject(p3);
		oos.writeObject(vector);
		oos.writeInt(su);
		
		oos.close();
		fos.close();
		
		System.out.println("��ü���� ����!!");
		
	}

}
