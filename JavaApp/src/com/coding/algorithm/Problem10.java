package com.coding.algorithm;

import java.util.ArrayList;

public class Problem10 {
public static void main(String[] args) {
		
		//�����佺�׳׽��� ü ���
		long start = System.currentTimeMillis();
		
		ArrayList<Integer> primeList;

        int n = 2000000;
        
        
        long res = 0;
       
        primeList = new ArrayList<Integer>(n+1);
        
        primeList.add(0);
        primeList.add(0);
        
           
        for(int i=2; i<=n; i++ )
                primeList.add(i);

        for(int i=2; (i*i)<=n; i++){
                if(primeList.get(i) != 0){
                        for(int j =i+i; j<=n; j+=i) 
                        	primeList.set(j, 0);
                }
        }
       
        for(int i=0; i<=n; i++){
                if(primeList.get(i) != 0){
                	res += primeList.get(i);
                	
                }
        }
       
        System.out.println(res);
        
        long end = System.currentTimeMillis();

        System.out.println( "���� �ð� : " + ( end - start )/1000.0 ); 
	}
}
