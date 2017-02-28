package com.kosta.j0228;

public class Car {
	
	String carName; //�ڵ��� �̸�
	int wheelNum;	//����
	int velocity;//�ӵ�
	
	public Car(String carName, int wheelNum, int velocity){
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
		
	}
	
	public String toString(){ //���ڿ� ��ȯ �޼ҵ�, Ŭ������ ���¸� ǥ���ϴ� �޼�
	
	return "�� ���� "+carName+"�̰� �������� "+wheelNum+"���̰� �ӵ��� "+velocity + "km/h";
	}
	
	public boolean equals(Car c){
		if(carName == c.carName
				&& wheelNum == c.wheelNum
				&& velocity == c.velocity){
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String args[]){
		Car c1 = new Car("������",4,340);
	    Car c2 = new Car("���������",4,360);
		//Car c2 = c1; //�����޸��Ҵ�
	    
	   System.out.println(c1.toString());
	   System.out.println(c2.toString());
	   
	   //<��ü c1�� c2�� ��>
	   //1. �޸�(��ġ) �� : ==(� ������)
	   
	   if(c1 == c2){
	   System.out.println("c1�� c2�� ���� �޸𸮸� ����!!");
	   } else {
		   System.out.println("c1�� c2�� �ٸ� �޸𸮸� ����!!");
	   }
	   
	   //2. ��ü ���� ��(�ʵ尪�� ��)
	   if(c1.equals(c2)){
		   System.out.println("��ü���� ����!!");
	   } else {
		   System.out.println("��ü���� �ٸ�!!");
	   }
	   
	   //����) �⺻�ڷ����� �� == �����ڴ� ���� ��!!
	   // int a = 10; int b = 10; a == b : true
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	}
}
