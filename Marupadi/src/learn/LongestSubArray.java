package learn;

import java.util.Scanner;

public class LongestSubArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array size");
		int n = input.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter array values");
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		int max = 1, len = 1, maxindex = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				len++;
			} else {
				if (max < len) {
					max = len;
					maxindex = i - max;
				}
				len = 1;

			}
		}
		if (max < len) {
			max = len;
			maxindex = n - max;
		}
		for (int i = maxindex; i < max + maxindex; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
