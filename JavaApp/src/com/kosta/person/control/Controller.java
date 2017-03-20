package com.kosta.person.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kosta.person.model.Model;
import com.kosta.person.model.Person;
import com.kosta.person.view.GetNameView;
import com.kosta.person.view.InputForm;
import com.kosta.person.view.MainView;
import com.kosta.person.view.UpForm;

public class Controller implements ActionListener {
	MainView main;
	InputForm input;
	UpForm up;
	Model model;
	GetNameView gnv;
	
	public Vector<Person> vector, vector2;
	int count;
	int rowNum, no;
	boolean listClicked;
	boolean whichVector;
	int row;
	
	public Controller() {
		main = new MainView();
		input = new InputForm();
		up = new UpForm();
		model = new Model();
		gnv = new GetNameView();
		vector = model.vector;
		vector2 = model.vector2;
		eventUp();
		main.displayTable(vector);
		row = vector.size();
//		Thread t2 = new Thread(main);
//		t2.start();
		
	}
	
	
	public void eventUp(){
		main.insert.addActionListener(this);
		main.update.addActionListener(this);
		main.delete.addActionListener(this);
		main.exit.addActionListener(this);
		main.getName.addActionListener(this);
		main.getall.addActionListener(this);
		
		main.table.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				int col = main.table.columnAtPoint(e.getPoint());
				String name = main.table.getColumnName(col);
				//System.out.println(name);
				if(count != 0){
				switch(name){
				case "번호":
					if(!whichVector){
						model.sortByNo(vector);
						main.displayTable(vector);
						
					} else {
						model.sortByNo(vector2);
						main.displayTable(vector2);
					}
					
					listClicked = false;
					
					break;
					
				case "이름":
					if(!whichVector){
						model.sortByName(vector);
						main.displayTable(vector);
						
					} else {
						model.sortByName(vector2);
						main.displayTable(vector2);
					}
					
					listClicked = false;
					break;
					
				case "나이":
					if(!whichVector){
						model.sortByAge(vector);
						main.displayTable(vector);
						
					} else {
						model.sortByAge(vector2);
						main.displayTable(vector2);
					}
					
					listClicked = false;
					break;
					
				case "직업":
					if(!whichVector){
						model.sortByJob(vector);
						main.displayTable(vector);
						
					} else {
						model.sortByJob(vector2);
						main.displayTable(vector2);
					}
					
					listClicked = false;
					break;
					
					default: break;
				}
				} else {
					
				}
			}
		});
		
		input.submit.addActionListener(this);
		input.reset.addActionListener(this);
		input.tf3.addActionListener(this);
		
		up.up.addActionListener(this);
		up.reset.addActionListener(this);
		up.tf3.addActionListener(this);
		
		gnv.search.addActionListener(this);
		gnv.tf.addActionListener(this);
		
		
		main.table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				rowNum = main.table.getSelectedRow();
				//String strno = main.table.getValueAt(rowNum,0).toString();
				//no = Integer.parseInt(strno);
				no = (int)main.table.getValueAt(rowNum, 0);
				
				listClicked = true;
			}
		});
		
		input.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				input.setVisible(false);
				main.setVisible(true);
			
			}
		});
		
		up.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				up.setVisible(false);
				main.setVisible(true);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == main.insert){
			input.setVisible(true);
			main.setVisible(false);
			input.tf1.requestFocus();
			
		} else if(ob == main.update){
			//count = vector.size();
			
			if(row == 0){
				model.noListDialog();
				
			} else {
				if(listClicked){
					up.setVisible(true);
					main.setVisible(false);
					
					int idx = model.getinfo(no);
				
					up.tf1.setText(vector.get(idx).getName());
					up.tf2.setText(vector.get(idx).getAge()+"");
					up.tf3.setText(vector.get(idx).getJob());
					up.tf4.setText(no+"");
					
				} else {
					model.upClickDialog();
				}
			}
			
		} else if(ob == main.delete){
			
			if(row == 0){
				model.noListDialog();
			} else {
				if(listClicked){
					
					if(model.deletesure() == 0){
						model.delete(no);
						main.displayTable(vector);
						whichVector = false;
					}
				} else {
					model.delClickDialog();
				}
			}
			
			
		} else if(ob == main.exit){
			
			model.exit();
			
		} else if(ob == input.submit){

			String name = input.tf1.getText().trim();
			String strage = input.tf2.getText().trim();
			String job = input.tf3.getText().trim();
			
			if(!name.isEmpty() || !strage.isEmpty() || !job.isEmpty()){
				if(strage.matches("[0-9]+")){
					int age = Integer.parseInt(strage);
					
					model.insert(count+1, name, age, job);
					main.displayTable(vector);
					whichVector = false;
					
					input.tf1.setText("");
					input.tf2.setText("");
					input.tf3.setText("");
					
					input.setVisible(false);
					main.setVisible(true);
					
					count++;
				} else {

					model.ageIsNumDialog();
				}
				
			} else {
				model.emptyFieldDialog();
			}
			
		} else if(ob == input.tf3){
			input.submit.doClick();
			
		} else if(ob == input.reset){
			
			input.tf1.setText("");
			input.tf2.setText("");
			input.tf3.setText("");
			
		} else if(ob == up.up){

			String name = up.tf1.getText();
			String strage = up.tf2.getText();
			String job = up.tf3.getText();
			
			if(!name.isEmpty() || !strage.isEmpty() || !job.isEmpty()){
				if(strage.matches("[0-9]+")){
					int age = Integer.parseInt(strage);
					
					model.update(no, name, age, job);
					main.displayTable(vector);
					whichVector = false;
					
					up.tf1.setText("");
					up.tf2.setText("");
					
					up.tf3.setText("");
					up.setVisible(false);
					
					main.setVisible(true);
					listClicked = false;
					
				} else {
					model.ageIsNumDialog();
				}
						
			}
		} else if(ob == up.tf3){
			up.up.doClick();
			
		} else if(ob == up.reset){
			
			up.tf1.setText("");
			up.tf2.setText("");
			up.tf3.setText("");
			
		} else if(ob == main.getName){
			
			if(row == 0){
				model.noListDialog();
			} else {
				gnv.setVisible(true);
				
//				String searchName = JOptionPane.showInputDialog(main,"검색이름: ");
//				
//				if(!searchName.isEmpty()){
//					model.getName(searchName.trim());
//					main.displayTable(vector2);
//					whichVector = true;
//				} else {
//					model.emptyFieldDialog();
//				}
			}
			
			
		} else if(ob == gnv.search){
			
			String name = gnv.tf.getText().trim();
			if(!name.isEmpty()){
				gnv.tf.setText("");
				model.getName(name);
			
				gnv.setVisible(false);
				main.setVisible(true);
				
				main.displayTable(vector2);
				whichVector = true;
			} else {
				model.emptyFieldDialog();
			}
			
		} else if(ob == gnv.tf){
			gnv.search.doClick();
			
		} else if(ob == main.getall){
			main.displayTable(vector);
			whichVector = false;
		}
	}
	
	public static void main(String[] args) {
		new Controller();
		

	}




}
