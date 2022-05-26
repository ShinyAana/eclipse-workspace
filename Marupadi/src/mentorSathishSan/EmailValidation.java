package mentorSathishSan;

import java.util.Scanner;

class UserNameValidator
{
	public static final String regularExpression="^[\\w-]{1,20}@[\\w]{2,20}\\.[\\w]{2,3}$";
}
public class EmailValidation {
	public static final Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=Integer.parseInt(input.nextLine());
		while(n--!=0)
		{
			String userName=input.nextLine();
			if(userName.matches(UserNameValidator.regularExpression))
			{
				System.out.println("Valid mail address ");
				
			}
			else
				System.out.println("InValid mail address ");
			
		}
		

		
	}

}
