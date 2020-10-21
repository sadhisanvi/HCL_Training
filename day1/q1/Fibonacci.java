package com.day1.q1;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		int num = obj.nextInt();
		int a = 1, b = 1;
		double x = a + b;
		int count = 2, c;
		System.out.println("The first " + num + " fibonocci numbers are: ");
		System.out.print(a + " " + b);
		while (count < num) {
			c = a + b;
			x = x + c;
			a = b;
			b = c;
			System.out.print(" " + c);
			count++;
		}
		System.out.println();
		System.out.println("The average is: " + x / num);
		obj.close();
	}
}