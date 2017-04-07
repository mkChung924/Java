package com.kosta.j0323;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	
	JTextArea ta;
	JScrollPane scroll_ta;
	JTextField tf;
	JButton bt;
	JPanel p;
	
	//소켓 입출력
	Socket s;
	BufferedReader in;
	OutputStream out;
	
	
	public ChatClient() {
		
		setTitle("채팅방");
		ta = new JTextArea();
		ta.setLineWrap(true);
		scroll_ta = new JScrollPane(ta);
		tf = new JTextField(15);
		p = new JPanel();
		bt = new JButton("변경");
		p.add(tf);
		p.add(bt);
		//속성설정
		
		add(scroll_ta,"Center");
		add(p,"South");
		
		//마무리
		setBounds(530,150,300,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		connectProcess(); //out 객체 먼저 생성
		sendNickName();
		new Thread(this).start();
		
		//Event
		
		tf.addActionListener(this);
		bt.addActionListener(this);
		
	
	}
	
	public void sendNickName(){
		try {
			String nickName = JOptionPane.showInputDialog(this, "대화명: ");
			out.write((nickName + "\n").getBytes()); //out이 생성된 후 닉네임 보내야함
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//sendNickName;
	
	//서버 연결 메스도
	public void connectProcess(){
		
		try {
			
			s = new Socket("192.168.0.104",8282); //서버연결 시도
			//System.out.println("확인");
			//소켓 입출력객체 생성
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			out = s.getOutputStream();
		
		} catch(IOException e){
			e.printStackTrace();
		}
	} //connectProcess
	
	
		@Override
	public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == tf){
				sendMsg();
			} else {
				try {
					String newName = JOptionPane.showInputDialog(this, "변결할 이름은?");
					out.write(("@"+ newName+"\n").getBytes());
					//System.out.println(out.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
	}
		
	public void sendMsg(){//TF입력값 ---> 서버에게 메시지를 보내기
		try{
			String msg = tf.getText().trim();
			if(msg == null || msg.isEmpty()) return;
			out.write( ("" + msg + "\n").getBytes() );
			tf.setText("");
		} catch(IOException e2){
			e2.printStackTrace();
		}
	}
		
	public void run(){ //이유? 언제 보낼지 모르는 서버의 메시지를 대기하기 위해서
		
		while(true){
			
			try{
				
				ta.append(in.readLine()+"\n"); //서버가 보낸 메시지를 얻어옴 --- TextArea에 출력
				ta.setCaretPosition(ta.getText().length());
				//scroll_ta.getVerticalScrollBar().setValue(scroll_ta.getVerticalScrollBar().getMaximum());
				
			} catch(IOException e3){
				e3.printStackTrace();
			}
		}
	}
		
	public static void main(String[] args) {
		new ChatClient();
	}



}
