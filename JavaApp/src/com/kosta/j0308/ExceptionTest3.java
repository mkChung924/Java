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
			System.out.println("�Ű������� ���� ���� �ΰ��� ��");
		int su1 = Integer.parseInt(args[0]);//ArrayIndexOutOfBoundsException, NumberFormatException
		int su2 = Integer.parseInt(args[1]);//ArrayIndexOutOfBoundsException, NumberFormatException
		System.out.println("su1 = "+ su1 + ", su2 = " + su2);
		System.out.println("su1�� su2�� ���� �� = " + (su1/su2));//ArithmeticException
		System.out.println("�������� ��Ȱ�� �����Ͽ����ϴ�.");
		
		} catch(ArrayIndexOutOfBoundsException e){
			//catch�� �ڽĺ��� �����ؾ��Ѵ�. Exception�� ��� ������ �θ�.
		} catch(Exception e){
			System.out.println("��� ���ܿ� ���� ó��~!!");
		}
		
/*		} catch(ArrayIndexOutOfBoundsException e){
			System.out.println("=> #�迭�� ������ ������ϴ�.");
		} catch(NumberFormatException e){
			System.out.println("=> #���ڸ� �Է��ϼ���.");
		} catch(ArithmeticException e){
			System.out.println("=> #Ȥ�� 0���� ��������? ���� �� ���ؿ�~");
			return;//return;�� �ִ� ��� try~catch ������ main�� ������.
		} */
		
		finally {
			System.out.println("I am finally! finally : �ݵ�� ���� ����!!");
		}
		
		//try~catch��
		System.out.println("������ ����!");
		
	}

}
