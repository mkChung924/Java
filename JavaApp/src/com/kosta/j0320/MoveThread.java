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
	JButton bt_start, bt_stop, bt_restart;
	Thread t;
	int x,y;
	boolean running = true;
	
	public MoveThread() {
		
		setTitle("¿òÁ×ÀÌ´Â È­»ìÇ¥");
		ImageIcon icon = new ImageIcon("image/right.gif");
		la = new JLabel(icon);
		la.setBounds(0, 0, 55, 55);
		bt_start = new JButton("¿òÁ÷¿©");
		bt_start.setBounds(5,520,100,50);
		bt_stop = new JButton("¸ØÃç");
		bt_stop.setBounds(110,520,100,50);
		bt_restart = new JButton("ÃÊ±âÈ­");
		bt_restart.setBounds(220,520,100,50);
		
		setLayout(null);
		add(la);
		add(bt_start);
		add(bt_stop);
		add(bt_restart);
		setBounds(300,200,600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		bt_start.addActionListener(this);
		bt_stop.addActionListener(this);
		bt_restart.addActionListener(this);
	
	}
	
	public static void main(String[] args) {
		new MoveThread();
	}

	@Override
	public void run() {
		
		try {
			while(running){
				
					Thread.sleep(20);
					if(x < 545){
						x+=5;
					} else {
						if(y < 520){
						y += 5;
						}
					}
						
					la.setLocation(x, y);
					if(x >= 545 && y >= 520){
						running = false;
					}
			}
			Thread.currentThread().interrupt();
			return;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		} finally {
			la.setLocation(0, 0);
		}
		
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		

		Object ob = e.getSource();
		if(ob == bt_start){
			running = true;
			
			if(t == null || t.getState() == State.TERMINATED){
				System.out.println(t.getState());
			t = new Thread(this);
			System.out.println(t.getState());
			
			t.start();
			
			System.out.println(t.getState());
			}
		} else if(ob == bt_stop){
			t.stop();
			x = 0;
			y = 0;
			la.setBounds(x,y,55,55);
			System.out.println(t.getState());
		} else {
			
		}
	}
	
}
