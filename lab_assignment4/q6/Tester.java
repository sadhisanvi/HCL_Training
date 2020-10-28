package lab_assignment4.q6;

import java.util.Scanner;

public class Tester {

	public static void Test(int num) throws InputException {

		if (num > 100) {
			throw new InputException("“Number can’t be greater than 100");
		}
	}

	public static void main(String[] args) {

		try (Scanner obj = new Scanner(System.in)) {
			System.out.println("Enter number :");
			int num = obj.nextInt();
			Test(num);
		} catch (InputException e) {
			System.out.println(e.getMessage());
		}
	}

}
