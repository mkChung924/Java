class GrandParent
{
	int g = 100;

	void grand(){
		System.out.println("���θ� �ȳ�~");
	}
}


class Parent extends GrandParent
{
	int i = 11;
	int j = 22;

	void print(){
		System.out.println("����Ʈ�޼ҵ�");
	}
	void hello2(String a){
		System.out.println(a+ " �θ�ȳ�~");
	}
	void hello2(int a){
	System.out.println(a+ " �θ�ȳ�~");
	}
}

class Child extends Parent
{
	int k = 33;
	int m = 44;

	void bark(){
		System.out.println("�۸�");
	}

	void hello(){
		System.out.println("�ڽľȳ�~");
	}

}


class InheritanceTest
{
	public static void main(String args[])
	{
		//�ڽ�Ŭ���� ��ü����
		Child child = new Child();//Child Ŭ������ ����� �غ� ������.
		//c.~ : ChildŬ������ �ִ� ~ 
		child.bark();
		child.hello();
		System.out.println("k = " + child.k);

		child.print();
		System.out.println("i = " + child.i);

		child.hello2("�����");
		child.hello2(1);

		child.grand();
		System.out.println("g = " + child.g);

		System.out.println("" + child.toString());

		System.out.println("unhappy".substring(0,7));

		String number = "111111-1111111";
		System.out.println("�ֹι�ȣ ���ڸ�: "+number.substring(0,6));
		System.out.println("�ֹι�ȣ ���ڸ�: "+number.substring(7,13));

		Parent p = new Child();
		//Child c = new Parent(); ==> �����߻�


	}
}