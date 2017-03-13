package com.kosta.j0313;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUITest2 extends Frame implements ActionListener{
	
	Button bt1, bt2;
	TextField tf1;
	
	
	public GUITest2() {
		
		//�͸��� ����Ŭ����!!
		/*
		 * class C implements WindowListener{
		 * }
		 * class C extends WindowAdapter{
		 * }
		 * 
		 * addWindowListener(new C());
		 */
		addWindowListener(new WindowAdapter() { //== extends WindowAdapter
			//���ǵ� Ŭ����(WindowAdapter)�� ���� �������̵�!
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//��ü����
		bt1 = new Button("��ư1");
		bt2 = new Button("��ư2");
		tf1 = new TextField(10);
		
		//�Ӽ� ����
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(tf1);
		
		//������
		setLocation(550,250);
		setSize(300,300);
		setVisible(true);
		
		
		//������(������) ���
//		bt1.addActionListener(new A());
//		bt2.addActionListener(new B());
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		

	}
	
		@Override
	public void actionPerformed(ActionEvent e) { //�̺�Ʈ ó����(Handler)
				
			if(e.getSource() == bt1){
				System.out.println("hello~!");
				
			} else if(e.getSource() == bt2){
				System.out.println("java~~!");
				
			}
		
	}
	
	public static void main(String[] args) {
		new GUITest2();
	}



}
