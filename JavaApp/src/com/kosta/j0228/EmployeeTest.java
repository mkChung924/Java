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
	
	public String getDetails(){ //�� Ŭ�������� �ʵ���� ���� ���� ���� ǥ��!
		//���������� void�� �ƴѰ�쿡�� �ݵ�� ��ġ�ϴ� �ڷ����� return ������; ��ġ!
		String str = "�̸��� "+ name + "�̰� �۾��� "+jobTitle+", ������ "+salary;
		return str;
	}
	
}//class Employee

class Manager extends Employee{
	
	
	
}

public class EmployeeTest {
	public static void main(String args[]){
		
	}

}
