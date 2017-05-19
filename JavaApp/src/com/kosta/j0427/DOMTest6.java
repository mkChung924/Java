package com.kosta.j0427;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest6 {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	
	/*
	 * (별*)(별*)
	 * 미션: books.xml 을 DOM Parsing하여 모든 책 제목을 화면에 출력하시오.
	 * 결과화면) JavaProgramming
	 * 		   OraclSQL
	 * 		   JavaScript
	 * 		   XMLBible
	 * 
	 * ==> Document에 있는 메소드 사용!!
	 * 			Element getElementById(String id)
	 * 			NodeList getElementsByTagName(String name)
	 * 
	 * 미션2: books.xml을 DOM Parsing하여 모든 책 정보를 화면에 출력하시오.
	 * 결과화면)
	 * 			#책 정보
	 * 			JavaProgramming(홍길동) : 25000원
	 * 			OracleSQL(길라임) : 32000원
	 * 			JavaScript(김주원) : 33000원
	 * 			XMLBible(홍길동) : 35000원
	 * 
	 * 미션3: books.xml을 DOM Parsing하여 홍길동 책 정보를 화면에 출력하시오.
	 * 결과화면)
	 * 			#책 정보
	 * 			JavaProgramming[25000원]
	 * 			XMLBible[35000원]
	 */
	
	public DOMTest6() {
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			
			//재료(xml문서) 전달
			
			doc = builder.parse("0426/books3.xml");
			
			System.out.println("DOM파싱 성공"); //text한 xml분석 ----> 메모리 로딩
			
			//--------------- DOM PROGRAMMING 시작 ------------------------------------
			
			//모든 책의 제목 출력
			NodeList titleList = doc.getElementsByTagName("title"); //<title><title><title><title>
			System.out.println("#책 목록");
			for(int i = 0; i < titleList.getLength(); i++){
				System.out.println("["+(i+1)+"] "+titleList.item(i).getFirstChild().getNodeValue());
											//NodeList	<title>	<TextNode>		텍스트데이터
			}
			
			
			//모든 책의 정보 출력
			NodeList authorList = doc.getElementsByTagName("author");
			NodeList priceList = doc.getElementsByTagName("price");
			
			System.out.println("#책 정보");
			for(int i = 0; i < titleList.getLength(); i++){
				System.out.println("["+(i+1)+"]"+titleList.item(i).getFirstChild().getNodeValue() +
						"("+ authorList.item(i).getFirstChild().getNodeValue() +")" +
						" : " + priceList.item(i).getFirstChild().getNodeValue() + "원");
			}
			
			//홍길동 책 정보 출력
			String searchAuthor = "홍길동";
			System.out.println("#책 정보("+searchAuthor+")");
			for(int i = 0; i < authorList.getLength(); i++){
				String name = authorList.item(i).getFirstChild().getNodeValue();
				if(name.equals(searchAuthor)){
					String title = titleList.item(i).getFirstChild().getNodeValue();
					String price = priceList.item(i).getFirstChild().getNodeValue();
					System.out.println(title+"["+price+"원]");
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
		new DOMTest6();
	}
}
