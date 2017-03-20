package com.kosta.j0320;

public class TVContribution {//��۱�
	
	public static void main(String[] args) {
		
			//������(Thread) 5�� ����
/*		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4 = new Customer();
		Customer c5 = new Customer();
		c1~c5 : Thread ��ü!!
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();*/
		
		//�����(������) ��ü ����
		
		Account account = new Account();
		
		//1���� �迭 ��ü ����: �ڷ��� �迭��[] = new �ڷ���[������]
		Customer customers[] = new Customer[5];
		for(int i = 0; i < 5; i++){
			customers[i] = new Customer(account); //������ ��ü ����
		}
		
		for(int i = 0; i < 5; i++){
			customers[i].start(); //��� ����
		}
		
		try {
			for(int i = 0; i < 5; i++){
				customers[i].join();
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("��ݿϷ�!");
		System.out.println("�� ��ݾ�: " + account.getTotal());
	}


}
