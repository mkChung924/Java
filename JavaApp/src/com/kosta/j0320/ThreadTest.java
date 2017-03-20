package com.kosta.j0320;

import javax.swing.JFrame;

class MyThread extends Thread{

	//자식은 부모다!! ----> MyThread 는 Thread!
	
	//스레드 특징 ---> run()
	
	@Override
	public void run() { //스레드 메소드 !! ==> 동시실행을 목적으로 하는 코드문장들!
		// TODO Auto-generated method stub
		try {
			for(int i = 1; i < 11; i ++){
				
				Thread.sleep(1000);
				System.out.println("자바스레드1: " + i);
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
				System.out.println("자바스레드2: " + i);
			}
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	
}

public class ThreadTest {
	
	public static void main(String[] args) {
		MyThread t = new MyThread();
		//스레드 run()메소드는 반드시 start()를 통해 호출!
		//직접호출시에는 일반메소드와 차이가 없음!!
		t.start();
		
		//스레드객체 생성
		MyThread2 r = new MyThread2(); // r ---> 스레드객체 ? X
										// r ---> Runnable객체 O
		Thread t2 = new Thread(r); // t2 ---> 스레드 객
		t2.start();
	}

}
