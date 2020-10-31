package lab_assignment6.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class DemoWordFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File("story.txt")))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				String tokens[] = line.split(" ");
				for (String token : tokens) {
					if (map.containsKey(token)) {
						Integer freq = map.get(token);
						map.put(token, ++freq);
					} else {
						map.put(token, 1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		Set<Entry<String, Integer>> entry = map.entrySet();
		for (Entry<String, Integer> entryset : entry) {
			System.out.println(entryset.getKey() + " : " + entryset.getValue());
		}
	}

}
