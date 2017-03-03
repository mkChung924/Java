package com.kosta.j0302;

//int su[] = {1,2,3,4,5};
//����1. �� �迭�� �����͸� ���ʴ�� ���
//����2. �� �迭�� �����͸� �������� ���
//����3. int su2[][] = {{1},{1,2},{1,2,3}}; �迭�� �����͸� �������� �Բ� ��� ��) su2[0][0] = 1
//����4. int su[]={1,2,3,4,5}; su3�̶�� �迭�� ���� su�迭�� ���� ����.
//  int su3[];
//        su3 = su; (x) // new int[5];
//    su3[2]=33;
//   syso su[2] --->3��µǵ���!!
//���� 5. int su[]={1,2,3,4,5};
//--> for���� ���� [0]����~[4]�������� ����� ���� �� 5 4 3 2 1 �� ���� ��µǵ��� �Ͻÿ�.
//

public class DailyPractice {
	
	public static void main(String args[]){
		
		DailyPractice dp = new DailyPractice();
		
		// 1��
		System.out.println("int su[] = {1,2,3,4,5}");
		System.out.println("# ����1. �� �迭�� �����͸� ���ʴ�� ���");
		int su[] = {1,2,3,4,5};
		for(int i = 0; i < su.length; i++){
			System.out.print(su[i]);
			if(i < su.length - 1){
				System.out.print(", ");
			}
		}
		
		// 2��
		System.out.println();
		System.out.println("# ����2. �� �迭�� �����͸� ������ ���");
		for(int i = su.length - 1; i >= 0; i--){
			System.out.print(su[i]);
			if(i > 0){
				System.out.print(", ");
			}
		}
		
		//3��
		System.out.println();
		System.out.println("# ����3. int su2[][] = {{1},{1,2},{1,2,3}}; �迭�� �����͸� �������� �Բ� ��� ��) su2[0][0] = 1");
		int su2[][] = {{1},{1,2},{1,2,3}};
		for(int i = 0; i < su2.length; i++){
			for(int j = 0; j < su2[i].length; j++){
				System.out.print("su2["+i+"]["+j+"] = " + su2[i][j] + "\t");
			}
			System.out.println();
		}
		
		//4��
		System.out.println();
		System.out.println("# ����4. int su[]={1,2,3,4,5}; su3�̶�� �迭�� ���� su�迭�� ���� ����.");
		int su3[] = new int[su.length];
		
		su3 = dp.copy(su3, su);
		System.out.print("su3[] = {");
		for(int i = 0; i < su3.length; i++){
			System.out.print(su3[i]);
			if(i < su3.length - 1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
		System.out.println("su[2] = " + su[2]);
		
		// 5��
		System.out.println();
		System.out.println("# ���� 5. int su[]={1,2,3,4,5}\nfor���� ���� [0]����~[4]�������� ����� ���� �� 5 4 3 2 1 �� ���� ��µǵ��� �Ͻÿ�.");	
		
		int su4[] = new int[6];
		//int su5[] = {1,2,3,4,5,6};//6�ڸ� Ȯ������
		su4 = dp.exchange(su);
		for(int i = 0; i < su.length; i++){
			System.out.print(su4[i] + " ");
		}
		
	}
	
	//�޼ҵ� ����
	public int[] copy(int num[], int num2[]){
		
		for(int i = 0; i < num.length; i++){
			num[i] = num2[i];
		}
		
		return num;
		
	}
	
	public int[] exchange(int su[]){

		for(int i = 0; i < su.length/2; i++){
			int temp;
			temp = su[i];
			su[i] = su[su.length - i - 1];
			su[su.length - i - 1] = temp;
				
		}
		
		return su;
		
	}
	

}
