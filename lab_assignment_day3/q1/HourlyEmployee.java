package lab_assignment_day3.q1;

public class HourlyEmployee extends Employee implements IncreaseSalary, Payable {
	private int salaryPerHour;
	private int numOfHours;
	public HourlyEmployee(int salary, int numOfHours) {
		this.salaryPerHour = salary;
		this.numOfHours = numOfHours;
	}
	@Override
	public int getSalary() {
		System.out.println("Salary of Hourly employee :");		
		return salaryPerHour * numOfHours;
	}
	@Override
	public int increasedSalary() {
		return 5;
	}
	@Override
	public double getPayment() {
		return salaryPerHour * numOfHours;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HourlyEmployee [salaryPerHour=");
		builder.append(salaryPerHour);
		builder.append(", numOfHours=");
		builder.append(numOfHours);
		builder.append(", salary=");
		builder.append(salaryPerHour*numOfHours);
		builder.append("]");
		return builder.toString();
	}

}

