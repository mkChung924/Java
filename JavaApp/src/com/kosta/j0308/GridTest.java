package com.kosta.j0308;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridTest {
	
	Frame f;
	Frame f2;
	Button bt1,bt2,bt3,bt4,bt5,Do;
	
	public GridTest() {
		f = new Frame("Grid Test");
		f2 = new Frame("��");
		
		bt1 = new Button("��");
		bt2 = new Button("��");
		bt3 = new Button("��");
		bt4 = new Button("��");
		bt5 = new Button("��");
		Do = new Button("��");
				
		f.setLayout(new GridLayout());
		f2.setLayout(new BorderLayout());
		f.add(bt1);
		f.add(bt2);
		f.add(bt3);
		f.add(bt4);
		f.add(bt5);
		f2.add(Do);
		
		f.setLocation(450, 300);
		f.setSize(300,300);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��");
				f2.setLocation(450, 300);
				f2.setSize(200, 200);
				f2.setVisible(true);
				
				Do.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						f2.setVisible(false);						
					}
				});
				
				
			}
		});
		
		
		
	}
	
	public static void main(String[] args) {
		new GridTest();
	}

}
