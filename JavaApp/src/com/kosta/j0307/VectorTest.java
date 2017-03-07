package com.kosta.j0307;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String args[]){
		
//		int su2 = 13;
//		Integer su3 = new Integer(20);
//		
//		int su4 = new Integer(30); //jdk 5�����̻� ���� ��������.
//		
//		Integer su5 = 40; //���� �ڽ��� ���� -> new Integer(40)���� �ڵ�������
		
		//Vector v = new Vector<>(initialCapacity, capacityIncrement);
		//initialCapacity : ���� ũ��, capacityIncrement : ����ũ�� ����ġ
		
		Vector v = new Vector(5,3); //(����)�����͸� ��� �ٱ��� Ŭ����
		
		System.out.println("vector size : " + v.size());
		System.out.println("vector capacity : " + v.capacity());
		
		//��Ҹ� �ٱ��Ͽ� ���
		Integer su = new Integer(1);
		v.addElement(su);
		v.addElement(new Integer(2));
		
		for(int i = 3; i < 10; i++){
			v.addElement(i);
		}
		
		System.out.println("new veotor size : " + v.size());
		System.out.println("new vector capacity : " + v.capacity());
		v.addElement(true);
		v.addElement(3.14);
		v.addElement("�ڹ�");
		
		System.out.println("new veotor size : " + v.size());
		System.out.println("new vector capacity : " + v.capacity());
		
		if(v.contains(3.14)){
			System.out.println("3.14�� �����ϰ� �ֽ��ϴ�.");
		}
		
		//��� ��� ���
		Enumeration enu = v.elements();
		//Enumeration(������ �������̽�):[1,2,3,...,"�ڹ�"]
		while(enu.hasMoreElements()){
			System.out.print(enu.nextElement() + " ");
		}
		
	}

}
