package com.kosta.j0316;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainViewTest extends JFrame{
	
	JTable table;
	DefaultTableModel dtm;
	JScrollPane scroll;
	
	public MainViewTest() {
	
		Object a[] = {"번호", "이름","나이","직업"};
		Object b[][] = {};
		dtm = new DefaultTableModel(b,a);
		table = new JTable(dtm);
		scroll = new JScrollPane(table);
		
		Object row[] = {0, "정명규", 27, "백수"};
		dtm.addRow(row);
		
		add(scroll);
		
		setBounds(500,200,300,300);
		setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new MainViewTest();
	}

}
