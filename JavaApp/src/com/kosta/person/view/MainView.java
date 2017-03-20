package com.kosta.person.view;

import com.kosta.person.model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame implements Runnable{
	
	
	public JTable table;
	public JScrollPane scroll;
	public DefaultTableModel dtm;
	public JButton insert,update,delete,exit,getName,getall;
	public JPanel panel, northp;
	JLabel la;
	Calendar cal;
	
	public MainView() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String col[] = {"��ȣ","�̸�","����","����"};
		Object row[][] = new Object[0][4]; 
		//��ü����
		
		//cell ���ٲٰ� �ϴ� �޼ҵ� ����
		dtm = new DefaultTableModel(row,col){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		la = new JLabel();
		
		northp = new JPanel();
		table = new JTable(dtm);
		scroll = new JScrollPane(table);
		insert = new JButton("�Է�");
		update = new JButton("����");
		delete = new JButton("����");
		exit = new JButton("����");
		getName = new JButton("�̸��˻�");
		getall = new JButton("��ü�˻�");
		panel = new JPanel();
		
		//�Ӽ�����
		setLayout(new BorderLayout());
		table.setGridColor(Color.BLACK);
		panel.setLayout(new FlowLayout());
		panel.add(insert);
		panel.add(update);
		panel.add(delete);
		panel.add(getName);
		panel.add(getall);
		panel.add(exit);
		northp.add(la);
		
		add(northp,"North");
		add(scroll);
		add(panel,"South");
		
		//������
		setTitle("MainView");
		setBounds(450,200,550,300);
		//setResizable(false);
		setVisible(true);
		
		//setTimeLabel();
		//Thread t = new Thread(this);
		new Thread(this).start();
		
	}
	
	public void run(){
		
		try {
			while(true){
				
			cal = Calendar.getInstance();
			
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int hour = cal.get(Calendar.HOUR_OF_DAY);
			int minute = cal.get(Calendar.MINUTE);
			int second = cal.get(Calendar.SECOND);
			
			la.setText(year+"�� "+ month + "�� " + day + "�� " + hour + "�� " + minute + "�� "+ second+ "�� ");
			Thread.sleep(1000);
			
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayTable(Vector<Person> v){
		dtm.setRowCount(0);
		for(int i = 0; i < v.size(); i++){
		dtm.addRow(v.get(i).toObjectArray());
		}
		
	}

}
