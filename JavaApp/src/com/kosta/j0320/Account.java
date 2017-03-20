package com.kosta.j0320;

public class Account { //모금함 (저금통)
	private int total;
	
	public synchronized void deposit(int money){
		//synchronized ---> 메소드 동기화 (메소드에 진입한 스레드가 있을 경우 다른 스레드들은 대기하게 하는 역할)
		//synchronized(동기화객체){} -----> 특정 영역동기화
		total += money;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
