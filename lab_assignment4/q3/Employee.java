package lab_assignment4.q3;

import java.io.Serializable;

class Employee implements Serializable {
	private int id;
	private String name;
	private String address;
	private transient double salary;

	public Employee(int id, String name, String address, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", salary=");
		builder.append(salary);
		builder.append("]");
		return builder.toString();
	}

}
