package com.kosta.j0314;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardTest extends Frame implements ActionListener{
	
	Button bt1, bt2, bt3;
	Panel yellowp, bluep, redp,
			p1,p2,p3;
	CardLayout card;
	
	public CardTest() {
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//객체생성
		bt1 = new Button("다음");
		bt2 = new Button("다음");
		bt3 = new Button("다음");
		yellowp = new Panel();
		bluep = new Panel();
		redp = new Panel();
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		card = new CardLayout();
		
		//속성 설정
		setLayout(card);//같은 위치 정렬
		
		yellowp.setBackground(Color.YELLOW);
		bluep.setBackground(Color.BLUE);
		redp.setBackground(Color.RED);
		
		p1.setLayout(new BorderLayout(0, 10));
		p1.add(yellowp, "Center");
		p1.add(bt1, "South");
		
		p2.setLayout(new BorderLayout(0, 10));
		p2.add(bluep, "Center");
		p2.add(bt2, "South");
		
		p3.setLayout(new BorderLayout(0, 10));
		p3.add(redp, "Center");
		p3.add(bt3, "South");
		
		add("a1",p1);
		add("a2",p2);
		add("a3",p3);
		
		//마무리
		setTitle("카드레이아웃");
		setBounds(560,200,300,400);
		setVisible(true);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == bt1){
			card.show(this, "a2");
			
		} else if(ob == bt2){
			card.show(this, "a3");
			
		} else if(ob == bt3){
			card.show(this, "a1");
			
		}
				
	}
	
	public static void main(String[] args) {
		new CardTest();
	}



}
