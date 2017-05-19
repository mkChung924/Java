package com.kosta.j0428;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest4 extends DefaultHandler{
	
	SAXParserFactory factory;
	SAXParser parser;
	
	public SAXTest4(){
		
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			
			parser.parse("0426/books.xml", this);
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("fatalError: ġ�������� ---> XML������ ��߳�!");
		System.out.println(e.getMessage());
	}
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("Error: ���Ŀ��� ---> DTD �Ǵ� ��Ű���� ��ġ��������");
		System.out.println();
	}
	
	public static void main(String[] args) {
		new SAXTest4();
	}

}
