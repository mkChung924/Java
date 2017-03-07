package com.question.java;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

public class Web {
	public static void main(String args[]) throws IOException, URISyntaxException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String uri = "";
		System.out.println("���ϴ� Ȩ�������� �̵��մϴ�. ��ȣ�� �����ϼ���.\n1.Naver\n2.Daum\n3.Nate\n4.Facebook\n����: ");
		String choice = br.readLine().trim();
		boolean num = choice.matches("[1-9]");
		if(num){
			switch(choice){
			
			case "1":
				uri = "http://naver.com";
				break;
				
			case "2": 
				uri = "http://daum.net";
				break;
				
			case "3":
				uri = "http://nate.com";
				break;
				
			case "4":
				uri = "http://facebook.com";
				break;
				
			default: break;
			}
			Desktop.getDesktop().browse(new URI(uri));
		} else {
			System.out.println("Select only a number.");
		}
	}

}
