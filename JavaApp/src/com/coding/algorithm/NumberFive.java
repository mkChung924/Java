package com.coding.algorithm;

public class NumberFive {

	public NumberFive() {
		int count = 0;
		long start = System.currentTimeMillis();
		for(int i = 1; i < Integer.MAX_VALUE; i++){
			count = 0;
			for(int j = 1; j < 20; j++){
				if(i%j == 0){
					++count;

				}
				if(count == 19){
					System.out.println("¸¸Á·: "+ i +", " + count);
					
					long end = System.currentTimeMillis();
					System.out.println((end-start)/1000.0 + "ÃÊ");
					
					return;
					
				}
			}
		}

		
	}
	
	public static void main(String[] args) {
		new NumberFive();
	}
}
