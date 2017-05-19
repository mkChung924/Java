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
	//SAX: �̺�Ʈ����� �ļ�
	SAXParserFactory factory;
	SAXParser parser;
	boolean title, author;
	String tempTitle;
	
	/*
	 * �̼�: books.xml �������� å ������� ȭ�鿡 ����Ͻÿ�.
	 * ���)
	 * 		<å���>
	 * 		JavaProgramming
	 * 		OracleSQL
	 * 		JavaScript
	 * 		XMLBible
	 * 
	 * �̼�2: ���� ȫ�浿�� å����� ����Ͻÿ�.
	 */
	
	public SAXTest3() {
		
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			System.out.println("<å���>");
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
			
			if(authors.equals("ȫ�浿")){
				System.out.println(tempTitle);
			}
		}
		
		
		

		}
			
	
	public static void main(String[] args) {
		new SAXTest3();
	}


}
