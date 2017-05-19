package com.kosta.j0411.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetNameView extends JFrame{
	
	JLabel la;
	public JTextField tf;
	public JButton search;
	JPanel panel, panel2;
	
	public GetNameView() {
	
		setTitle("이름검색");
		la = new JLabel("검색할 이름: ");
		tf = new JTextField(5);
		panel = new JPanel();
		panel2 = new JPanel();
		
		search = new JButton("검색");
		
		setLayout(new GridLayout(4, 1));
		panel.setLayout(new FlowLayout());
		panel.add(la);
		panel.add(tf);
		panel2.add(search);
		add(new JLabel());
		add(panel);
		add(panel2);
		
		setBounds(500,250,300,150);
	
	}

}
