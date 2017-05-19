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

public class SAXTest2 extends DefaultHandler{
	//SAX: 이벤트기반의 파서
	SAXParserFactory factory;
	SAXParser parser;
	
	public SAXTest2() {
		
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();
			parser.parse("0428/test.xml",this);
			
			
			
			
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new SAXTest2();
	}

	@Override
	public void setDocumentLocator(Locator locator) {
			
		System.out.println("setDocumentLocator");
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
	}

	@Override
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
		System.out.println("startPrefixMapping");
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		System.out.println("endPrefixMapping");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		System.out.println("startElement");	
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("characters");
	}

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
		System.out.println("ignorableWhitespace");
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
		System.out.println("processingInstruction");
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		System.out.println("skippedEntity");	
	}

}
