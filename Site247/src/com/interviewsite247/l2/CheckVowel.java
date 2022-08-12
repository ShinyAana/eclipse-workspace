package com.interviewsite247.l2;

import java.util.Scanner;

public class CheckVowel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CheckVowel startProcess = new CheckVowel();
		startProcess.checkVowel();
	}

	private void checkVowel() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the string to check vowel presence");
		String inputString = input.next();
		if (inputString.isEmpty())
			System.out.println("Enter valid String");
		else {
			boolean isPresent = isVowelPresent(inputString);
			if (isPresent)
				System.out.println("True");
			else
				System.out.println("False");

		}
	}

	private boolean isVowelPresent(String inputString) {
		boolean isVowel = false;
//char[] inputStr=inputString.toCharArray();
		for (int i = 0; i < inputString.length(); i++) {
			char currentChar = inputString.charAt(i);
			switch (currentChar) {
			case 'a':
				isVowel = true;
				break;
			case 'e':
				isVowel = true;
				break;

			case 'i':
				isVowel = true;
				break;

			case 'o':
				isVowel = true;
				break;

			case 'u':
				isVowel = true;
				break;

			case 'A':
				isVowel = true;
				break;

			case 'E':
				isVowel = true;
				break;

			case 'I':
				isVowel = true;
				break;

			case 'O':
				isVowel = true;
				break;

			case 'U':
				isVowel = true;
				break;

			default:
				isVowel = false;

			}
			if (isVowel)
				break;

		}
		if (isVowel)
			return true;
		else
			return false;

	}

}
