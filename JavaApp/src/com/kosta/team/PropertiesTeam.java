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
		System.out.println("java.util.properties ����");
		
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
			
			prop.setProperty("��⵵", "�Ȼ��");
			prop.setProperty("������", "���ʽ�");
			prop.setProperty("�����", "������");
			prop.setProperty("��û����", "õ�Ƚ�");
			prop.setProperty("��õ������", "������");
			prop.setProperty("�λ걤����", "�ؿ�뱸");
			
			//key�� �ߺ� �Ұ���
			//���� ���߿� �ִ� ���� �����.
			//����Ǵ� ������.. setProperty�� ������ �ƴϴ�.
			
			//prop.store(fos, "fos ����"); <-- �����ڵ�� �����Ͽ� ����� ����� Ȯ���ϴµ� ������� ����.
			prop.store(osw, "�ڸ�Ʈ"); //������ utf-8�� ��ȯ���־� ���� �Ŀ� ����� ���� Ȯ�� ����.
			
			System.out.println(propName + " ���� �Ϸ�!");
			
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

			//prop.load(fis); prop.save(fos)�� �Ѱ�� �����ڵ� �� �����ڵ�� �� ������. prop.save(osw)�� �� ��� utf-8 �� �����ڵ��̹Ƿ� ��� �� null�� ǥ�õ�.
			prop.load(isr); // utf-8 �� utf-8 �� �� ������.
			
			System.out.println(propName + " �ҷ����� ����!");

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
		    //���� ��� �̿ܿ� key�� value�� print�� �� �ִ� �����
		    System.out.println("\n���� ��� �̿ܿ� key�� value�� print�� �� �ִ� �����");
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
			
			prop.setProperty("��⵵", "�Ȼ��");
			prop.setProperty("������", "���ʽ�");
			prop.setProperty("�����", "������");
			prop.setProperty("��û����", "õ�Ƚ�");
			prop.setProperty("��õ������", "������");
			prop.setProperty("�λ걤����", "�ؿ�뱸");
			
			//key�� �ߺ� �Ұ���
			//���� ���߿� �ִ� ���� �����.
			//����Ǵ� ������.. setProperty�� ������ �ƴϴ�.
			
			prop.storeToXML(fos, "�ڸ�Ʈ", "utf-8"); 
			
			System.out.println(propName + " ���� �Ϸ�!");
			
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
			System.out.println("**XML ���� ������ Properties �ҷ�����");
			FileInputStream fis = new FileInputStream("team2.xml");
			prop.loadFromXML(fis);
			fis.close();
			
			System.out.println("loadXML(); - url.xml �ε� �Ϸ�!");
			
			System.out.println();
			System.out.println("��ü ��� ��� - prop.list(System.out)");
			prop.list(System.out);
			
			System.out.println();
			System.out.println("��ü key ��� - prop.stringPropertyNames() \n" + prop.stringPropertyNames());
			
			System.out.println();
			System.out.println("��ü value ��� - prop.values() \n" + prop.values());
			
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
