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
			System.out.println("�Ľ̼���!");
			//===============DOM ���α׷��� ����=========================

			//�̼�: ��ü ���� �����ϱ�! (�������� ---> ȭ�鿡 ���!)
			Element root = doc.getDocumentElement(); //���� rootElement ���
			processNode(doc);
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void processNode(Node n){ //�������� ��ü��� �����ϱ�
		
		//System.out.println(n.getChildNodes().getLength());

		switch(n.getNodeType()){ //1~12

			case Node.ELEMENT_NODE:
			{
				NodeList list = n.getChildNodes();
				//System.out.println("�ڽĿ�� ����: "+list.getLength());
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
