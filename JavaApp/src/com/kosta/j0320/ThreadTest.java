package com.kosta.j0320;

import javax.swing.JFrame;

class MyThread extends Thread{

	//�ڽ��� �θ��!! ----> MyThread �� Thread!
	
	//������ Ư¡ ---> run()
	
	@Override
	public void run() { //������ �޼ҵ� !! ==> ���ý����� �������� �ϴ� �ڵ幮���!
		// TODO Auto-generated method stub
		try {
			for(int i = 1; i < 11; i ++){
				
				Thread.sleep(1000);
				System.out.println("�ڹٽ�����1: " + i);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}//run
	
}

class MyThread2 extends JFrame implements Runnable{
	
	

	@Override
	public void run() {
	
		try {
			for(int i = 1; i < 11; i++){
				Thread.sleep(1000);
				System.out.println("�ڹٽ�����2: " + i);
			}
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	
}

public class ThreadTest {
	
	public static void main(String[] args) {
		MyThread t = new MyThread();
		//������ run()�޼ҵ�� �ݵ�� start()�� ���� ȣ��!
		//����ȣ��ÿ��� �Ϲݸ޼ҵ�� ���̰� ����!!
		t.start();
		
		//�����尴ü ����
		MyThread2 r = new MyThread2(); // r ---> �����尴ü ? X
										// r ---> Runnable��ü O
		Thread t2 = new Thread(r); // t2 ---> ������ ��
		t2.start();
	}

}