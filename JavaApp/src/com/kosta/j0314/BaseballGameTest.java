package com.kosta.j0314;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
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

public class BaseballGameTest extends JFrame implements ActionListener{
	
	JPanel panel;
	JTextArea ta1;
	JButton bt_new, bt_ans, bt_del, bt_end, bt_help;
	JLabel input;
	JTextField tf1;
	JScrollPane scroll_ta;
	JMenuBar menuBar;
	JMenu file, help;
	JMenuItem esc, guide, restart, about;
	
	Vector<Integer> v;
	Random r;
	int count;
	
	public BaseballGameTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자야구게임");
		
		//객체생성
		v = new Vector<>(3);
		panel = new JPanel();
		ta1 = new JTextArea("게임이 시작되었습니다.\n중복되지않는 세자리의 숫자를 입력하세요!\n예)123, 485, ...\n\n");
		input = new JLabel("<html><font size = 5>입력</font></html>");
		tf1 = new JTextField();
		bt_new = new JButton("<html><font size = 5>새게임</font></html>");
		bt_ans = new JButton("<html><font size = 5>정답</font></html>");
		bt_del = new JButton("<html><font size = 5>지우기</font></html>");
		bt_end = new JButton("<html><font size = 5>종료</font></html>");
		bt_help = new JButton("<html><font size = 4>가이드</font></html>");
		scroll_ta = new JScrollPane(ta1);
		menuBar = new JMenuBar();
		file = new JMenu("파일");
		help = new JMenu("Help");
		esc = new JMenuItem("게임 종료");
		guide = new JMenuItem("도움말");
		restart = new JMenuItem("게임 재시작");
		about = new JMenuItem("About");
		
		//속성설정
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		scroll_ta.setBounds(10,10,300,300);
		//ta1.setBounds(5,5,300,400);
		ta1.setEditable(false);
		input.setBounds(175, 325, 40, 30);
		tf1.setBounds(213, 320, 100, 40);
		bt_new.setBounds(325, 50, 110, 40);
		bt_ans.setBounds(325, 110, 110, 40);
		bt_del.setBounds(325, 170, 110, 40);
		bt_end.setBounds(325, 230, 110, 40);
		bt_help.setBounds(345, 320, 90, 35);
		file.add(restart);
		file.add(esc);
		help.add(about);
		help.add(guide);
		menuBar.add(file);
		menuBar.add(help);
		
		panel.setBounds(0,0,450,370);
		panel.add(scroll_ta);
		panel.add(input);
		panel.add(tf1);
		panel.add(bt_new);
		panel.add(bt_ans);
		panel.add(bt_del);
		panel.add(bt_end);
		panel.add(bt_help);
		
		add(panel);
		
		//마무리
		setJMenuBar(menuBar);
		setBounds(450,150,450,410);
		setVisible(true);
		
		
		bt_new.addActionListener(this);
		bt_ans.addActionListener(this);
		bt_del.addActionListener(this);
		bt_end.addActionListener(this);
		bt_help.addActionListener(this);
		tf1.addActionListener(this);
		esc.addActionListener(this);
		guide.addActionListener(this);
		restart.addActionListener(this);
		about.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		
		if(ob == tf1){
			
			Gaming();
	
		} else if(ob == bt_ans){
			ta1.append("포기하시는군요!\n정답은 ["+v.get(0) + " " + v.get(1) + " " + v.get(2)+"] 입니다.\n");
		} else if(ob == bt_del){
			tf1.setText("");
			ta1.setText("");
			
		} else if(ob == bt_new){
//			new BaseballGameTest();
			ta1.setText("새로운 게임을 시작합니다.\n");
			Generate();
			//ta1.append(v.get(0) + "" + v.get(1) + "" + v.get(2)+"\n");
			
		} else if(ob == bt_help){
			JOptionPane.showMessageDialog(this, "야구 게임!\n컴퓨터는 임의의 중복되지 않는 숫자 세 자리를 생성합니다."
					+ "\n사용자는 그 숫자를 맞추는 게임입니다."
					+"\n\n - 중복되지 않는 숫자 세자리를 입력한다."
					+"\n - 입력된 숫자와 자릿수까지 맞으면 스트~라이크!"
					+"\n - 숫자는 맞지만 자리가 다르면 볼~~"
					+ "\n - 다 틀리면 0S 0B..."
					+"\n\n화팅하삼!");
			
		} else if(ob == bt_end){
			System.exit(0);
			
		} else if(ob == esc){
			System.exit(0);
			
		} else if(ob == guide){
			JOptionPane.showMessageDialog(this, "야구 게임!\n컴퓨터는 임의의 중복되지 않는 숫자 세 자리를 생성합니다."
					+ "\n사용자는 그 숫자를 맞추는 게임입니다."
					+"\n\n - 중복되지 않는 숫자 세자리를 입력한다."
					+"\n - 입력된 숫자와 자릿수까지 맞으면 스트~라이크!"
					+"\n - 숫자는 맞지만 자리가 다르면 볼~~"
					+ "\n - 다 틀리면 0S 0B..."
					+"\n\n화팅하삼!");
		} else if(ob == about){
		
		    JOptionPane pane = new JOptionPane();
		    pane.setMessage("이름: 숫자야구게임\n버전: 1.0.0\n제작자: Myung Kyu Chung\n제작날짜: 2017년 3월 15일");
		    JDialog d = pane.createDialog(this, "About");
		    d.setVisible(true);
		} else {
			dispose();
			new BaseballGameTest();
		}
	}
	
	public static void main(String[] args) {
		BaseballGameTest bg = new BaseballGameTest();
		
		bg.Generate();
		//bg.ta1.append(bg.v.get(0) + " " + bg.v.get(1) + " " + bg.v.get(2)+"\n");
	}

	public void Generate(){
		
		v.clear();
		r = new Random();
		int ball = 0;
		for(int i = 0; i < v.capacity(); i++){
			ball = r.nextInt(9);
			v.add(ball);
		}
		
		for(int i = 0; i < v.capacity(); i++){
			for(int j = 0; j < v.capacity(); j++){
				if(i == j){continue;}
				
				if(v.get(i) == v.get(j)){
					v.set(j, r.nextInt(9));
				}
			}
		}
		
	}//Generate
	
	public void Gaming(){
		String balls = tf1.getText().trim();
		Vector<Integer> v2 = new Vector<>(3);
		
		v2.clear();
		if(balls.matches("[a-zA-Zㄱ-힣]+")){
			ta1.append("숫자만 입력가능합니다.\n");
			
		} else {
			
//			int one = Integer.parseInt(balls.substring(0,1));
//			int two = Integer.parseInt(balls.substring(1,2));
//			int three = Integer.parseInt(balls.substring(2,3));
			
//			int one = balls.charAt(0)-48;
//			int two = balls.charAt(1)-48;
//			int three = balls.charAt(2)-48;
			
			int one = Character.getNumericValue(balls.charAt(0));
			int two = Character.getNumericValue(balls.charAt(1));
			int three = Character.getNumericValue(balls.charAt(2));
			
			if(one == two || one == three || two == three){
				ta1.append("중복된 숫자는 입력불가합니다.\n");
			} else {
				v2.add(one);
				v2.add(two);
				v2.add(three);
				
				int s = 0;
				int b = 0;
				
				for(int i = 0; i < v.capacity(); i++){
					for(int j = 0; j < v2.capacity(); j++){
						
						if(v.get(i) == v2.get(j)){
							if(i == j){
								s++;
							} else {
								b++;
							}
						}
					}
				}

			
				if(s == 3){
					
					ta1.append(count + 1 +":  "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)+ " ▶︎ " +" 정답!!\n" );
					ta1.append("\n> "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)+ " 축하합니다^^!\n");
					if(count <= 3){
						
						ta1.append("> 오!! "+(count+1)+ "번만에 맞추셨어요. 천재세요?\n");
					} else if(count >3 && count <=7){
						ta1.append("> "+(count+1)+"번만이라.. 잘하시네용~\n");
					} else if(count>7){
						ta1.append("> "+(count+1)+"번? 그저그래요..\n");
					} 
					count = 0;
					
				} else {
					ta1.append(count + 1 +":  "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)+ " ▶︎ " + s +"S " + b +"B\n" );
				}
				
			}
			count++;
			
		}
		
		tf1.setText("");
		
	}//Gaming


}
