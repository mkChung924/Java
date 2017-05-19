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
			
			//DOM���α׷� ����!
			doc = builder.newDocument(); //.parse("a.xml"); ----> .newDocument();
			
			//Document ��ü ---> ����(������Ʈ, �ؽ�Ʈ, �ּ�)
			
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
			
			//1.�߰�: �θ���.appendChild(�ڽĳ��);
			doc.appendChild(root);
			
			a.appendChild(c); //<A><C></C></A>
			c.appendChild(t1); //<C>Hello</C>
			b.appendChild(t2); //<B>Good Bye</B>
			d.appendChild(t3); //<C>Good Day</C>
			
			root.appendChild(a);//<ROOT><A><C>Hello</C></A>
			root.appendChild(b);
			
			//2. �߰�(�����ֱ�)
			//�θ���.insertBefore(���ο� ���, �������);
			root.insertBefore(d, b);
			
			//3. ����: �θ���.removeChild(�������);
			//root.removeChild(b);
			//����, b�±׸� �����ϰ� ������ �θ� �𸦰��?
			b.getParentNode().removeChild(b);
			
			//4. ��ü�ϱ� : �θ���.replaceChild(�����, �������);
			root.replaceChild(e, d);
			
			//5. ����: �����ҳ��.cloneNode(���̻���); //true: �ڽı��� ���� ����, false: �� ��常 ����
			Node newNode = root.cloneNode(true);
			a.appendChild(newNode);
			
			
			
			processNode(doc);
			fw.close();
			
			System.out.println("�������Ϸ�");
			
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
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
		new DOMTest7();
	}

}
