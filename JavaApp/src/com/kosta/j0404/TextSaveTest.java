package com.kosta.j0404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextSaveTest {
	
	public String itemFilePath  = "Items.txt";
	
	BufferedWriter bw;
	BufferedReader br;
	
	public int itemCost[] = new int[]{ 500, 900, 1100, 1000 };
	public int itemCount[] = new int[]{ 10, 10, 10, 10 };
	
	public TextSaveTest() {
		
		try {
			br = new BufferedReader(new FileReader(itemFilePath));
			String contents = br.readLine();
			String a[] = contents.split(" ");
			
			System.out.println(a[0] +" " + a[1]);
			
			br.close();
			
			bw = new BufferedWriter(new FileWriter(itemFilePath));
			bw.write(contents);
			
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("¿Ï·á!");
		
		
	}
	
	public static void main(String[] args) {
		new TextSaveTest();
	}

}
