package com.kosta.j0323;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Lime extends JFrame implements ActionListener{
	
	JButton bt_reference, bt_add, bt_su;
	JTextArea ta;
	JScrollPane scroll_ta;
	
	JPanel southp;
	
	A a;
	
	public Lime() {
		
		setTitle("라임객체");
		
		a = A.getInstance();
		
		//객체생성
		bt_reference = new JButton("레퍼런스");
		bt_add = new JButton("su더하기");
		bt_su = new JButton("su출력");
		
		ta = new JTextArea();
		scroll_ta = new JScrollPane(ta);
		southp = new JPanel();
		
		//속성설정
		southp.add(bt_reference);
		southp.add(bt_add);
		southp.add(bt_su);
		
		add(scroll_ta,"Center");
		add(southp, "South");
		
		//마무리
		setBounds(930,250,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		bt_reference.addActionListener(this);
		bt_add.addActionListener(this);
		bt_su.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent e){
		Object ob = e.getSource();
		String str;
		if(ob == bt_reference){
			str = "레퍼런스: " + a + "\n";
		} else if(ob == bt_add){
			str = "su의 값을 1증가\n";
			a.su++;
		} else {
			str = "su = "+a.su+"\n";
			
		}
		ta.append(str);
	}
	
	public static void main(String[] args) {
		new Lime();
	}
	
}
