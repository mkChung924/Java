package com.kosta.person.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kosta.person.control.*;

public class Model {
	

	public Vector<Person> vector;
	public Vector<Person> vector2;

	public Model() {
		
		vector = new Vector<>();
		vector2 = new Vector<>();
	}
	
	public void insert(int no, String name, int age, String job){
		vector.add(new Person(no,name,age,job));
		
	}
	
	public void update(int no, String name, int age, String job){
		for(int i = 0; i < vector.size(); i++){
			if(vector.get(i).getNo() == no){
				vector.set(i, new Person(no,name,age,job));
				break;
			}
		}
		
	}

	public void delete(int no){
		for(int i = 0; i < vector.size(); i++){
			if(vector.get(i).getNo() == no){
				vector.remove(i);
			}
		}
	
	}

	public void exit(){
		
		int esc = JOptionPane.showConfirmDialog(null, "정말 종료하시겠습니까?");
		if(esc == 0){
			System.exit(0);
		}
	
	}
	
	public void getName(String name){
		vector2.clear();
		for(int i = 0; i < vector.size(); i++){
			if(vector.get(i).getName().contains(name)){
				vector2.add(new Person(vector.get(i).getNo(),vector.get(i).getName(),vector.get(i).getAge(),vector.get(i).getJob()));
			}
		}			
	}
	
	
	public int deletesure(){
		
		int del = JOptionPane.showConfirmDialog(null, "정말로 삭세 하시겠습니까?");
		return del;

	}
	
	public void noListDialog(){
		JOptionPane.showMessageDialog(null, "이름목록이 존재하지 않습니다.");
	}
	
	public void emptyFieldDialog(){
		JOptionPane.showMessageDialog(null, "빈칸이 존재합니다.");
	}
	
	public void upClickDialog(){
		JOptionPane.showMessageDialog(null, "수정할 목록을 클릭하세요.");
	}
	
	public void delClickDialog(){
		JOptionPane.showMessageDialog(null, "삭제할 목록을 클릭하세요.");
	}
	
	public void ageIsNumDialog(){
		JOptionPane.showMessageDialog(null, "나이는 숫자만 가능합니다.");
		
	}
	
	
	public void sortByNo(Vector v){
		Collections.sort(v, (Person b1, Person b2) -> Integer.compare(b1.getNo(),b2.getNo()));
		
		}
	
	public void sortByName(Vector v){
		Collections.sort(v, (Person b1, Person b2) -> b1.getName().compareTo(b2.getName()));
	}
	
	public void sortByAge(Vector v){
		//Collections.sort(vector, (Person b1, Person b2) -> Integer.compare(b1.getAge(),b2.getAge()));

		Collections.sort(v, new Comparator<Person>() {
	        @Override public int compare(Person b1, Person b2) {
	        	return Integer.compare(b1.getAge(), b2.getAge());
	        	
	        }

	    });
	}
	
	public void sortByJob(Vector v){
		Collections.sort(v, (Person b1, Person b2) -> b1.getJob().compareTo(b2.getJob()));
	}
	
	public int getinfo(int no){
		
		int i = 0;
		
		for(i = 0; i < vector.size(); i++){
			if(vector.get(i).getNo() == no){
				break;
			}
		}
		return i;
	}
	
	
}
