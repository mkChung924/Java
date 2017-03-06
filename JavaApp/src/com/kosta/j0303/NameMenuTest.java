package com.kosta.j0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//<클래스 작성>
//1. NameMenu.java(이름 추가, 수정, 삭제, 검색 기능 메소드를 위치)
//	- 멤버: 배열객체 String names[];
//	- 추가(add, append, plus, insert)
//	- 검색(search, find, select)
//	- 수정(modify, change, update, replace, rename)
//	- 삭제(delete, remove, clear, truncate, erase)

//2. NameMenuTest.java(main()메소드 포함, 반복되는 메뉴 출력)
public class NameMenuTest {
	
	
	public NameMenuTest() { //기본 생성
	}
	

	public static void main(String args[]) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		
		NameMenu nm = new NameMenu();
		
		do{

		System.out.println("<이름메뉴>");
		System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
		System.out.print("번호입력 ==> ");
		num = Integer.parseInt(br.readLine()); // "1", "2", "3", "4", "5"
		
		switch(num){

		case 1: 
			String name;
			System.out.print("이름 입력: ");
			name = br.readLine();
			nm.insert(name);
			
			break;
			
		case 2:
			nm.select();
			
			break;
		
		case 3:
			String oldName;
			String newName;
			if(nm.listCheck()){
			System.out.print("기존 이름: ");
			oldName = br.readLine();
			System.out.print("새 이름: ");
			newName = br.readLine();
			
			nm.update(oldName, newName);
			}
			break;
			
			
		case 4:
					
			String delName;
			if(nm.listCheck()){
			System.out.print("이름 입력: ");
			delName = br.readLine();
			nm.delete(delName);
			}
			break;
			
		case 5:
			
			break;
			
			
		}

			System.out.println();
			
		} while(num != 5); //입력 받는 번호가 5번이 아닐때 계속 loop
		
		System.out.println("-- END --");
		

	}//main

} //NameMenuTest 클래스

