package com.kosta.j0426;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DOMTest {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	

	
	public DOMTest() {
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//재료(xml문서) 전달
			
			doc = builder.parse("0426/test.xml");
			
			System.out.println("DOM파싱 성공"); //text한 xml분석 ----> 메모리 로딩
			
			//--------------- DOM PROGRAMMING 시작 ------------------------------------
			
			Element root = doc.getDocumentElement();
			System.out.println("Name of Tag : " + root.getTagName());
			
			//루트의 자식구하기
			Node child = root.getFirstChild();
			System.out.println("FirstChild NodeValue: " + child.getNodeValue());
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new DOMTest();
	}
}
