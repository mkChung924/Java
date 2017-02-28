package com.kosta.j0228;

//�������̽�
interface My{
	
	//void m5(){} //�����߻�: �������̽������� ����� �޼ҵ常 ��ġ!
//	void m6();
}

//�߻�Ŭ����
abstract class Shape{
//	void m3(){}
//	abstract void m4();
//	abstract void draw() throws Exception;
	abstract void draw();

	
}

//�⺻Ŭ����
class Circle extends Shape{
//	void m1(){}
//	void m2(); //����: �⺻ Ŭ���������� ����� �޼ҵ尡 ��ġ�� �� ����.

	void draw(){ 
		//�������̵��� ������ ��: 
		//1. ���������ڴ� �θ�� ���ų� Ȯ��Ǿ�� ��!
		//2. throws�� �θ�� ���ų� ��ҵǾ�� ��!
		
		System.out.println("���׸���~!!");
	}
}

class Triangle extends Shape{
	@Override
	protected void draw() {
		// TODO Auto-generated method stub
		System.out.println("�ﰢ�� �׸���~!!");
	}
}

class Rectangle extends Shape{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("�簢�� �׸���~!!");	
	}
}

public class AbstractTest {
	
	public static void main(String args[]){
		//Shape s = new Shape(); // ����: �߻�Ŭ������ ��ü���� X
		Shape s; //�߻�Ŭ���� ������ ����
		s = new Circle();
		s.draw();
		
		s = new Triangle();
		s.draw();
		
		s = new Rectangle();
		s.draw();
		
		
	}

}
