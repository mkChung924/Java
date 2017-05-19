package com.kosta.j0412.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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

import com.kosta.j0412.model.UserInfo;

public class ServiceForm extends JFrame implements Runnable{
	
	public JTable table;
	public JScrollPane scroll;
	public DefaultTableModel dtm;
	public JButton selectAll,update,delete,search;
	public JPanel panel, northp;
	JLabel la;
	Calendar cal;
	
	public ServiceForm() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String col[] = {"ID","�̸�","����","����", "��ȭ��ȣ", "�ּ�"};
		Object row[][] = new Object[0][6]; 
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
		selectAll = new JButton("����");
		update = new JButton("����");
		delete = new JButton("����");
		search = new JButton("�˻�");
		panel = new JPanel();
		
		//�Ӽ�����
		setLayout(new BorderLayout());
		table.setGridColor(Color.BLACK);
		panel.setLayout(new FlowLayout());
		panel.add(selectAll);
		panel.add(update);
		panel.add(delete);
		panel.add(search);
		northp.add(la);
		
		add(northp,"North");
		add(scroll);
		add(panel,"South");
		
		//������
		setTitle("Display Data");
		setBounds(420,200,650,300);
		//setResizable(false);
		//setVisible(true);
		
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
	
	public void displayTable(Vector<UserInfo> v){
		dtm.setRowCount(0);
		for(int i = 0; i < v.size(); i++){
		dtm.addRow(v.get(i).toObjectArray());
		}
		
	}
	
	public void showMsg(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}
	

}
