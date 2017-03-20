package com.kosta.j0320;

public class Account { //����� (������)
	private int total;
	
	public synchronized void deposit(int money){
		//synchronized ---> �޼ҵ� ����ȭ (�޼ҵ忡 ������ �����尡 ���� ��� �ٸ� ��������� ����ϰ� �ϴ� ����)
		//synchronized(����ȭ��ü){} -----> Ư�� ��������ȭ
		total += money;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
