package pack2;
import pack1.Parent;

public class Child extends Parent{
	
	void callTest(){
		System.out.println("다른 패키지 Child 클래스 Call Test");
		m1();
		m2();
		//m3(); 다른 패키지에서 default 호출 불가
		//m4(); private 메소드 호출 불가
		//m5(); 없는 메소드 호출 불가
	}
	
	public static void main(String args[]){
		Child c = new Child();
		c.callTest();
		System.out.println(c.su);
	}

}
