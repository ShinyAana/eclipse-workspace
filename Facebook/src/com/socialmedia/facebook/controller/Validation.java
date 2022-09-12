package com.socialmedia.facebook.controller;
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
}
