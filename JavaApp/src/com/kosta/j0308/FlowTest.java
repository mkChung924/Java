package com.kosta.j0308;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowTest {
	//프로그램에 필요한 객체(컨테이너, 컴포넌트) 선언
	
	Frame f;
	Button btn1, btn2, btn3, btn4, btn5;
	MenuBar menubar;
	Menu edit;
	
	public FlowTest() {//생성자 : 초기화 메소드
		
		//선언된 객체에 대한 객체생성
		f = new Frame("Flow Test");
		menubar = new MenuBar();
		edit = new Menu("편집");
		btn1 = new Button("button1");
		btn2 = new Button("button2");
		btn3 = new Button("button3");
		btn4 = new Button("button4");
		btn5 = new Button("button5");

		
		//속성 설정(레이아웃, 붙이기)
		f.setLayout(new FlowLayout());
		menubar.add(edit);
		f.add(btn1);
		f.add(btn2);
		f.add(btn3);
		f.add(btn4);
		f.add(btn5);

		
		//마무리 2개(프레임 사이즈 설정, 프레임 보이기 설정)
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
		//생성자 호출
		//FlowTest ft = new FlowTest();
		new FlowTest();
		
	
		
		
	}

}
