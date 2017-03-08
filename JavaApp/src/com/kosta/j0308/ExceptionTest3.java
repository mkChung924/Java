package com.kosta.j0308;

public class ExceptionTest3 {
	public static void main(String args[]){
		
		/*
		 * args[0]		args[1]
		 * --------------------
		 * "10"				"5"
		 * "10"		 		"0"
		 * "ab"				"cd"
		 * "10"				
		 */
		
		try{
			System.out.println("매개변수를 통해 받은 두개의 수");
		int su1 = Integer.parseInt(args[0]);//ArrayIndexOutOfBoundsException, NumberFormatException
		int su2 = Integer.parseInt(args[1]);//ArrayIndexOutOfBoundsException, NumberFormatException
		System.out.println("su1 = "+ su1 + ", su2 = " + su2);
		System.out.println("su1을 su2로 나눈 몫 = " + (su1/su2));//ArithmeticException
		System.out.println("나눗셈을 원활히 수행하였습니다.");
		
		} catch(ArrayIndexOutOfBoundsException e){
			//catch는 자식부터 나열해야한다. Exception은 모든 예외의 부모.
		} catch(Exception e){
			System.out.println("모든 예외에 대한 처리~!!");
		}
		
/*		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("=> #배열의 범위를 벗어났습니다.");
		} catch(NumberFormatException e){
			System.out.println("=> #숫자만 입력하세요.");
		} catch(ArithmeticException e){
			System.out.println("=> #혹시 0으로 나눴나요? 수학 잘 못해요~");
			return;//return;이 있는 경우 try~catch 끝내고 main이 정지됨.
		} */
		
		finally {
			System.out.println("I am finally! finally : 반드시 실행 문장!!");
		}
		
		//try~catch끝
		System.out.println("마지막 문장!");
		
	}

}
