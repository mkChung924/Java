import java.lang.System; //import : ����ϰڴٸ� ����
//�� ���α׷������� ����� Ŭ����(����)���� ��ġ(��Ű��)�� ǥ���� �ִ� ����!
//package(��Ű��): ���� ���ü� �ִ� Ŭ�������� ����. ���������� ��������.
//import java.lang.String;
import java.io.IOException;
import java.lang.*; //�����Ϸ��� �ڵ��߰�
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

		System.out.print("���ڸ� ���� �Է� : ");
		int su = System.in.read();
		System.in.read(); // ���Ͱ�ó��(13)
		System.in.read(); // ���Ͱ�ó��(10) 

		System.out.print("���� ���� �ٽ� �Է� : ");
		int su2 = System.in.read() - 48;

		System.out.println("����� �Է��� ���� " + su2 + "�̰� �� ���� �ƽ�Ű �ڵ尪�� "+su+"�Դϴ�!!");

		System.in.read();
		System.in.read();

		System.out.println();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("BufferedReader�� �̿��� ���� �Է�: ");
		String str = br.readLine();
		int num1 = Integer.parseInt(str);
		String num2 = String.valueOf(num1);
		System.out.println(str);
		System.out.println(num1);
		System.out.println(num2);

		//�ٸ� Ŭ������ �żҵ带 ����� �� ����
		//gugudan(int b) �� static���� ���ǵǾ� ���� �� ����. 
		//���� ��ü�� ������ �ʿ����.
		GuGuDanTest.gugudan(num1);
	}
}