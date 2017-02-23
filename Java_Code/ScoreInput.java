import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ScoreInput
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("영어 점수를 입력하시오 : ");
		String engstr = br.readLine();
		System.out.print("수학 점수를 입력하시오 : ");
		String mathstr = br.readLine();

		int eng = Integer.parseInt(engstr);
		int math = Integer.parseInt(mathstr);

		String engScore = "";
		String mathScore = "";

		////영어점수 환산
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

		////수학점수 환산
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
		//영어
		if(eng >= 90 && eng <=100){
			engScore = "A 학점";

		} else if(eng >= 80 && eng < 90){
			engScore = "B 학점";

		} else if(eng >= 70 && eng < 80){
			engScore = "C 학점";

		} else {
			engScore = "F 학점";
		}
		
		//수학
		if(math >= 90 && math <=100){
			mathScore = "A 학점";

		} else if(math >= 80 && math < 90){

			mathScore = "B 학점";

		} else if(math >= 70 && math < 80){
			mathScore = "C 학점";

		} else {
			mathScore = "F 학점";
		}
*/
		System.out.println("     과목  | 점수 |  학점  |");
		System.out.println("     영어  |  " + eng + "  |   " + engScore + "    |");
		System.out.println("     수학  |  " + math + "  |   " + mathScore + "    |");
		avg(eng,math);
	}

	 static void avg(int a, int b){
		double average = (a + b)/(double)2;
		System.out.println("     평균  |  "+ average);
	}
}