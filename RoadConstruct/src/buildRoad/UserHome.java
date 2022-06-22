package buildRoad;

import java.util.Scanner;


public class UserHome {

	public void userAccount() {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("........Connecting Folks.........");
		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("New user? Press 1 to Sign Up");
		System.out.println("Press 2 to login");
		System.out.println();
		System.out.println(" 1.Create Account \n 2. Login Account \n 3.Go To HomePage");
		System.out.print("=> ");
		int page_retry_count = 0;
		try {
			int ch = input.nextInt();
			switch (ch) {
			case 1: {
				page_retry_count = 0;
				new LogInPage().createUser();
				break;
			}
			case 2: {
				page_retry_count = 0;
				new LogInPage().loginAccount();
				break;
			}
			case 3: {
				StartProcess mainObj = new StartProcess();
				mainObj.startMenu();

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
			userAccount();
		}
	}

		
	}


