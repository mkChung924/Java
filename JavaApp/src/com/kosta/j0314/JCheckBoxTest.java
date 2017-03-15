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
		setTitle("체크박스테스트");
		
		//객체생성
		p1 = new JPanel();
		p1.setBorder(new TitledBorder(new BevelBorder(0,Color.BLACK,Color.BLACK),"패널타이틀"));
		//양각 RAISED, 음각 LOWERED
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
		cb1 = new JCheckBox("첫번째체크박스",new ImageIcon("image/LEFT.gif"));
		cb1.setRolloverIcon(icon3);
		cb1.setSelectedIcon(icon2);
		cb2 = new JCheckBox("두번째체크박스", new ImageIcon("image/right.gif"));
		cb2.setRolloverIcon(icon6);
		cb2.setSelectedIcon(icon5);
		cb3 = new JCheckBox("세번째체크박스");
		cb3.setToolTipText("안녕, cb3?");
		
		//속성설정
		p1.setLayout(new GridLayout(3, 1));
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		
		setLayout(new BorderLayout()); //프레임 기본값
		add(p1);
		
		//마무리
		setBounds(550,200,300,300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new JCheckBoxTest();
	}



}
