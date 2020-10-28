package lab_assignment4.q5;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner obj = new Scanner(System.in)) {
			System.out.println("Enter number : ");
			int num = obj.nextInt();
			if (num > 100)
				throw new Exception();
		} catch (Exception e) {
			System.out.println("Number can't be greater than 100");
		}
	}

}
