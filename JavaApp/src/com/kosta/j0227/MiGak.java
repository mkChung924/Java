package com.kosta.j0227;

public class MiGak implements MenuPan{
					//구현하다 ---> 구현의 약속
	
	public void 짜장면(){//인터페이스 내의 모든 메소드는 public으로 고정
				//자식 클래스에서는 오버라이딩시 부모와 같거나 큰 접근제한자을 지정!!
		System.out.println("짜장면~!!!");
	}

	@Override
	public void 짬뽕() {
		// TODO Auto-generated method stub
		System.out.println("매콤한 짬뽕~~");
		
	}

	@Override
	public void 볶음밥() {
		// TODO Auto-generated method stub
		
	}
	
	//메뉴판에 없는 것도 만들 수 있다.
	public void 초밥(){}
	
	
	
	

}
