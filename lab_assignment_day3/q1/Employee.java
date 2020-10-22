package lab_assignment_day3.q1;

public abstract class Employee {
	private int rate;

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public abstract int getSalary();

}
