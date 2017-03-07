package com.kosta.j0307;

import java.util.Vector;

class A{
	void hello(){
		System.out.println("A클래스 안녕~");
	}
	
}
public class VectorTest2 {
	public static void main(String args[]){
		
		/*
		 * <>: 제네릭타입 ----> 어떤 자료형을 사용할 지를 명시(명료성을 높임)
		 * <E> : element(요소)로 사용될 자료형을 명시.
		 * <K> : key로 사용될 자료형을 명시.
		 * <V> : value로 사용될 자료형 명시.
		 * <T> : type에 사용될 자료형을 명시.
		 */
		
		Vector v = new Vector();
		v.add(new A());
		v.add("안녕");
		Object obj = v.get(0); //vector v의 첫번째 추가된 데이터를 얻어오기
		//obj.hello();//에러!! (이유 : 부모레퍼런스를 통해 자식요소 호출 불가!)
		System.out.println("-vector는 Object를 반환해서 캐스팅을 하여 클래스를 사용");
		A a = (A) obj;
		a.hello();
		//제네릭타입을 사용했을 때 장점: 추가적인 자식캐스팅이 필요없음!!
		
		System.out.println("\n-제네릭타입을 클래스 A로 설정");
		Vector<A> v2 = new Vector<>(); //7버전부터는 두번째 괄호안 타입 생략가능
		v2.add(new A());
		
//		v2.add("안녕~"); //A클래스 자료형 이회의 데이터는 추가시 에러발생
//		A a2 = v2.get(0);
//		a2.hello();
		
		v2.get(0).hello();
	}
}