package com.kosta.calc.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalcView extends JFrame{
	
	public JTextField tf1, tf2;
	public JButton button;
	public JPanel panel;
	public JComboBox<String> comboBox;
	public JLabel label;
	
	public CalcView() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ü����
		setTitle("MVC���ܰ���");
		
		panel = new JPanel();
		tf1 = new JTextField(3);
		tf2 = new JTextField(3);
		comboBox = new JComboBox<>();
		button = new JButton("���");
		label = new JLabel();
				
		//�Ӽ�����
		setLayout(new FlowLayout());
		add(tf1);
		add(comboBox);
		add(tf2);
		add(button);
		add(label);
		
		comboBox.addItem("+");
		comboBox.addItem("-");
		comboBox.addItem("x");
		comboBox.addItem("/");
		
		
		//������
		setBounds(500,250,290,100);
		setVisible(true);
		setResizable(false);
	}

}
