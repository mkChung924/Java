package com.kosta.j0320;

public class Customer extends Thread{ //성금자 ---> 스레드(경쟁적인 성금자)

	Account account;
	
	public Customer(Account account) {
		this.account = account;
		//account = new Account();
		
	}
	
	public void run(){
		
		try {
			for(int i = 1; i <= 200; i++){
				
				Thread.sleep(100);
				account.deposit(1000);//1회 천원씩 모금.
				System.out.println(getName() + " : " + i + "회");
				//System.out.println(account.getTotal()+"");
				if(account.getTotal() >= 500000){ //목표액 (50만원) 달성
					
					break;
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
