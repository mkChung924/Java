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
		
		setTitle("���Ӱ�ü");
		
		a = A.getInstance();
		
		//��ü����
		bt_reference = new JButton("���۷���");
		bt_add = new JButton("su���ϱ�");
		bt_su = new JButton("su���");
		
		ta = new JTextArea();
		scroll_ta = new JScrollPane(ta);
		southp = new JPanel();
		
		//�Ӽ�����
		southp.add(bt_reference);
		southp.add(bt_add);
		southp.add(bt_su);
		
		add(scroll_ta,"Center");
		add(southp, "South");
		
		//������
		setBounds(930,250,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		bt_reference.addActionListener(this);
		bt_add.addActionListener(this);
		bt_su.addActionListener(this);
	
	}
	
	public void actionPerformed(ActionEvent e){
		Object ob = e.getSource();
		String str;
		if(ob == bt_reference){
			str = "���۷���: " + a + "\n";
		} else if(ob == bt_add){
			str = "su�� ���� 1����\n";
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
