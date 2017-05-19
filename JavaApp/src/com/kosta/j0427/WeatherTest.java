package com.kosta.j0427;

import java.io.IOException;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherTest {
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	Document doc;
	Calendar cal;
	
	public WeatherTest() {
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			doc = builder.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1154551000");
			cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int mon = cal.get(Calendar.MONTH) + 1;
			cal.add(Calendar.DATE,1);
			int date = cal.get(Calendar.DATE);
			System.out.println(year+"�� "+ mon + "�� " + date+"��");
			
			//System.out.println("�Ľ̼���!");
			//===============DOM ���α׷��� ����=========================
			
			NodeList categoryList = doc.getElementsByTagName("category");
			//System.out.println(categoryList.item(0).getFirstChild().getNodeValue()); //����Ư���� ��õ�� ���굿
			String city = categoryList.item(0).getFirstChild().getNodeValue();
			
			NodeList dataList = doc.getElementsByTagName("data");
			NodeList hourList = doc.getElementsByTagName("hour");
			NodeList dayList = doc.getElementsByTagName("day");
			NodeList tempList = doc.getElementsByTagName("temp");
			NodeList maxTempList = doc.getElementsByTagName("tmx");
			NodeList minTempList = doc.getElementsByTagName("tmn");
				
			for(int i = 0; i < dataList.getLength(); i++){
				String hour = hourList.item(i).getFirstChild().getNodeValue();
				String day = dayList.item(i).getFirstChild().getNodeValue();
				String temp = tempList.item(i).getFirstChild().getNodeValue();
				String maxTemp = maxTempList.item(i).getFirstChild().getNodeValue();
				String minTemp = minTempList.item(i).getFirstChild().getNodeValue();
				
				if(hour.equals("15")){
					
					if(day.equals("1")){
						System.out.println("���� " + city +" "+ hour +"�� ����� " + temp + "�� �Դϴ�.");
						System.out.println("�ְ��� " + maxTemp +"��, ������� " + minTemp +" �Դϴ�.");
						System.out.println();
				
						
					} else if(day.equals("2")){
						System.out.println("�� "+ city +" "+ hour +"�� ����� " + temp + "�� �Դϴ�.");
						System.out.println("�ְ��� " + maxTemp +"��, ������� " + minTemp +" �Դϴ�.");
					}
									
				}
			}
					
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new WeatherTest();
	}

}
