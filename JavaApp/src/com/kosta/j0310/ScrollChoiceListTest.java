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
 * ��
 * ��ũ�ѹ�
 * ���̽�
 * ����Ʈ
 * 
 * Scrollbar(int orientation, int value, int visible, int minimum, int maximum)
 * 		orienation : ���� �Ǵ� ���� (�������)
 * 		value : �������� ��ġ, visible : �������� �ʺ�(���α���)
 * 		minimum : �ּ� ��ǥ��, maximum : �ִ� ��ǥ��
 * 
 * List(int rows, boolean MultipleMode)
 * 		rows : �������� ���� ũ��
 * 		MultipleMode : ���߼��� ���� ����
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
		
		//��ü ����
		topP = new Panel();
		middleP = new Panel();
		bottomP = new Panel();
		smallP = new Panel();
		la = new Label(" ���� ");
		sb = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,300); //Scrollbar.HORIZONTAL : 0 , VERTICAL : 1
		choice = new Choice();
		list = new List(); //�⺻�� 4�� ���̴� ũ�� + �ϳ� ���� ����
		//list = new List(4, true); //4�� ���̴� ũ�� + ���߼��� ����

		
		//�Ӽ� ����
		
		setLayout(new GridLayout(3,1));
		topP.setLayout(new GridLayout(3, 1,0,30));
		topP.setBackground(Color.ORANGE);
		
		middleP.setLayout(new FlowLayout());
		middleP.setBackground(Color.GREEN);
		
		bottomP.setLayout(new FlowLayout());
		bottomP.setBackground(Color.PINK);
		
		smallP.setLayout(new BorderLayout());//��������
		smallP.add(la, "West");
		smallP.add(sb,"Center");

		//choice.setBackground(Color.GREEN); //Panel�� ������ ����ȭ��.
		choice.add("����");
		choice.add("���");
		choice.add("��õ");
		choice.add("�λ�");
		choice.add("����");
		choice.add("���ֵ�");
		
		list.add("�߱�");
		list.add("�౸");
		list.add("��");
		list.add("�豸");
		list.add("�籸");
		list.add("����");
		list.add("�״Ͻ�");
		list.add("��Ű");
		list.add("����");
		list.add("����Ʈ��");
		
		//�� panel add
		topP.add(new Label());
		topP.add(smallP);
		middleP.add(choice);
		bottomP.add(list);
		
		//frame add
		add(topP);
		add(middleP);
		add(bottomP);
		
		//������2��(������, ���̱�)
		setTitle("���־�������Ʈ�׽�Ʈ");
		setLocation(550,100);
		setSize(300,550);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ScrollChoiceListTest();
	}

}
