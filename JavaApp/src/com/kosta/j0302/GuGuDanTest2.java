package com.kosta.j0302;

public class GuGuDanTest2 {
	
	public static void main(String args[]){
			
		int mult;
		
		System.out.println("< ������ >");
		for(int i = 1; i < 10; i++){
			for(int j = 2; j < 10; j++){
				mult = j*i;
				String zero = "";
				if(mult < 10) zero = " ";
				System.out.print(j + "x" + i + " = " + zero + mult + "\t");
			}
			System.out.println();
		}
		
		//printf�� Ȱ��
		System.out.println("< ������ >");
		for(int i = 1; i < 12; i++){
			for(int j = 2; j < 10; j++){
				mult = j*i;
				String zero = "";
				if(mult < 10) zero = " ";
				//printf(String format, Object... args)
				//printf("%d%d",)
//				<�������>
//				%d : ����		---> %d   %3d(3�ڸ� Ȯ���� 10���� ���������� ���)   %-3d(�ڸ��� Ȯ���� 10���� �������� ���)
//				%f : �Ǽ�		---> %f   %5.2f(��ü�ڸ��� 5�ڸ� Ȯ��, �Ҽ��� ���� �� �ڸ����� ���)
//				%s : ���ڿ�	---> 
//				%c : ����
				
				System.out.printf("%d*%2d = %-3d  ",j,i,(j*i));
				//System.out.printf(j + "x" + i + " = " + zero + mult + "\t");
			}
			System.out.println();
		}
			
	}

}
