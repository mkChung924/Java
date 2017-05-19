package com.baseballgame.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JoinForm extends JFrame{
	
	//객체생성
	public JLabel la_id, la_pass, la_pass_check, la_name, la_ssn, la_tel, la_add, la_job, la_dash1,la_dash2,la_dash3;
	public JComboBox combo_job;
	public JTextField tf_id, tf_name, tf_ssn1, tf_ssn2, tf_tel1, tf_tel2, tf_tel3, tf_add;
	public JPasswordField tf_pass, tf_pass_check;
	public JButton bt_dup, bt_submit;
	
	public JoinForm() {
	
	//속성 설정
	la_id = new JLabel("<html><font size = 5>ID</font><html>", JLabel.CENTER);
	la_pass = new JLabel("<html><font size = 5>비 번</font><html>", JLabel.CENTER);
	la_pass_check = new JLabel("<html><font size = 5>비번확인</font><html>", JLabel.CENTER);
	la_name = new JLabel("<html><font size = 5>이름</font><html>", JLabel.CENTER); 
	la_ssn = new JLabel("<html><font size = 5>주민번호</font><html>", JLabel.CENTER); 
	la_tel = new JLabel("<html><font size = 5>전화번호</font><html>", JLabel.CENTER); 
	la_add = new JLabel("<html><font size = 5>주소</font><html>", JLabel.CENTER); 
	la_job = new JLabel("<html><font size = 5>직업</font><html>", JLabel.CENTER);
	la_dash1 = new JLabel("-");
	la_dash2 = new JLabel("-");
	la_dash3 = new JLabel("-");
	
	String jobs[] = {"학생", "개발자", "직장인", "공무원"};
	combo_job = new JComboBox<String>(jobs);
		
	tf_id = new JTextField(20);
	tf_pass = new JPasswordField(20);
	tf_pass_check = new JPasswordField(20);
	tf_name = new JTextField(10);
	tf_ssn1 = new JTextField(6);
	tf_ssn2 = new JTextField(7);
	tf_tel1 = new JTextField(4);
	tf_tel2 = new JTextField(4);
	tf_tel3 = new JTextField(4);
	tf_add = new JTextField(50);
	
	bt_dup = new JButton("중복확인");
	bt_submit = new JButton("등록");
	
	setLayout(null);
	setTitle("회원가입");
	
	la_id.setBounds(20,30,80, 15);
	la_pass.setBounds(20, 80, 80,15);
	la_pass_check.setBounds(20,130,80, 15);
	la_name.setBounds(20,180,80, 15);
	la_ssn.setBounds(20,230,80, 15);
	la_tel.setBounds(20,280,80, 15);
	la_add.setBounds(20,330,80, 15);
	la_job.setBounds(20,380,80, 15);
	
	tf_id.setBounds(120,30,100,20);
	tf_pass.setBounds(120,80,100,20);
	tf_pass_check.setBounds(120,130,100,20);
	tf_name.setBounds(120,180,100,20);
	tf_ssn1.setBounds(120,230,100,20);
	la_dash1.setBounds(220, 230, 20, 20);
	tf_ssn2.setBounds(230,230,100,20);
	tf_tel1.setBounds(120,280,60,20);
	la_dash2.setBounds(180, 280, 20, 20);
	tf_tel2.setBounds(190,280,60,20);
	la_dash3.setBounds(250, 280, 20, 20);
	tf_tel3.setBounds(260,280,60,20);
	tf_add.setBounds(120,330,210,20);
	
	combo_job.setBounds(120, 375, 100, 30);
	
	bt_dup.setBounds(230, 30, 100, 20);
	bt_submit.setBounds(145, 435, 100, 20);
	
	add(la_id);
	add(la_pass);
	add(la_pass_check);
	add(la_name);
	add(la_ssn);
	add(la_tel);
	add(la_add);
	add(la_job);
	
	add(tf_id);
	add(tf_pass);
	add(tf_pass_check);
	add(tf_name);
	add(tf_ssn1);
	add(la_dash1);
	add(tf_ssn2);
	add(tf_tel1);
	add(la_dash2);
	add(tf_tel2);
	add(la_dash3);
	add(tf_tel3);
	add(tf_add);
	
	add(combo_job);
	
	add(bt_dup);
	add(bt_submit);
	
	
	//마무리
	//setVisible(true);
	setBounds(500,200,380,500);
	}
	
	public void showMsg(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}
	
}
