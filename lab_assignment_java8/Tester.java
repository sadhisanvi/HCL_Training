package lab_assignment_java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Tester {
	public static void main(String args[]) {

		List<Transaction> transactions = getAllTransactions();

		// 1. Find all transactions in the year 2011 and sort them by value (small to
		// high)

		List<Transaction> allTransactionsIn2011 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

		allTransactionsIn2011.forEach(t -> System.out.println(t));

		// 2. What are all the unique cities where the traders work?

		List<Trader> getTraders = transactions.stream().map(t -> t.getTrader()).collect(Collectors.toList());
		List<String> getUniqueCities = getTraders.stream().map(t -> t.getCity()).distinct()
				.collect(Collectors.toList());

		getUniqueCities.forEach(city -> System.out.println(city));
		;

		// 3. Find all traders from delhi and sort them by name.

		List<Trader> getAllTradersFromDelhi = getTraders.stream().filter(t -> t.getCity().equals("delhi"))
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());

		getAllTradersFromDelhi.forEach(traders -> System.out.println(traders));

		// 4. Return a string of all traders names sorted alphabetically.
		List<String> stringOfAllTradersNames = getTraders.stream()
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).map(t -> t.getName())
				.collect(Collectors.toList());

		stringOfAllTradersNames.forEach(trader -> System.out.print(trader + " "));

		// 5. Are any traders based in Jaipur?
		System.out.println("Are any traders based in Jaipur...");
		boolean anyTradersFromJaipur = getTraders.stream().anyMatch(t -> t.getCity().equals("jaipur"));
		System.out.println(anyTradersFromJaipur);

		// 6. Print all transactions values from the traders living in delhi
		List<Integer> allTransactionsValuesOfTradersFromDelhi = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("delhi")).map(t -> t.getValue())
				.collect(Collectors.toList());

		allTransactionsValuesOfTradersFromDelhi.forEach(value -> System.out.println(value));

		// 7. Whats the highest value of all the transactions?

		OptionalInt maxValue = transactions.stream().mapToInt(t -> t.getValue()).max();
		System.out.println(maxValue);

		// 8. Find the transaction with the smallest value

		List<Transaction> transactionWithTheSmallestValue = transactions.stream()
				.sorted(Comparator.comparing(Transaction::getValue)).limit(1).collect(Collectors.toList());
		System.out.println(transactionWithTheSmallestValue);

	}

	private static List<Transaction> getAllTransactions() {
		Trader ram = new Trader("ram", "delhi");
		Trader kapil = new Trader("kapil", "noida");
		Trader raj = new Trader("raj", "banglore");
		Trader ekta = new Trader("ekta", "banglore");
		List<Transaction> transactions = Arrays.asList(new Transaction(ram, 2011, 300),
				new Transaction(ram, 2012, 1000), new Transaction(kapil, 2011, 400), new Transaction(raj, 2012, 710),
				new Transaction(ekta, 2012, 700), new Transaction(ekta, 2012, 950));

		return transactions;
	}

}
