package com.interviewsite247.l2;

import java.util.Arrays;
import java.util.Scanner;

public class FindThirdLargest {

	public static void main(String[] args) {
		FindThirdLargest startProcess = new FindThirdLargest();
		startProcess.findThirdLargest();
	}

	private void findThirdLargest() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter array  size");
		int n = input.nextInt();

		int[] array = new int[n];
		if (n < 3) {
			System.out.println("-1");
			return;
		} else {
			System.out.println("Enter array  value");
			for (int i = 0; i < n; i++) {
				array[i] = input.nextInt();
			}

			int j = 1;
			while (j < n) {
				int i = 0;
				while (i < n - j) {
					if (array[i] > array[i + 1]) {
						int temp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = temp;
					}
					i++;
				}
				j++;
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Third largest " + array[n - 3]);
		

	}

}
