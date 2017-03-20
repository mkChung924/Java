package com.kosta.j0316;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
	
	JTable jTable;
	JScrollPane scroll;
	Dimension dm;
	
	public JTableTest() {
		
		dm = new Dimension(400,120);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("J���̺��׽�Ʈ");
		
		Object a[][] = {{"ȫ�浿",13,"�л�"},
						{"�����",15,"�л�"},
						{"���ֿ�",16,"�л�"}};
		String b[] = {"�̸�","����","����"};
		
		//new JTable(TableModel dm)
		//				-------------> TableModel�� �ڽ�Ŭ���� : DefaultTableModel
		//DefaultTableModel(Object[][] data, Object[] colNames)
		DefaultTableModel dtm = new DefaultTableModel(a, b);

		jTable = new JTable(dtm);
		scroll = new JScrollPane(jTable);
		jTable.setGridColor(Color.BLACK);
		
		System.out.println("������� �̸���? "+jTable.getValueAt(1, 0));
		jTable.setValueAt("������", 1, 0);
		
		System.out.println("���̺� �� ��� ����� �̸�");
		for(int i = 0; i < jTable.getRowCount(); i++){
			System.out.println((String)jTable.getValueAt(i, 0));
		}
		
		Object c[] = {"�����",27,"���"};
		dtm.addRow(c);
		//dtm.removeRow(3);
		for(int i = 0; i < dtm.getRowCount(); i++){
			if(jTable.getValueAt(i, 0).equals("������")){
				dtm.removeRow(i);
			}
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
		new JTableTest();
	}

}
