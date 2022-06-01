package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bufferedareader {

	public static void main(String[] args)
	{
	try
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();//Buffered reader string -only it can read..we have to convert it to primitive types. 
		double number=Double.parseDouble(s);
		System.out.println("Number is" +number);
		

	}
	catch(Exception e)
	{
		System.out.println("Error :" +e.getMessage());
	}
	}
	

}
