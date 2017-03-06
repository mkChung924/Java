package com.kosta.j0303;

public class NameMenu {
	
	String names[];
	int count;
	
	public NameMenu() {
		
		names = new String[5];
		count = 0;
		//System.out.println("haha");
	}
	
	public boolean existName(String name){
		for(int i = 0; i < names.length; i++){
			if(name.equals(names[i])){
				return true;
			}
		}
		return false;
	}
	
	public void insert(String addName){ //이름 추가
		
//		if(names[names.length-1] != null){
//			System.out.println("더 이상 입력할 수 없습니다.\n 한 개 이상의 이름을 먼저 삭제한 후 입력하세요.");
//			return;
//		}
		if(count == 5){
			System.out.println("꽉 참.");
			return;
		}
		
		for(int i = 0; i < names.length; i++){
			
			if(names[i] != null){
				if(names[i].equals(addName)){
				System.out.println("동일한 이름이 존재합니다.");
				return;
				} 
			} else if(names[i] == null){
				names[i] = addName;
				count++;
				break;
			}			
		}
		System.out.println("저장완료!");

	}
	
	public void select(){ // 이름 저장소를 화면 출력; 모든이름 출력
		
		long start = System.currentTimeMillis();
		
		if(names[0] != null){
			System.out.println("#이름목록");
			for(int i = 0; i < names.length; i++){
				if(names[i] != null){
					System.out.println("["+i+"] "+ names[i]);
				} 
			}
			
			long end = System.currentTimeMillis();
			System.out.println( "*실행 시간 : " + ( end - start )/1000.0 + "s");
			
		} else {
			
				System.out.println("저장된 이름이 없습니다. 먼저 추가해 주세요.");
				return;
			} 
		
		
		}
		
	public boolean listCheck(){

		if(names[0] != null){
			return true;
		} else {
			System.out.println("이름 목록이 비었습니다. 먼저 추가해 주세요.");
			return false;
		}
		
	}
	
	public boolean oldNameCheck(String oldName){
		
		for(int i = 0; i < names.length; i++){
			if(names[i] != null){
				if(names[i].equals(oldName)){
					return true;
				} else {
					System.out.println("존재하지 않는 이름입니다!!\n");
					
				}
			} else {
				System.out.println("##");
				return false;
			}
		}
		return false;
		
	}
	
	public void update(String oldName, String newName){ // 이름 변경
		
		for(int i = 0; i < names.length; i++){
			if(newName.equals(names[i])){
				System.out.println("새로운 이름이 이미 존재합니다.");
				return;
			}
		}

		if(names[0] != null){
			for(int i = 0; i < names.length; i++){
				if(names[i].equals(oldName)){
					names[i] = newName;
					break;
				}
			}
				System.out.println("변경 완료!");
		} else {
			System.out.println("이름이 존재하지 않습니다.");
		}
	}
	

	public void delete(String delName){ // 이름 삭제
		
		long start = System.currentTimeMillis();
		
		int i;
		for(i = 0; i < names.length; i++){
			if(names[i] == null){
				System.out.println("존재하지 않는 이름입니다!!");
				return;
			} else {
			if(names[i].equals(delName)){
				names[i] = null;
				count--;
				break;
				}
			}
		}

		for(int j = i; j < names.length; j++){
			if(j < names.length -1 ) {
				names[j] = names[j+1];
			}
		}
		
		System.out.println("삭제 완료!");
		long end = System.currentTimeMillis();
		System.out.println( "\n*실행 시간 : " + ( end - start )/1000.0 + "s");
		
	}

}
