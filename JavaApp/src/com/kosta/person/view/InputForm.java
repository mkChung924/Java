package com.kosta.person.view;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputForm extends JFrame{

	public JPanel p1,p2,p3,p4;
	public JTextField tf1,tf2,tf3;
	public JLabel la1,la2,la3;
	public JButton submit, reset;
	
	public InputForm() {
		
		setTitle("�Է���");
		//��ü����
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		tf1 = new JTextField(5);
		tf2 = new JTextField(5);
		tf3 = new JTextField(5);
		la1 = new JLabel("�̸�");
		la2 = new JLabel("����");
		la3 = new JLabel("����");
		submit = new JButton("Ȯ��");
		reset = new JButton("���");
		
		
		//�Ӽ�����
		setLayout(null);
		p1.add(la1);
		p1.add(tf1);
		p2.add(la2);
		p2.add(tf2);
		p3.add(la3);
		p3.add(tf3);
		p4.add(submit);
		p4.add(reset);
		
		p1.setBounds(45,10,200,30);
		p2.setBounds(45,50,200,30);
		p3.setBounds(45,90,200,30);
		p4.setBounds(45,130,200,30);
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		
		//������
		setBounds(500,200,300,200);
		setResizable(false);
		//setVisible(true);
		
	}
	
	
}
