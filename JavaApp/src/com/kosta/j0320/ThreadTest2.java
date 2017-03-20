package com.kosta.j0320;

class YouThread extends Thread{
	
	public YouThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i = 1; i < 10; i ++){
				Thread.sleep(1000);
				System.out.println(getName() + " " + i);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//run
}//YouThread

public class ThreadTest2 {
	
	public static void main(String[] args) {
		YouThread t1 = new YouThread("�浿������");
		YouThread t2 = new YouThread("���Ӿ�����");
		YouThread t3 = new YouThread("�ֿ�������");
		
		//������ �켱���� �ο�(1~10) 10: �켱���� ���� ����, 5 ----> �⺻��
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		t3.setPriority(Thread.NORM_PRIORITY);
		
		t1.start();
		t2.start();
		t3.start();
	}
	

	

}
