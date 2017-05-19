package com.baseballgame.view;

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

import com.baseballgame.model.PlayerInfo;
import com.kosta.j0412.model.UserInfo;

public class ScoreView extends JFrame implements Runnable{
	
	public JTable table;
	public JScrollPane scroll;
	public DefaultTableModel dtm;
	public JButton selectAll,close;
	public JPanel panel, northp;
	JLabel la;
	Calendar cal;
	
	public ScoreView() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		String col[] = {"ID","�̸�","����","����"};
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
		selectAll = new JButton("��������");
		close = new JButton("�ݱ�");
		panel = new JPanel();
		
		//�Ӽ�����
		setLayout(new BorderLayout());
		table.setGridColor(Color.BLACK);
		panel.setLayout(new FlowLayout());
		panel.add(selectAll);
		panel.add(close);

		northp.add(la);
		
		add(northp,"North");
		add(scroll);
		add(panel,"South");
		
		//������
		setTitle("Display Best Score");
		setBounds(520,200,450,300);
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
	
	public void displayTable(Vector<PlayerInfo> v){
		dtm.setRowCount(0);
		for(int i = 0; i < v.size(); i++){
		dtm.addRow(v.get(i).toObjectArray());
		}
		
	}
	
	public void showMsg(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public static void main(String[] args) {
		new ScoreView();
	}
	

}
