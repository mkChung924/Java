package com.kosta.j0331;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class FileOutputTest {
	
	FileOutputStream fos;
	ObjectOutputStream oos;
	Vector<Object> vector;
	Vector<Beans> vectorB;
	
	public FileOutputTest() {
		
		try {
			fos = new FileOutputStream("test.txt");
			oos = new ObjectOutputStream(fos);
			
			vector = new Vector<>();
			vectorB = new Vector<>();
			String name = "ȫ�浿";
			int age = 27;
			
			vector.add(name);
			vector.add(age);
			
			Beans beans1 = new Beans("�����",21,"�л�");
			Beans beans2 = new Beans("���ֿ�",22,"����");
			
			vectorB.add(beans1);
			vectorB.add(beans2);
			
			oos.writeObject(name);
			oos.writeInt(age);
			oos.writeObject(vector);
			oos.writeObject(vectorB);
			
			oos.close();
			fos.close();
			
			System.out.println("��ü�����Ϸ�!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	public static void main(String[] args) {
		new FileOutputTest();
	}
}
