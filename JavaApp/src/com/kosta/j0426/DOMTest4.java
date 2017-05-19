package com.kosta.j0426;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest4 {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	
	/*
	 * 미션: books.xml 을 DOM Parsing하여 첫번째 book의 title을 화면에 출력하시오.
	 * 결과화면) JavaProgramming
	 * 
	 * ==> 단, 부모	자식		형제 관계를 통해 문제를 해결하세요.
	 * 		parent	child	sibling
	 * 
	 * doc------> books ------> book ------> title -----> TextNode("JavaProgramming")
	 * 
	 */
	
	public DOMTest4() {
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//재료(xml문서) 전달
			
			doc = builder.parse("0426/books.xml");
			
			System.out.println("DOM파싱 성공"); //text한 xml분석 ----> 메모리 로딩
			
			//--------------- DOM PROGRAMMING 시작 ------------------------------------
			
			Element root = doc.getDocumentElement();
			System.out.println("루트 엘리먼트명 : " + root.getTagName());
			
			//루트의 자식구하기
			//첫번째 <book>의 책 제목 출력
			String title = root.getFirstChild().getNextSibling().getFirstChild().getNextSibling().getFirstChild().getNodeValue();
			System.out.println("Title: "+title);
			
			NodeList list = root.getChildNodes();
			
			//System.out.println(list.getLength());
			for(int i = 0; i < list.getLength(); i++){
				if(list.item(i).getNodeName().equals("book")){
				
					NodeList list2 = list.item(i).getChildNodes();
					for(int j = 0; j < list2.getLength(); j++){
						if(list2.item(j).getNodeName().equals("title")){
							System.out.println("Title: "+list2.item(j).getTextContent());
							break;
						}
						
					}

					break;
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
		new DOMTest4();
	}
}
