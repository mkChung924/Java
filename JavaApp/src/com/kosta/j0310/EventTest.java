package com.kosta.j0310;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventTest extends Frame implements ActionListener {
	
	Button bt,bt2;
	Dimension dm;
	int i = 0;
	
	public EventTest() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0); // ������ - ���������� ����, ����� - �������� ����
			}
		});
		
		setTitle("�̺�Ʈ�׽�Ʈ");
		dm = new Dimension(300,300);
		bt = new Button("����ư");
		bt2 = new Button("������");
		
		setLayout(new FlowLayout());
		add(bt);
		add(bt2);
		
		setLocation(550,200);
		setSize(dm);
		setVisible(true);
		
		bt.addActionListener(this);
		bt2.addActionListener(this);
		
	}
	
		@Override
	public void actionPerformed(ActionEvent e) {
			
			/*
			 * e.getActionCommand(); ���� String --> ���� �̺�Ʈ�ҽ��� Button�̶�� ��ư�� ���� ���޵�
			 * e.getSource(); return Object
			 * 
			 */
		
			 
			
		if(e.getSource() == bt){
			i++;
			System.out.println("����ư �ȳ�?" + i);
			setTitle("����ư �ȳ�~" + i);
			
		}
		
		else if(e.getSource() == bt2){
			System.exit(0);
		}
	}
		
		
	public static void main(String[] args) {
		new EventTest();
	}

}
