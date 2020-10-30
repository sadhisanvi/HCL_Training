package lab_assignment4.q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tester {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			String data = " ";
			br = new BufferedReader(new InputStreamReader(System.in));
			data = br.readLine();
			bw = new BufferedWriter(new FileWriter("data.txt"));
			bw.write(data);
			System.out.println("data was written to file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
