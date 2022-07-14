package mockInterview;

import java.util.Arrays;
import java.util.Scanner;

public class FindArrayPairs {

	public static void main(String[] args) {
		FindArrayPairs object = new FindArrayPairs();
		object.findPairs();
	}

	private void findPairs() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array size");
		int size = input.nextInt();
		int[] inputArray = new int[size];
		System.out.println("Enter array elements ");
		for (int i = 0; i < size; i++) {
			inputArray[i] = input.nextInt();
		}
		System.out.println("Enter the divisor");
		int divisor = input.nextInt();
		int[] result = new int[2];
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (inputArray[i] > inputArray[j]) {
					int temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
				}
			}

		}
		System.out.println("Array pairs");
		for (int k = 0; k < size; k++) {
			for (int l = k + 1; l < size; l++) {
				if ((inputArray[k] + inputArray[l]) % divisor == 0) {
					result[0] = inputArray[k];
					result[1] = inputArray[l];
					System.out.println(Arrays.toString(result));
					break;
				}
			}
		}

	}
}