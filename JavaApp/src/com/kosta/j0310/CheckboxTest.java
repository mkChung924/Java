package com.kosta.j0310;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckboxTest extends Frame{
	
	Panel northp, southp;
	Checkbox apple, strawberry;
	Checkbox male, female;
	TextArea ta1;
	Label gender;
	CheckboxGroup cg;
	
	public CheckboxTest() {
		
		//x버튼 눌러서 끄기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//객체 생성
		cg = new CheckboxGroup(); // radio button 활성화 시키기 위한 생성자
		northp = new Panel();
		southp = new Panel();
		ta1 = new TextArea("<2017년 3월 10일 첫 예제>\n");
		gender = new Label("성별");
		apple = new Checkbox("사과",true);
		strawberry = new Checkbox("딸기",false);
		male = new Checkbox("남자",cg,true);
		female = new Checkbox("여자",cg, false);
		
		
		//속성 설정
		//setLayout(new BorderLayout()); //Frame 기본값, 생략 가능
		//northp.setLayout(new FlowLayout());//Panel 기본값, 생략 가능
		//southp.setLayout(new FlowLayout());//Panel 기본값, 생략 가능
		northp.setBackground(Color.YELLOW);
		northp.add(apple);
		northp.add(strawberry);
		southp.setBackground(Color.ORANGE);
		southp.add(gender);
		southp.add(male);
		southp.add(female);
		add(northp,"North");
		add(ta1, "Center");
		add(southp,"South");
		
		//마무리2(사이즈, 보이기)
		
		setTitle("체크박스테스트");
		setSize(300,300);
		setLocation(500,250);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new CheckboxTest();
		
	}

}
