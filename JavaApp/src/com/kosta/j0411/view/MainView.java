package com.kosta.j0411.view;

import com.kosta.j0411.model.PersonDTO;
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
import javax.swing.JOptionPane;
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
		
		String col[] = {"번호","이름","나이","직업"};
		Object row[][] = new Object[0][4]; 
		//객체생성
		
		//cell 못바꾸게 하는 메소드 포함
		dtm = new DefaultTableModel(row,col){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		la = new JLabel();
		
		northp = new JPanel();
		table = new JTable(dtm);
		scroll = new JScrollPane(table);
		insert = new JButton("입력");
		update = new JButton("수정");
		delete = new JButton("삭제");
		exit = new JButton("종료");
		getName = new JButton("이름검색");
		getall = new JButton("전체검색");
		panel = new JPanel();
		
		//속성설정
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
		
		//마무리
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
			
			la.setText(year+"년 "+ month + "월 " + day + "일 " + hour + "시 " + minute + "분 "+ second+ "초 ");
			Thread.sleep(1000);
			
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayTable(Vector<PersonDTO> v){
		dtm.setRowCount(0);
		for(int i = 0; i < v.size(); i++){
		dtm.addRow(v.get(i).toObjectArray());
		}
		
	}
	
	public void showMsg(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}

}
