package com.bank.process;

import java.util.Scanner;


public class ApplicationStart {

	public static void main(String[] args)
	{
		ApplicationStart obj=new ApplicationStart();
		obj.startProcess();
	}

	public void startProcess()
	{
		boolean isExit=true;
		while(isExit) {
			
		
		System.out.println();
		System.out.println("........Welcome to ZOHO Bank.........");
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("New user? Press 1 to Sign Up");
		System.out.println("Press 2 to login");
		System.out.println();
		System.out.println(" 1.Create Account \n 2.Login Account \n 3.Exit");
		System.out.print("=> ");
		int page_retry_count = 0;
		try {
			int ch = input.nextInt();
			switch (ch) {
			case 1: {
				page_retry_count = 0;
				new LogInPage().accountCreation();
				break;
			}
			case 2: {
				page_retry_count = 0;
				new LogInPage().loginAccount();
				break;
			}
			case 3: {
				isExit=false;
				break;
			}
			}

		} catch (Exception e) {

			page_retry_count++;
			if (page_retry_count == 3) {
				System.out.println();
				System.out.println("                [many more attempt]   !!");
				System.out.println();
				System.exit(0);
			}
			System.out.println();
			e.printStackTrace();
			System.out.println("   *Enter valid input ..");
			System.out.println();
			startProcess();
		}
		}

	}

}
