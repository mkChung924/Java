package com.kosta.j0309;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.Border;

public class TextFieldAreaTest extends Frame{
	//컨테이너, 컴포넌트 객체선언
	Panel northp, southp;
	Panel panel3;
	TextField tf1;
	TextField tf2;
	TextArea ta1;
	Label li1;
	
	public TextFieldAreaTest() {
		//객체 생성
		northp = new Panel();
		southp = new Panel();
		//panel3 = new Panel();
		
		tf1 = new TextField("상단TextField", 10);
		tf2 = new TextField(13);
		ta1 = new TextArea();
		li1 = new Label("File Name:", Label.CENTER);
		
		//속성 설정
		setTitle("TextFieldAreaTest");
		//setLayout(new BorderLayout());//Frame은 기본값으로 BorderLayout()으로 설정되어있음.
		//northp.setLayout(new FlowLayout());//기본값으로 FlowLayout()으로 설정되어있음.
		//southp.setLayout(new FlowLayout());
		northp.add(tf1);
		northp.setBackground(new Color(0,255,0));
		li1.setForeground(Color.RED);
		southp.add(li1);
		southp.add(tf2);
		southp.setBackground(Color.YELLOW);
		add(northp, "North");
		add(ta1, "Center");
		add(southp, "South");
		//add(panel3);
		
		//마무리2(사이즈, 보이기)
		
		setLocation(550,250);
		setSize(300,300);
		setVisible(true);
			
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new TextFieldAreaTest();
	}

}
