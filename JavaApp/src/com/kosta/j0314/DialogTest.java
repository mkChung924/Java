package com.kosta.j0314;

import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JOptionPane;

public class DialogTest {
	
	Frame f;
	
	public DialogTest() {
		// TODO Auto-generated constructor stub
		f = new Frame("다이얼로그테스트");
		
		f.setLayout(new FlowLayout());
		f.setSize(300,300);
		f.setLocation(500, 200);
		f.setVisible(true);
		
		String movieName = JOptionPane.showInputDialog(f, "좋아하는 영화?");
		JOptionPane.showMessageDialog(f,  movieName);
		
		int t = JOptionPane.showConfirmDialog(f,  "삭제?");
		System.out.println("T = " + t);
		
	}
	
	public static void main(String[] args) {
		new DialogTest();
		
	}

}
