package learn2;
public class Mobile {
	String name="Android";
	static int charge=0;
	int count=0;
	
	Mobile()
	{
		charge++;
	}
	Mobile(int x)
	{
		count++;
	}

	public static void main(String[] args) {
		
	
	
	  for(int i=0; i<5; i++)
	  {
		 new Mobile();
		 new Mobile(10);
		  
	  }
		
	  System.out.println(Mobile.charge+" "+ new Mobile().count);

	}

}
