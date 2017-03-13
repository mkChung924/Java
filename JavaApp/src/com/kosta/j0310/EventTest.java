package com.kosta.j0310;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventTest extends Frame implements ActionListener {
	
	Button bt,bt2;
	Dimension dm;
	int i = 0;
	
	public EventTest() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0); // 음수값 - 비정상적인 종료, 양수값 - 정상적인 종료
			}
		});
		
		setTitle("이벤트테스트");
		dm = new Dimension(300,300);
		bt = new Button("나버튼");
		bt2 = new Button("나가기");
		
		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		
		setLocation(550,200);
		setSize(dm);
		setVisible(true);
		
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
	}
	
		@Override
	public void actionPerformed(ActionEvent e) {
			
			/*
			 * e.getActionCommand(); 리턴 String --> 만약 이벤트소스가 Button이라면 버튼의 라벨이 전달됨
			 * e.getSource(); return Object
			 * 
			 */
		
			 
			
		if(e.getSource() == bt){
			i++;
			System.out.println("나버튼 안녕?" + i);
			setTitle("나버튼 안녕~" + i);
			
		}
		
		else if(e.getSource() == bt2){
			System.exit(0);
		}
	}
		
		
	public static void main(String[] args) {
		new EventTest();
	}

}
