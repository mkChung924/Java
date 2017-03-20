package com.kosta.j0320;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.State;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoveThread extends JFrame implements ActionListener, Runnable {

	JLabel la;
	JButton bt_start, bt_stop;
	Thread t;
	int x,y;
	boolean running;
	
	public MoveThread() {
		
		setTitle("¿òÁ×ÀÌ´Â È­»ìÇ¥");
		ImageIcon icon = new ImageIcon("image/right.gif");
		la = new JLabel(icon);
		la.setBounds(0, 0, 55, 55);
		bt_start = new JButton("¿òÁ÷¿©");
		bt_start.setBounds(5,520,100,50);
		bt_stop = new JButton("¸ØÃç");
		bt_stop.setBounds(110,520,100,50);
		
		setLayout(null);
		add(la);
		add(bt_start);
		add(bt_stop);
		setBounds(300,200,600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_start.addActionListener(this);
		bt_stop.addActionListener(this);
	
	}
	
	public static void main(String[] args) {
		new MoveThread();
	}

	@Override
	public void run() {
		
		try {
			while(true){
				
					Thread.sleep(20);
					if(x < 545){
						x+=5;
					} else {
						if(y < 520){
						y += 5;
						}
					}
						
					la.setLocation(x, y);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		Object ob = e.getSource();
		if(ob == bt_start){
			if(t == null || t.getState() == State.TERMINATED){
			t = new Thread(this);
			System.out.println(t.getState());
			
			t.start();
			System.out.println(t.getState());
			}
		} else {
			t.stop();
			System.out.println(t.getState());
		}
	}
	
}
