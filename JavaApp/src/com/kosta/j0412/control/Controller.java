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
		
		if(ob == login.bt_signin){///////로그인
			
			if(loginCheck()){///////입력정보확인
				if(dao.select(login.tf_id.getText().trim(), login.tf_pass.getText().trim())){
					
					service.setVisible(true);
					login.setVisible(false);
					service.displayTable(dao.selectAll());
					
				} else {
					login.showMsg("아이디 또는 비밀번호를 확인해주세요.");
				}
			}
			
		} else if(ob == login.tf_pass){
			
			login.bt_signin.doClick();
			
		} else if(ob == login.bt_signup){///////신규가입
			
			login.setVisible(false);
			join.setVisible(true);
			
		} else if(ob == join.bt_dup){///////중복확인
			
			String id = join.tf_id.getText().trim();
			if(!id.isEmpty()){
				if(dao.selectId(id)){
					join.showMsg("아이디가 존재합니다.");
				} else {
					join.showMsg("사용 가능한 아이디입니다.");
					idCheck = true;
				}
			} else {
				join.showMsg("아이디를 입력하세요.");
			}
			
		} else if(ob == join.bt_submit){///////회원등록
			
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
					login.showMsg("회원가입이 완료되었습니다.");
						
				} else {
					join.showMsg("중복확인을 해주세요.");
				}
				
				
			} else {
				join.showMsg("빈칸을 모두 채워주세요.");
			}
			
		} else if(ob == service.selectAll){///////보기
			
			service.displayTable(dao.selectAll());
			
		} else if(ob == service.update){///////수정
			
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
				service.showMsg("수정할 데이터를 선택하세요.");
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
			
		} else if(ob == service.delete){///////삭제
			
		} else if(ob == service.search){///////찾기
			
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
			login.showMsg("아이디 또는 비밀번호를 입력해주세요.");
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
			if(join.tf_ssn1.getText().matches("[a-zA-Zㄱ-힣]+") || join.tf_ssn2.getText().matches("[a-zA-Zㄱ-힣]+") ||
					join.tf_tel1.getText().matches("[a-zA-Zㄱ-힣]+") || join.tf_tel2.getText().matches("[a-zA-Zㄱ-힣]+") ||
					join.tf_tel2.getText().matches("[a-zA-Zㄱ-힣]+")){
				
				join.showMsg("주민번호 또는 전화번호는 숫자만 입력 가능합니다.");
				
			} else if(join.tf_name.getText().matches("[0-9]+")){
				join.showMsg("이름에는 숫자가 포함될 수 없습니다.");
				
			} else if(join.tf_tel1.getText().trim().length() < 2 || 
					join.tf_tel2.getText().trim().length() < 3 || 
					join.tf_tel3.getText().trim().length() < 4){
				
				join.showMsg("전화번호가 잘못되었습니다.");
				
			} else if(!join.tf_pass.getText().trim().equals(join.tf_pass_check.getText().trim())){
				join.showMsg("비밀번호가 일치하지 않습니다.");
				
			} else if(join.tf_ssn1.getText().trim().length() < 6 || join.tf_ssn2.getText().trim().length() < 7){
				join.showMsg("주민등록번호를 확인해주세요.");
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
			
			up.showMsg("전화번호가 잘못되었습니다.");
			
		} else if(!up.tf_pass.getText().trim().equals(up.tf_pass_check.getText().trim())){
			up.showMsg("비밀번호가 일치하지 않습니다.");
			
		} else {
			return true;
		}
		
		return false;
		
	}
	
	public static void main(String[] args) {
		new Controller();
	}



}
