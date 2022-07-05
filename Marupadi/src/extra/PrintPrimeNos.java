package extra;

public class PrintPrimeNos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintPrimeNos obj=new PrintPrimeNos();
		obj.findPrime();
	}

	private void findPrime() 
	{
		int count=0;
	for(int i=2;i<=9999;i++)
	{
		count=0;
		for(int j=1;j<=i;j++)
		{
			if(i%j==0)
			{
			count++;
			}
		
		}
		if(count==2)
		{
				System.out.print(i + " ");
	     }
		
		if(i==10 || i==100 || i==1000)
		{
			System.out.println();
		}
	}
	}

}
