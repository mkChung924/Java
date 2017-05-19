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
		
		if(ob == login.bt_signin){///////·Î±×ÀÎ
			
			if(loginCheck()){///////ÀÔ·ÂÁ¤º¸È®ÀÎ
				if(dao.select(login.tf_id.getText().trim(), login.tf_pass.getText().trim())){
					
					service.setVisible(true);
					login.setVisible(false);
					service.displayTable(dao.selectAll());
					
				} else {
					login.showMsg("¾ÆÀÌµð ¶Ç´Â ºñ¹Ð¹øÈ£¸¦ È®ÀÎÇØÁÖ¼¼¿ä.");
				}
			}
			
		} else if(ob == login.tf_pass){
			
			login.bt_signin.doClick();
			
		} else if(ob == login.bt_signup){///////½Å±Ô°¡ÀÔ
			
			login.setVisible(false);
			join.setVisible(true);
			
		} else if(ob == join.bt_dup){///////Áßº¹È®ÀÎ
			
			String id = join.tf_id.getText().trim();
			if(!id.isEmpty()){
				if(dao.selectId(id)){
					join.showMsg("¾ÆÀÌµð°¡ Á¸ÀçÇÕ´Ï´Ù.");
				} else {
					join.showMsg("»ç¿ë °¡´ÉÇÑ ¾ÆÀÌµðÀÔ´Ï´Ù.");
					idCheck = true;
				}
			} else {
				join.showMsg("¾ÆÀÌµð¸¦ ÀÔ·ÂÇÏ¼¼¿ä.");
			}
			
		} else if(ob == join.bt_submit){///////È¸¿øµî·Ï
			
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
					login.showMsg("È¸¿ø°¡ÀÔÀÌ ¿Ï·áµÇ¾ú½À´Ï´Ù.");
						
				} else {
					join.showMsg("Áßº¹È®ÀÎÀ» ÇØÁÖ¼¼¿ä.");
				}
				
				
			} else {
				join.showMsg("ºóÄ­À» ¸ðµÎ Ã¤¿öÁÖ¼¼¿ä.");
			}
			
		} else if(ob == service.selectAll){///////º¸±â
			
			service.displayTable(dao.selectAll());
			
		} else if(ob == service.update){///////¼öÁ¤
			
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
				service.showMsg("¼öÁ¤ÇÒ µ¥ÀÌÅÍ¸¦ ¼±ÅÃÇÏ¼¼¿ä.");
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
			
		} else if(ob == service.delete){///////»èÁ¦
			
		} else if(ob == service.search){///////Ã£±â
			
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
			login.showMsg("¾ÆÀÌµð ¶Ç´Â ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.");
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
			if(join.tf_ssn1.getText().matches("[a-zA-Z¤¡-ÆR]+") || join.tf_ssn2.getText().matches("[a-zA-Z¤¡-ÆR]+") ||
					join.tf_tel1.getText().matches("[a-zA-Z¤¡-ÆR]+") || join.tf_tel2.getText().matches("[a-zA-Z¤¡-ÆR]+") ||
					join.tf_tel2.getText().matches("[a-zA-Z¤¡-ÆR]+")){
				
				join.showMsg("ÁÖ¹Î¹øÈ£ ¶Ç´Â ÀüÈ­¹øÈ£´Â ¼ýÀÚ¸¸ ÀÔ·Â °¡´ÉÇÕ´Ï´Ù.");
				
			} else if(join.tf_name.getText().matches("[0-9]+")){
				join.showMsg("ÀÌ¸§¿¡´Â ¼ýÀÚ°¡ Æ÷ÇÔµÉ ¼ö ¾ø½À´Ï´Ù.");
				
			} else if(join.tf_tel1.getText().trim().length() < 2 || 
					join.tf_tel2.getText().trim().length() < 3 || 
					join.tf_tel3.getText().trim().length() < 4){
				
				join.showMsg("ÀüÈ­¹øÈ£°¡ Àß¸øµÇ¾ú½À´Ï´Ù.");
				
			} else if(!join.tf_pass.getText().trim().equals(join.tf_pass_check.getText().trim())){
				join.showMsg("ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
				
			} else if(join.tf_ssn1.getText().trim().length() < 6 || join.tf_ssn2.getText().trim().length() < 7){
				join.showMsg("ÁÖ¹Îµî·Ï¹øÈ£¸¦ È®ÀÎÇØÁÖ¼¼¿ä.");
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
			
			up.showMsg("ÀüÈ­¹øÈ£°¡ Àß¸øµÇ¾ú½À´Ï´Ù.");
			
		} else if(!up.tf_pass.getText().trim().equals(up.tf_pass_check.getText().trim())){
			up.showMsg("ºñ¹Ð¹øÈ£°¡ ÀÏÄ¡ÇÏÁö ¾Ê½À´Ï´Ù.");
			
		} else {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		new Controller();
	}



}
