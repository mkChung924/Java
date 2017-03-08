package com.kosta.j0307;

import java.util.Random;
import java.util.Vector;

public class LottoVector {
	
	Vector<Integer> lotto;
	Random r;
	
	public LottoVector() {
		// TODO Auto-generated constructor stub
		lotto = new Vector<>(6);
		r = new Random();
	}
	
	public void generate(){
		
		for(int i = 0; i < lotto.capacity(); i++){
			lotto.add(r.nextInt(44) + 1);
		}
		
	}
	
	public void print(){
		for(int i = 0; i < lotto.capacity(); i++){
			System.out.print(lotto.get(i) + " ");
		}
		System.out.println();
	}
	
	public void duplicateCheck(){
		for(int i = 0; i < lotto.capacity(); i++){
			for(int j = 0; j < lotto.capacity(); i++){
				if(i == j ) continue;
				
				
			}
		}
		
	}

	public void clear(){
		lotto.clear();
	}
	

	
	public static void main(String args[]){
		
		LottoVector lv = new LottoVector();
		for(int i = 0; i < 10; i++){
			System.out.print(i+1 +"ȸ ");
			lv.generate();
			lv.print();
			lv.clear();
			
		}
	}

}
