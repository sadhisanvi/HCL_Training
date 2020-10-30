package lab_assignment4.q1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tester {

	public static void main(String[] args) {

		// BufferedReader br = null;
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("data.txt");
			// br = new BufferedReader(new FileReader(new File("data.txt")));
			int line = 0;
			while ((line = fis.read()) != -1) {
				System.out.print((char) line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
