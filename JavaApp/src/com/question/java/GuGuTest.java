package com.question.java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.*;
//import java.awt.*;
//import java.util.*;

class GuGuTest
{
	static BufferedReader br;
	static boolean run;

	public static void main(String args[]) throws IOException
	{
		run = true;
		while(run){

//		for(int i = 1; i < 3; i++){
//			System.out.println("< " + i + "단 >");
//			for(int j = 1 ; j < 10; j++){
//				System.out.println(i + "x" + j + "= " + (i*j));
//
//			}
//			System.out.println();
//		}
//
//		for(int i = 1; i < 10; i++){
//			for(int j = 1; j < 10; j++){
//				int mult = j*i;
//				String zero = "";
//				if(mult < 10) zero = " ";
//
//				System.out.print(j + "x" + i + "= " + zero + mult + "   ");
//			}
//			System.out.println();
//		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>구구단 출력 프로그램<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
		System.out.print("● 원하는 단을 입력하시오.만약 일정 구간의 구구단을 원할시 00을 입력하세요."+
			"\n   (0: 모든 구구단(1~9), 00: 일정구간 구구단, n : 프로그램 종료): ");

		br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String n = "";
		if(str.equals("n")) str = "000";
		int x = Integer.parseInt(str);
		
				if(str.equals("0")){
					fullgugudan();
				} else if(str.equals("00")){
					System.out.print("시작 단: ");
					String first = br.readLine();
					System.out.print("끝 단: ");
					String last = br.readLine();
					System.out.println();
					int f = Integer.parseInt(first);
					int l = Integer.parseInt(last);

					gugudan(f,l);
				} else if(str.equals("000")){
					run = false;
					System.out.println("\n구구단 프로그램 종료!!\n");

				} else {
					gugudan(x);
				}
	}
	}

	//메소드1 : 원하는 단
	static void gugudan(int b) throws IOException
	{
		System.out.println("< " + b + "단 >");
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(b + "x" + i + "= " + (b*i));
		}
		System.out.println(">>>>>>>>>> "+ b + "단 출력 완료! <<<<<<<<<<");
		System.out.println();
		off();

	}

		//메소드2 : 1부터 9단까지 구구단
		static void fullgugudan() throws IOException
	{
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(i + "단");
			for(int j = 1; j < 10 ; j++){
				System.out.println(i + "x" + j + "= " + (i*j));
			}
			System.out.println();
		}
		off();

	}

	//메소드3 : 일정 구간 구구단
	static void gugudan(int s, int e) throws IOException
	{

		for(int i = s; i <= e; i++){
			
			System.out.println("< " +i + "단 >");
			for(int j = 1; j<10; j++){
				System.out.println(i + "x" + j + "= " + (i*j));

			}
			System.out.println();
		}

		off();

	}

	//메소드4 : 종료할래?
	static void off() throws IOException{

		System.out.print("종료하시겠습니까(y : 종료/ n : 계속)? ");
		String ans = br.readLine();
		if(ans.equals("y")){
			run = false;
			System.out.println("\n구구단 프로그램 종료!!\n");
		} else if(ans.equals("n")){
			run = true;
		} else {
			System.out.println("잘못 입력하였습니다.\n프로그램을 중지하시겠습니까(y/n)? ");
			String ans2 = br.readLine();
			if(ans2.equals("y")){
				run = false;
			} else if(ans2.equals("n")){
				run = true;
			} else {
				run = false;
			}
		}

	}
}
