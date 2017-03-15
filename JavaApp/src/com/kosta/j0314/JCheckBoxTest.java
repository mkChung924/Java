package com.kosta.j0314;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class JCheckBoxTest extends JFrame{
	
	JPanel p1;
	JCheckBox cb1, cb2, cb3;
	ImageIcon icon1;
	ImageIcon icon2;
	ImageIcon icon3;
	ImageIcon icon4;
	ImageIcon icon5;
	ImageIcon icon6;

	public JCheckBoxTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("üũ�ڽ��׽�Ʈ");
		
		//��ü����
		p1 = new JPanel();
		p1.setBorder(new TitledBorder(new BevelBorder(0,Color.BLACK,Color.BLACK),"�г�Ÿ��Ʋ"));
		//�簢 RAISED, ���� LOWERED
		//p1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		//p1.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		//new JCheckBox(String text);
		//new JCheckBox(Icon icon);
		//new JCheckBox(String text, Icon icon);
		//icon1 = new ImageIcon("/Users/myungkyuchung/git/Java/JavaApp/image/left.gif");// FM
		icon1 = new ImageIcon("image/left.gif");
		icon2 = new ImageIcon("image/leftdown.gif");
		icon3 = new ImageIcon("image/leftrollover.gif");
		icon4 = new ImageIcon("image/right.gif");
		icon5 = new ImageIcon("image/rightdown.gif");
		icon6 = new ImageIcon("image/rightrollover.gif");
		cb1 = new JCheckBox("ù��°üũ�ڽ�",new ImageIcon("image/LEFT.gif"));
		cb1.setRolloverIcon(icon3);
		cb1.setSelectedIcon(icon2);
		cb2 = new JCheckBox("�ι�°üũ�ڽ�", new ImageIcon("image/right.gif"));
		cb2.setRolloverIcon(icon6);
		cb2.setSelectedIcon(icon5);
		cb3 = new JCheckBox("����°üũ�ڽ�");
		cb3.setToolTipText("�ȳ�, cb3?");
		
		//�Ӽ�����
		p1.setLayout(new GridLayout(3, 1));
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		
		setLayout(new BorderLayout()); //������ �⺻��
		add(p1);
		
		//������
		setBounds(550,200,300,300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new JCheckBoxTest();
	}



}
