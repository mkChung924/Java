package com.kosta.j0321;

public class ASCIITest {
	//�ƽ�Ű �ڵ�(�� ���ڿ� ���� ��ǻ�Ͱ� �ν��ϴ� ������)�� ���εǴ� ���ڸ� ȭ�鿡 ���

	public static void main(String[] args) {
		for(int i = 32; i < 127; i++){// i = �ƽ�Ű�ڵ�
			System.out.write(i);
			if(i%8 == 7) System.out.write('\n');//8�� ���ڸ� ����� �� ���� ����
			else System.out.write('\t');//�� ���ڴ� ������ ���
			
		}
		System.out.close();
	}

}
