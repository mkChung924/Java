package com.kosta.j0320;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuChoiceTest extends JFrame implements ActionListener{
	JPanel northp, southp;
	JTextArea ta;
	JComboBox<String> comboBox;
	JCheckBox strawberry, apple, banna;
	JRadioButton breakfast, lunch, dinner;
	ButtonGroup bg;
	JScrollPane scroll;
	String temp, meal;
	
	public MenuChoiceTest() {
		
		setTitle("Menu Choice");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//객체생성
		bg = new ButtonGroup();
		northp = new JPanel();
		southp = new JPanel();
		ta = new JTextArea("***아침***\n1. Apple: false\n2. Strawberry: false\n3. Banna: false");
		comboBox = new JComboBox<>();
		strawberry = new JCheckBox("딸기");
		apple = new JCheckBox("사과");
		banna = new JCheckBox("바나나");
		breakfast = new JRadioButton("아침",true);
		lunch = new JRadioButton("점심");
		dinner = new JRadioButton("저녁");
		scroll = new JScrollPane(ta);
		bg.add(breakfast);
		bg.add(lunch);
		bg.add(dinner);
		comboBox.addItem("아침");
		comboBox.addItem("점심");
		comboBox.addItem("저녁");
		
		//속성설정
		setLayout(new BorderLayout());
		northp.setLayout(new GridLayout(2, 3));
		northp.add(breakfast);
		northp.add(lunch);
		northp.add(dinner);
		northp.add(apple);
		northp.add(strawberry);
		northp.add(banna);
		
		southp.setLayout(new FlowLayout());
		southp.add(comboBox);
		southp.setBackground(Color.orange);
		
		add(northp, "North");
		add(ta,"Center");
		add(southp, "South");
		
		//마무리
		setBounds(500,250,300,300);
		setVisible(true);
		
		breakfast.addActionListener(this);
		lunch.addActionListener(this);
		dinner.addActionListener(this);
		apple.addActionListener(this);
		strawberry.addActionListener(this);
		banna.addActionListener(this);
		comboBox.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob == breakfast || ob == lunch || ob == dinner){
		 meal = e.getActionCommand();
		 temp = meal;
		} else if(ob == comboBox){
			meal = comboBox.getSelectedItem().toString();
			if(meal.equals("아침")){
				breakfast.setSelected(true);
			} else if(meal.equals("점심")){
				lunch.setSelected(true);
			} else if(meal.equals("저녁")){
				dinner.setSelected(true);
			}
		}
		
		if(meal == null){
			meal = "아침";
		}
		
		boolean a = apple.isSelected();
		boolean b = banna.isSelected();
		boolean s = strawberry.isSelected();
		
		if(a || b || s){
		
			ta.setText("***"+meal + "***\n1. Apple: " + a + "\n2. Strawberry: " + s + "\n3. Banna: " + b);
			comboBox.setSelectedItem(meal);
		} else {
			ta.setText("***"+meal + "***\n1. Apple: " + a + "\n2. Strawberry: " + s + "\n3. Banna: " + b);
		}
		
	}
	
	public static void main(String[] args) {
		new MenuChoiceTest();
	}



}
