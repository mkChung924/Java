package com.kosta.j0228;

//인터페이스
interface My{
	
	//void m5(){} //에러발생: 인터페이스내에는 선언된 메소드만 위치!
//	void m6();
}

//추상클래스
abstract class Shape{
//	void m3(){}
//	abstract void m4();
//	abstract void draw() throws Exception;
	abstract void draw();

	
}

//기본클래스
class Circle extends Shape{
//	void m1(){}
//	void m2(); //에러: 기본 클래스에서는 선언된 메소드가 위치할 수 없다.

	void draw(){ 
		//오버라이딩시 주의할 점: 
		//1. 접근제한자는 부모와 같거나 확장되어야 함!
		//2. throws는 부모와 같거나 축소되어야 함!
		
		System.out.println("원그리기~!!");
	}
}

class Triangle extends Shape{
	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형 그리기~!!");
	}
}

class Rectangle extends Shape{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형 그리기~!!");	
	}
}

public class AbstractTest {
	
	public static void main(String args[]){
		//Shape s = new Shape(); // 에러: 추상클래스는 객체생성 X
		Shape s; //추상클래스 선언은 가능
		s = new Circle();
		s.draw();
		
		s = new Triangle();
		s.draw();
		
		s = new Rectangle();
		s.draw();
		
		
	}

}
