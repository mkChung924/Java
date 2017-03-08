package com.kosta.j0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonMenuTest {
	
	public static void main(String[] args) throws IOException{
		
		PersonMenu pm = new PersonMenu();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 0;
		String name;
		int age;
		String job;
		
		do{
			
			System.out.println("<사람 목록>\n1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("=> 번호입력: ");
			num = Integer.parseInt(br.readLine());
			
			switch(num){
			
			case 1:
				System.out.print("이름: ");
				name = br.readLine();
				System.out.print("나이: ");
				age = Integer.parseInt(br.readLine());
				System.out.print("직업: ");
				job = br.readLine();
				pm.insert(name, age, job);
				
				break;
				
			case 2:
				
				pm.select();
				
				break;
				
			case 3:
				
				if(pm.listEmpty()){
					System.out.println("등록된 정보가 없습니다.");
				} else {
					
				int idx;
				System.out.print("수정할 번호: ");
				idx = Integer.parseInt(br.readLine());
				if(pm.idxCheck(idx)){
					System.out.println("잘못된 접근입니다.\n");
				} else {
				System.out.print("나이: ");
				age = Integer.parseInt(br.readLine());
				System.out.print("직업: ");
				job = br.readLine();
				
					pm.update(idx, age, job);
				}
				
				}
			
				break;
				
			case 4:
				
				if(pm.listEmpty()){
					System.out.println("등록된 정보가 없습니다.");
				} else {
					
				int idx;
				System.out.print("삭제 번호: ");
				idx = Integer.parseInt(br.readLine());
				if(pm.idxCheck(idx)){
					System.out.println("잘못된 접근입니다.\n");
				} else {
				pm.delete(idx);
				}
				}
				
				break;
			
			case 5:
				
				break;
				
			default: break;
			
			}
			
		} while(num != 5);
		
		System.out.println("== END ==");
		
		
	}//main

}//class
