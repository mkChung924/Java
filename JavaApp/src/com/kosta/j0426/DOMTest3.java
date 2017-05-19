package com.kosta.j0426;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMTest3 {
	
	//XML문서 ----> 파일 출력!!
	
	FileWriter fw;
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;

	Document doc;

	public DOMTest3() {

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			fw = new FileWriter("0426/books2.xml");
			
			doc = builder.parse("0426/books.xml");
			
			System.out.println("파싱성공!");
			//===============DOM 프로그래밍 시작=========================

			//미션: 전체 문서 여행하기! (문서내용 ---> 화면에 출력!)
			Element root = doc.getDocumentElement(); //문서 rootElement 얻기
			processNode(doc);
			fw.close();
			System.out.println("파일출력 성공!");
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void processNode(Node n) throws IOException{ //문서내의 전체노드 여행하기
		
		switch(n.getNodeType()){ //1~12

			case Node.ELEMENT_NODE:
			{
				NodeList list = n.getChildNodes();
				String tagName = n.getNodeName();
				
		
				fw.write("<"+tagName);
				for(int i = 0; i < n.getAttributes().getLength(); i++){
					Node attr = n.getAttributes().item(i);
					fw.write(" "+attr.getNodeName() +"=\"" + attr.getNodeValue()+"\"");
				}
				fw.write(">");
				
				
				for(int i = 0 ; i < list.getLength(); i++){
	
					processNode(list.item(i));
				}
				fw.write("</"+tagName+">");
				break;
			}
			case Node.COMMENT_NODE:
				
				fw.write("<!--"+n.getNodeValue()+"-->");
	
				break;
				
			case Node.TEXT_NODE:
			{
				fw.write(n.getNodeValue());
				
				break;
			}
			
			case Node.DOCUMENT_NODE:
			{
				
				//XML선언 <?xml version="1.0" encoding="UTF-8" ?>
				fw.write("<?xml version='1.0' encoding='euc-kr' ?>\n");
				
				NodeList list = n.getChildNodes();
				for(int i = 0; i < list.getLength(); i++){
					
					processNode(list.item(i));
				}
				
				break;
			}
			
		}
		
	}

	public static void main(String[] args) {
		new DOMTest3();
	}
}
