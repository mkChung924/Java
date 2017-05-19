package com.baseballgame.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;

import com.baseballgame.view.JoinForm;
import com.baseballgame.view.LoginForm;
import com.baseballgame.view.MainView;
import com.baseballgame.view.ScoreView;
import com.kosta.j0314.BaseballGameTest;

public class Controller implements ActionListener{

	MainView main;
	JoinForm joinView;
	LoginForm loginView;
	ScoreView scoreView;
	
	String balls;
	int count;
	Vector<Integer> v;
	
	Random r;
	
	public Controller() {
		
		main = new MainView();
		joinView = new JoinForm();
		loginView = new LoginForm();
		scoreView = new ScoreView();
		
		r = new Random();
		v = new Vector<>();
	}
	
	
	public void eventUp(){
		main.bt_new.addActionListener(this);
		main.bt_ans.addActionListener(this);
		main.bt_del.addActionListener(this);
		main.bt_end.addActionListener(this);
		main.bt_score.addActionListener(this);
		main.bt_clue.addActionListener(this);
		main.tf1.addActionListener(this);
		main.esc.addActionListener(this);
		main.guide.addActionListener(this);
		main.restart.addActionListener(this);
		main.about.addActionListener(this);
		main.minimize.addActionListener(this);
		
		main.tf1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				if(main.tf == false){
					//JOptionPane.showMessageDialog(panel, "새게임 버튼을 누르세요!");
					main.showMessage("새게임 버튼을 눌러 게임을 시작하세요!");
					main.tf1.setFocusable(false);
					main.tf1.setEnabled(false);
				} 
			}
		});
	}
	
		@Override
	public void actionPerformed(ActionEvent e) {
			
			Object ob = e.getSource();
			
			if(ob == main.tf1){
				gaming();
				
			} else if(ob == main.bt_clue){
				clue();
				main.bt_clue.setEnabled(false);
				
			} else if(ob == main.bt_ans){
				
					if(count == 0){
						main.ta1.append(">한 번도 시도를 안하셨네요? ㅡ ㅡ\n>정답은 볼 수 없습니다.");
						main.ta1.append("\n\n새로운 게임을 시작하려면 새게임 버튼을 누르세요!\n\n");
						main.bt_ans.setEnabled(false);
						main.bt_clue.setEnabled(false);
						main.tf1.setEnabled(false);
						main.tf = false;
					} else {
						main.ta1.append(count+"번의 시도를 하셨군요..\n");
						main.ta1.append("정답은 ["+v.get(0) + " " + v.get(1) + " " + v.get(2)+"] 이였습니다.\n");
						main.ta1.append("\n새로운 게임을 시작하려면 새게임 버튼을 누르세요!\n\n");
						main.bt_ans.setEnabled(false);
						main.bt_clue.setEnabled(false);
						main.tf1.setEnabled(false);
						main.tf = false;
					}
				
				
			} else if(ob == main.bt_del){
				main.tf1.setText("");
				main.ta1.setText("");
				
			} else if(ob == main.bt_new){
				initGame();
				
			} else if(ob == main.bt_score){
				
				
			} else if(ob == main.bt_end){
				//System.exit(0);
				
					System.exit(0);

			} else if(ob == main.esc){
				
					System.exit(0);
				
				
			} else if(ob == main.guide){
				guideMessage();
				
			} else if(ob == main.about){
			
			    main.showMessage("<숫자 야구 게임>\n버전: 1.2.4\n제작자: M.K.Chung\n제작날짜: 2017년 3월 15일\n연락처: wjdaudrb7@naver.com");
			    //JDialog d = pane.createDialog(this, "About");
			    //d.setVisible(true);
			    
			} else if(ob == main.restart){
				main.dispose();
				new BaseballGameTest();
			} else {
				main.setExtendedState(JFrame.ICONIFIED);
			}
		
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
		
		public void initGame(){
			main.ta1.setText("게임이 시작되었습니다.\n중복되지않는 세자리의 숫자를 입력하세요!\n예)123, 485, ...\n\n");
			generate();
			main.tf1.setEnabled(true);
			main.tf1.setFocusable(true);
			main.tf1.requestFocus();
			main.bt_ans.setEnabled(true);
			main.bt_clue.setEnabled(true);
			main.tf = true;
			count = 0;
		}
		
		public void gaming(){
			balls = main.tf1.getText().trim();
			Vector<Integer> v2 = new Vector<>(3);
			
			v2.clear();
			//balls.matches("[0-9]{3}")를 사용해도 무방
			if(balls.matches("[a-zA-Zㄱ-힣]+")){ //matches("[\\d]") = matches("[0-9]")
				
				main.showMessage("숫자만 입력 가능합니다.");
			    //JDialog d = pane.createDialog(this, "문자 경고!");
			    //d.setVisible(true);
				
			} else if(balls.length() > 3 || balls.length() < 3 && balls.length() > 0){
				main.showMessage("세자리 숫자만 입력하세요.");
			    //JDialog d = pane.createDialog(this, "경고!");
			    //d.setVisible(true);
			    
			} else if(balls.length() == 0){
				main.showMessage("값을 입력해 주세요.");
			    //JDialog d = main.showMessage(this, "빈칸 경고!");
			    //d.setVisible(true);
			    
			} else {
				
				int one = Character.getNumericValue(balls.charAt(0));
				int two = Character.getNumericValue(balls.charAt(1));
				int three = Character.getNumericValue(balls.charAt(2));
				
				if(one == two || one == three || two == three){
					main.showMessage("중복된 값을 입력하였습니다.");
				    //JDialog d = pane.createDialog(this, "중복값 경고!");
				    //d.setVisible(true);
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
						
						main.ta1.append(count + ":  "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)+ " ▶︎ " +" 정답!!\n" );
						main.ta1.append("\n> "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)+ " 축하합니다^^!\n");
						
						if(count <= 3){
							main.ta1.append("> 오!! "+(count)+ "번만에 맞추셨어요. 천재세요?\n");
						} else if(count >3 && count <=7){
							main.ta1.append("> "+(count)+"번만이라.. 나쁘지않네용~\n");
						} else if(count>7){
							main.ta1.append("> "+(count)+"번? 그저그래요..\n");
						} 
						
						//count = 0;
//						Generate();
//						ta1.append("\n새로운 게임을 시작합니다.\n");
						main.tf = false;
						main.tf1.setFocusable(false);
						main.bt_ans.setEnabled(false);
						main.bt_clue.setEnabled(false);
						
					} else {
						main.ta1.append(count + ":  "+v2.get(0)+" "+v2.get(1)+" "+v2.get(2)
						+ " ▶︎ " +s+"Strike " + b +"Ball\n" );
					}
					
				}
			}
			
			main.tf1.setText("");
			main.scroll_ta.getVerticalScrollBar().setValue(main.scroll_ta.getVerticalScrollBar().getMaximum());
			
		}//Gaming
		
		
		public void clue(){
			int hints = v.get(r.nextInt(3));
			main.ta1.append(">힌트 숫자! ㅎㅎ [" + hints+"]\n");
			main.requestFocus();
			main.setEnabled(true);
		}
		
		
		public boolean validCheck(){
			
			if(balls.matches("[0-9]{3}")) return true;
			return false;
		}
		
		public void guideMessage(){
			main.showMessage("숫자 야구 게임!\n컴퓨터는 임의의 중복되지 않는 숫자 세 자리를 생성합니다."
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

		
	public static void main(String[] args) {
		new Controller();
	}



}
