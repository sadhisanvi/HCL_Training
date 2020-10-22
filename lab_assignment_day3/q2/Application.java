package lab_assignment_day3.q2;

public class Application {
	public static void main(String[] args) {
		Invoice invoice = new Invoice("1", "bag", 2, 200.0);
		double k = invoice.getPayment();
		System.out.println(k);
	}
}
