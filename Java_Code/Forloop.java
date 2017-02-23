import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Forloop
{

	public static void main(String args[]) throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		System.out.println("��մ� ���� �����[���� ���� ( 1 = *, 2 = **, 3 = *** )]\n");
		System.out.println("1. �Ƕ�̵�\n2. ���簢��\n3. ������\n");
		System.out.print("��ȣ : ");
		String x = br.readLine();
		int num = Integer.parseInt(x);
		
		switch(num){
			case 1:
				System.out.print("\n�� ���� �Ƕ�̵� : ");
				String pleng = br.readLine();
				int plength = Integer.parseInt(pleng);
				pyramid(plength);
				break;

			case 2:
				System.out.print("\n�� ���� ���� �Է� : ");
				String leng = br.readLine();
				int length = Integer.parseInt(leng);
				rectangle(length);
				break;

			case 3:
				System.out.print("\n�� ���� ���� �Է� : ");
				String rhleng = br.readLine();
				int rhlength = Integer.parseInt(rhleng);
				rhombus(rhlength);
				break;

			default:
				break;

		}

	}

	static void rectangle(int a){

		for(int i = 0 ; i < a; i++){
			for(int j = 0; j < a; j++){

				System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void pyramid(int a){
		
		String star = "*";

		for(int i = 0; i < a ; i++){
			//System.out.print("\t");
			for(int j = 0; j < a - i ; j++){
				System.out.print(" ");
			}
			System.out.println(star);
			star += "**";
		}
	}

	static void rhombus(int a){

		String star = "*";

		for(int i = 0; i < a; i++){
			for(int j = 0; j < a - i; j++){
				System.out.print(" ");

			}
			System.out.println(star);
			star += "**";
		}

		//System.out.println(star);

		for(int i = a; i > 0; i--){
			for(int j = a - i + 1 ; j >= 0; j--){
				System.out.print(" ");
			}
			for(int k = (i *2) -3; k > 0; k--){
				System.out.print("*");
			}

			System.out.println();
		}


//		for(int k = 0; k < a; k++){
//			for(int z = a; z > a - k; z--){
//				System.out.print(" ");
//
//			}
//			System.out.println(star);
//				star = ;
//		}

	}



}