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
	//�����̳�, ������Ʈ ��ü����
	Panel northp, southp;
	Panel panel3;
	TextField tf1;
	TextField tf2;
	TextArea ta1;
	Label li1;
	
	public TextFieldAreaTest() {
		//��ü ����
		northp = new Panel();
		southp = new Panel();
		//panel3 = new Panel();
		
		tf1 = new TextField("���TextField", 10);
		tf2 = new TextField(13);
		ta1 = new TextArea();
		li1 = new Label("File Name:", Label.CENTER);
		
		//�Ӽ� ����
		setTitle("TextFieldAreaTest");
		//setLayout(new BorderLayout());//Frame�� �⺻������ BorderLayout()���� �����Ǿ�����.
		//northp.setLayout(new FlowLayout());//�⺻������ FlowLayout()���� �����Ǿ�����.
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
		
		//������2(������, ���̱�)
		
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
