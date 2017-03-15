package com.kosta.j0314;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MouseEventTest extends JFrame implements MouseListener{
	
	JButton bt1;
	
	public MouseEventTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스이벤트");
		//객체생성
		bt1= new JButton("나버튼");
		
		//속성설정
		setLayout(new FlowLayout());
		
		add(bt1);
		
		//마무리
		setBounds(550,200,300,300);
		setVisible(true);
		
		bt1.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스 클릭됨");
		JOptionPane.showMessageDialog(this, "버튼눌렀니?");	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스 눌려짐");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스 놓아짐");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스 올라감");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스 나감");
	}
	
	public static void main(String[] args) {
		new MouseEventTest();
	}



}
