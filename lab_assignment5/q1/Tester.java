package lab_assignment5.q1;

class MyJob implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i <= 100; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

}

public class Tester {

	public static void main(String[] args) {

		MyJob job = new MyJob();
		Thread thread1 = new Thread(job, "Thread1");
		Thread thread2 = new Thread(job, "Thread2");
		Thread thread3 = new Thread(job, "Thread3");

		thread1.start();
		thread2.start();
		thread3.start();

	}

}
