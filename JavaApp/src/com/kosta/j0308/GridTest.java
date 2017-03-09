package com.kosta.j0308;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridTest implements ActionListener {
	
	Frame f;
	Frame f2;
	Button bt1,bt2,bt3,bt4,bt5,bt6,Do,le,mi,pa,sol,la;
	
	public GridTest() {
		f = new Frame("Grid Test");
		f2 = new Frame("도");
		
		bt1 = new Button("도");
		bt2 = new Button("레");
		bt3 = new Button("미");
		bt4 = new Button("파");
		bt5 = new Button("솔");
		bt6 = new Button("라");
		Do = new Button("도");
		le = new Button("레");
		mi = new Button("미");
		pa = new Button("파");
		sol = new Button("솔");
		la = new Button("라");
		
				
		f.setLayout(new GridLayout(1,6,5,0));
		f2.setLayout(new FlowLayout());
		f.add(bt1);
		f.add(bt2);
		f.add(bt3);
		f.add(bt4);
		f.add(bt5);
		f.add(bt6);
		f2.add(Do);
		f2.add(le);
		f2.add(mi);
		f2.add(pa);
		f2.add(sol);
		f2.add(la);
		
		f.setLocation(450, 300);
		f.setSize(400,300);
		f.setVisible(true);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);
		bt6.addActionListener(this);
		Do.addActionListener(this);
		le.addActionListener(this);
		mi.addActionListener(this);
		pa.addActionListener(this);
		sol.addActionListener(this);
		la.addActionListener(this);
			
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == bt1){
			Do.setVisible(true);
			le.setVisible(false);
			mi.setVisible(false);
			pa.setVisible(false);
			sol.setVisible(false);
			la.setVisible(false);
			f2.setLocation(450, 300);
			f2.setSize(200, 200);
			f2.setVisible(true);
		}
		
		if(e.getSource() == bt2){
			f2.setLocation(450, 300);
			f2.setSize(200, 200);
			f2.setVisible(true);
		}
		
		if(e.getSource() == bt3){
			f2.setLocation(450, 300);
			f2.setSize(200, 200);
			f2.setVisible(true);
		}
		
		if(e.getSource() == bt4){
			f2.setLocation(450, 300);
			f2.setSize(200, 200);
			f2.setVisible(true);
		}
		
		if(e.getSource() == bt5){
			f2.setLocation(450, 300);
			f2.setSize(200, 200);
			f2.setVisible(true);
		}
		
		if(e.getSource() == bt6){
			f2.setLocation(450, 300);
			f2.setSize(200, 200);
			f2.setVisible(true);
		}
		
		if(e.getSource() == Do){
			f2.setVisible(false);
		}
		
		if(e.getSource() == le){
			f2.setVisible(false);
		}
		
		if(e.getSource() == mi){
			f2.setVisible(false);
		}
		
		if(e.getSource() == pa){
			f2.setVisible(false);
		}
		
		if(e.getSource() == sol){
			f2.setVisible(false);
		}
		
		if(e.getSource() == la){
			f2.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new GridTest();
	}



}
