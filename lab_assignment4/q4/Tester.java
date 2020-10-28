package lab_assignment4.q4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner obj = new Scanner(System.in)) {
			while (true) {
				System.out.println("“Please enter a number or enter ‘-1’ if you want to quit");
				int num = obj.nextInt();
				if (num % 2 == -1)
					System.exit(0);
				else if (num % 2 == 0)
					System.out.println("You have entered an even number");
				else
					System.out.println("You have entered an odd number");
			}
		} catch (InputMismatchException e) {
			System.out.println("You must enter an integer.");
		}
	}
}
