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
   
   //���� ����� ��ü
   BufferedReader in;
   OutputStream out;
   
   String nickName;
   
   String selectedRoom;
   String myRoom;

   String roomName;//������ ���� �̸�

   public MainChat() {	 
	 setTitle("����");
	 
	 cc = new ChatClient();
	 
	 roomInfo = new JList<String>();
	   roomInfo.setBorder(new TitledBorder("������"));
	 roomInwon = new JList<String>();
	   roomInwon.setBorder(new TitledBorder("�ο�����"));
	 waitInfo = new JList<String>();
       waitInfo.setBorder(new TitledBorder("��������"));
       
     sp_roomInfo = new JScrollPane(roomInfo);
     sp_roomInwon = new JScrollPane(roomInwon);
     sp_waitInfo = new JScrollPane(waitInfo);
     
     bt_create = new JButton("�游���");
     bt_enter = new JButton("�����");
     bt_exit = new JButton("������");     
     
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

     
     nickName = JOptionPane.showInputDialog(this, "�г���: ");
     sendMsg(NICK_NAME +"|"+nickName);
     sendMsg("161" + "|");
     
     eventUp();
   }//������
   
   public void eventUp(){
	   //����(MainChat)
	   bt_create.addActionListener(this);
	   bt_enter.addActionListener(this);
	   bt_exit.addActionListener(this);
	   roomInfo.addMouseListener(new MouseAdapter() {
		   public void mouseClicked(MouseEvent e){
			   	String str = roomInfo.getSelectedValue();//"�ڹٹ�--1"
			   	selectedRoom = str.substring(0, str.indexOf("-"));
			   	myRoom = selectedRoom;
			   	sendMsg("250|"+myRoom);
			   	//System.out.println(myRoom+"����");
		   }
	});
	   
	   //��ȭ��(ChatClient)
	   cc.bt_change.addActionListener(this);
	   cc.bt_exit.addActionListener(this);
	   cc.sendTF.addActionListener(this);

   }
   
   	@Override
	public void actionPerformed(ActionEvent e) {
   		Object ob = e.getSource();
   		
   		if(ob == bt_create){ //�� ����� ��û
   			
   			roomName = JOptionPane.showInputDialog(this, "�� �̸�: ");
   			if(roomName != null){
	   				if(roomName.trim().length() != 0){
	   				//���̸��� �������� ����
		   			sendMsg(ROOM_NAME+"|"+roomName);
		   			
		   			this.setVisible(false);
		   			cc.setVisible(true);
   				}
   			} 
   			
   			
   		} else if(ob == bt_enter){
   			
   			if(selectedRoom == null){
   				JOptionPane.showMessageDialog(this, "���� ���� �����ϼ���.");
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
   			
   			int exit = JOptionPane.showConfirmDialog(this, "�����ðڽ��ϱ�?");
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
   			String newName = JOptionPane.showInputDialog(this,"�� �г���: ");
   			sendMsg(NEW_NICK_NAME + "|"+newName);
				
		} else if(ob == bt_exit){
			
   			int exit = JOptionPane.showConfirmDialog(this, "ä���� �����Ͻðڽ��ϱ�?");
   			if(exit == 0){
   				System.exit(0);
   				sendMsg("1000|"+nickName);
   			}
   			
   		} else {
   			
   		}
		
	}//actionPerformed
   	
   	public void connect(){//���� ���� ���� ��û
   		
   		try {
			Socket s = new Socket("192.168.0.169", 8282);
			
			in = new BufferedReader(new InputStreamReader(s.getInputStream())); //in: �����޽��� �б� ��ü ���� --> msg --> Ŭ���̾�Ʈ
			out = s.getOutputStream(); // out : �޽��� ������, ���� ��ü Ŭ���̾�Ʈ --> msg --> ����
			
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
			//System.out.println(out+"����");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
   	} //sendMsg
   	
   	public void run(){ //������ ���� �޽��� �б�
   		//�� run�޼ҵ� ���? GUI���α׷����࿡ ���� ��ġ���ʴ� �ڵ� �ۼ�.
   		//�޼ҵ�ȣ���� �������� ����!! ������޼ҵ�� ���ý���(��ٸ��� �ʴ� ���� ����)!!
   		try {
			while(true){
				
				String msg = in.readLine(); //msg: ������ ���� �޽���
				if(msg == null) return;
				String msgs[] = msg.split("\\|");
				//msg ==> "300|�ȳ��ϼ���" "160|�ڹٻ��--1"
				
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
						cc.ta.append("["+msgs[1]+"]���� �����Ͽ����ϴ�.\n");
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
						
						cc.ta.append("["+msgs[1]+"]���� �����Ͽ����ϴ�.\n");
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



