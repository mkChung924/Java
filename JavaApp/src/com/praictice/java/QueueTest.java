package com.praictice.java;

import java.util.ArrayList;
import java.util.Scanner;

public class QueueTest {
	
	ArrayList<Integer> que;
	
	public QueueTest() {
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
			} else if(command.equals("front")){
				front();
			} else if(command.equals("back")){
				back();
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
			System.out.println(que.get(0));
			que.remove(0);
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
	
	public void front(){
		if(que.isEmpty()) System.out.println(-1);
		else {
			System.out.println(que.get(0));
		}
		
	}
	
	public void back(){
		if(que.isEmpty())System.out.println(-1);
		else {
			System.out.println(que.get(que.size()-1));
		}
	}
	
	public static void main(String[] args) {
		new QueueTest();
	}

}
