class Loop
{
	public static void main(String args[]){

	
		//���� 5�� : 5 4 3 2 1
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
			
		}//while���� ����ȣ�� ������ �� ���ǽ����� �б�!

		System.out.println("sum = " + sum);
		System.out.println("su = " + su);

		int a = 0;

		do{

			System.out.print(a+" ");
			a++;

		} while(a <= 10);

		System.out.println();

		//�ݺ����� �� �� {}�� �Ƚ��൵ �ȴ�. ��, �� ������ ��츸.
		for(int k = 0 ; k < 3; k++) System.out.println("�ȳ� KOSTA~!!");

	}//main
}