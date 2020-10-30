package lab_assignment4.q7;

import java.io.IOException;

import lab_assignment4.q6.InputException;

public class Tester {

	public static void main(String[] args) {

		DemoException exception = new DemoException();
		try {
			exception.throwException();
		} catch (InputException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
