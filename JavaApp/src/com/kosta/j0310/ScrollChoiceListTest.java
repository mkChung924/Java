package com.kosta.j0310;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Collections;

/*
 * 라벨
 * 스크롤바
 * 초이스
 * 리스트
 * 
 * Scrollbar(int orientation, int value, int visible, int minimum, int maximum)
 * 		orienation : 수평 또는 수직 (지향방향)
 * 		value : 조절바의 위치, visible : 조절바의 너비(가로길이)
 * 		minimum : 최소 좌표값, maximum : 최대 좌표값
 * 
 * List(int rows, boolean MultipleMode)
 * 		rows : 아이템이 보일 크기
 * 		MultipleMode : 다중선택 가능 여부
 */


public class ScrollChoiceListTest extends Frame {
	
	Panel topP,middleP,bottomP;
	Panel smallP;
	Label la;
	Scrollbar sb;
	Choice choice;
	List list;
	
	public ScrollChoiceListTest() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//객체 생성
		topP = new Panel();
		middleP = new Panel();
		bottomP = new Panel();
		smallP = new Panel();
		la = new Label(" 빨강 ");
		sb = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,300); //Scrollbar.HORIZONTAL : 0 , VERTICAL : 1
		choice = new Choice();
		list = new List(); //기본값 4개 보이는 크기 + 하나 선택 가능
		//list = new List(4, true); //4개 보이는 크기 + 다중선택 가능

		
		//속성 설정
		
		setLayout(new GridLayout(3,1));
		topP.setLayout(new GridLayout(3, 1,0,30));
		topP.setBackground(Color.ORANGE);
		
		middleP.setLayout(new FlowLayout());
		middleP.setBackground(Color.GREEN);
		
		bottomP.setLayout(new FlowLayout());
		bottomP.setBackground(Color.PINK);
		
		smallP.setLayout(new BorderLayout());//방위정렬
		smallP.add(la, "West");
		smallP.add(sb,"Center");

		//choice.setBackground(Color.GREEN); //Panel의 배경색상에 동기화됨.
		choice.add("서울");
		choice.add("경기");
		choice.add("인천");
		choice.add("부산");
		choice.add("광주");
		choice.add("제주도");
		
		list.add("야구");
		list.add("축구");
		list.add("농구");
		list.add("배구");
		list.add("당구");
		list.add("골프");
		list.add("테니스");
		list.add("하키");
		list.add("럭비");
		list.add("소프트볼");
		
		//각 panel add
		topP.add(new Label());
		topP.add(smallP);
		middleP.add(choice);
		bottomP.add(list);
		
		//frame add
		add(topP);
		add(middleP);
		add(bottomP);
		
		//마무리2개(사이즈, 보이기)
		setTitle("비주얼컴포넌트테스트");
		setLocation(550,100);
		setSize(300,550);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ScrollChoiceListTest();
	}

}
