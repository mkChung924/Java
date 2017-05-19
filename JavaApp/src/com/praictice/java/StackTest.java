package com.praictice.java;

import java.util.ArrayList;
import java.util.Scanner;

public class StackTest {
	
	ArrayList<Integer> que;
	
	public StackTest() {
		que = new ArrayList<>();
		String command = "";
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String order[] = new String[num];
		for(int i = 0; i < num; i++){
			command = sc.next();
			if(command.equals("push")){
				int com = sc.nextInt();
				push(com);
				
			} else if(command.equals("pop")){
				pop();
			} else if(command.equals("size")){
				size();
			} else if(command.equals("empty")){
				empty();
			} else if(command.equals("top")){
				top();
			} else {
				
			}
		}
		sc.close();
	}
	
	public void push(int a){
		que.add(a);
		
	}
	
	public void pop(){
		if(que.isEmpty()) {System.out.println(-1);}
		else {
			System.out.println(que.get(que.size()-1));
			que.remove(que.size()-1);
			que.trimToSize();
			}
		
	}
	
	public void size(){
		System.out.println(que.size());
	}
	
	public void empty(){
		if(que.isEmpty()) System.out.println(1);
		else {
			System.out.println(0);
		}
	}
	
	public void top(){
		if(que.isEmpty())System.out.println(-1);
		else {
			System.out.println(que.get(que.size()-1));
		}
	}
	
	public static void main(String[] args) {
		new StackTest();
	}

}
