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

public class DOMTest2 {

	DocumentBuilderFactory factory;
	DocumentBuilder builder;

	Document doc;

	public DOMTest2() {

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();

			doc = builder.parse("0426/books.xml");
			System.out.println("파싱성공!");
			//===============DOM 프로그래밍 시작=========================

			//미션: 전체 문서 여행하기! (문서내용 ---> 화면에 출력!)
			Element root = doc.getDocumentElement(); //문서 rootElement 얻기
			processNode(doc);
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void processNode(Node n){ //문서내의 전체노드 여행하기
		
		//System.out.println(n.getChildNodes().getLength());

		switch(n.getNodeType()){ //1~12

			case Node.ELEMENT_NODE:
			{
				NodeList list = n.getChildNodes();
				//System.out.println("자식요소 갯수: "+list.getLength());
				//NodeList - getLength(), item(idx)
				String tagName = n.getNodeName();
				//System.out.println(n.getTextContent());
				System.out.print("<"+tagName);
				for(int i = 0; i < n.getAttributes().getLength(); i++){
					System.out.print(" "+n.getAttributes().item(i));
				}
				System.out.print(">");
				for(int i = 0 ; i < list.getLength(); i++){
	
					processNode(list.item(i));
				}
				System.out.print("</"+tagName+">");
				break;
			}
			case Node.COMMENT_NODE:
				
				System.out.println("<!--"+n.getNodeValue()+"-->");
	
				break;
				
			case Node.TEXT_NODE:
			{
				System.out.print(n.getNodeValue());
				
				break;
			}
			
			case Node.DOCUMENT_NODE:
			{
				NodeList list = n.getChildNodes();
				for(int i = 0; i < list.getLength(); i++){
					
					processNode(list.item(i));
				}
				
				break;
			}
			
		}

	}

	public static void main(String[] args) {
		new DOMTest2();
	}
}
