class A{
	void hello(){
	System.out.println("A ��Ʈ�� : ��¥��~!!");
	}
}

class B{
	//�������� : �������(Ŭ�������� ��� �޼ҵ尡 �Բ� ��� ����)
	int su;
	//su = 10; ����
	int su2 = 20;

	//�޼ҵ� ����
	void hello(){
	su = 10;
	int su3;
	su3 = 30; //��������(�޼ҵ� �ȿ����� ��� ����)
	System.out.println("B �ѱ� : �ȳ�~!!");
	}
}

class C{
	void hello(){
		System.out.println("C �̱� : ���~!!");
	}
}

class CallTest{
	public static void main(String args[]){
		System.out.println(":::���� �λ��:::");


//		��ü������: A obj = new A();
		A a = new A();
		//a: �޸𸮻��� BŬ������ ����Ű�� ���۷���(����) ����
		a.hello();
		//a.����ʵ�
		//a.�޼ҵ�();

		B b = new B();
		b.hello();

		C c = new C();
		c.hello();

			int su2 = 22;
		System.out.println();
		System.out.println("CallTest Ŭ������ �������� su2 = " + su2);
		System.out.println("B Ŭ������ su2 = " + b.su2);
		//System.out.println("B Ŭ������ su3 = " + b.su3);
		//----> Ŭ������ �����ϴ� ������ ���� �������� ȣ���� �Ұ���!!
	}
}
