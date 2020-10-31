package lab_assignment6.q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {
		Scanner sc = null;
		double max = 0.0;
		List<Double> list = new ArrayList<>();
		try {
			File file = new File("data.txt");
			sc = new Scanner(file);

			while (sc.hasNext()) {
				list.add(Double.parseDouble(sc.nextLine()));
			}
			max = list.get(0);
			for (int i = 1; i < list.size(); i++) {

				if (list.get(i) > max) {
					max = list.get(i);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println(max);
	}
}
