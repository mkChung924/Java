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
		
		System.out.println("2�� HashSet");
		//�̿���� ������ �ǹ̴� ������ �������Ǵ� ������ �����ԡ��̴�.
		//HashSet �� equals�� ���ϱ� ������ 1 �� 1.00�� �ٸ��ٰ� ������ -> LinkedHashSet�� �ƿ� ���ʺ��� �����������.
		//HashSet, TreeSet�� ����ȭ�� �������� ����
		//������: Thread Safe���� �ʴ�.
		System.out.println("<Set(����)�� Ư¡>\n1.��Ҵ� �ߺ��� �� ����.\n2.������ ���� ���� �ִ�.\n3.���ĵ� ���� �ִ�.\n");
		System.out.println("HashSet - ���� ���� ���� X.");
		System.out.println("LinkedHashSet - ���� ���� ���");
		System.out.println("TreeSet - Ordering ���Ѽ� ����. �ӵ� ���� ����");
		System.out.println("�޼ҵ� : add(), remove(), contains(), iterator(), isEmpty(), size()");
		
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
		hs.add("�Ȼ�");
		hs.add("����");
		hs.add("�Ⱦ�");
		hs.add("����");
		hs.add("����");
		
		
		lhs.add(9);
		lhs.add(5);
		lhs.add(3);
		lhs.add(10);
		lhs.add(2);
		lhs.add("�Ȼ�");
		lhs.add("����");
		lhs.add("�Ⱦ�");
		lhs.add("����");
		lhs.add("����");
		
		ts.add(9);
		ts.add(5);
		ts.add(3);
		ts.add(10);
		ts.add(2);
		
		ts2.add("�Ȼ�");
		ts2.add("����");
		ts2.add("�Ⱦ�");
		ts2.add("����");
		ts2.add("����");

		
		Iterator it = hs.iterator();
		System.out.println("\nHashSet");
		while(it.hasNext()){
			Object set = it.next();
			String set1 = set.toString();
			System.out.print(set1 + " ");
		}
		System.out.println();
		if(hs.contains("����")) System.out.println("if(hs.contains(\"����\")), "+"������ �����ϰ� �ֽ��ϴ�.");
		if(!hs.contains("����")) System.out.println("if(!hs.contains(\"����\")), "+"������ �����ϰ� ���� �ʽ��ϴ�.");
		
		
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
