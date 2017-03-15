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
	 *  AWT : ���������� C���� ����. ---> �ü������ �����ϴ� ������Ʈ�� ����.
	 *  
	 *  Swing : ���� �ڹپ��� ����. (�ü���� ������� ������ ������Ʈ ����) ---> javax.swing.*;
	 *  
	 *  -Ư¡: awt�� �����Ͽ� ù���ڰ� �빮�� J�� ����.
	 *  	AWT				Swing
	 *  -----------------------------
	 *    Button			JButton
	 *    Frame				JFrame
	 *    Checkbox			JCheckbox (x), JCheckBox(o)
	 */
	
	public SwingTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//x��ư�� ������ �� �۵��ϰ� �Ϸ��� ���� �ڵ带 ����Ͽ� ����ڿ� �°Բ� ����Ѵ�.
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e){
//				System.exit(0);
//			}
//		});
		
		setTitle("�����׽�Ʈ");
		
		//��ü����
		bt = new JButton("<html><font size = 15 color=red face=>����ư</font></html>");
		
		
		//�Ӽ�����
		setLayout(new FlowLayout());
		add(bt);
		
		
		//������
		setBounds(550,200,300,300);
		setVisible(true);
		
		bt.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "��ư������?");		
	}
	
	public static void main(String[] args) {
		new SwingTest();
	}



}
