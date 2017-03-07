package com.kosta.j0228;

import java.io.IOException;

// 방법 1. 객체 생성
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
//					System.out.println("구구단 종료!");
//					run = false;
//				} else {
//					System.out.println("잘못누르셨습니다.");
//					System.out.println("구구단 종료!");
//					run = false;
//				}
//			
//			}
//			
//	}
//}

// 방법 2. 상속
public class GuGuDanTest extends GuGuDan{
	
	static boolean run;
	
	public static void main(String args[]) throws IOException{
		
			run = true;
			char yn;
			
			//while 문
//			while(run){
//			
//				printDan(wantDan());
//				yn = continueDan();
//				if(yn == 'y' || yn == 'Y'){
//					run = true;
//				} else if(yn == 'n' || yn == 'N'){
//					System.out.println("구구단 종료!");
//					run = false;
//				} else {
//					System.out.println("잘못 누르셨습니다.");
//					System.out.println("구구단 종료!");
//					run = false;
//				}
//			
//			}
			
			//do~while 문
			do{
				printDan(wantDan());
				yn = continueDan();
			} while(yn == 'y' || yn == 'Y');
			//while(yn != ''n && yn != 'N');
			
			System.out.println("구구단 종료!");
			
	}
}

class GuGuDan{
	
	public static int wantDan() throws IOException{
		System.out.print("원하는 단? ");
		int dan = System.in.read() - 48;
		System.in.read();
		return dan;

	}
	
	public static void printDan(int dan){
		System.out.println("< "+ dan + "단 >");
		for(int i = dan; i <= dan; i++){
			for(int j = 1; j < 10; j++){
				System.out.println(i + "*" + j + " = " + (i*j));
			}
		}
	}
	
	public static char continueDan() throws IOException{
		System.out.print("게속(y/n)? ");
		char result = (char) System.in.read();
		System.in.read();
		return result;
	}
	

	

}

