package com.kosta.j0427;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DOMTest7 {
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	
	Document doc;
	
	FileWriter fw;
	
	
	public DOMTest7() {
		
		try {
			fw = new FileWriter("0427/root.xml");
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			
			//DOM프로그램 시작!
			doc = builder.newDocument(); //.parse("a.xml"); ----> .newDocument();
			
			//Document 객체 ---> 생성(엘리먼트, 텍스트, 주석)
			
			//doc.createElement(String tagName);
			Element root = doc.createElement("ROOT");
			Element a = doc.createElement("A");
			Element b = doc.createElement("B");
			Element c = doc.createElement("C");
			Element d = doc.createElement("D");
			Element e = doc.createElement("E");
			
			//doc.createTextNode(String data)
			Text t1 = doc.createTextNode("Hello");
			Text t2 = doc.createTextNode("Good Bye");
			Text t3 = doc.createTextNode("Good Day");
			
			//1.추가: 부모노드.appendChild(자식노드);
			doc.appendChild(root);
			
			a.appendChild(c); //<A><C></C></A>
			c.appendChild(t1); //<C>Hello</C>
			b.appendChild(t2); //<B>Good Bye</B>
			d.appendChild(t3); //<C>Good Day</C>
			
			root.appendChild(a);//<ROOT><A><C>Hello</C></A>
			root.appendChild(b);
			
			//2. 추가(끼워넣기)
			//부모노드.insertBefore(새로운 노드, 참조노드);
			root.insertBefore(d, b);
			
			//3. 삭제: 부모노드.removeChild(삭제노드);
			//root.removeChild(b);
			//만약, b태그를 삭제하고 싶은데 부모를 모를경우?
			b.getParentNode().removeChild(b);
			
			//4. 대체하기 : 부모노드.replaceChild(새노드, 기존노드);
			root.replaceChild(e, d);
			
			//5. 복제: 복제할노드.cloneNode(깊이상태); //true: 자식까지 전부 복제, false: 그 노드만 복제
			Node newNode = root.cloneNode(true);
			a.appendChild(newNode);
			
			
			
			processNode(doc);
			fw.close();
			
			System.out.println("노드생성완료");
			
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
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
		new DOMTest7();
	}

}
