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
		
		//x��ư ������ ����
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//��ü ����
		cg = new CheckboxGroup(); // radio button Ȱ��ȭ ��Ű�� ���� ������
		northp = new Panel();
		southp = new Panel();
		ta1 = new TextArea("<2017�� 3�� 10�� ù ����>\n");
		gender = new Label("����");
		apple = new Checkbox("���",true);
		strawberry = new Checkbox("����",false);
		male = new Checkbox("����",cg,true);
		female = new Checkbox("����",cg, false);
		
		
		//�Ӽ� ����
		//setLayout(new BorderLayout()); //Frame �⺻��, ���� ����
		//northp.setLayout(new FlowLayout());//Panel �⺻��, ���� ����
		//southp.setLayout(new FlowLayout());//Panel �⺻��, ���� ����
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
		
		//������2(������, ���̱�)
		
		setTitle("üũ�ڽ��׽�Ʈ");
		setSize(300,300);
		setLocation(500,250);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new CheckboxTest();
		
	}

}
