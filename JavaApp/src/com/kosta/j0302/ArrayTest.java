package com.kosta.j0302;

public class ArrayTest {
	public static void main(String args[]){
		//int su[];
		//	  su[] = {11,22,33}; //����: �迭�ʱⰪ�� �ݵ�� ����� �Բ� �ؾ� ��.
		int su[] = {11,22,33,44,55};
		
		//�迭 ���� �����͸� ���!!
		System.out.println(su[0]); //ù��° ������
		System.out.println(su[1]); //�ι�° ������
		System.out.println(su[2]); //����° ������
		
		System.out.println("�迭�� ũ��(��Ұ���): " + su.length);
		
		for(int i = 0; i < su.length; i++){
			System.out.println("su["+i+"]���� = " + su[i]);
		}
		
			/*main() �޼ҵ��� args[]�迭�� ���
			 * java ArrayTest ����
			 * String args[] = {};
			 * java ArrayTest "ȫ�浿" "�����" "���ֿ�" ����
			 * String args[]={"ȫ�浿", "�����", "���ֿ�"};
			 * java ArrayTest �浿 ���� �ֿ� ����
			 * String args[]={"�浿", "����", "�ֿ�"};*/
		
		for(int i = 0; i<args.length; i++){
			System.out.println("args["+i+"]���� = " + args[i]);
			System.out.println(Integer.parseInt(args[i]) + 10);
		}
		
		//�� 		  [0]	[1]		[2]
		int su2[][]= {{1}, {2,3}, {4,5,6}};
		//��			  [0]  [0][1] [0][1][2]
		System.out.println("su2�迭�� ũ��: "+su2.length);//���� ���� ���
		System.out.println("su2[1]������ ũ��: " + su2[1].length);//su2[1]������ ũ
		//System.out.println(su2[1][1]);
		
		for(int i = 0; i < su2.length; i++){
			for(int j = 0; j < su2[i].length; j++){
				System.out.print("su2["+i+"]["+j+"]���� = "+su2[i][j] + " ");
			}
			System.out.println();
		}

	}

}
