package acom.sds.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class TournamentTest {
		
	public TournamentTest() {
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();        
		for(test_case = 1; test_case <= TC; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
        
			int b = sc.nextInt();
			
			int c[] = new int[b];
			
			for(int i = 0; i < b; i++){
				c[i] = sc.nextInt();
			}
			
			Arrays.sort(c);
			
			int k = c.length;
			for(int j = 0; j < c.length-1; j++){
				c[j] += k;
				
			}
			c[c.length-1] = c[c.length-1] + 1;
			
			int count = 0;
			for(int s = 0; s < c.length-1; s++){
				if(c[s] >= c[c.length-1]) count++;
			}			
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println((count + 1));
						
		}
	}
		
	
	
	public static void main(String[] args) {
		new TournamentTest();
	}
	
	   
		

}
