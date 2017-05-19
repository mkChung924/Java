package com.kosta.j0412.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame{

	JLabel la_id, la_pass;
	public JTextField tf_id;
	public JPasswordField tf_pass;
	public JButton bt_signup, bt_signin;
	
	public LoginForm() {
		
		la_id = new JLabel("ID");
		la_pass = new JLabel("Password");
		
		tf_id = new JTextField(10);
		tf_pass = new JPasswordField();
		
		bt_signup = new JButton("신규가입");
		bt_signin = new JButton("로그인");
		
		setLayout(null);
		setTitle("Login Form");
		
		la_id.setBounds(10, 30, 50, 20);
		la_pass.setBounds(10, 80, 70, 20);
		
		tf_id.setBounds(80, 30, 100, 20);
		tf_pass.setBounds(80, 80, 100, 20);
		
		bt_signup.setBounds(200, 30, 50, 20);
		bt_signin.setBounds(110, 130, 50, 20);
		
		add(la_id);
		add(la_pass);
		add(tf_id);
		add(tf_pass);
		add(bt_signup);
		add(bt_signin);
		
		setVisible(true);
		setBounds(550,300,270,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void showMsg(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}
	
	
}
