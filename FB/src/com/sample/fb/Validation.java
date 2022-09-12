package com.sample.fb;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Validation {
	  public boolean emailIdValidationChecker(String currentUserEmailId) {
	        //String pattern = "^[A-Za-z0-9+_.-]+@(.+)$";
	        String pattern="^[\\w-]{1,20}@[\\w]{2,20}\\.[\\w]{2,3}$";
	        if(currentUserEmailId==null)
			{
				return false;
			}
			
	        return Pattern.compile(pattern).matcher(currentUserEmailId).matches();
	    }

	    public boolean phoneNumberValidationChecker(String currentUserPhoneNumber) {
	        String pattern = "(0|91)?[7-9]{1}[0-9]{9}";
	        if(currentUserPhoneNumber==null)
			{
				return false;
			}
			
	        return Pattern.compile(pattern).matcher(currentUserPhoneNumber).matches();
	    }
	    public int checkPassword(String password)
	    {
	    	char ch;
	    	int lc=0,uc=0,sc=0,digit=0;
		    for(int i=0;i<password.length();i++)
		    {
		        ch=password.charAt(i);
		        if(ch>='a' && ch<='z'){
		            lc+=1;
		        }
		        else if(ch>='A' && ch<='Z'){
		            uc+=1;
		        }
		        else if(ch>='0' && ch<='9'){
		            digit+=1;
		        }
		        else{
		            sc+=1;
		        }
		    }
		    if(lc>=1 && uc>=1 && sc>=1 && digit>=1 && password.length()>=8)
		    {
		    	return 1;
		    }
			return 0;
	    	
	    }
	    public boolean isValidDateTime(String date)
	    {
	    	DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    	try
	    	{
	    	    format.parse(date);
	    		return true;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Invalid date time format enter as yyyy-MM-dd HH:mm:ss");
	    	}
return false;
	    }

}
