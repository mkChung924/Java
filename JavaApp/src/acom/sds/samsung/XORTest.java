package acom.sds.samsung;

import java.util.Scanner;

public class XORTest {
	
	Scanner scan;
	
	public XORTest() {
		
		
		scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.nextLine();
		String c = scan.nextLine();
		String d[] = c.split(" ");
		
		int xor = 0;
		
		for(int i = 0; i < b; i ++){
			
			xor = xor^Integer.parseInt(d[i]);
		}
		
		
		
		
		
		System.out.println(xor);
		
	}
	
	public static void main(String[] args) {
		new XORTest();
	}

}
