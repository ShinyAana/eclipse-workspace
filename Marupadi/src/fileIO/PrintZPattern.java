package fileIO;

import java.util.Scanner;

public class PrintZPattern {

	public static void main(String[] args) {
		PrintZPattern object = new PrintZPattern();
		object.onStart();
	}

	private void onStart() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of stars to form Z pattern");
		int numberOfStars = input.nextInt();
		if (numberOfStars % 3 != 1)
			System.out.println("Can't form Z pattern");
		else {
			for (int row = 0; row <= numberOfStars / 3; row++) {
				for (int col = 0; col <= numberOfStars / 3; col++) {
					if (row == 0 || row == numberOfStars / 3 || row + col == numberOfStars / 3 + 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}

	}

}
