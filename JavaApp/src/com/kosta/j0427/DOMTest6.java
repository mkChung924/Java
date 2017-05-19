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

public class DOMTest6 {
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	
	/*
	 * (��*)(��*)
	 * �̼�: books.xml �� DOM Parsing�Ͽ� ��� å ������ ȭ�鿡 ����Ͻÿ�.
	 * ���ȭ��) JavaProgramming
	 * 		   OraclSQL
	 * 		   JavaScript
	 * 		   XMLBible
	 * 
	 * ==> Document�� �ִ� �޼ҵ� ���!!
	 * 			Element getElementById(String id)
	 * 			NodeList getElementsByTagName(String name)
	 * 
	 * �̼�2: books.xml�� DOM Parsing�Ͽ� ��� å ������ ȭ�鿡 ����Ͻÿ�.
	 * ���ȭ��)
	 * 			#å ����
	 * 			JavaProgramming(ȫ�浿) : 25000��
	 * 			OracleSQL(�����) : 32000��
	 * 			JavaScript(���ֿ�) : 33000��
	 * 			XMLBible(ȫ�浿) : 35000��
	 * 
	 * �̼�3: books.xml�� DOM Parsing�Ͽ� ȫ�浿 å ������ ȭ�鿡 ����Ͻÿ�.
	 * ���ȭ��)
	 * 			#å ����
	 * 			JavaProgramming[25000��]
	 * 			XMLBible[35000��]
	 */
	
	public DOMTest6() {
		
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			
			//���(xml����) ����
			
			doc = builder.parse("0426/books3.xml");
			
			System.out.println("DOM�Ľ� ����"); //text�� xml�м� ----> �޸� �ε�
			
			//--------------- DOM PROGRAMMING ���� ------------------------------------
			
			//��� å�� ���� ���
			NodeList titleList = doc.getElementsByTagName("title"); //<title><title><title><title>
			System.out.println("#å ���");
			for(int i = 0; i < titleList.getLength(); i++){
				System.out.println("["+(i+1)+"] "+titleList.item(i).getFirstChild().getNodeValue());
											//NodeList	<title>	<TextNode>		�ؽ�Ʈ������
			}
			
			
			//��� å�� ���� ���
			NodeList authorList = doc.getElementsByTagName("author");
			NodeList priceList = doc.getElementsByTagName("price");
			
			System.out.println("#å ����");
			for(int i = 0; i < titleList.getLength(); i++){
				System.out.println("["+(i+1)+"]"+titleList.item(i).getFirstChild().getNodeValue() +
						"("+ authorList.item(i).getFirstChild().getNodeValue() +")" +
						" : " + priceList.item(i).getFirstChild().getNodeValue() + "��");
			}
			
			//ȫ�浿 å ���� ���
			String searchAuthor = "ȫ�浿";
			System.out.println("#å ����("+searchAuthor+")");
			for(int i = 0; i < authorList.getLength(); i++){
				String name = authorList.item(i).getFirstChild().getNodeValue();
				if(name.equals(searchAuthor)){
					String title = titleList.item(i).getFirstChild().getNodeValue();
					String price = priceList.item(i).getFirstChild().getNodeValue();
					System.out.println(title+"["+price+"��]");
				}
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new DOMTest6();
	}
}
