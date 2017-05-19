package com.praictice.java;

import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueClassTest {
	
	Queue<Point> p;
	Queue<Point3> p3;
	HashMap<Point, Integer> hs;
	
	public QueueClassTest() {
		p = new LinkedList<>();
		p3 = new LinkedList<>();
		hs = new HashMap<Point, Integer>();
		
		hs.put(new Point(1,2),2);
		
		if(hs.containsKey(new Point(1,2))){
			System.out.println("hello");
		}
		
		int x = 1;
		int y = 2;
		int z = 3;
		
		p.offer(new Point(1,1));
		p.offer(new Point(2,2));
		if(p.contains(new Point(1,1))){
			System.out.println("hi");
		} else {
			System.out.println("come");
		}
		
		
		p3.offer(new Point3(x,y,z));
		p3.offer(new Point3(x+1,y+2,z+3));
		
		System.out.println(p3.contains(new Point3(x,y,z)));
		
	}
	
	public static void main(String[] args) {
		new QueueClassTest();
	}
	
	class Point3{
		int x,y,leng;
		
		public Point3() {
			
		}

		public Point3(int x, int y, int leng) {
			this.x = x;
			this.y = y;
			this.leng = leng;
		}
		

		
	}

}
