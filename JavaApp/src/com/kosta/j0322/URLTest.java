package com.kosta.j0322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.naver.com");
							//프로토콜	호스트		경로, 파일
			
			System.out.println("프로토콜: " +url.getProtocol());
			System.out.println("호스트: " + url.getHost());
			System.out.println("서비스파일명: " + url.getFile());
			
			InputStream is = url.openStream();
			FileOutputStream fos = new FileOutputStream("test.html");
			
			InputStreamReader br = new InputStreamReader(is, "utf-8");
			OutputStreamWriter bw = new OutputStreamWriter(fos,"utf-8");
			//소스 긁어오기
			
			char ch[] = new char[512];
			int i;
			while((i = br.read(ch)) != -1){
				bw.write(ch, 0, i);
			}
			
//			BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
//			
//			String str;
//			while((str = br.readLine()) != null){
//				//System.out.println(str);
//				bw.write(str+"\n");
//			}
			
			bw.close();
			br.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
