package com.kosta.j0309;

import java.awt.Frame;

public class FrameTest2 extends Frame{
	
	public FrameTest2(String title) {
		
		//Ÿ��Ʋ
		//super(title); //������ ȣ��� �� �ѹ��� �����. Ÿ��Ʋ�� �ٲٰ� ���� �� �ٲ��� ����.
		setTitle("�� Ÿ��Ʋ");

		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FrameTest2("�� Ÿ��Ʋ2");
	}

}
