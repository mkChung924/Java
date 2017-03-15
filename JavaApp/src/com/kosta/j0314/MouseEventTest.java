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
		setTitle("���콺�̺�Ʈ");
		//��ü����
		bt1= new JButton("����ư");
		
		//�Ӽ�����
		setLayout(new FlowLayout());
		
		add(bt1);
		
		//������
		setBounds(550,200,300,300);
		setVisible(true);
		
		bt1.addMouseListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���콺 Ŭ����");
		JOptionPane.showMessageDialog(this, "��ư������?");	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���콺 ������");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���콺 ������");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���콺 �ö�");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("���콺 ����");
	}
	
	public static void main(String[] args) {
		new MouseEventTest();
	}



}
