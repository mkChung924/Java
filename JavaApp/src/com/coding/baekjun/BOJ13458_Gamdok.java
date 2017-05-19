package com.coding.baekjun;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ13458_Gamdok {
	
	int n;
	int p[];
	int o1,o2;
	BigInteger count;
	
	public BOJ13458_Gamdok() {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p = new int[n];
		
		for(int i = 0; i < n; i++){
			int person = sc.nextInt();
			p[i] = person;
		}
		
		o1 = sc.nextInt();
		o2 = sc.nextInt();
		
//		System.out.println("시험장 갯수: "+n);
//		System.out.println("총감독관 감시수: "+o1);
//		System.out.println("부감독관 감시수: "+o2);
//		
//		for(int j = 0; j < p.length; j++){
//			System.out.print(p[j] + " ");
//		}
		
		find();
		System.out.println(count);
		
	}
	
	public void find(){
		
		count = BigInteger.valueOf(n);
		
		for(int i = 0; i < p.length; i++){
			
			if(p[i] > o1){
				int num = p[i] - o1;
				
				if(num <= o2){
					//System.out.println(num);
					count = count.add(BigInteger.ONE);
					
				} else if(num > o2){
					System.out.println(num);
					
					int num2 = num/o2;
					int num3 = num%o2;
					
					count = count.add(BigInteger.valueOf(num2));
					
					if(num3 != 0){
						if(num3 <= o2){
							count = count.add(BigInteger.ONE);
						}
					} else {
						continue;
					}
				} else {
					
				}
			} else {
				
				//System.out.println("countinue");
				continue;
			}
	
		}
		
		
	}
	
	public static void main(String[] args) {
		new BOJ13458_Gamdok();
	}

}
