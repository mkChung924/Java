package com.kosta.j0307;

import java.util.Vector;

public class NameMenu {
	
	Vector<String> names;
	final int MAX = 5;
	
	public NameMenu() {
		
		names = new Vector<>();
	}
	
	public boolean existName(String name){
		
		if(names.contains(name)){
			System.out.println("이미 이름이 등록되어있습니다.");
			return true;
		}
		
		return false;
	}
	
	public boolean emptyCheck(){
		
		if(names.isEmpty()){
			System.out.println("등록된 이름이 없습니다.");
			return true;
		}
		return false;
	}
	
	public void insert(String addName){ //이름 추가
		
		if(names.size() == MAX){
			System.out.println("정원을 초과하였습니다.");
			return;
		} 
		names.add(addName);
		System.out.println("저장 완료!");
		
	}
	
	public void select(){ // 이름 저장소를 화면 출력; 모든이름 출력
		
		long start = System.currentTimeMillis();
		int count = 1;
		
		if(emptyCheck()){
			//System.out.println("등록된 이름이 없습니다.");
		} else {
		
			System.out.println("#검색 결과");
			for(int i = 0; i < names.size(); i++){
				if(i == 6*count){
					System.out.println();
					count++;
				}
				System.out.print("["+i+"] "+names.get(i)+ " ");
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("\n실행 시간: " + (end - start)/1000.0 + "s");
		
		
		}
		

	public boolean oldNameCheck(String oldName){
		if(!names.contains(oldName)){
			System.out.println("일치하는 이름이 없습니다.");
			return true;
		}
		return false;
		
	}

	public void update(String oldName, String newName){ // 이름 변경
		
		if(emptyCheck()){
						
		} else if(names.contains(newName)){
			System.out.println("새로운 이름이 이미 존재합니다.");
			return;
			
		} else{
			
			if(names.contains(oldName)){
				names.set(names.indexOf(oldName), newName);
				System.out.println("변경 완료!");
			} else {
				System.out.println("일치하는 이름이 없습니다.");
			}
		}
	}
	
	public void delete(String delName){ // 이름 삭제
		
		long start = System.currentTimeMillis();
		
		if(emptyCheck()){
			return;
		}
		
		if(names.contains(delName)){
			names.remove(delName);
			System.out.println("삭제 완료!");
		} else {
			System.out.println("존재하지 않는 이름입니다.");
		}
		
		
		long end = System.currentTimeMillis();
		System.out.println( "\n*실행 시간 : " + ( end - start )/1000.0 + "s");
		
	}

}
