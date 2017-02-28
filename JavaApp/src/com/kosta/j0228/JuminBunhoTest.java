package com.kosta.j0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class JuminBunhoTest {
	public static void main(String args[]) throws IOException{
		//�ֹι�ȣ�� �Է¹޾� ȭ�鿡 ���̸� ���
		//�Էµ����� : 910924 - 119040
		//2017 - (1900+90) - 1
		
		//����⵵ ������(�ڹٳ�¥���� : Date, Calendar);
		
		//Calendar cal = new GregorianCalendar();
		Calendar c = Calendar.getInstance();
				//��ü c���� ��¥�� ���õ� ��� ������ ����Ǿ� ����!
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		InputStream is = System.in; //����Ʈ �Է�(Ű�����Է�)
		Reader r = new InputStreamReader(is); //����Ʈ�� ���ڷ� ��ȯ
		BufferedReader br = new BufferedReader(r); //���ڸ� ���ۿ� ����
		
		System.out.println("������ " + year + "�� " + month + "�� " + day + "���Դϴ�.");
		System.out.print("�״��� �ֹι�ȣ�� �Է��ϼ���.��)910924-1234567\n�ֹι�ȣ: ");
		String num = br.readLine();
		//String num = "910-1199040";
		JuminCal(num);
		
		
	}
	
	static void JuminCal(String a){
				
		boolean bool = true;
		
		Calendar c = Calendar.getInstance();
		//��ü c���� ��¥�� ���õ� ��� ������ ����Ǿ� ����!

		int cyear = c.get(Calendar.YEAR);
		int cmonth = c.get(Calendar.MONTH);
		int cday = c.get(Calendar.DAY_OF_MONTH);
		
		int fullYear = 0;
		int age = 0;
		String sex ="";
		String place ="";
		String country = "";
		
		if(a.length() < 14){
			System.out.print("�߸��� �ֹε�Ϲ�ȣ�Դϴ�.");
			bool = false;
		}
		
		String year = a.substring(0,2);
		String month = a.substring(2,4);
		String day = a.substring(4,6);
		String gender = a.substring(7,8);
		String area = a.substring(8,10);
		
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);
		int g = Integer.parseInt(gender);
		int ar = Integer.parseInt(area);
	
		
		if(g == 1 || g == 3 || g == 5 || g == 7){sex = "����";}
		else if(g == 2 || g == 4 || g == 6 || g == 8){sex = "����";}
		else {sex = "�ܰ���";}
		
		if(g == 1 || g == 2 || g == 3 || g == 4 ){country = "������";}
		else if(g == 5 || g==6 || g==7 || g==8){country = "�ܱ���";}
		else{country = "�ܰ���";}
		
		if(g == 1 || g == 2 || g == 5 || g == 6){
			if(y < 10){
				System.out.print("�߸��� �ֹε�Ϲ�ȣ�Դϴ�.");
				bool = false;
				
			} else {
			fullYear = 1900 + y ;
			}
		} else if(g == 3 || g == 4 || g==6 || g==8){
			fullYear = 2000 + y ;
		} else {
			System.out.print("�߸��� �ֹε�Ϲ�ȣ�Դϴ�.");
			bool = false;
		}
		
			
		if(m < (cmonth+1)){
			age = cyear - fullYear + 1;
		} else{
			if(d >= cday){
				age = cyear - fullYear + 1;
			} else {
				age = cyear - fullYear;
			}
		}
		
		if(ar >= 0 && ar <=8){place = "����";}
		else if(ar >= 9 && ar <= 12){place = "�λ�";}
		else if(ar >= 13 && ar <= 15){place = "��õ";}
		else if(ar >= 16 && ar <= 25){place = "��⵵";}
		else if(ar >= 23 && ar <= 34){place = "������";}
		else if(ar >= 35 && ar <= 39){place = "��û�ϵ�";}
		else if(ar >= 40 && ar <= 47){place = "��û����";}
		else if(ar >= 48 && ar <= 54){place = "����ϵ�";}
		else if(ar >= 55 && ar <= 56){place = "���󳲵�";}
		else if(ar >= 67 && ar <= 90){place = "���";}
		else {place ="���ѹα� ���";}
		
		//System.out.println(year+month+day+gender);
		//System.out.println(fullYear);
		if(m == cmonth + 1){
			if(d == cday){
				System.out.println("�ڻ��� �����մϴ�!��");
			}
		}
		
		if(bool){
			System.out.println("#######������ ������#######");
			System.out.println("�������: "+ fullYear+"�� " + m + "�� " + d + "��");
			System.out.println("����: " + country);
			System.out.println("�����: " + place);
			System.out.println("����: " + sex);
			System.out.println("����: " + age);
			
			}
		else {
			System.out.println(" ����");
		}
		

		
	}

}
