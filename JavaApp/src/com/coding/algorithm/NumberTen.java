package com.coding.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*10 이하의 소수를 모두 더하면 2 + 3 + 5 + 7 = 17 이 됩니다.

이백만(2,000,000) 이하 소수의 합은 얼마입니까?*/

public class NumberTen {
	
	int count;
	int sosu;
	List<Integer> v;
	List<Integer> v3;
	Vector<Integer> v2;
	int MAX = 2000000;
	long res = 0;
	
	public NumberTen() {
		
		v = new ArrayList<Integer>(MAX +1);
		v3 = new ArrayList<Integer>();
		v2 = new Vector<Integer>(MAX+1);
		long start = System.currentTimeMillis();
	
	
		
//		v.add(0);
//		v.add(0);
//		
//		for(int i = 2; i <= MAX ; i ++) 
//			v.add(i);
//		
//		for(int i = 2; (i*i) <= MAX; i++){
//			//System.out.println(v.get(i));
//			if(v.get(i) != 0){
//				for(int j = i+i; j <= MAX; j+=i){
//					v.set(j, 0);
//				}
//			}
//		}
//		
//		for(int i = 2; i <= MAX; i++){
//			if(v.get(i) != 0){
//				res += v.get(i);
//			}
//		}
//		
//		System.out.println(res);
		
//		v2.add(0);
//		v2.add(0);
//		
//		for(int i = 2; i < MAX; i++){
//			v2.add(i);
//		}
		
		long end = System.currentTimeMillis();
		
		System.out.println((end - start)/1000.0 + "초");
		
		
		
		
		
//		for(int i = 3; i <= MAX; i+=2){
//			count = 0;
//			if(i%3 == 0) continue;
//			
//			for(int j = 1; j <= i; j++){
//				
//				if(i%j == 0){
//					++count;
//					if(count > 2) {
//						count = 0;
//						break;			
//					}	
//				}
//			}
//			
//			if(count == 2){
//				
//				sosu = i;
//				System.out.println(sosu);
//				
//				if(sosu >= 2000000){
//					System.out.println("끝");
//					System.out.println(v.size());
//					long end = System.currentTimeMillis();
//					System.out.println((end - start)/1000.0 + "초");
//					
//					long sum = 0;
//					for(int k = 0; k < v.size(); k++){
//						sum += (int) v.get(k);
//					}
//					System.out.println(sum);
//					
//					return;
//				} else {
//					//sosu = i;
//					//System.out.println(sosu);
//					v.add(sosu);
//				}
//			}
//			
//		}
		

		
		
	}
	
	
	public static void main(String[] args) {
		new NumberTen();
	}

}
