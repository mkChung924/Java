package com.kosta.team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class PropTest {
	
	Properties prop;
	Properties prop1;
	FileOutputStream fos;
	FileInputStream fis;
	OutputStreamWriter osw;
	
	public PropTest() {
		try {
			
			prop = new Properties();
			
			prop.setProperty("사과", "Apple");
			
			System.out.println(prop.getProperty("사과"));
			
			String fileName = "fruit.properties";
			fos = new FileOutputStream(fileName);
			osw = new OutputStreamWriter(fos, "utf-8");
			
			prop.store(osw, "코멘트");
			osw.close();
			fos.close();
			System.out.println(fileName + " 저장완료!");
			
			
			prop1 = new Properties();
			fis = new FileInputStream(fileName);
			
			prop1.load(fis);
			fis.close();
			System.out.println(fileName + " 로드완료!");
			
			System.out.println(prop1.getProperty("사과"));
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new PropTest();
	}

}
