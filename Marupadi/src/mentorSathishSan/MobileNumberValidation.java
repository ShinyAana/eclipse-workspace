package mentorSathishSan;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class MobileNumberValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		System.out.println("Enter mobile number to validate  ");
		String mobileNumber =input.nextLine();
	     
	  Pattern p=Pattern.compile("[6-9][0-9]{9}");
     Matcher m=p.matcher(mobileNumber);
     
     if(m.find())
     {
    	 System.out.println(m.group() + " is valid mobile number ");
     }
     else
     {
    	 System.out.println("The entered number is invalid ....Enter a valid mobile number ");
     }
	}

}
