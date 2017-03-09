package com.kosta.j0309;

import java.awt.Frame;

public class FrameTest2 extends Frame{
	
	public FrameTest2(String title) {
		
		//타이틀
		//super(title); //생성자 호출시 딱 한번만 실행됨. 타이틀을 바꾸고 싶을 때 바꾸지 못함.
		setTitle("나 타이틀");

		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameTest2("나 타이틀2");
	}

}
