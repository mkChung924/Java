package com.question.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("Elena", 590);
		hm.put("Thomas", 252);
		hm.put("Hamilton", 562);
		hm.put("Suzie", 251);
		hm.put("Phil", 519);
		hm.put("Matt", 408);
		hm.put("Alex", 870);
		hm.put("Emma", 846);
		hm.put("John", 185);
		hm.put("James", 620);
		hm.put("Emily", 577);
		hm.put("Daniel", 633);
		hm.put("Neda", 937);
		hm.put("Aaron", 380);
		hm.put("Kate", 285);
		
		System.out.println(hm.keySet());
		
		Iterator it = ArrayPractice.sortByValue(hm).iterator();
		LinkedHashMap<String, Integer> hm2 = new LinkedHashMap<>();
		
		while(it.hasNext()){
			String temp = (String) it.next();
			hm2.put(temp, hm.get(temp));
			
		}
		System.out.println(hm2.keySet().toArray()[0] + " got the highest score of " + hm2.values().toArray()[0] + ".");
		
		
		// key�� �����ϴ� ���
/*		TreeMap<String, Integer> tm = new TreeMap<>(hm);		
		Iterator it2 = tm.keySet().iterator();
		while(it2.hasNext()){
			String key = (String) it2.next();
			int value = tm.get(key);
			
			System.out.println(key + " : " + value);
		}*/
	
	}
	
	public static List sortByValue(final Map map){
		
		List<String> list = new ArrayList(); //ArrayList ����
		list.addAll(map.keySet()); //ArrayList�� ������ key���� ����
		
		Collections.sort(list, new Comparator(){		//�������ִ� �޼ҵ�
			public int compare(Object o1, Object o2){	//key���� ������ �ִ� value�� ��
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);
				
				return ((Comparable) v1).compareTo(v2);	//�񱳰� ����
			}
		});
		Collections.reverse(list);	//�񱳵� ���� �������� �Ǵ� �������� ���� ���� : reverse: ��������
		return list;				//�񱳵Ǿ� ���� ����Ʈ ����
	}

}
