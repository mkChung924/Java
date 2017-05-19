package com.kosta.j0410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

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
	
	public static boolean num_check(String str){//숫자 조합일 경우 리턴 true
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			
			if(!(ch >= '0' && ch <= '9')){
				return false;
			}		
		}//for
		
		if(str.length()==0) return false;
		return true;
		
	}//num_check
	

	public static void main(String args[]) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		
		NameMenu nm = new NameMenu();
		
		do{

		System.out.println("<이름메뉴>");
		System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
		System.out.print("번호입력 ==> ");
		String str = br.readLine();
		char a[] = str.toCharArray();
		
//		if(str.isEmpty()){
//			
//			System.out.println("값을 입력하세요.\n");
//			continue;
//			
//		} else if(!(a[0] >= '1' && a[0] <= '5')){
//			
//			if(a[0] >= 'A'){
//			System.out.println("번호만 입력하세요.");
//			} else if(a[0] < '1' || a[0] > '5'){
//				System.out.println("1~5번만 선택 가능합니다.");
//			}
//			
//		} else {
//		}
		
		if(num_check(str)){
			num = Integer.parseInt(str); // "1", "2", "3", "4", "5"
		} else {
			num = 0;
			System.out.println("번호만 입력하세요!");
		}
		
		switch(num){

		case 1: 
			String name;
			System.out.print("이름 입력: ");
			name = br.readLine().trim();
			
			if(nm.insert(name)){
				System.out.println("저장 성공!");
			} else {
				System.out.println("저장 실패!");
			}
			break;
			
		case 2:
			Vector<String> v = nm.select();
			System.out.println("#이름목록");
			for(int i = 0; i < v.size(); i++){
				System.out.println("["+(i+1)+"] "+v.get(i));
			}
			
			break;
		
		case 3:
			String oldName;
			String newName;
			

				System.out.print("기존 이름: ");
				oldName = br.readLine().trim();		

				System.out.print("새 이름: ");
				newName = br.readLine().trim();	
				
				
				if(nm.update(oldName, newName)){
					System.out.println("새로운 이름이 변경되었습니다.");
					
				} else {
					System.out.println("존재하지 않는 이름입니다.");
				}

			break;

			
		case 4:
					
			String delName;

			System.out.print("이름 입력: ");
			delName = br.readLine().trim();
			if(nm.delete(delName)){
				System.out.println("삭제완료!");
			} else {
				System.out.println("삭제할 데이터가 없습니다.");
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

