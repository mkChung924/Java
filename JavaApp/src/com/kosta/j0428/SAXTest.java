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

public class SAXTest extends DefaultHandler{
	//SAX: 이벤트기반의 파서
	SAXParserFactory factory;
	SAXParser parser;
	
	public SAXTest() {
		
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			
			
			//books.xml읽어서 화면에 출력
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
	public void startDocument() throws SAXException {
		System.out.println("<?xml version =\"1.0\" encoding = \"utf-8\" ?>");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//System.out.println("startElement");
		//System.out.println("Uri = " + uri);
		//System.out.println("localName = " + localName);
		System.out.print("<" + qName); //태그이름
		for(int i = 0; i < attributes.getLength(); i++){
			System.out.print(" " + attributes.getQName(i) + "='" +attributes.getValue(i)+"'");
		}
		System.out.print(">");
		
		
	}



	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.print("</"+qName+">");
		
	}



	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch, start, length);
		System.out.print(str);

	}



	public static void main(String[] args) {
		new SAXTest();
	}

}
