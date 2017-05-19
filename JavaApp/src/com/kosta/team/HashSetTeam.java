package com.kosta.team;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTeam {
	
	HashSet<Object> hs;
	
	public HashSetTeam() {
		hs = new HashSet<>();
		
		//add() 메소드
		hs.add("사과");
		hs.add("포도");
		hs.add("망고");
		hs.add("배");
		
		Iterator it = hs.iterator();
		while(it.hasNext()){
			String str = (String) it.next();
			System.out.print(str + " ");
		}
		
		System.out.println("\n--> 사과 삭제");
		hs.remove("사과");
		
		Iterator it2 = hs.iterator();
		while(it2.hasNext()){
			String str = (String) it2.next();
			System.out.print(str + " ");
		}
		
		System.out.println("포도를 포함하고 있는가? contains()\n--> " + hs.contains("포도"));
		System.out.println("hs는 비었는가? isEmpty()\n--> " + hs.isEmpty());
		System.out.println("hs의 size? \n--> " + hs.size());
	}
	
	public static void main(String[] args) {
		new HashSetTeam();
	}

}
