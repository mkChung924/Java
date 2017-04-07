package com.kosta.j0324;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class MainChat extends JFrame implements ActionListener, Runnable {
	
	static final int NICK_NAME = 150;
	static final int NEW_NICK_NAME = 155;
	static final int ROOM_NAME = 160;
	static final int MY_MSG = 300;
	static final int EXIT_FROM_ROOM = 900;
	
   JList<String> roomInfo,roomInwon,waitInfo;
   JScrollPane sp_roomInfo, sp_roomInwon, sp_waitInfo;
   JButton bt_create, bt_enter, bt_exit;
   
   JPanel p;
   ChatClient cc;
   
   //소켓 입출력 객체
   BufferedReader in;
   OutputStream out;
   
   String nickName;
   
   String selectedRoom;
   String myRoom;

   String roomName;//방장이 정한 이름

   public MainChat() {	 
	 setTitle("대기실");
	 
	 cc = new ChatClient();
	 
	 roomInfo = new JList<String>();
	   roomInfo.setBorder(new TitledBorder("방정보"));
	 roomInwon = new JList<String>();
	   roomInwon.setBorder(new TitledBorder("인원정보"));
	 waitInfo = new JList<String>();
       waitInfo.setBorder(new TitledBorder("대기실정보"));
       
     sp_roomInfo = new JScrollPane(roomInfo);
     sp_roomInwon = new JScrollPane(roomInwon);
     sp_waitInfo = new JScrollPane(waitInfo);
     
     bt_create = new JButton("방만들기");
     bt_enter = new JButton("방들어가기");
     bt_exit = new JButton("나가기");     
     
     p = new JPanel();
     
     sp_roomInfo.setBounds(10, 10, 300, 300);
     sp_roomInwon.setBounds(320, 10, 150, 300);
     sp_waitInfo.setBounds(10, 320, 300, 130);
     
     bt_create.setBounds(320,330,150,30);
     bt_enter.setBounds(320,370,150,30);
     bt_exit.setBounds(320,410,150,30);
     
     p.setLayout(null);
      p.setBackground(Color.orange);
     p.add(sp_roomInfo);
     p.add(sp_roomInwon);
     p.add(sp_waitInfo);
     p.add(bt_create);
     p.add(bt_enter);
     p.add(bt_exit);
     
     add(p);
     setBounds(400,200, 480, 480);
     setVisible(true);
     setDefaultCloseOperation(EXIT_ON_CLOSE);   
     
     connect();
     new Thread(this).start();

     
     nickName = JOptionPane.showInputDialog(this, "닉네임: ");
     sendMsg(NICK_NAME +"|"+nickName);
     sendMsg("161" + "|");
     
     eventUp();
   }//생성자
   
   public void eventUp(){
	   //대기실(MainChat)
	   bt_create.addActionListener(this);
	   bt_enter.addActionListener(this);
	   bt_exit.addActionListener(this);
	   roomInfo.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e){
			   	String str = roomInfo.getSelectedValue();//"자바방--1"
			   	selectedRoom = str.substring(0, str.indexOf("-"));
			   	myRoom = selectedRoom;
			   	sendMsg("250|"+myRoom);
			   	//System.out.println(myRoom+"보냄");
		   }
	});
	   
	   //대화방(ChatClient)
	   cc.bt_change.addActionListener(this);
	   cc.bt_exit.addActionListener(this);
	   cc.sendTF.addActionListener(this);

   }
   
   	@Override
	public void actionPerformed(ActionEvent e) {
   		Object ob = e.getSource();
   		
   		if(ob == bt_create){ //방 만들기 요청
   			
   			roomName = JOptionPane.showInputDialog(this, "방 이름: ");
   			if(roomName != null){
	   				if(roomName.trim().length() != 0){
	   				//방이름을 서버에게 전달
		   			sendMsg(ROOM_NAME+"|"+roomName);
		   			
		   			this.setVisible(false);
		   			cc.setVisible(true);
   				}
   			} 
   			
   			
   		} else if(ob == bt_enter){
   			
   			if(selectedRoom == null){
   				JOptionPane.showMessageDialog(this, "방을 먼저 선택하세요.");
   				return;
   				
   			} else {
   			
	   			sendMsg("200|"+selectedRoom);
	   			
	   			this.setVisible(false);
	   			cc.setVisible(true);
	   			cc.sendTF.requestFocus();
   			
   			}
   		} else if(ob == cc.sendTF){
   			String msg = cc.sendTF.getText().trim();
   			sendMsg(MY_MSG+"|"+msg);
   			cc.sendTF.setText("");
   			
   		} else if(ob == cc.bt_exit){
   			
   			int exit = JOptionPane.showConfirmDialog(this, "나가시겠습니까?");
   			if(exit == 0){
   			
	   			if(myRoom == null){
	   				sendMsg(EXIT_FROM_ROOM+"|"+roomName);
	   	   			cc.setVisible(false);
	   	   			this.setVisible(true);
	   			} else {
	   			
		   			sendMsg(EXIT_FROM_ROOM+"|"+myRoom);
		   			cc.setVisible(false);
		   			this.setVisible(true);
	   			}
	   			
	   			cc.ta.setText("");
	   			
   			}
   			
   		} else if(ob == cc.bt_change){
   			String newName = JOptionPane.showInputDialog(this,"새 닉네임: ");
   			sendMsg(NEW_NICK_NAME + "|"+newName);
				
		} else if(ob == bt_exit){
			
   			int exit = JOptionPane.showConfirmDialog(this, "채팅을 종료하시겠습니까?");
   			if(exit == 0){
   				System.exit(0);
   				sendMsg("1000|"+nickName);
   			}
   			
   		} else {
   			
   		}
		
	}//actionPerformed
   	
   	public void connect(){//소켓 서버 연결 요청
   		
   		try {
			Socket s = new Socket("192.168.0.169", 8282);
			
			in = new BufferedReader(new InputStreamReader(s.getInputStream())); //in: 서버메시지 읽기 객체 서버 --> msg --> 클라이언트
			out = s.getOutputStream(); // out : 메시지 보내기, 쓰기 객체 클라이언트 --> msg --> 서버
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
   		
   	}//connect
   	
   	public void sendMsg(String msg){
   		
   		try {
   			
   			if(msg == null || msg.length() == 0) return;
   			
			out.write((msg + "\n").getBytes());
			//System.out.println(out+"보냄");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
   	} //sendMsg
   	
   	public void run(){ //서버가 보낸 메시지 읽기
   		//왜 run메소드 사용? GUI프로그램실행에 영향 미치지않는 코드 작성.
   		//메소드호출은 순차적인 실행!! 스레드메소드는 동시실행(기다리지 않는 별로 실행)!!
   		try {
			while(true){
				
				String msg = in.readLine(); //msg: 서버가 보낸 메시지
				if(msg == null) return;
				String msgs[] = msg.split("\\|");
				//msg ==> "300|안녕하세요" "160|자바사랑--1"
				
				String protocol = msgs[0];
				
				switch(protocol){
				
					case "150":
						
						String nickNames[] = msgs[1].split(",");
						waitInfo.setListData(nickNames);
						break;
						
					case "160":
						
						if(msg.length() > 4){
						String roomNames[] = msgs[1].split(",");
						roomInfo.setListData(roomNames);
						} else {
							String a[] = {""};
							roomInfo.setListData(a);
						}
						break;
						
					case "200":
						
						cc.setTitle(msgs[2]);
						cc.ta.append("["+msgs[1]+"]님이 입장하였습니다.\n");
						cc.ta.setCaretPosition(cc.ta.getText().length());
						
						String namesList[] = msgs[3].split(",");
						cc.li_inwon.setListData(namesList);
						
						break;
						
					case "250":
						
						System.out.println("msg ="+ msg);
						if(msg.length() > 4){
							String namesInRoom[] = msgs[1].split(",");
							roomInwon.setListData(namesInRoom);
						} else {
							String a[] = {""};
							roomInwon.setListData(a);
						}
						break;
						
					case "300":
						
						cc.ta.append(msgs[1]+"\n");
						cc.ta.setCaretPosition(cc.ta.getText().length());
						break;
						
					case "900":
						
						cc.ta.append("["+msgs[1]+"]님이 퇴장하였습니다.\n");
						cc.ta.setCaretPosition(cc.ta.getText().length());
						
						String namesList2[] = msgs[2].split(",");
						cc.li_inwon.setListData(namesList2);
						
						break;
				}
				
				
				

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
   	}//run

   public static void main(String[] args) {
	  new MainChat();
   }




}



