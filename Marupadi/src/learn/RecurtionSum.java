package learn;

public class RecurtionSum {

	public static void main(String[] args) 
	{
	int sum=findSum(123);
	System.out.println(sum);
	}

	private static int findSum(int num) 
	{
		if(num==0)
		{
	     return 0;
		}
	return(num%10 + findSum(num/10));
	
	}

}
