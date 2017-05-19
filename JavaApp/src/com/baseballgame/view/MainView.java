package com.baseballgame.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MainView extends JFrame{
	
	public boolean tf;
	String balls;
	JPanel panel;
	public JTextArea ta1;
	public JButton bt_new, bt_ans, bt_del, bt_end, bt_score, bt_clue;
	JLabel input, dev;
	public JTextField tf1;
	public JScrollPane scroll_ta;
	public JMenuBar menuBar;
	public JMenu file, help, window;
	public JMenuItem esc, guide, restart, about, minimize;
	JOptionPane pane;
	
	Vector<Integer> v;
	Random r;
	
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���ھ߱�����");
		
		//��ü����
		pane = new JOptionPane();
		v = new Vector<>(3);
		panel = new JPanel();
		ta1 = new JTextArea();
		input = new JLabel("<html><font size = 5>�Է�</font></html>");
		dev = new JLabel("<html><font size = 3>made by M.K.Chung</font></html>");
		tf1 = new JTextField();
		bt_new = new JButton("<html><font size = 5>������</font></html>");
		bt_ans = new JButton("<html><font size = 5>����</font></html>");
		bt_del = new JButton("<html><font size = 5>�����</font></html>");
		bt_end = new JButton("<html><font size = 5>����</font></html>");
		bt_score = new JButton("<html><font size = 4>����Ȯ��</font></html>");
		bt_clue = new JButton("<html><font size = 5>��Ʈ</font></html>");
		scroll_ta = new JScrollPane(ta1);
		menuBar = new JMenuBar();
		file = new JMenu("����");
		help = new JMenu("Help");
		window = new JMenu("������");
		esc = new JMenuItem("���� ����");
		guide= new JMenuItem("����Ȯ��");
		restart = new JMenuItem("���� �����");
		about = new JMenuItem("About");
		minimize = new JMenuItem("�ּ�ȭ");
		
		//�Ӽ�����
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		scroll_ta.setBounds(10,10,305,300);
		//ta1.setBounds(5,5,300,400);
		ta1.setEditable(false);
		ta1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		ta1.setFont(new Font("Default",Font.BOLD,14));//(�ʺ�)������ ����� text�� �ٹٲ�!
		ta1.setLineWrap(true);
		input.setBounds(170, 325, 40, 30);
		dev.setBounds(15,340,200,30);
		tf1.setBounds(210, 320, 100, 40);
		tf1.setFocusable(false);
		tf1.setEnabled(false);
		bt_new.setBounds(325, 20, 95, 40);
		bt_clue.setBounds(325,80,95,40);
		bt_ans.setBounds(325, 140, 95, 40);
		bt_del.setBounds(325, 200, 95, 40);
		bt_end.setBounds(325, 260, 95, 40);
		bt_score.setBounds(325, 325, 100, 35);
		bt_clue.setEnabled(false);
		bt_ans.setEnabled(false);
		bt_new.setToolTipText("������ �ʱ�ȭ�մϴ�.");
		bt_end.setToolTipText("������ �����մϴ�.");
		
		file.add(restart);
		file.add(esc);
		window.add(minimize);
		help.add(about);
		help.add(guide);
		menuBar.add(file);
		menuBar.add(window);
		menuBar.add(help);
		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel.setBounds(0,0,430,370);
		panel.add(scroll_ta);
		panel.add(input);
		panel.add(dev);
		panel.add(tf1);
		panel.add(bt_new);
		panel.add(bt_clue);
		panel.add(bt_ans);
		panel.add(bt_del);
		panel.add(bt_end);
		panel.add(bt_score);
		panel.add(dev);
		
		add(panel);
		
		//������
		setJMenuBar(menuBar);
		setBounds(480,160,430,415);
		setVisible(true);
	}
	
	public void showMessage(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public static void main(String[] args) {
		new MainView();
	}

}
