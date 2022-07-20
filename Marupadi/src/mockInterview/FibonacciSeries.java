package mockInterview;

public class FibonacciSeries {

	public static void main(String[] args) {
		FibonacciSeries object = new FibonacciSeries();
		object.startProcess();
	}

	private void startProcess() {
		System.out.println("First 10 fibonacci numbers that are prime");
		int a, b, c, count = 0;
		a = 1;
		b = 1;

		for (int i = 3; i <= 50; ++i) {
			c = a + b;
			count = 0;
			for (int j = c; j >= 1; j--) {
				if (c % j == 0) {
					count++;
				}
			}
			if (count == 2) {
				System.out.println(c + " ");

			}
			a = b;
			b = c;
		}
	}

}
