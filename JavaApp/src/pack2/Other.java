package pack2;
import pack1.Parent;

public class Other {
	
	void callTest(){
		Parent p = new Parent();
		System.out.println("�ٸ� ��Ű�� OtherŬ���� Call Test");
		p.m1();
		//p.m2();
		//p.m3();
		//p.m4();
	}
	
	public static void main(String args[]){
		Other o = new Other();
		o.callTest();
	}

}
