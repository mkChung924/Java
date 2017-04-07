package com.kosta.j0323;

class A{
	
	int su; //0
	
	private static A instance;
	
	private A(){}//기본생성자
	
	void hello(){}
	
	public static A getInstance(){
		
		if(instance == null){
			instance = new A();
		}
		return instance; //기본생성자가 private	이지만 같은 클래스내에서는 접근 가능
	}
	
}

public class SingleTonTest { 
	//싱글톤 테스트: 클래스객체를 한개생성하여 여러 곳에서 공동으로 사용!!
	//		------> 한 클래스 당 한번의 객체생성을 하겠다!
	public static void main(String[] args) {
		
		A a1 = A.getInstance();//new A();
		//a1.hello();
		A a2 = A.getInstance();// new A();
		A a3 = A.getInstance();// new A();
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
	}

}
