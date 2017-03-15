package com.kosta.j0314;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JRadioButtonTest extends JFrame{
	
	JRadioButton bt1;
	JRadioButton bt2;
	JRadioButton bt3;
	
	public JRadioButtonTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//��ü ����
		Icon icon1 = new ImageIcon("image/left.gif");
		Icon icon2 = new ImageIcon("image/leftdown.gif");
		Icon icon3 = new ImageIcon("image/leftrollover.gif");
		ButtonGroup group = new ButtonGroup();
		bt1 = new JRadioButton("��ħ",icon1);
		bt1.setPressedIcon(icon3);
		bt1.setRolloverIcon(icon3);
		bt1.setSelectedIcon(icon2);
		bt2 = new JRadioButton("����");
		bt3 = new JRadioButton("����");
		
		group.add(bt1);
		group.add(bt2);
		group.add(bt3);
		
		//�Ӽ� ����
		setLayout(new GridLayout(3, 1));
		add(bt1);
		add(bt2);
		add(bt3);
		
		//������
		setBounds(550,200,300,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new JRadioButtonTest();
	}

}
