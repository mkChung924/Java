package com.kosta.j0320;

public class TVContribution {//방송국
	
	public static void main(String[] args) {
		
			//성금자(Thread) 5명 모집
/*		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4 = new Customer();
		Customer c5 = new Customer();
		c1~c5 : Thread 객체!!
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();*/
		
		//모금함(저금통) 객체 생성
		
		Account account = new Account();
		
		//1차원 배열 객체 생성: 자료형 배열명[] = new 자료형[사이즈]
		Customer customers[] = new Customer[5];
		for(int i = 0; i < 5; i++){
			customers[i] = new Customer(account); //스레드 객체 생성
		}
		
		for(int i = 0; i < 5; i++){
			customers[i].start(); //모금 시작
		}
		
		try {
			for(int i = 0; i < 5; i++){
				customers[i].join();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("모금완료!");
		System.out.println("총 모금액: " + account.getTotal());
	}


}
