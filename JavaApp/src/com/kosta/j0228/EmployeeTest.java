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
		System.out.println("������ȣ");
		String str = "�̸��� "+ name + "�̰� �۾��� "+jobTitle+", ������ "+salary;
		return str;
	}
	
}//class Employee

class Manager extends Employee{
	String department;
	
	Manager(String name, String jobTitle, int salary, String department){
		super(name, jobTitle, salary);
		this.department = department;
		//������: super(), this() ������ ȣ�� ----> �ݵ�� ù��° ���ο� ���!!
	}
	
	public String getDetails(){//�޼ҵ� ������(�������̵�!!)
//		super.getDetails();
//		String str = "�̸��� "+ name + "�̰� �۾��� "+jobTitle+", ������ "+salary + " �μ��� "+department;
//		return str;
		String str = super.getDetails() + " �μ��� "+department;
		return str;
	}
}

public class EmployeeTest {
	public static void main(String args[]){
		Manager m = new Manager("�����", "������", 5000, "��ǰ���ߺ�");
		System.out.println(m.getDetails());
	}

}
