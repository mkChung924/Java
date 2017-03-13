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
		
		//익명의 내부클래스!!
		/*
		 * class C implements WindowListener{
		 * }
		 * class C extends WindowAdapter{
		 * }
		 * 
		 * addWindowListener(new C());
		 */
		addWindowListener(new WindowAdapter() { //== extends WindowAdapter
			//정의된 클래스(WindowAdapter)에 대한 오버라이딩!
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//객체생성
		bt1 = new Button("버튼1");
		bt2 = new Button("버튼2");
		tf1 = new TextField(10);
		
		//속성 설정
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(tf1);
		
		//마무리
		setLocation(550,250);
		setSize(300,300);
		setVisible(true);
		
		
		//연결자(감시자) 등록
//		bt1.addActionListener(new A());
//		bt2.addActionListener(new B());
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		

	}
	
		@Override
	public void actionPerformed(ActionEvent e) { //이벤트 처리부(Handler)
				
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
