package lab_assignment_day3.q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			Employee employee;
			System.out.println("Enter 1: To get SalariedEmployee salary ");
			System.out.println("Enter 2: To get HourlyEmployee salary ");
			System.out.println("Enter 3: To get ComissionEmployee salary ");
			char choice1 = sc.next().charAt(0);
			switch (choice1) {
			case '1':
				employee = new SalariedEmployee(10000);
				System.out.println(employee.getSalary());
				break;
			case '2':
				employee = new HourlyEmployee(1000, 10);
				System.out.println(employee.getSalary());
				break;
			case '3':
				employee = new CommissionEmployee(50, 200);
				System.out.println(employee.getSalary());
				break;
			default:
				break;
			}
			break;
		case 2:
			Employee employee1;
			employee1 = new SalariedEmployee(1000);
			employee1.setRate((2) * employee1.getSalary());
			System.out.println(employee1.getRate());

			employee1 = new HourlyEmployee(1000, 12);
			employee1.setRate((2 * employee1.getSalary()));
			System.out.println(employee1.getRate());

			employee1 = new CommissionEmployee(1000, 50);
			employee1.setRate((2) * employee1.getSalary());
			System.out.println(employee1.getRate());
			break;
		default:
			break;

		}

		sc.close();
	}
}
