package lab_assignment4.q3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Tester {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		// Serialization
		try {
			Employee emp = new Employee(121, "manu", "visakhapatnam", 20000);
			oos = new ObjectOutputStream(new FileOutputStream("data.ser"));
			oos.writeObject(emp);
			System.out.println(emp.toString());
			System.out.println("object is Serialized");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// DeSerialization
		try {
			ois = new ObjectInputStream(new FileInputStream("data.ser"));
			Employee emp1 = (Employee) ois.readObject();
			System.out.println(emp1.toString());
			System.out.println("object is DeSerialized");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}

	}

}
