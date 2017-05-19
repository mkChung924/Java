package com.praictice.java;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
	public static void main(String[] args) {
		
		
		Map<String, Integer> hsm = new LinkedHashMap<>();
		hsm.put("1번 포인트", 1);
		hsm.put("2번 포인트", 2);
		hsm.put("3번 포인트", 2);
		hsm.put("2번 포인트", 3);
		
		System.out.println(hsm.toString());
	}

}
