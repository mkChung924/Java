class A{
	void hello(){
	System.out.println("A 베트남 : 신짜오~!!");
	}
}

class B{
	//변수선언 : 멤버변수(클래스내의 모든 메소드가 함께 사용 가능)
	int su;
	//su = 10; 에러
	int su2 = 20;

	//메소드 정의
	void hello(){
	su = 10;
	int su3;
	su3 = 30; //지역변수(메소드 안에서만 사용 가능)
	System.out.println("B 한국 : 안녕~!!");
	}
}

class C{
	void hello(){
		System.out.println("C 미국 : 헬로~!!");
	}
}

class CallTest{
	public static void main(String args[]){
		System.out.println(":::나라별 인사법:::");


//		객체생성식: A obj = new A();
		A a = new A();
		//a: 메모리상의 B클래스를 가리키는 레퍼런스(참조) 변수
		a.hello();
		//a.멤버필드
		//a.메소드();

		B b = new B();
		b.hello();

		C c = new C();
		c.hello();

			int su2 = 22;
		System.out.println();
		System.out.println("CallTest 클래스의 지역변수 su2 = " + su2);
		System.out.println("B 클래스의 su2 = " + b.su2);
		//System.out.println("B 클래스의 su3 = " + b.su3);
		//----> 클래스를 참조하는 변수를 통해 지역변수 호출은 불가능!!
	}
}
