package com.kosta.j0308;

import java.util.Vector;

public class PersonMenu {
	
	Person p;
	Vector<Person> persons;
	
	public PersonMenu() {
		
		p = new Person(null,0,null);
		persons = new Vector<>();
	}
	
	public boolean listEmpty()
	{
		if(persons.isEmpty()){
			return true;
		}
		
		return false;
	}
	
	public boolean listExist(String name, int age, String job){
		for(int i = 0; i< persons.size(); i++){
			if(persons.get(i).getName().equals(name) && persons.get(i).getAge() == age && persons.get(i).getJob().equals(job)){
				return false;
			} else {
				return true;
			}
		}
		
		return true;
	}
	
	public void insert(String name, int age, String job){
		
		persons.add(new Person(name,age,job));
		System.out.println();
	}
	
	public void select(){
		
		if(listEmpty()){
			System.out.println("������ ������ּ���.");
		} else {
		
			for(int i = 0; i < persons.size(); i++){
				System.out.println((i+1)+": "+persons.get(i));
			}
		}
		System.out.println();
		
	}
	
	public boolean idxCheck(int idx){
		if(idx > persons.size()){
			return true;
		} 
		return false;
		
	}
	
	public void update(int idx, int age, String job){
	
		String name = persons.get(idx-1).getName();
		persons.set(idx-1, new Person(name, age, job));
		System.out.println("���� �Ϸ�!\n");
		
	}
	
	public void delete(int idx){
		
		persons.remove(idx-1);
		System.out.println("���� �Ϸ�!\n");
		
	}
	
}
