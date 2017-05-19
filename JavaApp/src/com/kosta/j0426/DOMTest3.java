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
	
	//XML���� ----> ���� ���!!
	
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
			
			System.out.println("�Ľ̼���!");
			//===============DOM ���α׷��� ����=========================

			//�̼�: ��ü ���� �����ϱ�! (�������� ---> ȭ�鿡 ���!)
			Element root = doc.getDocumentElement(); //���� rootElement ���
			processNode(doc);
			fw.close();
			System.out.println("������� ����!");
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	public void processNode(Node n) throws IOException{ //�������� ��ü��� �����ϱ�
		
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
				
				//XML���� <?xml version="1.0" encoding="UTF-8" ?>
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
