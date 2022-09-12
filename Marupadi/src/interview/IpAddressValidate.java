package interview;


import java.util.regex.Pattern;

public class IpAddressValidate {

 public static void main(String[] args) {
  // 127.0.0.1
  System.out.println(IpAddressValidate.isValidIpManually("127.0.0.11"));
 }

private static boolean isValidIpManually(String ipAddress) 
{
	  if (ipAddress == null || ipAddress.isEmpty()) {
		   return false;
		  }
		  
		  String[] strArray = ipAddress.split("\\.");
		  
		  if (strArray.length != 4) {
		   return false;
		  }
		  for (String str : strArray) {
		   try {
		    Integer num = Integer.valueOf(str);
		    
		    if (num > 255) {
		     return false;
		    }
		   } catch (NumberFormatException e) {
		    return false;
		   }
		  }
		  return true;
		 }

}

 

