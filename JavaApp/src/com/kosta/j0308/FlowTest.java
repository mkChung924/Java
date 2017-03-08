package com.kosta.j0308;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowTest {
	//���α׷��� �ʿ��� ��ü(�����̳�, ������Ʈ) ����
	
	Frame f;
	Button btn1, btn2, btn3, btn4, btn5;
	MenuBar menubar;
	Menu edit;
	
	public FlowTest() {//������ : �ʱ�ȭ �޼ҵ�
		
		//����� ��ü�� ���� ��ü����
		f = new Frame("Flow Test");
		menubar = new MenuBar();
		edit = new Menu("����");
		btn1 = new Button("button1");
		btn2 = new Button("button2");
		btn3 = new Button("button3");
		btn4 = new Button("button4");
		btn5 = new Button("button5");

		
		//�Ӽ� ����(���̾ƿ�, ���̱�)
		f.setLayout(new FlowLayout());
		menubar.add(edit);
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);

		
		//������ 2��(������ ������ ����, ������ ���̱� ����)
		f.setSize(500, 200);
		f.setMenuBar(menubar);
		f.setVisible(true);
		
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
		});
		
	}
	
	public static void main(String[] args) {
		//������ ȣ��
		//FlowTest ft = new FlowTest();
		new FlowTest();
		
	
		
		
	}

}
