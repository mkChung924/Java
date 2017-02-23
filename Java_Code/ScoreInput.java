import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ScoreInput
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���� ������ �Է��Ͻÿ� : ");
		String engstr = br.readLine();
		System.out.print("���� ������ �Է��Ͻÿ� : ");
		String mathstr = br.readLine();

		int eng = Integer.parseInt(engstr);
		int math = Integer.parseInt(mathstr);

		String engScore = "";
		String mathScore = "";

		////�������� ȯ��
		switch(eng/10){

			case 10 :
				engScore = "A";
				break;

			case 9:
				engScore = "B";
				break;
			
			case 8:
				engScore = "C";
				break;

			case 7:
				engScore = "D";
				break;

			default:
				engScore = "F";
				break;
		}

		////�������� ȯ��
		switch(math/10){

			case 10 :
				mathScore = "A";
				break;

			case 9:
				mathScore = "B";
				break;
			
			case 8:
				mathScore = "C";
				break;

			case 7:
				mathScore = "D";
				break;

			default:
				mathScore = "F";
				break;
		}

/*
		//����
		if(eng >= 90 && eng <=100){
			engScore = "A ����";

		} else if(eng >= 80 && eng < 90){
			engScore = "B ����";

		} else if(eng >= 70 && eng < 80){
			engScore = "C ����";

		} else {
			engScore = "F ����";
		}
		
		//����
		if(math >= 90 && math <=100){
			mathScore = "A ����";

		} else if(math >= 80 && math < 90){

			mathScore = "B ����";

		} else if(math >= 70 && math < 80){
			mathScore = "C ����";

		} else {
			mathScore = "F ����";
		}
*/
		System.out.println("     ����  | ���� |  ����  |");
		System.out.println("     ����  |  " + eng + "  |   " + engScore + "    |");
		System.out.println("     ����  |  " + math + "  |   " + mathScore + "    |");
		avg(eng,math);
	}

	 static void avg(int a, int b){
		double average = (a + b)/(double)2;
		System.out.println("     ���  |  "+ average);
	}
}