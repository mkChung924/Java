package com.kosta.j0309;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class TextFieldArea {
	
	Frame f;
	Panel panel1;
	Panel panel2;
	Panel panel3;
	TextField tf1;
	TextField tf2;
	TextArea ta1;
	Label li1;
	
	public TextFieldArea() {
		
		//��ü ����
		f = new Frame("�� Ÿ��Ʋ");
		panel1 = new Panel();
		panel2 = new Panel();
		panel3 = new Panel();
		
		tf1 = new TextField();
		tf2 = new TextField();
		ta1 = new TextArea();
		li1 = new Label("�����̸�: ");
		
		//�Ӽ� ����
		f.setLayout(new BorderLayout());
		f.add(tf1,"North");
		f.add(ta1,"Center");
		f.add(tf2,"South");
		
		
		//������2(������, ���̱�)
		f.setSize(300, 300);
		f.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new TextFieldArea();
	}

}
