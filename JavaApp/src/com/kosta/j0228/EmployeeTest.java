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
		System.out.println("하하하호");
		String str = "이름은 "+ name + "이고 작업은 "+jobTitle+", 연봉은 "+salary;
		return str;
	}
	
}//class Employee

class Manager extends Employee{
	String department;
	
	Manager(String name, String jobTitle, int salary, String department){
		super(name, jobTitle, salary);
		this.department = department;
		//※주의: super(), this() 생성자 호출 ----> 반드시 첫번째 라인에 기술!!
	}
	
	public String getDetails(){//메소드 재정의(오버라이딩!!)
//		super.getDetails();
//		String str = "이름은 "+ name + "이고 작업은 "+jobTitle+", 연봉은 "+salary + " 부서는 "+department;
//		return str;
		String str = super.getDetails() + " 부서는 "+department;
		return str;
	}
}

public class EmployeeTest {
	public static void main(String args[]){
		Manager m = new Manager("정명규", "개발자", 5000, "제품개발부");
		System.out.println(m.getDetails());
	}

}
