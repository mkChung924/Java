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
	
	//���� �����
	Socket s;
	BufferedReader in;
	OutputStream out;
	
	
	public ChatClient() {
		
		setTitle("ä�ù�");
		ta = new JTextArea();
		ta.setLineWrap(true);
		scroll_ta = new JScrollPane(ta);
		tf = new JTextField(15);
		p = new JPanel();
		bt = new JButton("����");
		p.add(tf);
		p.add(bt);
		//�Ӽ�����
		
		add(scroll_ta,"Center");
		add(p,"South");
		
		//������
		setBounds(530,150,300,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		connectProcess(); //out ��ü ���� ����
		sendNickName();
		new Thread(this).start();
		
		//Event
		
		tf.addActionListener(this);
		bt.addActionListener(this);
		
	
	}
	
	public void sendNickName(){
		try {
			String nickName = JOptionPane.showInputDialog(this, "��ȭ��: ");
			out.write((nickName + "\n").getBytes()); //out�� ������ �� �г��� ��������
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//sendNickName;
	
	//���� ���� �޽���
	public void connectProcess(){
		
		try {
			
			s = new Socket("192.168.0.104",8282); //�������� �õ�
			//System.out.println("Ȯ��");
			//���� ����°�ü ����
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
					String newName = JOptionPane.showInputDialog(this, "������ �̸���?");
					out.write(("@"+ newName+"\n").getBytes());
					//System.out.println(out.toString());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
	}
		
	public void sendMsg(){//TF�Է°� ---> �������� �޽����� ������
		try{
			String msg = tf.getText().trim();
			if(msg == null || msg.isEmpty()) return;
			out.write( ("" + msg + "\n").getBytes() );
			tf.setText("");
		} catch(IOException e2){
			e2.printStackTrace();
		}
	}
		
	public void run(){ //����? ���� ������ �𸣴� ������ �޽����� ����ϱ� ���ؼ�
		
		while(true){
			
			try{
				
				ta.append(in.readLine()+"\n"); //������ ���� �޽����� ���� --- TextArea�� ���
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
