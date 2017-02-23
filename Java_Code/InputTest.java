import java.lang.System; //import : 사용하겠다를 선언
//현 프로그램내에서 사용할 클래스(파일)들의 위치(패키지)를 표시해 주는 역할!
//package(패키지): 서로 관련성 있는 클래스들의 묶음. 윈도우즈의 폴더개념.
//import java.lang.String;
import java.io.IOException;
import java.lang.*; //컴파일러가 자동추가
import java.io.BufferedReader;
import java.io.InputStreamReader;

class InputTest
{
	public static void main(String args[]) throws IOException
	{
		System.out.println(65);
		System.out.println( (char)65 );

		char ch1 = 'a';
		char ch2 = 'd';

		System.out.println(ch1>ch2);
		System.out.println(ch2>99);

		System.out.print("한자리 수를 입력 : ");
		int su = System.in.read();
		System.in.read(); // 엔터값처리(13)
		System.in.read(); // 엔터값처리(10) 

		System.out.print("같은 수를 다시 입력 : ");
		int su2 = System.in.read() - 48;

		System.out.println("당신이 입력한 수는 " + su2 + "이고 그 수의 아스키 코드값은 "+su+"입니다!!");

		System.in.read();
		System.in.read();

		System.out.println();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("BufferedReader를 이용한 숫자 입력: ");
		String str = br.readLine();
		int num1 = Integer.parseInt(str);
		String num2 = String.valueOf(num1);
		System.out.println(str);
		System.out.println(num1);
		System.out.println(num2);

		//다른 클래스의 매소드를 사용할 수 있음
		//gugudan(int b) 가 static으로 정의되어 있을 때 가능. 
		//따로 객체를 생성할 필요없음.
		GuGuDanTest.gugudan(num1);
	}
}