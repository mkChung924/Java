package com.kosta.j0227;


class MethodDefine {
	
	String a = "�ȳ� MethodDefine Ŭ����?";
	void m1(){
		System.out.println("m1() �޼ҵ�!");
	}
	
	void m2(int a){
		System.out.println(a + "�� �Է��� m2() �޼ҵ�!");
	}
	
	void m3(String str){
		System.out.println("m3() �޼ҵ�: " + str);
	}
	void m4(int a, int b, int c){
		System.out.println("4() �޼ҵ�: a."+a + " b."+b+" c."+c);
	}
	void m4_2(int a[]){
//		System.out.println("4()_2 �޼ҵ�: su[0]: "+ a[0]);
//		System.out.println("4()_2 �޼ҵ�: su[1]: "+ a[1]);
//		System.out.println("4()_2 �޼ҵ�: su[2]: "+ a[2]);
//		System.out.println("//===============================");
		
		System.out.println("�迭�� ����: "+a.length)
		;
		for(int i = 0; i <a.length; i++){
			System.out.println("4_2() �޼ҵ�: a["+i+"]: " + a[i]);
		}
	}
	void m5(String a, int b, String c){
		System.out.println("5() �޼ҵ�: �̸�:"+a + " ����:"+b+" Ư¡:"+c);
	}
	
	void m5_2(String str[]){
		for(int i = 0; i < str.length; i ++){
			System.out.println("5_2() �޼ҵ�: str["+i+"]���� = " + str[i]);
		}
	}
	
	void m5_3(Person p){//Person p = new Person();
		System.out.println("�̸�:" + p.name + "\n����:" + p.age + "\n����:" + p.job);
	}
	
	void m5_4(Person[] p){
			System.out.println(p.getClass().getName());
		
	}
	
	
	int m6(){
		int su = 10;
		
		return su; 
	}
	
	String m7(){
		String msg = "ȫ�浿";
		
		return msg;
	}
	
	int[] m8(){//���� : int, int, int 8(){}
				//---> ����: �����ڷ����� �����͸� ������ ���� �� �� ����!
		int a = 10;
		int b = 20;
		int c = 30;
		
		int array[] = {a,b,c};
		
		return array;	
	}
	
	Person m9(){
			//Person p = new Person():
		return new Person(); //return person;
	}
	
	void m10(){
		Person p = new Person();
		
	
	}
	
}

//public�� ���� ���� �̸� �տ��� ���� �� �ִ�.
public class MethodCallTest {
	public static void main(String args[]){
		
		MethodDefine md = new MethodDefine();
		//==> MethodDefindŬ�������� �ʵ�� �޼ҵ带 ����� �غ� ����.
		//==> md(��������) : MethodDefineŬ������ �����ϴ� ����!!
		//===> md.�ʵ�� 	md.�޼ҵ��();
		String b = md.a;
		System.out.println(b);
		md.m1();
		md.m2('ň');
		md.m3("�ȳ�?");
		md.m4(1,2,3);
		md.m5("�����", 27, "õ��");
		//===============================
		
		int su[] = {10,20,30,40,50};
		
		md.m4_2(su);
		
		String str[] = {"�����", "4", "������"};
		md.m5_2(str);
		
		Person p = new Person();
		md.m5_3(p);
		
		//================================
		
		int num = md.m6();//���ϰ��� �ִ� �޼ҵ��� ���) ȣ��� ����� ����� ������ ��´�.
		System.out.println(num);
		
		//=======================================
		
		String msg = md.m7();
		System.out.println(msg);
		
		//=======================================
		int jj[] = md.m8();
		for(int i = 0; i < jj.length; i++){
			System.out.println("jj["+i+"]"+"���� = " + jj[i]);
		}
		
		//=======================================
		Person pp = md.m9();
	
		System.out.println("m9() �޼ҵ� ȣ�� ���� ���޵� �̸�: "+ pp.name);
		System.out.println("m9() �޼ҵ� ȣ�� ���� ���޵� ����: "+ pp.age);
		System.out.println("m9() �޼ҵ� ȣ�� ���� ���޵� ����: "+ pp.job);
		
		Person[] bb = new Person[5];
		md.m5_4(bb);
		
		
	}//main
}//class
