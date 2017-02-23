import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Scanners
{
	public static void main(String args[]) throws IOException
	{
		//byte[] b = new byte[256];

		int num = 65;

		System.out.println((char)num);

		System.out.print("숫자를 입력하시오 : ");
		int su = System.in.read() - 48;

		System.in.read();
		System.in.read();

		System.out.print("문자를 입력하시오 : ");
		char ch = (char) System.in.read();
		
		System.in.read();
		System.in.read();

		System.out.println("숫자 : " + su + ", 문자 : " + ch);

		System.out.println("===============================");
		System.out.println("//문자열 입력 및 출력//");

		//byte를 사용하여 문자의 갯수를 정의하여 사용
		byte[] b = new byte[10];
		System.out.print("문자열 입력 : ");
		System.in.read(b);
		String str = new String(b);
		System.out.println("문자열 : "+str);

		///BufferedReader 사용
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자열 입력 : ");
		String readstr = in.readLine();
		System.out.println("문자열 : '"+ readstr + "', 문자 수 : " + readstr.length());

		System.out.print("숫자 입력 : ");
		String readstr1 = in.readLine();
		int readint = Integer.parseInt(readstr1);
		System.out.println("숫자 : "+ readint);

	}
}