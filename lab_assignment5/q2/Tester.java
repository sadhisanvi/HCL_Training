package lab_assignment5.q2;

import java.util.Random;

class SumofRandomNumbers implements Runnable {

	private int sum;

	public SumofRandomNumbers(int sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		getSum(sum);
	}

	public int getSum(int sum) {

		Random random = new Random();
		int value = random.nextInt(10) + 1;
		System.out.println("Random number is " + value);
		this.sum += value;
		synchronized (this) {
			return this.sum;
		}
	}
	
	public int getSum() {
		return sum;
	}

}

public class Tester {

	public static void main(String[] args) {

		int sum = 0;
		System.out.println("main starts");
		SumofRandomNumbers randomSum = new SumofRandomNumbers(sum);
		Thread thread1 = new Thread(randomSum);
		Thread thread2 = new Thread(randomSum);
		Thread thread3 = new Thread(randomSum);
		Thread thread4 = new Thread(randomSum);
		Thread thread5 = new Thread(randomSum);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();

		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Sum: " + randomSum.getSum());

		System.out.println("main ends");
	}

}
