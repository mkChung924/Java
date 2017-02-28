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
		//주민번호를 입력받아 화면에 나이를 출력
		//입력데이터 : 910924 - 119040
		//2017 - (1900+90) - 1
		
		//현재년도 얻어오기(자바날짜관련 : Date, Calendar);
		
		//Calendar cal = new GregorianCalendar();
		Calendar c = Calendar.getInstance();
				//객체 c에는 날짜에 관련된 모든 정보가 저장되어 있음!
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		
		InputStream is = System.in; //바이트 입력(키보드입력)
		Reader r = new InputStreamReader(is); //바이트를 문자로 변환
		BufferedReader br = new BufferedReader(r); //문자를 버퍼에 저장
		
		System.out.println("오늘은 " + year + "년 " + month + "월 " + day + "일입니다.");
		System.out.print("그대의 주민번호를 입력하세요.예)910924-1234567\n주민번호: ");
		String num = br.readLine();
		//String num = "910-1199040";
		JuminCal(num);
		
		
	}
	
	static void JuminCal(String a){
				
		boolean bool = true;
		
		Calendar c = Calendar.getInstance();
		//객체 c에는 날짜에 관련된 모든 정보가 저장되어 있음!

		int cyear = c.get(Calendar.YEAR);
		int cmonth = c.get(Calendar.MONTH);
		int cday = c.get(Calendar.DAY_OF_MONTH);
		
		int fullYear = 0;
		int age = 0;
		String sex ="";
		String place ="";
		String country = "";
		
		if(a.length() < 14){
			System.out.print("잘못된 주민등록번호입니다.");
			bool = false;
		}
		
		String year = a.substring(0,2);
		String month = a.substring(2,4);
		String day = a.substring(4,6);
		String gender = a.substring(7,8);
		//charAt을 사용해서 char값을 받을 수도 있으나 난 별
		String area = a.substring(8,10);
		
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);
		int g = Integer.parseInt(gender);
		int ar = Integer.parseInt(area);
	
		
		if(g == 1 || g == 3 || g == 5 || g == 7){sex = "남자";}
		else if(g == 2 || g == 4 || g == 6 || g == 8){sex = "여자";}
		else {sex = "외계인";}
		
		if(g <= 4 ){country = "내국인";}
		else if(g >= 5 ){country = "외국인";}
		else{country = "외계인";}
		
		if(g == 1 || g == 2 || g == 5 || g == 6){
			if(y < 10){
				System.out.print("잘못된 주민등록번호입니다.");
				bool = false;
				
			} else {
			fullYear = 1900 + y ;
			}
		} else if(g == 3 || g == 4 || g==6 || g==8){
			fullYear = 2000 + y ;
		} else {
			System.out.print("잘못된 주민등록번호입니다.");
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
		
		if(ar >= 0 && ar <=8){place = "서울";}
		else if(ar >= 9 && ar <= 12){place = "부산";}
		else if(ar >= 13 && ar <= 15){place = "인천";}
		else if(ar >= 16 && ar <= 25){place = "경기도";}
		else if(ar >= 23 && ar <= 34){place = "강원도";}
		else if(ar >= 35 && ar <= 39){place = "충청북도";}
		else if(ar >= 40 && ar <= 47){place = "충청남도";}
		else if(ar >= 48 && ar <= 54){place = "전라북도";}
		else if(ar >= 55 && ar <= 56){place = "전라남도";}
		else if(ar >= 67 && ar <= 90){place = "경상도";}
		else {place ="대한민국 어딘가";}
		
		//System.out.println(year+month+day+gender);
		//System.out.println(fullYear);
		if(m == cmonth + 1){
			if(d == cday){
				System.out.println("★생일 축하합니다!♬");
			}
		}
		
		if(bool){
			System.out.println("#######추적된 데이터#######");
			System.out.println("생년월일: "+ fullYear+"년 " + m + "월 " + d + "일");
			System.out.println("국적: " + country);
			System.out.println("출생지: " + place);
			System.out.println("성별: " + sex);
			System.out.println("나이: " + age);
			
			}
		else {
			System.out.println(" ㅂㅂ");
		}
		

		
	}

}
