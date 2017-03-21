package com.kosta.j0321;

public class ASCIITest {
	//아스키 코드(각 문자에 대해 컴퓨터가 인식하는 십진수)에 매핑되는 문자를 화면에 출력

	public static void main(String[] args) {
		for(int i = 32; i < 127; i++){// i = 아스키코드
			System.out.write(i);
			if(i%8 == 7) System.out.write('\n');//8개 문자를 출력한 후 라인 변경
			else System.out.write('\t');//각 문자는 탭으로 출력
			
		}
		System.out.close();
	}

}
