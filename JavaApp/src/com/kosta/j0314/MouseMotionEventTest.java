package com.kosta.j0314;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseMotionEventTest extends JFrame implements MouseMotionListener{
	//MouseMotion: 마우스움직임에 대한 이벤트 ---> move, drag
	
	JLabel green, red;
	
	
	public MouseMotionEventTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스모션 테스트");
		
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
		
		addMouseMotionListener(this);//프레임 위에서의 마우스 움직임!
		
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//사건(event): 마우스 드래그(클릭상태에서의 움직임) 발생
		//처리: 현재 마우스의 좌표를 얻어서 red에게 좌표값을 전달!
		int x = e.getX()-55;
		int y = e.getY()-75;
		red.setLocation(x,y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//처리: 현재 마우스의 좌표를 얻어서 green에게 좌표값을 전달!
		int x = e.getX()-55;
		int y = e.getY()-75;
		green.setLocation(x,y);
	}
	
	public static void main(String[] args) {
		new MouseMotionEventTest();
	}



}
