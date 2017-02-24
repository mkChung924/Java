//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.io.*;

class GuGuDanTest
{
	public static void main(String args[]) throws IOException
	{

		for(int i = 1; i < 3; i++){
			System.out.println("< " + i + "단 >");
			for(int j = 1 ; j < 10; j++){
				System.out.println(i + "x" + j + "= " + (i*j));

			}
			System.out.println();
		}

		for(int i = 1; i < 10; i++){
			for(int j = 1; j < 10; j++){
				int mult = j*i;
				String zero = "";
				if(mult < 10) zero = " ";

				System.out.print(j + "x" + i + "= " + zero + mult + "   ");
			}
			System.out.println();
		}

		System.out.println("\n######################################################");
		System.out.println("################구구단 출력 프로그램##################");
		System.out.println("######################################################");
		System.out.print("원하는 단을 입력하시오.만약 일정 구간의 구구단을 원할시 00을 입력하세요.\n(0: 모든 구구단(1~9), 00: 일정구간 구구단): ");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int x = Integer.parseInt(str);

				if(str.equals("0")){
					fullgugudan();
				} else if(str.equals("00")){
					System.out.print("시작 단: ");
					String first = br.readLine();
					System.out.print("끝 단: ");
					String last = br.readLine();
					int f = Integer.parseInt(first);
					int l = Integer.parseInt(last);

					gugudan(f,l);
				} else {
					gugudan(x);
				}
	}

	static void gugudan(int b)
	{
		System.out.println("< " + b + "단 >");
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(b + "x" + i + "= " + (b*i));
		}
		System.out.println(">>>>>>>>>> "+ b + "단 출력 완료! <<<<<<<<<<");
	}

		static void fullgugudan()
	{
		for(int i = 1; i < 10 ; i++)
		{
			System.out.println(i + "단");
			for(int j = 1; j < 10 ; j++){
				System.out.println(i + "x" + j + "= " + (i*j));
			}
			System.out.println();
		}
	}

	static void gugudan(int s, int e){

		for(int i = s; i <= e; i++){
			System.out.println("< " +i + "단 >");
			for(int j = 1; j<10; j++){
				System.out.println(i + "x" + j + "= " + (i*j));

			}
			System.out.println();
		}
	}
}
