package com.question.java;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.InputStreamReader;

//인터넷 URL에서 소스파일 읽어오기//

public class Practice01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			
			URL mySite = new URL("http://www.7iron.co.kr");
			URLConnection yc = mySite.openConnection();
			Scanner in = new Scanner(new InputStreamReader(yc.getInputStream()));
					int count = 0;
			while(in.hasNext()){
				System.out.println(in.next());
				count++;
			}
			System.out.println("Number of tokens: " + count);
			in.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
