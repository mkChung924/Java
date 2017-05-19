package com.kosta.team;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class HashSetTest {
	
	HashSet<Object> hs;
	LinkedHashSet<Object> lhs;
	TreeSet<Integer> ts;
	TreeSet<String> ts2;
	
	public HashSetTest() {
		
		System.out.println("2조 HashSet");
		//이용어의 원래의 의미는 「끌어 모음」또는 「섞어 정착함」이다.
		//HashSet 은 equals로 비교하기 때문에 1 과 1.00을 다르다고 구분함 -> LinkedHashSet은 아예 애초부터 구분지어버림.
		//HashSet, TreeSet은 동기화가 지원하지 않음
		//문제점: Thread Safe하지 않다.
		System.out.println("<Set(집합)의 특징>\n1.요소는 중복될 수 없다.\n2.순서가 있을 수도 있다.\n3.정렬될 수도 있다.\n");
		System.out.println("HashSet - 저장 순서 보장 X.");
		System.out.println("LinkedHashSet - 저장 순서 기억");
		System.out.println("TreeSet - Ordering 시켜서 저장. 속도 가장 느림");
		System.out.println("메소드 : add(), remove(), contains(), iterator(), isEmpty(), size()");
		
		hs = new HashSet<>();
		lhs = new LinkedHashSet<>();
		ts = new TreeSet<>();
		ts2 = new TreeSet<>();
		
		hs.clear();
		lhs.clear();
		ts.clear();
		ts2.clear();
		
		hs.add("B");
		hs.add("A");
		hs.add("C");
		hs.add("D");
		hs.add("E");
		hs.add("안산");
		hs.add("수원");
		hs.add("안양");
		hs.add("서울");
		hs.add("구로");
		
		
		lhs.add(9);
		lhs.add(5);
		lhs.add(3);
		lhs.add(10);
		lhs.add(2);
		lhs.add("안산");
		lhs.add("수원");
		lhs.add("안양");
		lhs.add("서울");
		lhs.add("구로");
		
		ts.add(9);
		ts.add(5);
		ts.add(3);
		ts.add(10);
		ts.add(2);
		
		ts2.add("안산");
		ts2.add("수원");
		ts2.add("안양");
		ts2.add("서울");
		ts2.add("구로");

		
		Iterator it = hs.iterator();
		System.out.println("\nHashSet");
		while(it.hasNext()){
			Object set = it.next();
			String set1 = set.toString();
			System.out.print(set1 + " ");
		}
		System.out.println();
		if(hs.contains("서울")) System.out.println("if(hs.contains(\"서울\")), "+"서울을 포함하고 있습니다.");
		if(!hs.contains("지구")) System.out.println("if(!hs.contains(\"지구\")), "+"지구를 포함하고 있지 않습니다.");
		
		
		Iterator it2 = lhs.iterator();
		System.out.println("\nLinkedHashSet");
		while(it2.hasNext()){
			System.out.print(it2.next()+" ");
		}
		
		System.out.println();
		
		Iterator it3 = ts.iterator();
		System.out.println("\nTreeSet1 - Integer");
		while(it3.hasNext()){
			System.out.print(it3.next()+ " ");
		}
		
		System.out.println();
		
		Iterator it4 = ts2.iterator();
		System.out.println("\nTreeSet2 - String");
		while(it4.hasNext()){
			System.out.print(it4.next()+ " ");
		}
		
	}
	
	public static void main(String[] args) {
		new HashSetTest();
	}

}
