package com.kosta.j0307;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String args[]){
		
//		int su2 = 13;
//		Integer su3 = new Integer(20);
//		
//		int su4 = new Integer(30); //jdk 5버전이상 부터 가능해짐.
//		
//		Integer su5 = 40; //오토 박싱을 해줌 -> new Integer(40)으로 자동포장함
		
		//Vector v = new Vector<>(initialCapacity, capacityIncrement);
		//initialCapacity : 방의 크기, capacityIncrement : 방의크기 증가치
		
		Vector v = new Vector(5,3); //(참조)데이터를 담는 바구니 클래스
		
		System.out.println("vector size : " + v.size());
		System.out.println("vector capacity : " + v.capacity());
		
		//요소를 바구니에 담기
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
		v.addElement("자바");
		
		System.out.println("new veotor size : " + v.size());
		System.out.println("new vector capacity : " + v.capacity());
		
		if(v.contains(3.14)){
			System.out.println("3.14를 포함하고 있습니다.");
		}
		
		//모든 요소 출력
		Enumeration enu = v.elements();
		//Enumeration(열거형 인터페이스):[1,2,3,...,"자바"]
		while(enu.hasMoreElements()){
			System.out.print(enu.nextElement() + " ");
		}
		
	}

}
