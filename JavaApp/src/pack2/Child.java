package pack2;
import pack1.Parent;

public class Child extends Parent{
	
	void callTest(){
		System.out.println("�ٸ� ��Ű�� Child Ŭ���� Call Test");
		m1();
		m2();
		//m3(); �ٸ� ��Ű������ default ȣ�� �Ұ�
		//m4(); private �޼ҵ� ȣ�� �Ұ�
		//m5(); ���� �޼ҵ� ȣ�� �Ұ�
	}
	
	public static void main(String args[]){
		Child c = new Child();
		c.callTest();
		System.out.println(c.su);
	}

}
