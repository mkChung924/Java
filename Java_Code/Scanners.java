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

		System.out.print("���ڸ� �Է��Ͻÿ� : ");
		int su = System.in.read() - 48;

		System.in.read();
		System.in.read();

		System.out.print("���ڸ� �Է��Ͻÿ� : ");
		char ch = (char) System.in.read();
		
		System.in.read();
		System.in.read();

		System.out.println("���� : " + su + ", ���� : " + ch);

		System.out.println("===============================");
		System.out.println("//���ڿ� �Է� �� ���//");

		//byte�� ����Ͽ� ������ ������ �����Ͽ� ���
		byte[] b = new byte[10];
		System.out.print("���ڿ� �Է� : ");
		System.in.read(b);
		String str = new String(b);
		System.out.println("���ڿ� : "+str);

		///BufferedReader ���
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ڿ� �Է� : ");
		String readstr = in.readLine();
		System.out.println("���ڿ� : '"+ readstr + "', ���� �� : " + readstr.length());

		System.out.print("���� �Է� : ");
		String readstr1 = in.readLine();
		int readint = Integer.parseInt(readstr1);
		System.out.println("���� : "+ readint);

	}
}