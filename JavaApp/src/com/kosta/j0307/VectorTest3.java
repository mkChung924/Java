package com.kosta.j0307;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest3 {
	public static void main(String args[]){
		
		Vector<String> v = new Vector<>();
		//v.addElement(String obj);
		//v.add(String e);
		//v.insertElementAt(obj, index);
		//v.add(int index, String element);
		
		//�߰� v.add(������);
		System.out.println(">�߰�");
		v.add("ȫ�浿"); // 0 - �ε���
		v.add("�����"); // 1
		v.add("���ֿ�"); // 2
		v.add("ȫ�浿");
		
		//������ �˻�
//		Enumeration<String> enu = v.elements();
//		while(enu.hasMoreElements()){
//			System.out.println(enu.nextElement());
//		}
		
		//��ü�����Ͱ˻�
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
		
		//����("�����" --> "������")
		//v.set(int index, String element);
		//v.setElementAt(String obj, int index);
		v.set(v.indexOf("�����"), "������");
		
		System.out.println("\n>����: ����� --> ������");
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
		
		//����("ȫ�浿" ����)
		//v.remove(Object obj);
		//v.remove("ȫ�浿");
		//v.remove(3);
		
		System.out.println("\n>����: ȫ�浿");
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
		
//		//ȫ�浿 ��ü ����
//		for(int i = 0; i < v.size(); i++){
//			if(v.contains("ȫ�浿")){
//				v.remove(v.indexOf("ȫ�浿"));
//			}
//		}
		
		System.out.println();
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
				
		//���ͳ��� ��ü �����͸� ����!
		System.out.println("\n>������ ��ü����!");
		v.removeAllElements();
		v.clear();
		
		System.out.println("���Ͱ� ����ֳ���? " + v.isEmpty());
		System.out.println("-END-");
		

		
	}

}
