package pack1;

public class Child extends Parent{
	
	void callTest(){
		System.out.println("Child Ŭ���� Call Test");
		m1();
		m2();
		m3();
		//m4(); private �޼ҵ� ȣ�� �Ұ�
		//m5(); ���� �޼ҵ� ȣ�� �Ұ�
	}
	
	public static void main(String args[]){
		Child c = new Child();
		c.callTest();
		System.out.println(c.su);
	}

}
