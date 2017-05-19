package com.kosta.j0411;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	static Vector<Integer> s;

	public Main() {
		s = new Vector<>();
	}

	static public void push(int a){
		
		s.add(a);

	}
	
	static public void pop(){
		
		
		if(s.size() == 0){
			System.out.println("-1");
		} else {
		System.out.println(s.get(s.size()-1));
		s.remove(s.get(s.size()-1));
		s.trimToSize();
		}
	}
	
	static public void size(){
		
		System.out.println(s.size());
		
	}
	
	static public void empty(){
		
		if(s.size()==0) System.out.println("1");
		else System.out.println("0");
		
	}
	
	static public void top(){
		
		System.out.println(s.get(s.size()-1));
		
	}
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		int num = sc.nextInt();
		sc.nextLine();

		while(count < num){
			String orders = sc.nextLine();
			String orderz[] = new String[2];
			orderz = orders.split(" ");
			
			switch(orderz[0]){
			
			case "push":
				push(Integer.parseInt(orderz[1]));
				break;
			case "pop":
				
				pop();

				break;
			case "size":
				
				size();
				break;
			case "empty":
				
				empty();
				break;
			case "top":
				
				top();
				break;
				
			default: break;
			
			}
			

			count++;
			
		}
		count = 0;
		sc.close();
	}

}
