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
			System.out.println("정보를 등록해주세요.");
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
	
		//String name = persons.get(idx-1).getName();
		int oldAge = persons.get(idx-1).getAge();
		String oldJob = persons.get(idx-1).getJob();
		persons.get(idx-1).setAge(age);
		persons.get(idx-1).setJob(job);
		//persons.set(idx-1, new Person(name, age, job));
		System.out.println("변경 완료!");
		
		if(oldAge == age){
			System.out.println("\t\t<변경사항>\n\t직업: " + oldJob + " -> " + job + "\n");

		} else if(oldJob.equals(job)){
			System.out.println("\t\t<변경사항>\n\t나이: " +oldAge + " -> " + age+"\n");

		} else {
			System.out.println("\t\t<변경사항>\n\t나이: " +oldAge + " -> " + age+"\n\t직업: " + oldJob + " -> " + job + "\n");

		}
		
	}
	
	public void delete(int idx){
		
		persons.remove(idx-1);
		System.out.println("삭제 완료!\n");
		
	}
	
}
