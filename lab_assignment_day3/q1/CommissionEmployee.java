package lab_assignment_day3.q1;

public class CommissionEmployee extends Employee implements IncreaseSalary, Payable {

	private int perecentage;
	private int weeklySale;

	public CommissionEmployee(int perecentage, int weeklySale) {
		this.perecentage = perecentage;
		this.weeklySale = weeklySale;
	}

	@Override
	public int getSalary() {
		System.out.println("Salary of comission employee is ");
		return (perecentage * weeklySale) / 100;
	}

	@Override
	public int increasedSalary() {
		return 3;
	}
	
	@Override
	public double getPayment() {
		return (perecentage * weeklySale) / 100;
	}

}
