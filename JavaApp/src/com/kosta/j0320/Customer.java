package com.kosta.j0320;

public class Customer extends Thread{ //������ ---> ������(�������� ������)

	Account account;
	
	public Customer(Account account) {
		this.account = account;
		//account = new Account();
		
	}
	
	public void run(){
		
		try {
			for(int i = 1; i <= 200; i++){
				
				Thread.sleep(100);
				account.deposit(1000);//1ȸ õ���� ���.
				System.out.println(getName() + " : " + i + "ȸ");
				//System.out.println(account.getTotal()+"");
				if(account.getTotal() >= 500000){ //��ǥ�� (50����) �޼�
					
					break;
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
