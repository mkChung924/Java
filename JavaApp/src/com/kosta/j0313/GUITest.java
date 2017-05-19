package com.kosta.j0313;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUITest extends Frame{
	
	Button bt1, bt2;
	TextField tf1;
	
	
	public GUITest() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		System.out.println("객체생성(메모리할당) 전");
		System.out.println("버튼1 : " + bt1);
		System.out.println("버튼2 :" + bt2);
		System.out.println("텍스트필드 : "+ tf1);
		
		bt1 = new Button("버튼1");
		bt2 = new Button("버튼2");
		tf1 = new TextField(10);
		
		System.out.println("객체생성(메모리할당) 후");
		System.out.println("버튼1 : " + bt1);
		System.out.println("버튼2 :" + bt2);
		System.out.println("텍스트필드 : "+ tf1);
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		add(tf1);
		
		setLocation(550,250);
		setSize(300,300);
		setVisible(true);
		
		System.out.println("컨테이너 부착 후");
		System.out.println("버튼1 : " + bt1);
		System.out.println("버튼2 :" + bt2);
		System.out.println("텍스트필드 : "+ tf1);
		
		//연결자(감시자) 등록
		bt1.addActionListener(new A());
		bt2.addActionListener(new B());
		

	}
	
	public static void main(String[] args) {
		new GUITest();
	}

}
