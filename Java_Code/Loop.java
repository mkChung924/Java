class Loop
{
	public static void main(String args[]){

	
		//문제 5번 : 5 4 3 2 1
		for(int i = 5; i > 0; i--){

			System.out.print(i+" ");
		}

		System.out.println();

		int sum = 0;
		int su = 1;

		boolean flag = true;
		while(flag){

			sum += su;

			System.out.println("su = " + su + ", sum = " + sum);
			if(su == 5) {break;}
			su++;
			
		}//while문의 끝괄호를 만났을 시 조건식으로 분기!

		System.out.println("sum = " + sum);
		System.out.println("su = " + su);

		int a = 0;

		do{

			System.out.print(a+" ");
			a++;

		} while(a <= 10);

		System.out.println();

		//반복문을 쓸 때 {}를 안써줘도 된다. 단, 한 문장일 경우만.
		for(int k = 0 ; k < 3; k++) System.out.println("안녕 KOSTA~!!");

	}//main
}