package checkPrograms;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//import java.sql.Date;

public class DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Date thisdate=new Date();
//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//String date=sdf.format(thisdate);
String date="2022-09-20 19:42:35";
DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
try
{
    format.parse(date);
	System.out.println("Valid");
}
catch(Exception e)
{
	System.out.println("Invalid");
}
//System.out.println(date);
	}

}
