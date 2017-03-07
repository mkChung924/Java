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
		
		//추가 v.add(데이터);
		System.out.println(">추가");
		v.add("홍길동"); // 0 - 인덱스
		v.add("길라임"); // 1
		v.add("김주원"); // 2
		v.add("홍길동");
		
		//데이터 검색
//		Enumeration<String> enu = v.elements();
//		while(enu.hasMoreElements()){
//			System.out.println(enu.nextElement());
//		}
		
		//전체데이터검색
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
		
		//수정("길라임" --> "차라임")
		//v.set(int index, String element);
		//v.setElementAt(String obj, int index);
		v.set(v.indexOf("길라임"), "차라임");
		
		System.out.println("\n>수정: 길라임 --> 차라임");
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
		
		//삭제("홍길동" 삭제)
		//v.remove(Object obj);
		//v.remove("홍길동");
		//v.remove(3);
		
		System.out.println("\n>삭제: 홍길동");
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
		
//		//홍길동 전체 삭제
//		for(int i = 0; i < v.size(); i++){
//			if(v.contains("홍길동")){
//				v.remove(v.indexOf("홍길동"));
//			}
//		}
		
		System.out.println();
		for(int i = 0 ; i < v.size(); i++){
			System.out.print("["+i+"]" + v.get(i) + " ");
		}
				
		//벡터내의 전체 데이터를 삭제!
		System.out.println("\n>데이터 전체삭제!");
		v.removeAllElements();
		v.clear();
		
		System.out.println("벡터가 비어있나요? " + v.isEmpty());
		System.out.println("-END-");
		

		
	}

}
