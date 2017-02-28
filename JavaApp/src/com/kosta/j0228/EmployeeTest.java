package com.kosta.j0228;

class Employee{
	String name;
	String jobTitle;
	int salary;
	
	public Employee(String name, String jobTitle, int salary) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.salary = salary;
	}
	
	public String getDetails(){ //현 클래스내의 필드들이 갖는 값이 상세히 표현!
		//리턴지료형 void가 아닌경우에는 반드시 일치하는 자료형의 return 데이터; 위치!
		String str = "이름은 "+ name + "이고 작업은 "+jobTitle+", 연봉은 "+salary;
		return str;
	}
	
}//class Employee

class Manager extends Employee{
	
	
	
}

public class EmployeeTest {
	public static void main(String args[]){
		
	}

}
