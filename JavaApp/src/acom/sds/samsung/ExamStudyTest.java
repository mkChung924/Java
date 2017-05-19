package acom.sds.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class ExamStudyTest {
	
	public ExamStudyTest() {
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
        
			sc.nextLine();
			String subject = sc.nextLine();
			String subjects[] = subject.split(" ");
			String scores = sc.nextLine();
			String score[] = scores.split(" ");
			
	//		if(Integer.parseInt(subjects[1]) <= score.length){
			
			int jumsu[] = new int[score.length];
			for(int i = 0; i < score.length; i++){
				jumsu[i] = Integer.parseInt(score[i]);
			}
			
			Arrays.sort(jumsu);
			
			int num = Integer.parseInt(subjects[1]);
			int sum = 0;
			
			for(int i = jumsu.length-1 ; i >= jumsu.length - num; i--){
				
				sum += jumsu[i];
			}
				

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(sum);
		//}
			}
			
	}
	
	public static void main(String[] args) {
		new ExamStudyTest();
	}

}
