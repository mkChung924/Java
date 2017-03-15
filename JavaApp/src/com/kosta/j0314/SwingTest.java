package com.kosta.j0314;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingTest extends JFrame implements ActionListener{
	JButton bt;
	
	/*
	 *  AWT : 내부적으로 C언어로 구성. ---> 운영체제에서 지원하는 컴포넌트를 얻어옴.
	 *  
	 *  Swing : 순수 자바언어로 구성. (운영체제에 상관없이 동일한 컴포넌트 지원) ---> javax.swing.*;
	 *  
	 *  -특징: awt와 지교하여 첫글자가 대문자 J로 시작.
	 *  	AWT				Swing
	 *  -----------------------------
	 *    Button			JButton
	 *    Frame				JFrame
	 *    Checkbox			JCheckbox (x), JCheckBox(o)
	 */
	
	public SwingTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//x버튼을 눌렀을 때 작동하게 하려면 밑의 코드를 사용하여 사용자에 맞게끔 사용한다.
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				System.exit(0);
//			}
//		});
		
		setTitle("스윙테스트");
		
		//객체생성
		bt = new JButton("<html><font size = 15 color=red face=>나버튼</font></html>");
		
		
		//속성설정
		setLayout(new FlowLayout());
		add(bt);
		
		
		//마무리
		setBounds(550,200,300,300);
		setVisible(true);
		
		bt.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "버튼눌렀니?");		
	}
	
	public static void main(String[] args) {
		new SwingTest();
	}



}
