package com.kosta.j0331;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;

public class FileInputTest {
	
	FileInputStream fis;
	ObjectInputStream ois;
	Vector<Object> vector;
	Vector<Beans> vectorB;
	public FileInputTest() {
		
		try {
			
			fis = new FileInputStream("test.txt");
			ois = new ObjectInputStream(fis);
			
			
			String name = (String) ois.readObject();
			int age = ois.readInt();
			vector = (Vector) ois.readObject();
			vectorB = (Vector) ois.readObject();
			
			ois.close();
			fis.close();
			
			System.out.println(name);
			System.out.println(age+"");
			System.out.println(vector.get(0) + ", " + vector.get(1));
			
			for(int i = 0; i < vectorB.size(); i++){
				System.out.println(vectorB.get(i).getName() + ", " + vectorB.get(i).getAge() + ", " + vectorB.get(i).getJob());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	
	public static void main(String[] args) {
		new FileInputTest();
	}
}
