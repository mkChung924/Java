package com.praictice.java;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		
		
		Map<String, Integer> hsm = new LinkedHashMap<>();
		hsm.put("1�� ����Ʈ", 1);
		hsm.put("2�� ����Ʈ", 2);
		hsm.put("3�� ����Ʈ", 2);
		hsm.put("2�� ����Ʈ", 3);
		
		System.out.println(hsm.toString());
	}

}
