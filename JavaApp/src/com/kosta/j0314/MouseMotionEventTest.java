package com.kosta.j0314;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionEventTest extends JFrame implements MouseMotionListener{
	//MouseMotion: ���콺�����ӿ� ���� �̺�Ʈ ---> move, drag
	
	JLabel green, red;
	
	
	public MouseMotionEventTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���콺��� �׽�Ʈ");
		
		green = new JLabel("MOVE");
		green.setBackground(Color.green);
		green.setOpaque(true);
		red = new JLabel("DRAG");
		red.setBackground(Color.RED);
		red.setOpaque(true);
		
		setLayout(null);
		
		green.setBounds(30,30,50,50);
		red.setBounds(30,90,50,50);
		add(green);
		add(red);
		
		setBounds(400,100,600,600);
		setVisible(true);
		
		green.addMouseMotionListener(this);
		red.addMouseMotionListener(this);
		
		addMouseMotionListener(this);//������ �������� ���콺 ������!
		
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//���(event): ���콺 �巡��(Ŭ�����¿����� ������) �߻�
		//ó��: ���� ���콺�� ��ǥ�� �� red���� ��ǥ���� ����!
		int x = e.getX()-55;
		int y = e.getY()-75;
		red.setLocation(x,y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//ó��: ���� ���콺�� ��ǥ�� �� green���� ��ǥ���� ����!
		int x = e.getX()-55;
		int y = e.getY()-75;
		green.setLocation(x,y);
	}
	
	public static void main(String[] args) {
		new MouseMotionEventTest();
	}



}
