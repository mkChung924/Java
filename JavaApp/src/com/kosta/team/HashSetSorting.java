package com.kosta.team;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetSorting {
	
	HashSet<String> hs;

	public HashSetSorting() {
	
		hs = new HashSet<>();
		
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("��");
		hs.add("ī");
		hs.add("Ÿ");
		hs.add("��");
		hs.add("��");
		
		
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
