
public class VoterIDException extends Exception
{
	public VoterIDException(int age)
	{
		System.out.println("Your age is "+age);
		
	}
public static void VerifyAge(int age)
{
	if(age<18)
	{
		try
		{
			throw new VoterIDException(age);
		}
		catch(VoterIDException e)
		{
			System.out.println("Plese check your age ");
		}
	}
}
	public static void main(String[] args) 
	{
		VoterIDException.VerifyAge(15);	
	}

}
