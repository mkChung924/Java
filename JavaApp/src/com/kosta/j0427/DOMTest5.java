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

public class DOMTest5 {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	
	/*
	 * �̼�: books.xml �� DOM Parsing�Ͽ� ù��° book�� title�� ȭ�鿡 ����Ͻÿ�.
	 * ���ȭ��) JavaProgramming
	 * 
	 * ==> ��, �θ�	�ڽ�		���� ���踦 ���� ������ �ذ��ϼ���.
	 * 		parent	child	sibling
	 * 
	 * doc------> books ------> book ------> title -----> TextNode("JavaProgramming")
	 * 
	 */
	
	public DOMTest5() {
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			
			//���(xml����) ����
			
			doc = builder.parse("0426/books3.xml");
			
			System.out.println("DOM�Ľ� ����"); //text�� xml�м� ----> �޸� �ε�
			
			//--------------- DOM PROGRAMMING ���� ------------------------------------
			
			Element root = doc.getDocumentElement();
			System.out.println("��Ʈ ������Ʈ�� : " + root.getTagName());
			
			//��Ʈ�� �ڽı��ϱ�
			//ù��° <book>�� å ���� ���
			System.out.println("FirstChild: "+root.getFirstChild().getNodeName());
			
			String title = root.getFirstChild().getNextSibling().getFirstChild().getFirstChild().getNodeValue();
			System.out.println("Title: "+title);

			
//			NodeList list = root.getChildNodes();
//			
//			//System.out.println(list.getLength());
//			for(int i = 0; i < list.getLength(); i++){
//				if(list.item(i).getNodeName().equals("book")){
//				
//					NodeList list2 = list.item(i).getChildNodes();
//					for(int j = 0; j < list2.getLength(); j++){
//						if(list2.item(j).getNodeName().equals("title")){
//							System.out.println("Title: "+list2.item(j).getTextContent());
//							break;
//						}
//						
//					}
//
//					break;
//				}
//			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new DOMTest5();
	}
}
