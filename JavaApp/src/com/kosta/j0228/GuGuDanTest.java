package com.kosta.j0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ��� 1. ��ü ��
//public class GuGuDanTest{
//	
//	static boolean run;
//	
//	public static void main(String args[]) throws IOException{
//		
//		GuGuDan ggd = new GuGuDan();
//		
//			run = true;
//			while(run){
//			
//				ggd.wantDan();
//				int dan = ggd.dan;
//				ggd.printDan(dan);
//				ggd.continueDan();
//				char yn = ggd.result;
//				if(yn == 'y'){
//					run = true;
//				} else if(yn == 'n'){
//					System.out.println("������ ����!");
//					run = false;
//				} else {
//					System.out.println("�߸������̽��ϴ�.");
//					System.out.println("������ ����!");
//					run = false;
//				}
//			
//			}
//			
//	}
//}

// ��� 2. ��
public class GuGuDanTest extends GuGuDan{
	
	static boolean run;
	
	public static void main(String args[]) throws IOException{
		
		
			run = true;
			while(run){
			
				wantDan();
				int dan = GuGuDan.dan;
				printDan(dan);
				continueDan();
				char yn = GuGuDan.result;
				if(yn == 'y'){
					run = true;
				} else if(yn == 'n'){
					System.out.println("������ ����!");
					run = false;
				} else {
					System.out.println("�߸������̽��ϴ�.");
					System.out.println("������ ����!");
					run = false;
				}
			
			}
			
	}
}

class GuGuDan{
	
	static int dan;
	static char result;
	
	static int wantDan() throws IOException{
		System.out.print("���ϴ� ��? ");
		dan = System.in.read() - 48;
		System.in.read();
		//System.in.read();
		return dan;

	}
	
	static void printDan(int dan){
		for(int i = dan; i <= dan; i++){
			for(int j = 1; j < 10; j++){
				System.out.println(i + "*" + j + " = " + (i*j));
			}
		}
	}
	
	static char continueDan() throws IOException{
		System.out.print("�Լ�(y/n)? ");
		result = (char) System.in.read();
		System.in.read();
		//System.out.println(result);
		return result;
	}
	

	

}

