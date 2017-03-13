package com.kosta.j0310;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * <�̺�Ʈ ó��> : ������Ʈ�� ��� �ο�
 * 1. �̺�Ʈ �ҽ� ����
 * 		- �����ٸ� �������� ��
 */

public class ColorTest extends Frame implements AdjustmentListener{
	
	Panel left, redP, blueP, greenP;
	Label red,blue,green;
	Scrollbar sb1,sb2,sb3;
	TextArea ta1;
	
	public ColorTest() {
		
		setTitle("���ٲٱ�");
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		//��ü����
		left = new Panel();
		redP = new Panel();
		blueP = new Panel();
		greenP = new Panel();		
		red = new Label(" ���� ");
		blue = new Label(" �Ķ� ");
		green = new Label(" �ʷ� ");
		sb1 = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,275);
		sb2 = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,275);
		sb3 = new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,275);
		ta1 = new TextArea("(red = 0, green = 0, blue = 0)");
		//�Ӽ� ����
		
		setLayout(new GridLayout(1,2));
		left.setLayout(new GridLayout(5, 1,0,30));
		left.setBackground(Color.ORANGE);
		redP.setLayout(new BorderLayout());
		blueP.setLayout(new BorderLayout());
		greenP.setLayout(new BorderLayout());
		
		redP.add(red,"West");
		redP.add(sb1,"Center");
		blueP.add(blue,"West");
		blueP.add(sb2,"Center");
		greenP.add(green,"West");
		greenP.add(sb3,"Center");
		
		left.add(new Label());
		left.add(redP);
		left.add(blueP);
		left.add(greenP);
		
		ta1.setForeground(Color.WHITE);
		ta1.setBackground(new Color(0,0,0));
		
		add(left);
		add(ta1);
		
	
		//������2��
		setLocation(450,200);
		setSize(600,300);
		setVisible(true);
		
		sb1.addAdjustmentListener(this);
		sb2.addAdjustmentListener(this);
		sb3.addAdjustmentListener(this);
	}
	
	int r = 0;
	int b = 0;
	int g = 0;
	
		@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
			
			ta1.setForeground(Color.BLACK);
			
			int red = sb1.getValue();
			int blue = sb2.getValue();
			int green = sb3.getValue();
			
			ta1.setBackground(new Color(red,green,blue));
			ta1.setText("(red = "+red+", green = "+green+", blue = "+blue+")");
			//ta1.append("(red = "+red+", green = "+green+", blue = "+blue+")\n");
			
			
			
			if(green < 200){
				ta1.setForeground(Color.WHITE);
			}
	}
		
	public static void main(String[] args) {
		new ColorTest();
	}



}
