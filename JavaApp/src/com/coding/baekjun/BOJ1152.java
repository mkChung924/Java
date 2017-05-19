package com.coding.baekjun;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();

		int count = 0;
		StringTokenizer st = new StringTokenizer(a, " ");
		while(st.hasMoreElements()){
			st.nextToken();
			count++;
		}
		System.out.println(count);
	}
}
