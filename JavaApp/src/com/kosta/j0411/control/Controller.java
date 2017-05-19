package com.kosta.j0411.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import com.kosta.j0411.model.PersonDAO;
import com.kosta.j0411.model.PersonDTO;
import com.kosta.j0411.view.InputForm;
import com.kosta.j0411.view.MainView;
import com.kosta.j0411.view.UpForm;

public class Controller implements ActionListener {
	
	MainView main;
	InputForm input;
	UpForm up;
	PersonDAO dao;
	
	int rowNum;
	int no;
	boolean listClicked;
	
	/*
	 * <��Ʈ�ѷ��� ����>
	 * 1. ����� ��û �м�
	 * 2. ����� �Էµ����� ������
	 * 3. ������ ModelŬ���� ��ü����
	 * 4. ������ �̵�
	 * ���û��� : ��ȿ�� �˻�
	 */
	
	public Controller() {
		main = new MainView();
		input = new InputForm();
		up = new UpForm();
		
		eventUp();
		dao = new PersonDAO();
		main.displayTable(dao.selectAll());
		
	}
	
	public void eventUp(){
		main.insert.addActionListener(this);
		main.update.addActionListener(this);
		main.delete.addActionListener(this);
		main.exit.addActionListener(this);
		main.getName.addActionListener(this);
		main.getall.addActionListener(this);
		
		input.submit.addActionListener(this);
		input.reset.addActionListener(this);
		input.tf3.addActionListener(this);
		
		up.up.addActionListener(this);
		up.reset.addActionListener(this);
		up.tf3.addActionListener(this);
		
//		gnv.search.addActionListener(this);
//		gnv.tf.addActionListener(this);
		
		main.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				rowNum = main.table.getSelectedRow();
				no = (int)main.table.getValueAt(rowNum, 0);
				System.out.println(no);
				
				listClicked = true;
			}
		});
		
		
		input.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				input.setVisible(false);
				main.setVisible(true);
			
			}
		});
		
		up.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				up.setVisible(false);
				main.setVisible(true);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == main.insert){
			
			System.out.println("ahah");
			main.setVisible(false);
			input.setVisible(true);
			
		} else if(ob == input.submit){
			
			String name = input.tf1.getText();
			String age = input.tf2.getText();
			String job = input.tf3.getText();
			PersonDTO person = new PersonDTO(0, name, Integer.parseInt(age), job);
			
			if(dao.insert(person)){
				input.setVisible(false);
				main.setVisible(true);
				main.showMsg("�Է¼���~!");
				
				main.displayTable(dao.selectAll());
			} else {
				input.showMsg("�Է½���~!");
			}
			
		} else if(ob == main.update){
			
			if(listClicked){
				main.setVisible(false);
				up.setVisible(true);
				
				up.tf1.setText(dao.getinfo(no).get(1) + "");
				up.tf2.setText(dao.getinfo(no).get(2) + "");
				up.tf3.setText(dao.getinfo(no).get(3) + "");
				up.tf4.setText(dao.getinfo(no).get(0) + "");
				
			} else {
				main.showMsg("���� �� �����͸� Ŭ���ϼ���.");
			}
			
		} else if(ob == up.up){
			
			String name = up.tf1.getText();
			String age = up.tf2.getText();
			String job = up.tf3.getText();
			String no = up.tf4.getText();
			if(dao.update(new PersonDTO(Integer.parseInt(no), name, Integer.parseInt(age), job))){
				up.setVisible(false);
				main.setVisible(true);
				main.displayTable(dao.selectAll());
			} else {
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args) {
		new Controller();
		
	}



}
