package com.kosta.team;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class HashMapTest {
	
	public HashMapTest() {
	
		HashMap<Boolean, Double> map = new HashMap<>();
		map.put(true, 1.34);
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			Boolean key  = (Boolean) it.next();
			Double value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		Properties prop = new Properties();
	
	}
	
	public static void main(String[] args) {
		new HashMapTest();
	}

}
