package com.kosta.j0308;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderTest {
	
	Frame f;
	Button bt1, bt2, bt3, bt4, bt5;
	MenuBar menubar;
	Menu edit;
	Menu file;
	Menu help;
	
	
	public BorderTest() {
		//��ü����
		f = new Frame("Border Test");
		menubar = new MenuBar();
		edit = new Menu("����");
		file = new Menu("����");
		help = new Menu("Help");
		bt1 = new Button("Button1");
		bt2 = new Button("Button2");
		bt3 = new Button("Button3");
		bt4 = new Button("Button4");
		bt5 = new Button("Button5");
		
		//�Ӽ�����(���̾ƿ�, ���̱�)
		f.setLayout(new BorderLayout());
		f.setLocation(450,300);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		f.add(bt1, "North");
		f.add(bt2, "East");
		f.add(bt3, "West");
		f.add(bt4, "South");
		f.add(bt5, "Center");
		
		//������ �޼ҵ� 2�� (������ ������, �����Ӻ��̱�)
		f.setSize(500,200);
		f.setVisible(true);
		f.setMenuBar(menubar);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
	}
	
	public static void main(String[] args) {
		new BorderTest();
	}

}
