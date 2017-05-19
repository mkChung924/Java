package acom.sds.samsung;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class AngleTest {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;

		TC = sc.nextInt();
		for (test_case = 1; test_case <= TC; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�.
			double a = sc.nextInt();
			double b = sc.nextInt();
			double c = sc.nextInt();
			double d = sc.nextInt();
			double e = sc.nextInt();
			a=a*a;b=b*b;c=c*c;d=d*d;e=e*e;
			
			int n = sc.nextInt();
			double PI = Math.PI;
			int pointList[] = { 8, 16, 7, 19, 3, 17, 2, 15, 10, 6, 13, 4, 18, 1, 20, 5, 12, 9, 14, 11 };
			// 8:-19Pi/20~-17Pi/20
			// ...
			// 14: 17Pi/20~ 19Pi/20
			// 11:19Pi/20~Pi, -Pi~-19Pi/20
			double limList[] = new double[pointList.length];
			ArrayList<Point> shotList = new ArrayList<Point>(n);
			ArrayList<Integer> grades = new ArrayList<Integer>(n);
			
			for(int i=0;i<pointList.length;i++){//��谪 �ʱ�ȭ
				limList[i] = (-19+2*i)*PI/20;
			}//limList[0]���ϴ� 11��.
			for (int i = 0; i < n; i++) {//Ÿ������ �ʱ�ȭ
				shotList.add(new Point(sc.nextInt(), sc.nextInt()));
			} // �����³�??
			
			for (int i=0;i<n;i++) {
				// Ÿ������ ���� ����.
				Point shot = shotList.get(i);
				double y = shot.y;
				double x = shot.x;
				double rad = Math.atan2(y,x);
				// ������ ���� ����.
				int grade=0;
				for(int j =0;j<limList.length;j++){
					if(rad>limList[j]){
						grade = pointList[j];
					}
				}
				if(grade==0) grade = 11;
				
				//���� �Ÿ��� ������� ����.
				double dis = x*x+y*y;
				if(dis<a)
					grade = 50;
				else if(dis<b){}
				else if(dis<c)
					grade = grade*3;
				else if(dis<d){}
				else if(dis<e)
					grade = grade*2;
				else
					grade = 0;
				grades.add(grade);
			}
			int ans=0;
			for(int grade:grades){
				ans+=grade;
			}

			System.out.println("Case #" + test_case);
			System.out.println(ans);
		}

	}

}
