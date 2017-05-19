package com.kosta.team;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetSorting {
	
	HashSet<String> hs;

	public HashSetSorting() {
	
		hs = new HashSet<>();
		
		hs.add("가");
		hs.add("나");
		hs.add("다");
		hs.add("라");
		hs.add("마");
		hs.add("바");
		hs.add("사");
		hs.add("아");
		hs.add("자");
		hs.add("차");
		hs.add("카");
		hs.add("타");
		hs.add("파");
		hs.add("하");
		
		
		Iterator it = hs.iterator();
		String str[] = new String[hs.size()];
		int count = 0;
		while(it.hasNext()){
			String kor = (String) it.next();
			System.out.print(kor + " ");
			str[count] = kor;
			count++;
		}
		count = 0;
		
		Arrays.sort(str);
		System.out.println();
		for(int i = 0; i < str.length; i++){
			System.out.print(str[i] + " ");
		}
		
		
	}
	
	public static void main(String[] args) {
		new HashSetSorting();
	}
}
