class GrandParent
{
	int g = 100;

	void grand(){
		System.out.println("조부모 안녕~");
	}
}


class Parent extends GrandParent
{
	int i = 11;
	int j = 22;

	void print(){
		System.out.println("프린트메소드");
	}
	void hello2(String a){
		System.out.println(a+ " 부모안녕~");
	}
	void hello2(int a){
	System.out.println(a+ " 부모안녕~");
	}
}

class Child extends Parent
{
	int k = 33;
	int m = 44;

	void bark(){
		System.out.println("멍멍");
	}

	void hello(){
		System.out.println("자식안녕~");
	}

}


class InheritanceTest
{
	public static void main(String args[])
	{
		//자식클래스 객체생성
		Child child = new Child();//Child 클래스를 사용할 준비가 끝났다.
		//c.~ : Child클래스에 있는 ~ 
		child.bark();
		child.hello();
		System.out.println("k = " + child.k);

		child.print();
		System.out.println("i = " + child.i);

		child.hello2("정명규");
		child.hello2(1);

		child.grand();
		System.out.println("g = " + child.g);

		System.out.println("" + child.toString());

		System.out.println("unhappy".substring(0,7));

		String number = "111111-1111111";
		System.out.println("주민번호 앞자리: "+number.substring(0,6));
		System.out.println("주민번호 뒷자리: "+number.substring(7,13));

		Parent p = new Child();
		//Child c = new Parent(); ==> 에러발생


	}
}