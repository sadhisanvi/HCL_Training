package lab_assignment4.q7;

import java.io.IOException;
import java.util.Scanner;

public class Tester {

	public static void throwException() throws InputException, IOException {

	}

	public static void main(String[] args) {
		try(Scanner obj = new Scanner(System.in)) {
			throwException();
		} catch (InputException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
