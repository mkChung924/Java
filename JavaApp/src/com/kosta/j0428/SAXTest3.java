package com.kosta.j0428;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest3 extends DefaultHandler{
	//SAX: 이벤트기반의 파서
	SAXParserFactory factory;
	SAXParser parser;
	boolean title, author;
	String tempTitle;
	
	/*
	 * 미션: books.xml 문서내의 책 제목들을 화면에 출력하시오.
	 * 결과)
	 * 		<책목록>
	 * 		JavaProgramming
	 * 		OracleSQL
	 * 		JavaScript
	 * 		XMLBible
	 * 
	 * 미션2: 저자 홍길동의 책목록을 출력하시오.
	 */
	
	public SAXTest3() {
		
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			System.out.println("<책목록>");
			parser.parse("0426/books.xml",this);
		
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if(qName.equals("title")){
			title = true;
		} else if(qName.equals("author")){
			author = true;
		} else {
			title = false;
		}
		
		
	
	}



	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
			author = false;
			title = false;
		
	}



	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		
		if(title){
			tempTitle = new String(ch, start, length);
			//System.out.println(tempTitle);
			
		}
		
		if(author){
			String authors = new String(ch, start, length);
			//System.out.println(authors);
			
			if(authors.equals("홍길동")){
				System.out.println(tempTitle);
			}
		}
		
		
		

		}
			
	
	public static void main(String[] args) {
		new SAXTest3();
	}


}
