package com.kosta.j0228;

import java.io.IOException;

// ��� 1. ��ü ����
//public class GuGuDanTest{
//	
//	static boolean run;
//	
//	public static void main(String args[]) throws IOException{
//		
//		GuGuDan ggd = new GuGuDan();
//		
//			run = true;
//			int dan;
//			char yn;

//			while(run){
//			
//				dan = ggd.wantDan();
//				ggd.printDan(dan);
//				yn = ggd.continueDan();
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

// ��� 2. ���
public class GuGuDanTest extends GuGuDan{
	
	static boolean run;
	
	public static void main(String args[]) throws IOException{
		
			run = true;
			char yn;
			
			//while ��
//			while(run){
//			
//				printDan(wantDan());
//				yn = continueDan();
//				if(yn == 'y' || yn == 'Y'){
//					run = true;
//				} else if(yn == 'n' || yn == 'N'){
//					System.out.println("������ ����!");
//					run = false;
//				} else {
//					System.out.println("�߸� �����̽��ϴ�.");
//					System.out.println("������ ����!");
//					run = false;
//				}
//			
//			}
			
			//do~while ��
			do{
				printDan(wantDan());
				yn = continueDan();
			} while(yn == 'y' || yn == 'Y');
			//while(yn != ''n && yn != 'N');
			
			System.out.println("������ ����!");
			
	}
}

class GuGuDan{
	
	public static int wantDan() throws IOException{
		System.out.print("���ϴ� ��? ");
		int dan = System.in.read() - 48;
		System.in.read();
		return dan;

	}
	
	public static void printDan(int dan){
		System.out.println("< "+ dan + "�� >");
		for(int i = dan; i <= dan; i++){
			for(int j = 1; j < 10; j++){
				System.out.println(i + "*" + j + " = " + (i*j));
			}
		}
	}
	
	public static char continueDan() throws IOException{
		System.out.print("�Լ�(y/n)? ");
		char result = (char) System.in.read();
		System.in.read();
		return result;
	}
	

	

}

