package com.kosta.team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

public class PropertiesTeam {
	
	Properties prop;
	
	public PropertiesTeam() {
	
		prop = new Properties();
		System.out.println("java.util.properties 공부");
		
		//saveProp();
		//loadProp();
		
		//saveXML();
		//loadXML();
		
	}
	
	public void saveProp(){
		
		try {
			
			String propName = "team3.properties";
			FileOutputStream fos = new FileOutputStream(propName);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
			
			prop.setProperty("경기도", "안산시");
			prop.setProperty("강원도", "속초시");
			prop.setProperty("서울시", "강남구");
			prop.setProperty("충청남도", "천안시");
			prop.setProperty("인천광역시", "연수구");
			prop.setProperty("부산광역시", "해운대구");
			
			//key는 중복 불가능
			//가장 나중에 있는 값이 저장됨.
			//저장되는 순서는.. setProperty한 순서는 아니다.
			
			//prop.store(fos, "fos 저장"); <-- 유니코드로 저장하여 저장된 목록을 확인하는데 어려움이 있음.
			prop.store(osw, "코멘트"); //위에서 utf-8로 변환해주어 저장 후에 목록을 직접 확인 가능.
			
			System.out.println(propName + " 저장 완료!");
			
			osw.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadProp(){
		
		try {
			
			prop.clear();
			String propName = "team3.properties";
			FileInputStream fis = new FileInputStream(propName);
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");

			//prop.load(fis); prop.save(fos)로 한경우 유니코드 대 유니코드로 잘 가져옴. prop.save(osw)로 한 경우 utf-8 대 유니코드이므로 모든 값 null포 표시됨.
			prop.load(isr); // utf-8 대 utf-8 로 잘 가져옴.
			
			System.out.println(propName + " 불러오기 성공!");

			System.out.println("\nEnumeration");

			System.out.println("Enumeration - with sorting");
			//////////////////////////////////////////////
			Enumeration e = prop.keys();
			Vector v = new Vector();
			
			while(e.hasMoreElements()){
				String key = (String) e.nextElement();
				v.add(key);
				//String value = (String) prop.getProperty(key);
			}
			
			Collections.sort(v);
			
		    Iterator it = v.iterator();
		    while(it.hasNext()){
		    	String key = (String) it.next();
		    	String value = (String) prop.get(key);
		    	System.out.println("key : " + key + " / value : " + value);
		    }
		    /////////////////////////////////////////////////
			
		    System.out.println("\nEnumeration - without sorting");
			Enumeration e2 = prop.propertyNames();
			
		    while(e2.hasMoreElements()){
		    	String key = (String) e2.nextElement();
		    	String value = (String) prop.getProperty(key);
		    	System.out.println("key : " + key + " / value : " + value);
		    }
		    
		    ///////////////////////////////////////////////////
		    
		    System.out.println("\nIterator");
		    
		    Iterator iterator = prop.keySet().iterator();
		    while(iterator.hasNext()){
		    	String key = (String) iterator.next();
		    	String value = (String) prop.getProperty(key);
		    	System.out.println("key : " + key + " / value : " + value);
		    }
		    
		    //////////////////////////////////////////////////////
		    //위의 방법 이외에 key와 value를 print할 수 있는 방법들
		    System.out.println("\n위의 방법 이외에 key와 value를 print할 수 있는 방법들");
		    System.out.println("prop.stringPropertyNames() : "+prop.stringPropertyNames());
		    System.out.println("prop.stringPropertyNames().toArray()[0] : "+prop.stringPropertyNames().toArray()[0]);
		    System.out.println("prop.values() : "+prop.values());
		    System.out.println("prop : " + prop);
		    System.out.println("prop.list(System.out) : \n");
		    prop.list(System.out);
		    
			
			isr.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

	}
	
	public void saveXML(){
		try {
			
			prop.clear();
			String propName = "team2.xml";
			FileOutputStream fos = new FileOutputStream(propName);
			
			prop.setProperty("경기도", "안산시");
			prop.setProperty("강원도", "속초시");
			prop.setProperty("서울시", "강남구");
			prop.setProperty("충청남도", "천안시");
			prop.setProperty("인천광역시", "연수구");
			prop.setProperty("부산광역시", "해운대구");
			
			//key는 중복 불가능
			//가장 나중에 있는 값이 저장됨.
			//저장되는 순서는.. setProperty한 순서는 아니다.
			
			prop.storeToXML(fos, "코멘트", "utf-8"); 
			
			System.out.println(propName + " 저장 완료!");
			
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void loadXML(){
		try {
			
			prop.clear();
			System.out.println();
			System.out.println("**XML 파일 형식의 Properties 불러오기");
			FileInputStream fis = new FileInputStream("team2.xml");
			prop.loadFromXML(fis);
			fis.close();
			
			System.out.println("loadXML(); - url.xml 로드 완료!");
			
			System.out.println();
			System.out.println("전체 목록 출력 - prop.list(System.out)");
			prop.list(System.out);
			
			System.out.println();
			System.out.println("전체 key 출력 - prop.stringPropertyNames() \n" + prop.stringPropertyNames());
			
			System.out.println();
			System.out.println("전체 value 출력 - prop.values() \n" + prop.values());
			
			System.out.println();
			System.out.println("->Enumeration");
			Enumeration e = prop.keys();
			while(e.hasMoreElements()){
				String keys = (String) e.nextElement();
				String values = (String) prop.getProperty(keys);
				System.out.println("key: " + keys + " / value: " + values);
				
			}
			
			System.out.println();
			System.out.println("->Iterator");
			Iterator iterator3 = prop.keySet().iterator();
			while(iterator3.hasNext()){
				String key = (String) iterator3.next();
				String value = (String) prop.get(key);
				System.out.println("key: " + key + " / value: " + value);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new PropertiesTeam();
	}

}
