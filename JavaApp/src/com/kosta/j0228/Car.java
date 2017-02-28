package com.kosta.j0228;

public class Car {
	
	String carName; //자동차 이름
	int wheelNum;	//바퀴
	int velocity;//속도
	
	public Car(String carName, int wheelNum, int velocity){
		this.carName = carName;
		this.wheelNum = wheelNum;
		this.velocity = velocity;
		
	}
	
	public String toString(){ //문자열 변환 메소드, 클래스의 상태를 표현하는 메소
	
	return "이 차는 "+carName+"이고 바퀴수는 "+wheelNum+"개이고 속도는 "+velocity + "km/h";
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
		Car c1 = new Car("포르쉐",4,340);
	    Car c2 = new Car("람보르기니",4,360);
		//Car c2 = c1; //같은메모리할당
	    
	   System.out.println(c1.toString());
	   System.out.println(c2.toString());
	   
	   //<객체 c1과 c2의 비교>
	   //1. 메모리(위치) 비교 : ==(등가 연산자)
	   
	   if(c1 == c2){
	   System.out.println("c1과 c2는 같은 메모리를 가짐!!");
	   } else {
		   System.out.println("c1과 c2는 다른 메모리를 가짐!!");
	   }
	   
	   //2. 객체 내용 비교(필드값을 비교)
	   if(c1.equals(c2)){
		   System.out.println("객체내용 같음!!");
	   } else {
		   System.out.println("객체내용 다름!!");
	   }
	   
	   //참고) 기본자료형의 비교 == 연산자는 값을 비교!!
	   // int a = 10; int b = 10; a == b : true
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	}
}
