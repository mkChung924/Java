package com.kosta.j0316;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableTest2 extends JFrame{
	
	JTable jTable;
	JScrollPane scroll;
	Dimension dm;
	
	public JTableTest2() {
		
		dm = new Dimension(400,120);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("J���̺��׽�Ʈ");
		
		Object a[][] = {{"ȫ�浿",13,"�л�"},
						{"�����",15,"�л�"},
						{"���ֿ�",16,"�л�"}};
		String b[] = {"�̸�","����","����"};
		
		jTable = new JTable(a,b);
		scroll = new JScrollPane(jTable);
		
		System.out.println("������� �̸���? "+jTable.getValueAt(1, 0));
		jTable.setValueAt("������", 1, 0);
		
		System.out.println("���̺� �� ��� ����� �̸�");
		for(int i = 0; i < jTable.getRowCount(); i++){
			System.out.println((String)jTable.getValueAt(i, 0));
		}
		
		add(scroll,"Center");
				
		//setLocation(500,200);
		//setPreferredSize(dm);
		//setSize(dm);
		setBounds(500,200,300,300);
		setVisible(true);
		
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				
				int row = jTable.getSelectedRow();
				int col = jTable.getSelectedColumn();
				
				System.out.println(jTable.getValueAt(row, col));
			}
		});
		
	}
	
	public static void main(String[] args) {
		new JTableTest2();
	}

}
