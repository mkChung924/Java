package com.kosta.j0307;

import java.util.Vector;

class A{
	void hello(){
		System.out.println("AŬ���� �ȳ�~");
	}
	
}
public class VectorTest2 {
	public static void main(String args[]){
		
		/*
		 * <>: ���׸�Ÿ�� ----> � �ڷ����� ����� ���� ���(��Ἲ�� ����)
		 * <E> : element(���)�� ���� �ڷ����� ���.
		 * <K> : key�� ���� �ڷ����� ���.
		 * <V> : value�� ���� �ڷ��� ���.
		 * <T> : type�� ���� �ڷ����� ���.
		 */
		
		Vector v = new Vector();
		v.add(new A());
		v.add("�ȳ�");
		Object obj = v.get(0); //vector v�� ù��° �߰��� �����͸� ������
		//obj.hello();//����!! (���� : �θ��۷����� ���� �ڽĿ�� ȣ�� �Ұ�!)
		System.out.println("-vector�� Object�� ��ȯ�ؼ� ĳ������ �Ͽ� Ŭ������ ���");
		A a = (A) obj;
		a.hello();
		//���׸�Ÿ���� ������� �� ����: �߰����� �ڽ�ĳ������ �ʿ����!!
		
		System.out.println("\n-���׸�Ÿ���� Ŭ���� A�� ����");
		Vector<A> v2 = new Vector<>(); //7�������ʹ� �ι�° ��ȣ�� Ÿ�� ��������
		v2.add(new A());
		
//		v2.add("�ȳ�~"); //AŬ���� �ڷ��� ��ȸ�� �����ʹ� �߰��� �����߻�
//		A a2 = v2.get(0);
//		a2.hello();
		
		v2.get(0).hello();
	}
}