package com.kosta.team;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Vector;

class SortedProperties extends Properties {
	  public Enumeration keys() {
	     Enumeration keysEnum = super.keys();
	     Vector<String> keyList = new Vector<String>();
	     while(keysEnum.hasMoreElements()){
	       keyList.add((String)keysEnum.nextElement());
	     }
	     Collections.sort(keyList);
	     return keyList.elements();
	  }
}

public class PropertiesTest{
	
	Properties prop;
	OutputStreamWriter osw;
	InputStreamReader isr;
	FileOutputStream fos;
	FileInputStream fis;
	SortedProperties sprop;

	public PropertiesTest() {
		
		System.out.println("Properties는 Map을 상속받는다."
				+ "\nkey(키)와 value(값)으로 데이터를 저장할뿐만 아니라 파일로 입출력이 가능하다."
				+ "\n저장되는 형식은 key=value 이며, 파일 확장자명은 .properties 로 저장한다.\n");
		
			prop = new Properties();
			sprop = new SortedProperties();
			
			sprop.setProperty("구로", "가산");
			sprop.setProperty("안산", "상록수");
			sprop.setProperty("수원", "수원역");
			sprop.setProperty("서울", "서울역");
			
			System.out.println("sprop.setProperty(\"구로\", \"가산\")"
					+ "\nsprop.setProperty(\"안산\", \"상록수\")"
					+ "\nsprop.setProperty(\"수원\", \"수원역\")"
					+ "\nsprop.setProperty(\"서울\", \"서울역\")");
			System.out.println();
			saveProp();
			loadProp();
			loadXML();
			
			System.out.println("\nSet 특성상 order된 상태로 저장되거나 불러와지지 않는다."
					+ "\n저장할 때 vector에 담아 sort를 하고 저장할 수 있다."
					+ "\n물론 불러올 때도 같은 방법으로 sort할 수 있겠다.");
			
		//System.out.println(prop);
		
		//System.out.println(prop.get("한국의 수도"));
	
	}
	
	public void saveProp(){
		try {
			
			fos = new FileOutputStream("test.properties");
			osw = new OutputStreamWriter(fos, "utf-8");
			sprop.store(osw, "프로퍼티 저장");
						
			osw.close();
			fos.close();
		
			System.out.println("saveProp(); - 프로퍼티 저장 완료!");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadProp(){
		
		try {
			
			fis = new FileInputStream("test.properties");
			isr = new InputStreamReader(fis,"utf-8");
			sprop.load(isr);
			isr.close();
			fis.close();
			
			System.out.println("loadProp(); - 프로퍼티 불러오기 완료!");
			
			System.out.println();
			System.out.println("**Properties 내 키-값 모두 출력");
			sprop.list(System.out);
			//System.out.println(prop.getProperty("한국의 수도"));
			
			System.out.println();
			System.out.println("**Properties value 전체출력");
			System.out.println(sprop.values());
			
			System.out.println();
			System.out.println("->Enumeration");
			Enumeration e = sprop.propertyNames();
			
			while(e.hasMoreElements()){
				String key = (String) e.nextElement();
				String value = (String) sprop.getProperty(key);
				System.out.println("key: " + key +", value: " + value);
			}
			
			System.out.println();
			System.out.println("->Iterator");
			Iterator<Object> it = sprop.keySet().iterator();
			
			while(it.hasNext()){
				String key = (String) it.next();
				String value = (String) sprop.getProperty(key);
				System.out.println("key: " + key +", value: " + value);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadXML(){
		try {
			System.out.println();
			System.out.println("**XML 파일 형식의 Properties 불러오기");
			fis = new FileInputStream("url.xml");
			prop.loadFromXML(fis);
			fis.close();
			System.out.println("loadXML(); - url.xml 로드 완료!");
			
			System.out.println();
			System.out.println("전체 목록 출력 - prop.list(System.out)");
			prop.list(System.out);
			
			System.out.println();
			System.out.println("전체 value 출력 - prop.values()");
			System.out.println(prop.values());
			
			System.out.println();
			System.out.println("->Enumeration");
			Enumeration e = prop.keys();
			while(e.hasMoreElements()){
				String keys = (String) e.nextElement();
				String values = (String) prop.getProperty(keys);
				System.out.println("key: " + keys + ", value: " + values);
				
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
	
	public static void main(String[] args){
		new PropertiesTest();
	}
}
