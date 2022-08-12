package mentorSathishSan;

public class Singleton {
private static Singleton singleton;

private Singleton()
{
	
}
	public static Singleton getInstance()
	{
		if(singleton==null)
		{
			singleton=new Singleton();
		}
		return singleton;
	}
public static void displayMessage()
{
	
	System.out.println("I have called using Singleton object ");
}


//int count=0;
 /*public Singleton toString()
 {
	 System.out.println("singleton toString method");
			return singleton;
 }*/

}
