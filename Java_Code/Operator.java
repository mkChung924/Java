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
		//기능1: 괄호안의 데이터 출력, 기능2: 라인바꿈 (ln == line new)
		System.out.print("");
		//기능1: 괄호안의 데이터 출력

		int year = 2017;
		boolean first1 = year%4 == 0;
		boolean first2 = year%100 != 0;
		boolean second = year % 400 ==0;

		//System.out.println(first1 && first2 || second);

		boolean result = first1 && first2 || second;

		if(result){
			System.out.println(year + "은 윤년입니다!!");
		}  else {
			System.out.println(year + "은 평년입니다!!");
		}

		for (int y = 1991; y <= 2017 ; y ++ )
		{
		boolean f1 = y%4 == 0;
		boolean f2 = y%100 != 0;
		boolean s = y % 400 ==0;

		boolean r = f1 && f2 || s;

		if(r){
			System.out.println(y+ "은 윤년입니다!!");
		}  else {
			System.out.println(y + "은 평년입니다!!");
		}
		}

		System.out.println();

		if(3>4){
			System.out.println("가");
			System.out.println("나");
		} else {
			System.out.println("다");
			System.out.println("라");
		}
	System.out.println("마");
	}
}