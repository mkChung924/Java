package com.kosta.j0314;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.border.BevelBorder;

public class BaseballGameTest extends JFrame implements ActionListener{
	
	boolean tf;
	String balls;
	JPanel panel;
	JTextArea ta1;
	JButton bt_new, bt_ans, bt_del, bt_end, bt_help, bt_clue;
	JLabel input, dev;
	JTextField tf1;
	JScrollPane scroll_ta;
	JMenuBar menuBar;
	JMenu file, help, window;
	JMenuItem esc, guide, restart, about, minimize;
	JOptionPane pane;
	
	Vector<Integer> v;
	Random r;
	int count;
	
	public BaseballGameTest() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("숫자야구게임");
		
		//객체생성
		pane = new JOptionPane();
		v = new Vector<>(3);
		panel = new JPanel();
		ta1 = new JTextArea();
		input = new JLabel("<html><font size = 5>입력</font></html>");
		dev = new JLabel("<html><font size = 3>made by M.K.Chung</font></html>");
		tf1 = new JTextField();
		bt_new = new JButton("<html><font size = 5>새게임</font></html>");
		bt_ans = new JButton("<html><font size = 5>정답</font></html>");
		bt_del = new JButton("<html><font size = 5>지우기</font></html>");
		bt_end = new JButton("<html><font size = 5>종료</font></html>");
		bt_help = new JButton("<html><font size = 4>도움말</font></html>");
		bt_clue = new JButton("<html><font size = 5>힌트</font></html>");
		scroll_ta = new JScrollPane(ta1);
		menuBar = new JMenuBar();
		file = new JMenu("파일");
		help = new JMenu("Help");
		window = new JMenu("윈도우");
		esc = new JMenuItem("게임 종료");
		guide = new JMenuItem("도움말");
		restart = new JMenuItem("게임 재시작");
		about = new JMenuItem("About");
		minimize = new JMenuItem("최소화");
		
		//속성설정
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBackground(Color.ORANGE);
		scroll_ta.setBounds(10,10,305,300);
		//ta1.setBounds(5,5,300,400);
		ta1.setEditable(false);
		ta1.setBorder(new BevelBorder(BevelBorder.LOWERED));
		ta1.setFont(new Font("Default",Font.BOLD,14));//(너비)범위를 벗어나는 text를 줄바꿈!
		ta1.setLineWrap(true);
		input.setBounds(170, 325, 40, 30);
		dev.setBounds(15,340,200,30);
		tf1.setBounds(210, 320, 100, 40);
		tf1.setFocusable(false);
		tf1.setEnabled(false);
		bt_new.setBounds(325, 20, 95, 40);
		bt_clue.setBounds(325,80,95,40);
		bt_ans.setBounds(325, 140, 95, 40);
		bt_del.setBounds(325, 200, 95, 40);
		bt_end.setBounds(325, 260, 95, 40);
		bt_help.setBounds(330, 325, 90, 35);
		bt_clue.setEnabled(false);
		bt_ans.setEnabled(false);
		bt_new.setToolTipText("게임을 초기화합니다.");
		bt_end.setToolTipText("게임을 종료합니다.");
		
		file.add(restart);
		file.add(esc);
		window.add(minimize);
		help.add(about);
		help.add(guide);
		menuBar.add(file);
		menuBar.add(window);
		menuBar.add(help);
		
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		panel.setBounds(0,0,430,370);
		panel.add(scroll_ta);
		panel.add(input);
		panel.add(dev);
		panel.add(tf1);
		panel.add(bt_new);
		panel.add(bt_clue);
		panel.add(bt_ans);
		panel.add(bt_del);
		panel.add(bt_end);
		panel.add(bt_help);
		panel.add(dev);
		
		add(panel);
		
		//마무리
		setJMenuBar(menuBar);
		setBounds(480,160,430,415);
		setVisible(true);
		//tf1.requestFocus();//초기에 tf에 커서 위치시키기
		
		//각종 메소드
		ruleDescription();
		eventUp();

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
			Object ob = e.getSource();
			
			if(ob == tf1){
				gaming();
				
			} else if(ob == bt_clue){
				clue();
				bt_clue.setEnabled(false);
				
			} else if(ob == bt_ans){
				
					if(count == 0){
						ta1.append(">한 번도 시도를 안하셨네요? ㅡ ㅡ\n>정답은 볼 수 없습니다.");
						ta1.append("\n\n새로운 게임을 시작하려면 새게임 버튼을 누르세요!\n\n");
						bt_ans.setEnabled(false);
						bt_clue.setEnabled(false);
						tf1.setEnabled(false);
						tf = false;
					} else {
						ta1.append(count+"번의 시도를 하셨군요..\n");
						ta1.append("정답은 ["+v.get(0) + " " + v.get(1) + " " + v.get(2)+"] 이였습니다.\n");
						ta1.append("\n새로운 게임을 시작하려면 새게임 버튼을 누르세요!\n\n");
						bt_ans.setEnabled(false);
						bt_clue.setEnabled(false);
						tf1.setEnabled(false);
						tf = false;
					}
				
				
			} else if(ob == bt_del){
				tf1.setText("");
				ta1.setText("");
				
			} else if(ob == bt_new){
				initGame();
				
			} else if(ob == bt_help){
				guideMessage();
				
			} else if(ob == bt_end){
				//System.exit(0);
				int exit = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
				if(exit == 0){
					System.exit(0);
				}
				
				
			} else if(ob == esc){
				int exit = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?");
				if(exit == 0){
					System.exit(0);
				}
				
			} else if(ob == guide){
				guideMessage();
				
			} else if(ob == about){
			
			    pane.setMessage("<숫자 야구 게임>\n버전: 1.2.4\n제작자: M.K.Chung\n제작날짜: 2017년 3월 15일\n연락처: wjdaudrb7@naver.com");
			    JDialog d = pane.createDialog(this, "About");
			    d.setVisible(true);
			} else if(ob == restart){
				dispose();
				new BaseballGameTest();
			} else {
				setExtendedState(JFrame.ICONIFIED);
			}
	}

	
	public static void main(String[] args) {
		new BaseballGameTest();

	}
	
	public void initGame(){
		ta1.setText("게임이 시작되었습니다.\n중복되지않는 세자리의 숫자를 입력하세요!\n예)123, 485, ...\n\n");
		generate();
		tf1.setEnabled(true);
		tf1.setFocusable(true);
		tf1.requestFocus();
		bt_ans.setEnabled(true);
		bt_clue.setEnabled(true);
		tf = true;
		count = 0;
	}
	
	private void eventUp(){
		
		bt_new.addActionListener(this);
		bt_ans.addActionListener(this);
		bt_del.addActionListener(this);
		bt_end.addActionListener(this);
		bt_help.addActionListener(this);
		bt_clue.addActionListener(this);
		tf1.addActionListener(this);
		esc.addActionListener(this);
		guide.addActionListener(this);
		restart.addActionListener(this);
		about.addActionListener(this);
		minimize.addActionListener(this);
		
		tf1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(tf == false){
					//JOptionPane.showMessageDialog(panel, "새게임 버튼을 누르세요!");
					showMsg("새게임 버튼을 눌러 게임을 시작하세요!");
					tf1.setFocusable(false);
					tf1.setEnabled(false);
				} 
			}
		});
	}
	
	public void showMsg(String msg){
		JOptionPane.showMessageDialog(this, msg);
	}
	
	public void ruleDescription(){
		ta1.setText("\t<숫자 야구 게임>\n\n 컴퓨터는 중복되지않는 숫자 세 자리를 생성합니다."
					+ "\n 사용자가 그 숫자를 맞추는 게임입니다."
					+"\n\n - 새게임 버튼을 누른다."
					+"\n - 중복되지 않는 숫자 세자리를 입력한다."
					+"\n - 입력된 숫자와 자릿수까지 맞으면 스트~라이크!"
					+"\n - 숫자는 맞지만 자리가 다르면 볼~~"
					+ "\n - 다 틀리면 0Strike 0Ball..."
					+"\n - 힌트는 힌트 버튼을 눌러 확인!"
					+"\n - 정말 모르겠다면.. 정답 버튼을..(누르지마)"
					+"\n\n 이제 새게임 버튼을 눌러 시작하세요! Good Luck!\n");
		
	}
	
	public void guideMessage(){
		JOptionPane.showMessageDialog(this, "숫자 야구 게임!\n컴퓨터는 임의의 중복되지 않는 숫자 세 자리를 생성합니다."
				+ "\n사용자가 그 숫자를 맞추는 게임입니다."
				+"\n\n - 새게임 버튼을 누른다."
				+"\n - 중복되지 않는 숫자 세자리를 입력한다."
				+"\n - 입력된 숫자와 자릿수까지 맞으면 스트~라이크!"
				+"\n - 숫자는 맞지만 자리가 다르면 볼~~"
				+ "\n - 다 틀리면 0Strike 0Ball..."
				+"\n - 힌트는 힌트 버튼을 눌러 확인!"
				+"\n - 정말 모르겠다면.. 정답 버튼을..(누르지마)"
				+"\n\n화팅하삼!");
	}

	public void generate(){
		//count = 0;
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
	
	public void gaming(){
		balls = tf1.getText().trim();
		Vector<Integer> v2 = new Vector<>(3);
		
		v2.clear();
		//balls.matches("[0-9]{3}")를 사용해도 무방
		if(balls.matches("[a-zA-Zㄱ-힣]+")){ //matches("[\\d]") = matches("[0-9]")
			
		    pane.setMessage("숫자만 입력 가능합니다.");
		    JDialog d = pane.createDialog(this, "문자 경고!");
		    d.setVisible(true);
			
		} else if(balls.length() > 3 || balls.length() < 3 && balls.length() > 0){
			pane.setMessage("세자리 숫자만 입력하세요.");
		    JDialog d = pane.createDialog(this, "경고!");
		    d.setVisible(true);
		    
		} else if(balls.length() == 0){
			pane.setMessage("값을 입력해 주세요.");
		    JDialog d = pane.createDialog(this, "빈칸 경고!");
		    d.setVisible(true);
		    
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
				pane.setMessage("중복된 값을 입력하였습니다.");
			    JDialog d = pane.createDialog(this, "중복값 경고!");
			    d.setVisible(true);
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
				count++;
				
				if(s == 3){
					
					ta1.append(count + ":  "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)+ " ▶︎ " +" 정답!!\n" );
					ta1.append("\n> "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)+ " 축하합니다^^!\n");
					
					if(count <= 3){
						ta1.append("> 오!! "+(count)+ "번만에 맞추셨어요. 천재세요?\n");
					} else if(count >3 && count <=7){
						ta1.append("> "+(count)+"번만이라.. 나쁘지않네용~\n");
					} else if(count>7){
						ta1.append("> "+(count)+"번? 그저그래요..\n");
					} 
					
					//count = 0;
//					Generate();
//					ta1.append("\n새로운 게임을 시작합니다.\n");
					tf = false;
					tf1.setFocusable(false);
					bt_ans.setEnabled(false);
					bt_clue.setEnabled(false);
					
				} else {
					ta1.append(count + ":  "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)
					+ " ▶︎ " +s+"Strike " + b +"Ball\n" );
				}
				
			}
		}
		
		tf1.setText("");
		scroll_ta.getVerticalScrollBar().setValue(scroll_ta.getVerticalScrollBar().getMaximum());
		
	}//Gaming
	
	public void clue(){
		int hints = v.get(r.nextInt(3));
		ta1.append(">힌트 숫자! ㅎㅎ [" + hints+"]\n");
		tf1.requestFocus();
		tf1.setEnabled(true);
	}
	
	
	public boolean validCheck(){
		
		if(balls.matches("[0-9]{3}")) return true;
		return false;
	}

	

}
