class Operator{

	public static void main(String args[]){

		int a = 10;
		int b;
		b=3;

		System.out.println(10/5);
		System.out.println(10/3);
		System.out.println(10/(double)3);
		System.out.println(10%3);

		System.out.println(a+"+"+b +" = " + (a+b));
		System.out.println(a+"-"+b +" = " + (a-b));
		System.out.println(a+"/"+b +" = "+ (a/b));
		System.out.println(a+"/"+b +" = "+ (a/(double)b));
		System.out.println(a+"*"+b +" = "+ (a*b));

		System.out.println(a++);
		System.out.println(a);
		System.out.println(++a);
		System.out.println(a--);
		System.out.println(--a);
		System.out.println(a);

		int su1 = 5, su2 = 5;
		int sum1 = 0, sum2 = 0;

		sum1 = su1++;
		sum2 = ++su2;

		System.out.println("sum1 : "+sum1 +", su1 : "+su1 );
		System.out.println("sum2 : " + sum2 +", su2 : " + su2);

		if(true || false){
			System.out.println("1");
		}

		System.out.println();
		//���1: ��ȣ���� ������ ���, ���2: ���ιٲ� (ln == line new)
		System.out.print("");
		//���1: ��ȣ���� ������ ���

		int year = 2017;
		boolean first1 = year%4 == 0;
		boolean first2 = year%100 != 0;
		boolean second = year % 400 ==0;

		//System.out.println(first1 && first2 || second);

		boolean result = first1 && first2 || second;

		if(result){
			System.out.println(year + "�� �����Դϴ�!!");
		}  else {
			System.out.println(year + "�� ����Դϴ�!!");
		}

		for (int y = 1991; y <= 2017 ; y ++ )
		{
		boolean f1 = y%4 == 0;
		boolean f2 = y%100 != 0;
		boolean s = y % 400 ==0;

		boolean r = f1 && f2 || s;

		if(r){
			System.out.println(y+ "�� �����Դϴ�!!");
		}  else {
			System.out.println(y + "�� ����Դϴ�!!");
		}
		}

		System.out.println();

		if(3>4){
			System.out.println("��");
			System.out.println("��");
		} else {
			System.out.println("��");
			System.out.println("��");
		}
	System.out.println("��");
	}
}