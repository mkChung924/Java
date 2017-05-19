package com.coding.algorithm;

import java.util.Scanner;

public class PrintTest {

	public PrintTest() {

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 100; i++) {
			String name = sc.nextLine();
			System.out.println(name);

		}

	}

	public static void main(String args[]) {
		new PrintTest();
	}

}
