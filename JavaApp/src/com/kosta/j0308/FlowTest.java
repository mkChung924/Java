package com.kosta.j0308;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BoxLayout;

public class FlowTest implements ActionListener {
	//���α׷��� �ʿ��� ��ü(�����̳�, ������Ʈ) ����
	
	boolean modifyClicked = false;
	boolean deleteClicked = false;
	Vector<Person> persons;
	Person p;
	
	Frame f;
	Panel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
	Button remove, modify, cancel,cancel2, insert, select, update, delete, exit;
	MenuBar menubar;
	Menu edit, file, help;
	MenuItem esc;
	Label li1, li2, li3, updateNumLabel, newAgeLabel, newJobLabel, deleteNumLabel;
	TextField tf1, tf2, tf3, updateNum, newAge, newJob, deleteNum;
	TextArea ta1;
	
	Dimension dm;
	
	
	public FlowTest() {//������ : �ʱ�ȭ �޼ҵ�
		
		persons = new Vector<>();
		p = new Person(null,0,null);
		
		//����� ��ü�� ���� ��ü����
		f = new Frame("GUI Test");
		panel1 = new Panel();
		panel2 = new Panel();
		panel3 = new Panel();
		panel4 = new Panel();
		panel5 = new Panel();
		panel6 = new Panel();
		panel7 = new Panel();
		ta1 = new TextArea("�߰�/�˻�/����/������ �غ�����.\n���� �Ͻ÷��� ���� �Ǵ� ����->�����⸦ ��������.\n",20,100);
		menubar = new MenuBar();
		file = new Menu("����");
		edit = new Menu("����");
		help = new Menu("����");
		esc = new MenuItem("Exit   ������");
		remove = new Button("����");
		modify = new Button("����");
		cancel = new Button("���");
		cancel2 = new Button("���");
		//���ι�ư
		insert = new Button("�߰�");
		select = new Button("��ȸ");
		update = new Button("����");
		delete = new Button("����");
		exit = new Button("����");
		
		li1 = new Label("�̸�", Label.CENTER);
		li2 = new Label("����", Label.CENTER);
		li3 = new Label("����", Label.CENTER);
		updateNumLabel = new Label("��ȣ",Label.CENTER);
		newAgeLabel = new Label("����", Label.CENTER);
		newJobLabel = new Label("����", Label.CENTER);
		deleteNumLabel = new Label("��ȣ", Label.CENTER);
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		updateNum = new TextField(10);
		newAge = new TextField(10);
		newJob = new TextField(10);
		deleteNum = new TextField(10);

		//�Ӽ� ����(���̾ƿ�, ���̱�)
		ta1.setEditable(false);
		ta1.setBackground(Color.black);
		ta1.setForeground(Color.white);
		f.setLayout(new BoxLayout(f,BoxLayout.Y_AXIS));
		panel1.setLayout(new GridLayout(3, 2, 5,0));
		panel2.setLayout(new FlowLayout());
		panel3.setLayout(new FlowLayout());
		panel4.setLayout(new GridLayout(3,2));
		panel5.setLayout(new FlowLayout());
		panel6.setLayout(new GridLayout(1, 2));
		panel7.setLayout(new FlowLayout());
		file.add(esc);
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
		//tf2.setEchoChar('*');
		
		delete.setForeground(Color.red);
		delete.setFont(new Font("���� ���",Font.BOLD,13));
		insert.addActionListener(this);
		select.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);
		exit.setForeground(Color.BLUE);
		modify.addActionListener(this);
		cancel.addActionListener(this);
		remove.addActionListener(this);
		cancel2.addActionListener(this);
		
		esc.addActionListener(this);
		
		panel1.add(li1);
		panel1.add(tf1);
		panel1.add(li2);
		panel1.add(tf2);
		panel1.add(li3);
		panel1.add(tf3);
		//panel2.add(ta1);
		panel3.add(insert);
		panel3.add(select);
		panel3.add(update);
		panel3.add(delete);
		panel3.add(exit);
		panel4.add(updateNumLabel);
		panel4.add(updateNum);
		panel4.add(newAgeLabel);
		panel4.add(newAge);
		panel4.add(newJobLabel);
		panel4.add(newJob);
		panel5.add(modify);
		panel5.add(cancel);
		panel6.add(deleteNumLabel);
		panel6.add(deleteNum);
		panel7.add(remove);
		panel7.add(cancel2);

		f.add(panel1);
		f.add(panel3);
		f.add(panel4);
		f.add(panel5);
		f.add(panel6);
		f.add(panel7);
		f.add(ta1);
		
		
		//������ 2��(������ ������ ����, ������ ���̱� ����)
		dm = new Dimension(400,470);
		panel4.setVisible(false);
		panel5.setVisible(false);
		panel6.setVisible(false);
		panel7.setVisible(false);
		f.setLocation(550, 100);
		f.setSize(dm);
		f.setMenuBar(menubar);
		f.setVisible(true);
		
		
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
				}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//���� �߰�
		if(e.getSource() == insert){
			
			String name = tf1.getText().toString().trim();
			String strAge = tf2.getText().toString().trim();
			String job = tf3.getText().toString().trim();
			
			if(name.isEmpty() || strAge.isEmpty() || job.isEmpty()){
				ta1.append("��ĭ�� �����մϴ�.\n");
			} else {
				
				if(strAge.matches("[a-zA-Z��-�R]+")){
					ta1.append("���̴� ���ڸ� �����մϴ�.\n");
				} else {
			
					int age = Integer.parseInt(strAge);
			
					persons.add(new Person(name, age, job));
					ta1.append("���� �Ϸ�!\n");
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
				}
			}
			//ta1.append("\n"+tf1.getText().toString()+"\n"+tf2.getText().toString()+"\n"+tf3.getText().toString());
		}
		
		//���� �˻�
		if(e.getSource() == select){
			if(persons.isEmpty()){
				ta1.append("��ϵ� ������ �����ϴ�.\n");
			} else {
				ta1.append("<�˻� ���>\n");
				for(int i = 0; i < persons.size(); i++){
					ta1.append((i+1)+": "+persons.get(i).toString()+"\n");
				}
			}
		}
		
		//���� ����
		if(e.getSource() == update){
			if(modifyClicked){
				
				panel4.setVisible(false);
				panel5.setVisible(false);
				f.setSize(dm);
				f.setVisible(true);
				modifyClicked = false;
				
			} else {
				panel4.setVisible(true);
				panel5.setVisible(true);
				panel6.setVisible(false);
				panel7.setVisible(false);
				f.setSize(400,600);
				f.setVisible(true);
				modifyClicked = true;
				deleteClicked = false;
			}
		}
		
		//���� ����
		if(e.getSource() == delete){
			
			if(deleteClicked){
				panel6.setVisible(false);
				panel7.setVisible(false);
				f.setSize(dm);
				f.setVisible(true);
				deleteClicked = false;
				
			} else {
				panel6.setVisible(true);
				panel7.setVisible(true);
				panel4.setVisible(false);
				panel5.setVisible(false);
				f.setSize(400,550);
				f.setVisible(true);
				deleteClicked = true;
				modifyClicked = false;
			}

			
		}
		
		if(e.getSource() == exit){
			System.exit(0);
		}
		
		//����
		if(e.getSource() == modify){
			
			String strIdx = updateNum.getText().toString().trim();
			String strAge = newAge.getText().toString().trim();
			String strJob = newJob.getText().toString().trim();
				
			if(!strIdx.isEmpty() && !strAge.isEmpty() && !strJob.isEmpty()){
				

				if(strIdx.matches("[a-zA-Z��-�R]+") || strAge.matches("[a-zA-z��-�R]+")){
					ta1.append("��ȣ/���̿��� ���ڸ� �Է��ϼ���.\n");
				} else {
					
					int idx = Integer.parseInt(strIdx);
					
					if(idx > persons.size()){
						ta1.append("�߸��� �����Դϴ�.\n");
						return;
					}
				
					//idx = Integer.parseInt(updateNum.getText().toString().trim());
					int age = Integer.parseInt(newAge.getText().toString().trim());
					String job = newJob.getText().toString().trim();
					String name = persons.get(idx-1).getName();
					int oldAge = persons.get(idx-1).getAge();
					String oldJob = persons.get(idx-1).getJob();
					
					persons.set(idx-1, new Person(name, age, job));
					
					updateNum.setText("");
					newAge.setText("");
					newJob.setText("");
					panel4.setVisible(false);
					panel5.setVisible(false);
					f.setSize(dm);
					f.setVisible(true);
					modifyClicked = false;
					
					if(oldAge == age && !oldJob.equals(job)){
						ta1.append("���� �Ϸ�.\n");
						ta1.append("\t<�������>\n\t����: " + oldJob + " -> " + job + "\n");
						
					} else if(oldJob.equals(job) && oldAge != age){
						ta1.append("���� �Ϸ�.\n");
						ta1.append("\t<�������>\n\t����: " +oldAge + " -> " + age+"\n");
					} else if(oldAge == age && oldJob.equals(job)){
						ta1.append("�ٲ� ������ �����ϴ�.\n");
					} else {
						ta1.append("���� �Ϸ�.\n");
						ta1.append("\t<�������>\n\t����: " +oldAge + " -> " + age+"\n\t����: " + oldJob + " -> " + job + "\n");
					}
				
				}
				
			} else {
				ta1.append("��ĭ�� �����մϴ�.\n");
			}
				
		}
		//���� ���
		if(e.getSource() == cancel){
			
			panel4.setVisible(false);
			panel5.setVisible(false);
			f.setSize(dm);
			f.setVisible(true);
			modifyClicked = false;
		}
		
		//����
		if(e.getSource() == remove){
			
			String num = deleteNum.getText().toString().trim();
			
			if(num.isEmpty()){
				ta1.append("��ĭ�� �����մϴ�.\n");
			} else {
				int delete = Integer.parseInt(num);
				if(delete > persons.size()){
					ta1.append("�߸��� �����Դϴ�.\n");
				} else if(delete == 0){
					ta1.append("�߸��� �����Դϴ�.\n");
				}else {
					persons.remove(delete -1);
					ta1.append("���� �Ϸ�.\n");
					deleteNum.setText("");
					panel6.setVisible(false);
					panel7.setVisible(false);
					f.setSize(dm);
					f.setVisible(true);
					deleteClicked = false;
				}
				
			}
			
		}
		
		//���� ���
		if(e.getSource() == cancel2){
			
			if(deleteClicked){
				panel6.setVisible(false);
				panel7.setVisible(false);
				f.setSize(dm);
				f.setVisible(true);
				deleteClicked = false;
				
			} else {
				panel6.setVisible(true);
				panel7.setVisible(true);
				f.setSize(dm);
				f.setVisible(true);
				deleteClicked = true;
			}
		}
		
		//escŬ��
		if(e.getSource() == esc){
			System.exit(0);
		}
	}

	////main
	public static void main(String[] args) {
		//������ ȣ��
		//FlowTest ft = new FlowTest();
		new FlowTest();
	
	}//main
	

}//class