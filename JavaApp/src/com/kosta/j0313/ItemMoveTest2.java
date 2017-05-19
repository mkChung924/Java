package com.kosta.j0313;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ItemMoveTest2 extends Frame implements ActionListener{
	
	Panel lpanel, rpanel, cpanel;
	List lList, rList;
	Button bt_l,bt_l_all,bt_r,bt_r_all,remove_all_l,remove_all_r;
	TextField ltf,rtf;
	
	public ItemMoveTest2() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		
		//객체생성
		lpanel = new Panel();
		rpanel = new Panel();
		cpanel = new Panel();
		lList = new List(10,true);
		rList = new List(10,true);
		bt_l = new Button("◁");
		bt_l_all = new Button("◀");
		bt_r = new Button("▷");
		bt_r_all = new Button("▶");
		remove_all_l = new Button("◀ 삭제");
		remove_all_r = new Button("▶ 삭제");
		ltf = new TextField();
		rtf = new TextField();
		
		//속성설정
		setLayout(new GridLayout(1, 3));
		lpanel.setLayout(new BorderLayout());
		rpanel.setLayout(new BorderLayout());
		cpanel.setLayout(null);
		cpanel.setBackground(Color.orange);
		lpanel.add(lList, "Center");
		lpanel.add(ltf, "South");
		rpanel.add(rList, "Center");
		rpanel.add(rtf, "South");

		bt_r.setBounds(55, 15, 40, 40);
		bt_r_all.setBounds(55, 55, 40, 40);
		bt_l.setBounds(55, 95, 40, 40);
		bt_l_all.setBounds(55, 135, 40, 40);
		remove_all_l.setBounds(45,185,60,40);
		remove_all_r.setBounds(45,225,60,40);
		cpanel.add(bt_r);
		cpanel.add(bt_r_all);
		cpanel.add(bt_l);
		cpanel.add(bt_l_all);
		cpanel.add(remove_all_l);
		cpanel.add(remove_all_r);
		
		add(lpanel);
		add(cpanel);
		add(rpanel);
		
		//마무리
		setTitle("ItemMove");
		setLocation(550,250);
		setSize(450,300);
		setVisible(true);
		
		ltf.addActionListener(this);
		rtf.addActionListener(this);
		bt_l.addActionListener(this);
		bt_l_all.addActionListener(this);
		bt_r.addActionListener(this);
		bt_r_all.addActionListener(this);
		remove_all_l.addActionListener(this);
		remove_all_r.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		
		if(e.getSource() == ltf){
			String left = ltf.getText().toString().trim();

			if(left.isEmpty()){
				return;
			} else {
				lList.add(left);
				ltf.setText("");
			}
		} else if(e.getSource() == rtf){
			String right = rtf.getText().toString().trim();

			if(right.isEmpty()){
				return;
			} else {
				rList.add(right);
				rtf.setText("");
			}
		} else if(e.getSource() == bt_r){

			int items[] = lList.getSelectedIndexes();
			for(int i = 0; i < items.length; i++){
				rList.add(lList.getItem(items[i]));
			}
			for(int i = items.length; i > 0; i--){
				lList.remove(items[i-1]);
			}
			
		} else if(e.getSource() == bt_r_all){
			for(int i = 0; i < lList.getItemCount(); i++){
				String item = lList.getItem(i);
				rList.add(item);

			}
			lList.removeAll();
			
		} else if(e.getSource() == bt_l){

			int items[] = rList.getSelectedIndexes();
			for(int i = 0; i < items.length; i++){
				lList.add(rList.getItem(items[i]));
			}
			for(int i = items.length; i > 0; i--){
				rList.remove(items[i-1]);
			}
			
		} else if(e.getSource() == bt_l_all){
			
			for(int i = 0; i < rList.getItemCount(); i++){
				String item = rList.getItem(i);
				lList.add(item);
			}
			rList.removeAll();
			
		} else if(e.getSource() == remove_all_l){
			lList.removeAll();
						
		} else if(e.getSource() == remove_all_r){
			rList.removeAll();
		}
		
	}
	
	public static void main(String[] args) {
		new ItemMoveTest2();
		
	}

}
