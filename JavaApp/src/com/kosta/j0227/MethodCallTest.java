package com.kosta.j0227;


class MethodDefine {
	
	String a = "안녕 MethodDefine 클래스?";
	void m1(){
		System.out.println("m1() 메소드!");
	}
	
	void m2(int a){
		System.out.println(a + "를 입력한 m2() 메소드!");
	}
	
	void m3(String str){
		System.out.println("m3() 메소드: " + str);
	}
	void m4(int a, int b, int c){
		System.out.println("4() 메소드: a."+a + " b."+b+" c."+c);
	}
	void m4_2(int a[]){
//		System.out.println("4()_2 메소드: su[0]: "+ a[0]);
//		System.out.println("4()_2 메소드: su[1]: "+ a[1]);
//		System.out.println("4()_2 메소드: su[2]: "+ a[2]);
//		System.out.println("//===============================");
		
		System.out.println("배열의 길이: "+a.length)
		;
		for(int i = 0; i <a.length; i++){
			System.out.println("4_2() 메소드: a["+i+"]: " + a[i]);
		}
	}
	void m5(String a, int b, String c){
		System.out.println("5() 메소드: 이름:"+a + " 나이:"+b+" 특징:"+c);
	}
	
	void m5_2(String str[]){
		for(int i = 0; i < str.length; i ++){
			System.out.println("5_2() 메소드: str["+i+"]번지 = " + str[i]);
		}
	}
	
	void m5_3(Person p){//Person p = new Person();
		System.out.println("이름:" + p.name + "\n나이:" + p.age + "\n직업:" + p.job);
	}
	
	void m5_4(Person[] p){
			System.out.println(p.getClass().getName());
		
	}
	
	
	int m6(){
		int su = 10;
		
		return su; 
	}
	
	String m7(){
		String msg = "홍길동";
		
		return msg;
	}
	
	int[] m8(){//주의 : int, int, int 8(){}
				//---> 에러: 리턴자료형에 데이터를 여러개 나열 할 수 없음!
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

//public은 저장 파일 이름 앞에만 붙일 수 있다.
public class MethodCallTest {
	public static void main(String args[]){
		
		MethodDefine md = new MethodDefine();
		//==> MethodDefind클래스내의 필드와 메소드를 사용할 준비가 끝남.
		//==> md(참조변수) : MethodDefine클래스를 참조하는 변수!!
		//===> md.필드명 	md.메소드명();
		String b = md.a;
		System.out.println(b);
		md.m1();
		md.m2('흫');
		md.m3("안녕?");
		md.m4(1,2,3);
		md.m5("정명규", 27, "천재");
		//===============================
		
		int su[] = {10,20,30,40,50};
		
		md.m4_2(su);
		
		String str[] = {"정명규", "4", "이현재"};
		md.m5_2(str);
		
		Person p = new Person();
		md.m5_3(p);
		
		//================================
		
		int num = md.m6();//리턴값이 있는 메소드의 경우) 호출된 결과를 선언된 변수에 담는다.
		System.out.println(num);
		
		//=======================================
		
		String msg = md.m7();
		System.out.println(msg);
		
		//=======================================
		int jj[] = md.m8();
		for(int i = 0; i < jj.length; i++){
			System.out.println("jj["+i+"]"+"번지 = " + jj[i]);
		}
		
		//=======================================
		Person pp = md.m9();
	
		System.out.println("m9() 메소드 호출 통해 전달된 이름: "+ pp.name);
		System.out.println("m9() 메소드 호출 통해 전달된 나이: "+ pp.age);
		System.out.println("m9() 메소드 호출 통해 전달된 직업: "+ pp.job);
		
		Person[] bb = new Person[5];
		md.m5_4(bb);
		
		
	}//main
}//class
