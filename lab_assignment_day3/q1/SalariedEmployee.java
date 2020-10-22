package lab_assignment_day3.q1;

public class SalariedEmployee extends Employee implements IncreaseSalary, Payable{

	private int salary;

	public SalariedEmployee(int salary) {
		this.salary = salary;
	}

	@Override
	public int getSalary() {
		System.out.println("Salary of salaried employee: ");
		return salary;
	}

	@Override
	public int increasedSalary() {
		return 5;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [salary=" + salary + "]";
	}
	
	@Override
	public double getPayment() {
		return salary;
	}
}