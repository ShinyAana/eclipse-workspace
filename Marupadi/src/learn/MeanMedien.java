package learn;
import java.util.Scanner;

public class MeanMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeanMedian m = new MeanMedian();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
	
		m.sort(a, n);
		float mean = (float) sum / n;
		float median = (n % 2 == 1) ? a[n / 2] : (float)(a[n / 2] + a[(n / 2) - 1]) / 2;
		System.out.println(mean + " " + median);
		m.findPairs(mean, median, a, n);

	}

	private void findPairs(float mean, float median, int[] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				float sum = a[i] + a[j];
				if (sum < mean && sum > median) {
					System.out.print("(" + a[j] + "," + a[i] + ")");
				}
			}
		}

	}

	private void sort(int[] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					a[i] = a[i] + a[j];
					a[j] = a[i] - a[j];
					a[i] = a[i] - a[j];
				}
			}
		}

	}

}
public class MeanMedien {

}
