package com.kosta.j0411.view;

import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kosta.person.model.Person;

public class UpForm extends JFrame{

	public JPanel p1,p2,p3,p4,p5,p6;
	public JTextField tf1,tf2,tf3,tf4;
	public JLabel la1,la2,la3,la4, info;
	public JButton up, reset;
	
	public UpForm() {
	
		setTitle("수정폼");
		//객체생성

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		tf1 = new JTextField(5);
		tf2 = new JTextField(5);
		tf3 = new JTextField(5);
		tf4 = new JTextField(5);
		la1 = new JLabel("이름");
		la2 = new JLabel("나이");
		la3 = new JLabel("직업");
		la4 = new JLabel("번호");
		info = new JLabel("수정할 항목을 수정해주세요.");
		up = new JButton("수정");
		reset = new JButton("취소");
		
		
		//속성설정
		tf4.setEditable(false);
		tf4.setEnabled(false);
		setLayout(null);
		p1.add(la1);
		p1.add(tf1);
		p2.add(la2);
		p2.add(tf2);
		p3.add(la3);
		p3.add(tf3);
		p4.add(up);
		p4.add(reset);
		p5.add(info);
		p6.add(la4);
		p6.add(tf4);

		p5.setBounds(45,20,200,30);
		p6.setBounds(45,60,200,30);
		p1.setBounds(45,100,200,30);
		p2.setBounds(45,140,200,30);
		p3.setBounds(45,180,200,30);
		p4.setBounds(45,220,200,30);
		
		
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p6);
		
		//마무리
		setBounds(500,200,300,300);
		setResizable(false);
		//setVisible(true);
		
	}
	
	
}