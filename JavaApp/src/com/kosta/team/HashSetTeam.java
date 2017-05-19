package com.kosta.team;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTeam {
	
	HashSet<Object> hs;
	
	public HashSetTeam() {
		hs = new HashSet<>();
		
		//add() �޼ҵ�
		hs.add("���");
		hs.add("����");
		hs.add("����");
		hs.add("��");
		
		Iterator it = hs.iterator();
		while(it.hasNext()){
			String str = (String) it.next();
			System.out.print(str + " ");
		}
		
		System.out.println("\n--> ��� ����");
		hs.remove("���");
		
		Iterator it2 = hs.iterator();
		while(it2.hasNext()){
			String str = (String) it2.next();
			System.out.print(str + " ");
		}
		
		System.out.println("������ �����ϰ� �ִ°�? contains()\n--> " + hs.contains("����"));
		System.out.println("hs�� ����°�? isEmpty()\n--> " + hs.isEmpty());
		System.out.println("hs�� size? \n--> " + hs.size());
	}
	
	public static void main(String[] args) {
		new HashSetTeam();
	}

}
