import java.io.IOException;

class GuGuDanTest
{
	public static void main(String args[]) throws IOException
	{

		for(int i = 3; i < 7; i++){
			System.out.println("< " + i + "�� >");
			for(int j = 1 ; j < 10; j++){
				System.out.println(i + " x " + j + " = " + (i*j));

			}
			System.out.println();
		}

		System.out.println("######################################################");
		System.out.println("################������ ��� ���α׷�##################");
		System.out.println("######################################################");
		System.out.print("���ϴ� ���� �Է��Ͻÿ�.(��ONLY 1~9, 0: ��� ������): ");

		int x = System.in.read() - 48;
		System.in.read();
		System.in.read();

				if(x == 0){
					fullgugudan();
				} else {
					gugudan(x);
				}
	}

	static void gugudan(int b)
	{
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(b + " x " + i + " = " + (b*i));
		}
		System.out.println(">>>>>>>>>> "+ b + "�� ��� �Ϸ�! <<<<<<<<<<");
	}

		static void fullgugudan()
	{
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(i + "��");
			for(int j = 1; j < 10 ; j++){
				System.out.println(i + " x " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}
}