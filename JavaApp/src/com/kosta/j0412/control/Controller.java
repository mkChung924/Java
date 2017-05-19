package com.kosta.j0412.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import com.kosta.j0412.model.UserInfo;
import com.kosta.j0412.model.UserInfoDao;
import com.kosta.j0412.view.JoinForm;
import com.kosta.j0412.view.LoginForm;
import com.kosta.j0412.view.ServiceForm;
import com.kosta.j0412.view.UpdateForm;

public class Controller implements ActionListener {
	
	ServiceForm service;
	LoginForm login;
	JoinForm join;
	UpdateForm up;
	
	UserInfoDao dao;
	
	boolean idCheck, listClicked;
	int rowNum;
	String selectedRow;
	
	public Controller() {
		
		service = new ServiceForm();
		login = new LoginForm();
		join = new JoinForm();
		up = new UpdateForm();
		
		dao = new UserInfoDao();
		
		eventUp();
		windowClose();
		mouseEvents();
		
		//service.displayTable(dao.selectAll());
		
	}
	
	
	public void mouseEvents(){
		
		service.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				rowNum = service.table.getSelectedRow();
				selectedRow = (String) service.table.getValueAt(rowNum, 0);
				System.out.println(selectedRow);
				
				listClicked = true;
			}
		});
		
	}
	
	public void windowClose(){
		
		join.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				join.setVisible(false);
				login.setVisible(true);
			}
		});
		
		up.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				up.setVisible(false);
				service.setVisible(true);
				
			}
		});
		
	}
	
	public void eventUp(){
		

		login.bt_signup.addActionListener(this);
		login.bt_signin.addActionListener(this);
		login.tf_pass.addActionListener(this);
		
		join.bt_dup.addActionListener(this);
		join.bt_submit.addActionListener(this);
		
		service.selectAll.addActionListener(this);
		service.update.addActionListener(this);
		service.delete.addActionListener(this);
		service.search.addActionListener(this);
		
		up.bt_submit.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == login.bt_signin){///////�α���
			
			if(loginCheck()){///////�Է�����Ȯ��
				if(dao.select(login.tf_id.getText().trim(), login.tf_pass.getText().trim())){
					
					service.setVisible(true);
					login.setVisible(false);
					service.displayTable(dao.selectAll());
					
				} else {
					login.showMsg("���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
				}
			}
			
		} else if(ob == login.tf_pass){
			
			login.bt_signin.doClick();
			
		} else if(ob == login.bt_signup){///////�ű԰���
			
			login.setVisible(false);
			join.setVisible(true);
			
		} else if(ob == join.bt_dup){///////�ߺ�Ȯ��
			
			String id = join.tf_id.getText().trim();
			if(!id.isEmpty()){
				if(dao.selectId(id)){
					join.showMsg("���̵� �����մϴ�.");
				} else {
					join.showMsg("��� ������ ���̵��Դϴ�.");
					idCheck = true;
				}
			} else {
				join.showMsg("���̵� �Է��ϼ���.");
			}
			
		} else if(ob == join.bt_submit){///////ȸ�����
			
			if(signUpFillCheck()){
				
				if(idCheck){
					String id = join.tf_id.getText().trim();
					String pass = join.tf_pass.getText().trim();
					String name = join.tf_name.getText().trim();
					int ssn1 = Integer.parseInt(join.tf_ssn1.getText().trim());
					int ssn2 = Integer.parseInt(join.tf_ssn2.getText().trim());
					String tel = join.tf_tel1.getText().trim() +"-"+join.tf_tel2.getText().trim()+"-"+join.tf_tel3.getText().trim();
					String add = join.tf_add.getText().trim();
					String job = join.combo_job.getSelectedItem().toString();
					
					dao.insert(new UserInfo(id,pass,name,ssn1,ssn2,tel,add,job));
					join.setVisible(false);
					login.setVisible(true);
					joinSetEmpty();
					login.showMsg("ȸ�������� �Ϸ�Ǿ����ϴ�.");
						
				} else {
					join.showMsg("�ߺ�Ȯ���� ���ּ���.");
				}
				
				
			} else {
				join.showMsg("��ĭ�� ��� ä���ּ���.");
			}
			
		} else if(ob == service.selectAll){///////����
			
			service.displayTable(dao.selectAll());
			
		} else if(ob == service.update){///////����
			
			if(listClicked){
				service.setVisible(false);
				up.setVisible(true);
				
				Vector<UserInfo> v = new Vector<>();
				v = dao.select4update(selectedRow);
				
				String tel = v.get(0).getTel();
				String tels[] = tel.split("-");
				
				up.tf_id.setText(v.get(0).getId());
				up.tf_name.setText(v.get(0).getName());
				up.tf_ssn1.setText(v.get(0).getSsn1()+"");
				up.tf_ssn2.setText(v.get(0).getSsn2()+"");
				up.tf_tel1.setText(tels[0]);
				up.tf_tel2.setText(tels[1]);
				up.tf_tel3.setText(tels[2]);
				up.tf_add.setText(v.get(0).getAddr());
				up.combo_job.setSelectedItem(v.get(0).getJob());
				
			} else {
				service.showMsg("������ �����͸� �����ϼ���.");
			}
			
		} else if(ob == up.bt_submit){
			
			if(updateFillCheck()){
				String pass = up.tf_pass.getText().trim();
				String name = up.tf_name.getText().trim();
				String tel = up.tf_tel1.getText().trim() +"-"+up.tf_tel2.getText().trim()+"-"+up.tf_tel3.getText().trim();
				String add = up.tf_add.getText().trim();
				String job = up.combo_job.getSelectedItem().toString();
				
				dao.update(new UserInfo(pass,tel,add,job));
				up.setVisible(false);
				service.setVisible(true);
				service.displayTable(dao.selectAll());
				
				up.tf_pass.setText("");
				up.tf_pass_check.setText("");
			}
			
		} else if(ob == service.delete){///////����
			
		} else if(ob == service.search){///////ã��
			
		} else {
			
		}
		
	}
	
	public void joinSetEmpty(){
		join.tf_id.setText("");
		join.tf_name.setText("");
		join.tf_pass.setText("");
		join.tf_pass_check.setText("");
		join.tf_ssn1.setText("");
		join.tf_ssn2.setText("");
		join.tf_tel1.setText("");
		join.tf_tel2.setText("");
		join.tf_tel3.setText("");
		join.tf_add.setText("");
	}
	
	
	public boolean loginCheck(){
		
		if(login.tf_id.getText().trim().isEmpty() || login.tf_pass.getText().trim().isEmpty()){
			login.showMsg("���̵� �Ǵ� ��й�ȣ�� �Է����ּ���.");
		} else {
			return true;
		}
		
		return false;
	}
	
	public boolean signUpFillCheck(){
		
		if(join.tf_id.getText().trim().isEmpty() || 
				join.tf_pass.getText().trim().isEmpty() || join.tf_pass_check.getText().trim().isEmpty() ||
				join.tf_name.getText().trim().isEmpty() || join.tf_ssn1.getText().trim().isEmpty() ||
				join.tf_ssn2.getText().trim().isEmpty() || join.tf_tel1.getText().trim().isEmpty() ||
				join.tf_tel2.getText().trim().isEmpty() || join.tf_tel2.getText().trim().isEmpty() ||
				join.tf_add.getText().trim().isEmpty()){
			
			return false;
		} else {
			if(join.tf_ssn1.getText().matches("[a-zA-Z��-�R]+") || join.tf_ssn2.getText().matches("[a-zA-Z��-�R]+") ||
					join.tf_tel1.getText().matches("[a-zA-Z��-�R]+") || join.tf_tel2.getText().matches("[a-zA-Z��-�R]+") ||
					join.tf_tel2.getText().matches("[a-zA-Z��-�R]+")){
				
				join.showMsg("�ֹι�ȣ �Ǵ� ��ȭ��ȣ�� ���ڸ� �Է� �����մϴ�.");
				
			} else if(join.tf_name.getText().matches("[0-9]+")){
				join.showMsg("�̸����� ���ڰ� ���Ե� �� �����ϴ�.");
				
			} else if(join.tf_tel1.getText().trim().length() < 2 || 
					join.tf_tel2.getText().trim().length() < 3 || 
					join.tf_tel3.getText().trim().length() < 4){
				
				join.showMsg("��ȭ��ȣ�� �߸��Ǿ����ϴ�.");
				
			} else if(!join.tf_pass.getText().trim().equals(join.tf_pass_check.getText().trim())){
				join.showMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				
			} else if(join.tf_ssn1.getText().trim().length() < 6 || join.tf_ssn2.getText().trim().length() < 7){
				join.showMsg("�ֹε�Ϲ�ȣ�� Ȯ�����ּ���.");
			} else{
				return true;
			}
		}
		
		return false;
	}
	
	public boolean updateFillCheck(){
		
		if(up.tf_pass.getText().trim().isEmpty() || up.tf_tel1.getText().trim().isEmpty() || 
				up.tf_tel2.getText().trim().isEmpty() || up.tf_tel3.getText().trim().isEmpty() || 
				up.tf_add.getText().trim().isEmpty()){
			return false;
		} else if(up.tf_tel1.getText().trim().length() < 2 || 
				up.tf_tel2.getText().trim().length() < 3 || 
				up.tf_tel3.getText().trim().length() < 4){
			
			up.showMsg("��ȭ��ȣ�� �߸��Ǿ����ϴ�.");
			
		} else if(!up.tf_pass.getText().trim().equals(up.tf_pass_check.getText().trim())){
			up.showMsg("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			
		} else {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		new Controller();
	}



}
