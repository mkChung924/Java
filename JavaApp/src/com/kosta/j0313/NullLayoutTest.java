package com.kosta.j0313;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NullLayoutTest extends Frame{

	Button bt;
	
	public NullLayoutTest() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		bt = new Button("button");
//		bt.setSize(80, 20);
//		bt.setLocation(110,140);
		bt.setBounds(110, 140, 80, 20);
		
		setLayout(null);//Null���̾ƿ��� ����� ��� ������Ʈ�� ���μ��� ���̿� x,y���� �����ؾ� ��!!
		add(bt);
		
		setLocation(550,250);
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullLayoutTest();
	}
}
