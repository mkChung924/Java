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
//			System.out.println("< " + i + "�� >");
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

		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>������ ��� ���α׷�<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
		System.out.print("�� ���ϴ� ���� �Է��Ͻÿ�.���� ���� ������ �������� ���ҽ� 00�� �Է��ϼ���."+
			"\n   (0: ��� ������(1~9), 00: �������� ������, n : ���α׷� ����): ");

		br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String n = "";
		if(str.equals("n")) str = "000";
		int x = Integer.parseInt(str);
		
				if(str.equals("0")){
					fullgugudan();
				} else if(str.equals("00")){
					System.out.print("���� ��: ");
					String first = br.readLine();
					System.out.print("�� ��: ");
					String last = br.readLine();
					System.out.println();
					int f = Integer.parseInt(first);
					int l = Integer.parseInt(last);

					gugudan(f,l);
				} else if(str.equals("000")){
					run = false;
					System.out.println("\n������ ���α׷� ����!!\n");

				} else {
					gugudan(x);
				}
	}
	}

	//�޼ҵ�1 : ���ϴ� ��
	static void gugudan(int b) throws IOException
	{
		System.out.println("< " + b + "�� >");
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(b + "x" + i + "= " + (b*i));
		}
		System.out.println(">>>>>>>>>> "+ b + "�� ��� �Ϸ�! <<<<<<<<<<");
		System.out.println();
		off();

	}

		//�޼ҵ�2 : 1���� 9�ܱ��� ������
		static void fullgugudan() throws IOException
	{
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(i + "��");
			for(int j = 1; j < 10 ; j++){
				System.out.println(i + "x" + j + "= " + (i*j));
			}
			System.out.println();
		}
		off();

	}

	//�޼ҵ�3 : ���� ���� ������
	static void gugudan(int s, int e) throws IOException
	{

		for(int i = s; i <= e; i++){
			
			System.out.println("< " +i + "�� >");
			for(int j = 1; j<10; j++){
				System.out.println(i + "x" + j + "= " + (i*j));

			}
			System.out.println();
		}

		off();

	}

	//�޼ҵ�4 : �����ҷ�?
	static void off() throws IOException{

		System.out.print("�����Ͻðڽ��ϱ�(y : ����/ n : ���)? ");
		String ans = br.readLine();
		if(ans.equals("y")){
			run = false;
			System.out.println("\n������ ���α׷� ����!!\n");
		} else if(ans.equals("n")){
			run = true;
		} else {
			System.out.println("�߸� �Է��Ͽ����ϴ�.\n���α׷��� �����Ͻðڽ��ϱ�(y/n)? ");
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
